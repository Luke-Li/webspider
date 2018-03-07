package com.chinaventure.webspider.jobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Producer;
import org.zbus.net.http.Message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.model.jfinal.StockSeed;
import com.chinaventure.webspider.service.impl.ZbusService;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.PropertiesUtil;
import com.chinaventure.webspider.util.TimeUtil;
import com.jfinal.plugin.activerecord.Db;

import net.kernal.spiderman.worker.download.Downloader;
import sealion.core.Job;

/**
 * 种子抓取列表。首先抓取需要更新的A股和新三板种子列表，保存到stock_seed。
 * 同时把种子放到zbus队列中，运行hoiceAStockJob和ChoiceXsbJob去更新
 */
public class StockSeedJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static String[] reportTypes = { "T004001001", "T004001002", "T004001003", "T004001004", "T013001001",
			"T013001002", "T013001003", "T013001004" };

	public static String thirdBoardName = "ChoiceThirdboard";
	public static String aStockName = "ChoiceAStock";

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
			if (!StockSeed.dao.isSeedCrawled()) {
				Db.update("truncate stock_seed");
				for (String type : reportTypes) {
					handleStock(type);
				}
			}

			addQueue(aStockName);
			addQueue(thirdBoardName);

			System.exit(0);

		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}

	}

	/**
	 * 处理逻辑 获取前一天的公告
	 * 
	 * @param stock
	 */
	private synchronized void handleStock(String reportType) {
		try {
			String url = "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=%s&pageIndex=%d&limit=20&sort=date&order=desc";
			boolean nextPage = true;
//			String currentDate = TimeUtil.getDateBeforeDays(1);// 获取一天以前的数据
			String currentDate = "2017-08-07";
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
							// 时间已经比昨天早，直接break
							nextPage = false;
							break;
						} else if (currentDate.compareToIgnoreCase(date) < 0) {
							// 时间比昨天新，暂不统计
							continue;
						}

						// 时间就是昨天的
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
	public void addQueue(String mpName) {

		logger.info("开始加载" + mpName + "种子");

		try {
			Broker broker = new ZbusBroker(PropertiesUtil.getProperty("zbus"));
			Producer producer = new Producer(broker, mpName);
			producer.createMQ();

			if (ZbusService.mqLength(producer) < 1) {
				logger.info("种子队列为空,可以进行初始化");

				List<StockSeed> list = null;
				if (aStockName.compareTo(mpName) == 0) {
					list = StockSeed.dao.find(String.format("select id,code,name from %s where updated=0 and type=0",
							StockSeed.TableName));
				} else {
					list = StockSeed.dao.find(String.format("select id,code,name from %s where updated=0 and type=1",
							StockSeed.TableName));
				}

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
