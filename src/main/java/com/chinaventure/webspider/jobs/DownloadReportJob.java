package com.chinaventure.webspider.jobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.log4j.Logger;
import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.util.HttpclientFileUtils;
import com.chinaventure.webspider.util.NumberUtil;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 * 下载以前的报告
 * 
 * @author Administrator
 *
 */
public class DownloadReportJob {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) throws InterruptedException {
		System.out.println("init jfinal start!");

		JFConfig.start();

		System.out.println("init jfinal end!");

		new DownloadReportJob().execute("choice_report_basic");
		new DownloadReportJob().execute("choice_report_type");
	}

	public void execute(String table) {
		try {
			String savePath = "report";
			String sql = String.format("select url from %s where create_time < ? order by create_time desc", table);

			String time = "2017-06-21";
			if("choice_report_basic".equals(table)){
				time = "2016-12-21";
			}
			List<Record> records = Db.find(sql, time);

			logger.info(String.format("The total %s reports ", table) + records.size());
			int count = 1;

			for (Record item : records) {
				String url = item.get("url");
				if (StringUtils.isNotBlank(url)) {
					if (null != downloadAttach(url, savePath)) {
						
						logger.info(" url = " + url + "count = " + count);
						count++;
					}
				}
			}

			logger.info(String.format("Download all %s reports ", table) + count);

		} catch (Exception e) {
			logger.fatal("Choice 报告数据抓取异常", e);
		}
	}

	private String downloadAttach(String pageUrl, String savePath) {

		HttpGet httpGet = new HttpGet(pageUrl);

		httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		httpGet.addHeader("Accept-Encoding", "gzip, deflate, sdch");
		httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		httpGet.addHeader("Connection", "keep-alive");
		httpGet.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");

		// httpGet.addHeader("Referer", pageUrl);

		threadSleep(randDom());
		return HttpclientFileUtils.download(httpGet, savePath, null);

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
