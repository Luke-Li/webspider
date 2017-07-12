package com.chinaventure.webspider.jobs;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Consumer;
import org.zbus.mq.Consumer.ConsumerHandler;
import org.zbus.mq.Producer;
import org.zbus.net.http.Message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.bean.ChoiceEntBeanNew;
import com.chinaventure.webspider.model.jfinal.ChoiceErrorLog;
import com.chinaventure.webspider.model.jfinal.ChoiceStockANew;
import com.chinaventure.webspider.model.jfinal.ChoiceStockASeed;
import com.chinaventure.webspider.model.jfinal.StockSeed;
import com.chinaventure.webspider.service.impl.ZbusService;
import com.chinaventure.webspider.util.FileUtil;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.NumberUtil;
import com.chinaventure.webspider.util.PropertiesUtil;
import com.chinaventure.webspider.util.StringUtil;
import com.chinaventure.webspider.util.TimeUtil;
import com.jfinal.plugin.activerecord.Db;

import net.kernal.spiderman.worker.download.Downloader;
import sealion.core.Job;

public class StockSeedJob extends Job {

	Logger logger = Logger.getLogger(getClass());
	
	public static String[] reportTypes = {
			"T004001001",
			"T004001002",
			"T004001003",
			"T004001004",
			"T013001001",
			"T013001002",
			"T013001003",
			"T013001004"
	};

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();

		new StockSeedJob().execute(params);
	}

	private Downloader.Request getChoiceRequest(String url, String referer) {

		if (StringUtils.isEmpty(referer)) {
			referer = "http://app.jg.eastmoney.com/html_Notice/index.html";
		}

		Downloader.Request request = new Downloader.Request(url);

		request.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		// request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64)
		// AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.59
		// Safari/537.36");
		request.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.94 Safari/537.36");
		request.addHeader("X-Requested-With", "XMLHttpRequest");
		request.addHeader("Referer", referer);
		request.addHeader("Accept-Encoding", "gzip,deflate");
		request.addHeader("Accept-Language", "en-us,en");

		return request;
	}

	@Override
	public void execute(Map<String, String> params) {
		try {
			JFConfig.start();
			Db.update("truncate stock_seed");
			for(String type:reportTypes){
				handleStock(type);
			}
			
			addAStockQueue();
			addXsbQueue();

		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}

	}

	/**
	 * 处理逻辑
	 * 
	 * @param stock
	 */
	private synchronized void handleStock(String reportType) {
		try {
			String url = "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=%s&pageIndex=%d&limit=20&sort=date&order=desc";
			boolean nextPage = true;
			String currentDate = TimeUtil.getDateBeforeDays(1);//获取一天以前的数据
			int page = 1;

			while (nextPage) {
				Downloader.Request request = getChoiceRequest(String.format(url, reportType, page), null);
				String jsonHtml = HttpclientUtils.downloadHtmlRetry(request);
				page++;

				if (!StringUtils.isEmpty(jsonHtml)) {
					JSONObject baseObject = JSONObject.parseObject(jsonHtml);
					JSONArray records = baseObject.getJSONArray("records");

					for (int j = 0; j < records.size(); j++) {
						JSONObject record = records.getJSONObject(j);
						String date = record.getString("date");

						if (currentDate.compareToIgnoreCase(date) > 0) {
							nextPage = false;
							break;//按时间倒序排就不需要continue,直接break
						}

						JSONArray secuList = record.getJSONArray("secuList");

						for (int k = 0; k < secuList.size(); k++) {
							JSONObject secu = secuList.getJSONObject(k);
							String secuName = secu.getString("secuSName");
							String secuCode = secu.getString("secuFullCode");

							StockSeed.dao.addSeed(secuName, secuCode);
						}

					}
				} else {
					nextPage = false;
				}
			}
		} catch (Exception e) {

			logger.error(e);
		}

	}
	
	/**
	 * 加载A股种子到zbus
	 */
	public void addAStockQueue(){
		
		logger.info("开始加载A股种子");
		String mpName = "ChoiceAStock";

		try {
			Broker broker = new ZbusBroker(PropertiesUtil.getProperty("zbus"));
			Producer producer = new Producer(broker, mpName);
			producer.createMQ();

			if (ZbusService.mqLength(producer) < 5) {
				logger.info("种子队列为空,可以进行初始化");

				logger.info("正在加载种子");
				List<StockSeed> list = StockSeed.dao.find(String.format("select id,code,name from %s where type=0", StockSeed.TableName));

				if (null != list) {
					for (StockSeed stock : list) {
						Message msg = new Message();
						msg.setBody(SerializationUtils.serialize(stock));

						producer.sendSync(msg);
					}
				}
			}
		} catch (Exception e) {
			logger.error("初始化种子异常!", e);
		}
	}
	
	/**
	 * 加载A股种子到zbus
	 */
	public void addXsbQueue(){
		
		logger.info("开始加载新三板种子");
		String mpName = "ChoiceThirdboard";

		try {
			Broker broker = new ZbusBroker(PropertiesUtil.getProperty("zbus"));
			Producer producer = new Producer(broker, mpName);
			producer.createMQ();

			if (ZbusService.mqLength(producer) < 5) {
				logger.info("种子队列为空,可以进行初始化");

				logger.info("正在加载种子");
				List<StockSeed> list = StockSeed.dao.find(String.format("select id,code,name from %s where type=1", StockSeed.TableName));

				if (null != list) {
					for (StockSeed stock : list) {
						Message msg = new Message();
						msg.setBody(SerializationUtils.serialize(stock));

						producer.sendSync(msg);
					}
				}
			}
		} catch (Exception e) {
			logger.error("初始化种子异常!", e);
		}
	}

}
