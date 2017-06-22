package com.chinaventure.webspider.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.model.InnotreeEnt;
import com.chinaventure.webspider.service.InnotreeService;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.NumberUtil;
import com.chinaventure.webspider.util.PropertiesUtil;
import com.google.gson.JsonObject;

import sealion.core.Job;

/**
 * 因果树的监测JOB
 * 
 * @author Administrator
 *
 */
public class InnotreeMonitorJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		params.put("host", "innotree");
		params.put("start", PropertiesUtil.getProperty("start"));
		params.put("end", PropertiesUtil.getProperty("end"));
		params.put("modulo", PropertiesUtil.getProperty("modulo"));

		new InnotreeMonitorJob().execute(params);
	}

	/**
	 * 调用 API
	 * 
	 * @param parameters
	 * @return
	 */
	public String getJsonContent(String url, String referUrl, JsonObject params) {
		try {
			HttpClient httpClient = HttpClients.createDefault();
			HttpGet method = new HttpGet(url);

			// 建立一个NameValuePair数组，用于存储欲传送的参数
			method.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
			method.addHeader("Accept-Encoding", "gzip, deflate");
			method.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
			method.addHeader("Connection", "keep-alive");
			method.addHeader("Content-Type", "application/json");
			method.addHeader("Referer", referUrl);
			method.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
			method.addHeader("X-Requested-With", "XMLHttpRequest");

			/*
			 * JsonObject j = new JsonObject(); j.addProperty("rand",
			 * "0.47811546109000846"); j.addProperty("page", "0");
			 * j.addProperty("size", "100");
			 */

			if (null != params) {
				// method.setEntity(new StringEntity(params.toString(),
				// Charset.forName("UTF-8")));
			}

			HttpResponse response = httpClient.execute(method);

			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				logger.error("request api fail :" + response.getStatusLine());
			}

			String body = EntityUtils.toString(response.getEntity());
			return body;
		} catch (Exception e) {
			logger.error("请求JSON数据", e);
		}

		return null;
	}

	/**
	 * spring
	 */
	private static ApplicationContext context;

	/**
	 * 服务类
	 */
	private InnotreeService service;


	/**
	 * 动态含COOKIE信息的下载器
	 */
	QxbDownloader downloadWorker;

	@Override
	public void execute(Map<String, String> params) {
		try {
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = context.getBean(InnotreeService.class);

			downloadWorker = new QxbDownloader(params.get("host"));

			Integer start = Integer.parseInt(params.get("start")), end = Integer.parseInt(params.get("end"));

			Integer modulo = Integer.parseInt(params.get("modulo"));

			entHandle(start, end, modulo);

			logger.info("数据处理完成");

		} catch (Exception e) {
			logger.fatal("因果树数据抓取", e);
		}
	}

	/**
	 * 多次重试下载
	 * 
	 * @param url
	 * @param referUrl
	 * @param params
	 * @return
	 */
	private JSONObject multipleDownload(String url, String referUrl, JsonObject params) {
		for (int i = 0; i < 5; i++) {
			try {
				String html = getJsonContent(url, referUrl, params);
				JSONObject baseObject = JSONObject.parseObject(html);

				return baseObject;
			} catch (Exception e) {
				logger.error("基金下载", e);
				threadSleep(randDom());
			}
		}
		return null;
	}

	/**
	 * 直投基金解析
	 * 
	 * @param object
	 * @return
	 */
	private List<InnotreeEnt> parseEnt(JSONObject object) {
		List<InnotreeEnt> list = new ArrayList<>();
		Date now = new Date();
		JSONArray datas = object.getJSONObject("data").getJSONArray("list");
		for (int i = 0; i < datas.size(); i++) {
			JSONObject item = datas.getJSONObject(i);

			InnotreeEnt model = new InnotreeEnt();
			model.setArea(item.getString("area"));
			model.setCreatetime(now);
			model.setFounder(item.getString("founder"));
			model.setIndustry(item.getString("industry"));
			model.setInnerid(item.getInteger("id"));
			model.setLogo(item.getString("logo"));
			model.setName(item.getString("name"));
			model.setPeriod(item.getString("period"));
			model.setScore(item.getInteger("score"));
			model.setUpdatetime(now);

			list.add(model);
		}

		return list;
	}

	Integer failCount = 0;

	private void fillEntdetailData(InnotreeEnt ent) throws Exception {
		downloadWorker.nextDownloadWorkerRandom();

		String url = "http://www.innotree.cn/project_extra/detail/%s.html";

		logger.info("开始处理公司:" + ent.getName());

		String html = HttpclientUtils.downloadHtmlRetry(String.format(url, ent.getInnerid()));

		if (StringUtils.isBlank(html)) {
			failCount++;
			logger.error("公司:" + ent.getName() + " 下载失败!");
		} else {
			try {
				Document doc = Jsoup.parse(html);

				Elements eles = doc.select("div[class=\"details_0629_right_div02_right\"] table");
				if (null != eles && eles.size() > 0) {
					String entName = eles.get(0).select("tr:eq(0) td:eq(1)").text();
					ent.setFullname(entName);

					String description = doc.getElementById("introduction_container").text();
					ent.setBrief(description);
				}else{
					ent.setFullname("网站暂无");
				}
			} catch (Exception ex) {
				logger.error("解析数据异常", ex);
			}
		}

		if (failCount > 15) {

			throw new Exception("失败次数超过15次，自动终止!");
		}
	}

	/**
	 * 直投基金处理
	 */
	private void entHandle(Integer start, Integer end, Integer modulo) {

		logger.info("开始处理因果树公司数据。");

		List<InnotreeEnt> listEnts = service.selectUnfillData();// service.selectUnfillData(start,
																// end);
		logger.info(String.format("begin:%s end:%s modulo:%s", start, end, modulo));
		try {
			for (InnotreeEnt innotreeEnt : listEnts) {

				if (StringUtils.isBlank(innotreeEnt.getFullname()) && StringUtils.isBlank(innotreeEnt.getBrief()) && (innotreeEnt.getInnerid() % 3) == modulo) {
					threadSleep(randDom());
					fillEntdetailData(innotreeEnt);
					service.updateEnt(innotreeEnt);
				}
			}
		} catch (Exception ex) {
			logger.fatal("下载失败!", ex);
		}

		if (true)
			return;

		// 每次提取多少条数据
		int size = 100;

		String url = "http://www.innotree.cn/ajax/projectrank/2/getFilterProjects?page=%s&size=" +  size + "&industry=&period=&area=&keyword=&sort=";// page从1开始,size=100
		String referUrl = "http://www.innotree.cn/allProjects";

		logger.info("开始处理第一页数据。");

		JSONObject baseObject = multipleDownload(String.format(url, 1), referUrl, null);

		List<InnotreeEnt> list = new ArrayList<>();

		list.addAll(parseEnt(baseObject));
		service.updateEnts(list);

		Integer total = baseObject.getJSONObject("data").getInteger("total");

		Integer totalPages = total / size;
		if (total % size > 0) {
			totalPages++;
		}
		if (null != totalPages) {
			for (int i = 2; i <= totalPages; i++) {
				logger.info("开始处理第" + i + "页数据。");
				try {
					list.clear();
					baseObject = multipleDownload(String.format(url, i), referUrl, null);

					list.addAll(parseEnt(baseObject));

					service.updateEnts(list);

					logger.info("第" + i + "页数据入库完成。");
				} catch (Exception e) {
					logger.error("处理第" + i + "页数据异常.", e);
				}
			}
		}

		logger.info("开始处理因果树公司数据。");
	}

	/** 一些通用方法 **/

	/**
	 * 随机生成7到20之间的随机数
	 * 
	 * @return
	 */
	private int randDom() {
		int max = 10;
		int min = 5;

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
