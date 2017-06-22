package com.chinaventure.webspider.jobs;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinaventure.webspider.model.PedailyInvest;
import com.chinaventure.webspider.service.PedailyService;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.NumberUtil;
import com.chinaventure.webspider.util.PropertiesUtil;
import com.chinaventure.webspider.util.url.UrlStandardization;

import net.kernal.spiderman.worker.download.Downloader;
import sealion.core.Job;

/**
 *Pedaily的投资事件监控JOB
 * 
 * @author Administrator
 *
 */
public class PedailyInvestJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		params.put("host", "chenkun");
		params.put("start", PropertiesUtil.getProperty("start"));
		params.put("end", PropertiesUtil.getProperty("end"));

		new PedailyInvestJob().execute(params);
	}

	/**
	 * spring
	 */
	private static ApplicationContext context;

	/**
	 * 服务类
	 */
	private PedailyService service;

	/**
	 * 动态含COOKIE信息的下载器
	 */
	QxbDownloader downloadWorker;
	
	@Override
	public void execute(Map<String, String> params) {
		try {			
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = context.getBean(PedailyService.class);

			downloadWorker = new QxbDownloader(params.get("host"));

			Integer start = Integer.parseInt(params.get("start")), end = Integer.parseInt(params.get("end"));

			String url = "http://newseed.pedaily.cn/invest/p%s";

			//1179
			for (; start <= end; start++) {
				logger.info(String.format("begin handle page %s  end page %s",start,end));
				
				String pageUrl = String.format(url, start);
				Downloader.Request request = new Downloader.Request(pageUrl);
				request.addHeader("Referer", String.format(url, start-1));
				
				threadSleep(randDom());
				String html = HttpclientUtils.downloadHtmlRetry(request);
				
				Document doc = Jsoup.parse(html);
				Elements baseTrs = doc.select("table[id=\"newslist\"] tbody tr");
				
				
				
				for (Element element : baseTrs) {
					Elements tds = element.getElementsByTag("td");
					
					logger.info(String.format("开始抓取公司:%s 的数据", tds.get(2).text()));
					
					PedailyInvest invest = new PedailyInvest();
					
					invest.setRound(tds.get(0).text());
					invest.setFinancingDate(tds.get(1).text());
					invest.setInvestSide(tds.get(2).text());
					invest.setFundedParty(tds.get(3).text());
					invest.setInvenstAmount(tds.get(4).text());
					
					String detailUrl = UrlStandardization.Normalize(pageUrl, tds.get(5).child(0).attr("href"))[0];
					
					invest.setDetailUrl(detailUrl);
					
					//详细信息处理
					detailHandel(pageUrl,invest);
					
					//日期
					invest.setCreateTime(new Date());
					invest.setUpdateTime(invest.getCreateTime());
					
					service.insertInvest(invest);
				}
				
			}

			logger.info("数据处理完成");

		} catch (Exception e) {
			logger.fatal("Pedaily 投资事件 数据抓取异常", e);
		}
	}

	
	
	private void detailHandel(String pageUrl,PedailyInvest invest){
		Downloader.Request request = new Downloader.Request(invest.getDetailUrl());
		request.addHeader("Referer", pageUrl);
		
		threadSleep(randDom());
		String html = HttpclientUtils.downloadHtmlRetry(request);
		
		if(StringUtils.isNotBlank(html)){
			
			Document doc = Jsoup.parse(html);
			Elements infos = doc.select("div[class=\"info\"]").get(0).children();
			
			invest.setIndustry(infos.get(0).childNodes().get(infos.get(0).childNodes().size()-1).outerHtml());
			
			//简介的逻辑处理
			String brief = StringUtils.EMPTY;
			for (int i = 2; i < infos.size(); i++) {
				brief+=infos.get(i);
			}
			
			invest.setBrief(brief);
		}
	}

	

	/** 一些通用方法 **/

	/**
	 * 随机生成7到20之间的随机数
	 * 
	 * @return
	 */
	private int randDom() {
		int max = 3;
		int min = 1;

		return NumberUtil.randDom(min, max);
	}

	/**
	 * 线程睡眠一定的时间
	 * 
	 * @param seconds
	 */
	private void threadSleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
