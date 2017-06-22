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

import com.chinaventure.webspider.model.PedailyCompany;
import com.chinaventure.webspider.service.PedailyService;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.NumberUtil;
import com.chinaventure.webspider.util.PropertiesUtil;
import com.chinaventure.webspider.util.url.UrlStandardization;

import net.kernal.spiderman.worker.download.Downloader;
import sealion.core.Job;

/**
 * 因果树的监测JOB
 * 
 * @author Administrator
 *
 */
public class PedailyCompanyJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		params.put("host", "chenkun");
		params.put("start", PropertiesUtil.getProperty("start"));
		params.put("end", PropertiesUtil.getProperty("end"));

		new PedailyCompanyJob().execute(params);
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

			String url = "http://newseed.pedaily.cn/company/p%s";

			// 2098
			for (; start <= end; start++) {
				logger.info(String.format("begin handle page %s  end page %s", start, end));

				String pageUrl = String.format(url, start);
				Downloader.Request request = new Downloader.Request(pageUrl);
				request.addHeader("Referer", String.format(url, start - 1));

				threadSleep(randDom());
				String html = HttpclientUtils.downloadHtmlRetry(request);

				Document doc = Jsoup.parse(html);
				Elements baseTrs = doc.select("ul[id=\"newslist\"] li");

				for (Element element : baseTrs) {

					PedailyCompany company = new PedailyCompany();

					company.setArea(element.select("div[class=\"content-r\"]").get(0).text());

					Elements infos = element.select("div[class=\"content-m\"] > *");
					Elements names = infos.get(0).children();

					logger.info(String.format("开始抓取公司:%s 的数据", names.get(0).text()));

					String detailUrl = UrlStandardization.Normalize(pageUrl, names.get(0).attr("href"))[0];

					company.setDetailUrl(detailUrl);

					company.setCompanyName(names.get(0).text());
					company.setProName(names.get(1).text());

					if (infos.size() > 1) {
						if (infos.size() > 2) {
							String industry = StringUtils.EMPTY;

							if (infos.get(1).children().size() > 1) {
								industry = infos.get(1).children().get(0).text();
								for (int i = 1; i < infos.get(1).children().size(); i++) {
									industry += "  " + infos.get(1).children().get(i).text();
								}

							} else {
								industry = infos.get(1).text();
							}

							company.setIndustry(industry);
						}

						String brief = infos.size() > 2 ? infos.get(2).text() : infos.get(1).text();

						if (brief.contains("...")) {
							// 详细信息处理
							detailHandel(pageUrl, company);
						} else {
							company.setBrief(brief);
						}
					}

					// 日期
					company.setCreatetime(new Date());
					company.setUpdatetime(company.getCreatetime());

					service.insertCompany(company);
				}

			}

			logger.info("数据处理完成");

		} catch (Exception e) {
			logger.fatal("Pedaily 创业公司 数据抓取异常", e);
		}
	}

	private void detailHandel(String pageUrl, PedailyCompany company) {
		Downloader.Request request = new Downloader.Request(company.getDetailUrl());
		request.addHeader("Referer", pageUrl);

		threadSleep(randDom());
		String html = HttpclientUtils.downloadHtmlRetry(request);

		Document doc = Jsoup.parse(html);
		Elements infos = doc.select("div[class=\"info\"]").get(0).children();

		// 简介的逻辑处理
		String brief = StringUtils.EMPTY;
		for (int i = 3; i < infos.size(); i++) {
			brief += infos.get(i);
		}

		company.setBrief(brief);
	}

	/** 一些通用方法 **/

	/**
	 * 随机生成7到20之间的随机数
	 * 
	 * @return
	 */
	private int randDom() {
		int max = 5;
		int min = 2;

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
