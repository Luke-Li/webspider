package com.chinaventure.webspider.jobs;

import java.nio.charset.Charset;
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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.apache.tools.ant.filters.StringInputStream;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.model.PofAoinFund;
import com.chinaventure.webspider.model.PofInfo;
import com.chinaventure.webspider.model.PofInfoFund;
import com.chinaventure.webspider.model.PofInfoLegalpersonResume;
import com.chinaventure.webspider.model.PofInfoManager;
import com.chinaventure.webspider.model.PofList;
import com.chinaventure.webspider.service.PofFundService;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.NumberUtil;
import com.chinaventure.webspider.util.url.UrlStandardization;
import com.google.gson.JsonObject;

import sealion.core.Job;

public class PofFundJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	private static boolean isPofFund = false;

	public static String managerUrl = "http://gs.amac.org.cn/amac-infodisc/res/pof/manager/";

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		new PofFundJob().execute(params);
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
			HttpPost method = new HttpPost(url);

			// 建立一个NameValuePair数组，用于存储欲传送的参数
			method.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
			method.addHeader("Accept-Encoding", "gzip, deflate");
			method.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
			method.addHeader("Connection", "keep-alive");
			method.addHeader("Content-Type", "application/json");
			method.addHeader("Referer", referUrl);
			// method.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1;
			// Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)
			// Chrome/52.0.2743.116 Safari/537.36");
			method.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
			method.addHeader("X-Requested-With", "XMLHttpRequest");

			/*
			 * JsonObject j = new JsonObject(); j.addProperty("rand",
			 * "0.47811546109000846"); j.addProperty("page", "0");
			 * j.addProperty("size", "100");
			 */

			if (null != params) {
				method.setEntity(new StringEntity(params.toString(), Charset.forName("UTF-8")));
			}

			if (isPofFund == true) {
				InputStreamEntity reqEntity = new InputStreamEntity(new StringInputStream("{}"), -1,
						ContentType.APPLICATION_OCTET_STREAM);

				method.setEntity(reqEntity);
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
	private PofFundService service;

	/**
	 * 队列名称
	 */
	String mpName = "Choice-AStock";

	@Override
	public void execute(Map<String, String> params) {
		try {
			// context = new
			// ClassPathXmlApplicationContext("file:C:/dev/service/webspider-master/src/main/resources/applicationContext.xml");
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = context.getBean(PofFundService.class);

			// pofFundHandle(); //从基金入口
			aoinFundHandle();
			pofHandle();

			logger.info("基金处理完成");

		} catch (Exception e) {
			logger.fatal("基金数据抓取", e);
		}
	}

	/**
	 * 直投基金解析
	 *
	 * @param object
	 * @return
	 */
	private List<PofAoinFund> parseAoinFund(JSONObject object) {

		List<PofAoinFund> list = new ArrayList<>();
		Date now = new Date();
		JSONArray datas = object.getJSONArray("content");
		for (int i = 0; i < datas.size(); i++) {
			JSONObject item = datas.getJSONObject(i);

			PofAoinFund model = new PofAoinFund();
			model.setAoinname(item.getString("aoinName"));
			model.setCode(item.getString("code"));
			model.setCreatedate(item.getLong("createDate"));
			model.setCreatetime(now);
			model.setInnerid(item.getString("id"));
			model.setManagername(item.getString("managerName"));
			model.setName(item.getString("name"));
			model.setUpdatetime(now);

			list.add(model);
		}

		return list;
	}

	/**
	 * 直投基金处理
	 */
	private void aoinFundHandle() {
		String url = "http://gs.amac.org.cn/amac-infodisc/api/aoin/product?rand=0.47811546109000846&page=%s&size=100";// page从0开始,size=100
		String referUrl = "http://gs.amac.org.cn/amac-infodisc/res/aoin/product/index.html";

		JsonObject params = new JsonObject();
		params.addProperty("rand", "0.47811546109000846");
		params.addProperty("page", "0");
		params.addProperty("size", "100");

		JSONObject baseObject = multipleDownload(String.format(url, 0), referUrl, params);

		List<PofAoinFund> list = new ArrayList<>();

		list.addAll(parseAoinFund(baseObject));

		Integer totalPages = baseObject.getInteger("totalPages");
		if (null != totalPages) {
			for (int i = 1; i < totalPages; i++) {
				params = new JsonObject();
				params.addProperty("rand", "0.47811546109000846");
				params.addProperty("page", Integer.toString(i));
				params.addProperty("size", "100");

				baseObject = multipleDownload(String.format(url, i), referUrl, params);

				list.addAll(parseAoinFund(baseObject));
			}
		}

		service.insertAoinFund(list);
	}

	/******************** 私募基金处理 ***************************/
	/**
	 * 解析私募基金管理人
	 *
	 * @param object
	 * @return
	 */
	private List<PofList> parsePofList(JSONObject object) {
		List<PofList> list = new ArrayList<>();
		Date now = new Date();
		JSONArray datas = object.getJSONArray("content");
		for (int i = 0; i < datas.size(); i++) {
			JSONObject item = datas.getJSONObject(i);

			PofList model = new PofList();
			model.setArtificialpersonname(item.getString("artificialPersonName"));//
			model.setCreatetime(now);
			model.setEstablishdate(item.getLong("establishDate"));
			model.setFundcount(item.getInteger("fundCount"));
			model.setFundscale(item.getDouble("fundScale"));
			model.setHascredittips(item.getBoolean("hasCreditTips"));
			model.setHasspecialtips(item.getBoolean("hasSpecialTips"));
			model.setInblacklist(item.getBoolean("inBlacklist"));
			model.setManagerhasproduct(item.getString("managerHasProduct"));
			model.setManagername(item.getString("managerName"));
			model.setOfficeaddress(item.getString("officeAddress"));
			model.setOfficecity(item.getString("officeCity"));
			model.setOfficecoordinate(item.getString("officeCoordinate"));
			model.setOfficeprovince(item.getString("officeProvince"));
			model.setPrimaryinvesttype(item.getString("primaryInvestType"));
			model.setRegadragg(item.getString("regAdrAgg"));
			model.setRegcoordinate(item.getString("regCoordinate"));
			model.setRegisteraddress(item.getString("registerAddress"));
			model.setRegistercity(item.getString("registerCity"));
			model.setRegisterdate(item.getLong("registerDate"));
			model.setRegisterno(item.getString("registerNo"));
			model.setRegisterprovince(item.getString("registerProvince"));
			model.setSiteid(item.getString("id"));
			model.setUpdatetime(now);
			model.setUrl(item.getString("url"));

			list.add(model);
		}

		return list;
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
		threadSleep(randDom());
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
	 * 私募基金处理，从管理人入口
	 */
	private void pofHandle() {
		logger.info("开始处理私募基金");
		String url = "http://gs.amac.org.cn/amac-infodisc/api/pof/manager?rand=0.35120890842190167&page=%s&size=100";// page从0开始,size=100
		String referUrl = "http://gs.amac.org.cn/amac-infodisc/res/pof/manager/index.html";

		JsonObject params = new JsonObject();
		params.addProperty("rand", "0.35120890842190167");
		params.addProperty("page", "0");
		params.addProperty("size", "100");

		JSONObject baseObject = multipleDownload(String.format(url, 0), referUrl, params);
		pofHandle(parsePofList(baseObject));

		Integer totalPages = baseObject.getInteger("totalPages");
		if (null != totalPages) {
			for (int i = 1; i < totalPages; i++) {
				params = new JsonObject();
				params.addProperty("rand", "0.35120890842190167");
				params.addProperty("page", Integer.toString(i));
				params.addProperty("size", "100");

				baseObject = multipleDownload(String.format(url, i), referUrl, params);

				pofHandle(parsePofList(baseObject));
			}
		}
	}

	private void pofHandle(List<PofList> list) {
		String url = "http://gs.amac.org.cn/amac-infodisc/res/pof/manager/";
		for (PofList pofList : list) {
			try {
				logger.info("开始处理基金:" + pofList.getManagername());

				String html = HttpclientUtils.downloadHtmlRetry(url + pofList.getUrl());
				if (html == null || "".equals(html)) {
					continue;
				}
				Document doc = Jsoup.parse(html);
				Elements baseTrs = doc.select("div[class=\"m-manager-list m-list-details\"] > table > tbody > tr");

				PofInfo info = service.selectPofInfoByMananagerName(pofList.getManagername());
				if (!this.needUpdate(info, doc)) {
					continue;
				}
				if (info == null) {
					info = new PofInfo();
				}
				// PofInfo info = new PofInfo();
				this.newManagerHandle(info, baseTrs);

				pofList.setInfo(info);
				service.updatePofList(pofList);
				logger.info("基金:" + pofList.getManagername() + "处理完成!");
			} catch (Exception e) {
				logger.error("处理基金:" + pofList.getManagername() + " 异常", e);
			}
		}
	}

	/**
	 * 新的基金管理人 处理办法
	 * 
	 * @param info
	 * @param baseTrs
	 */
	private void newManagerHandle(PofInfo info, Elements baseTrs) {
		if (null == info || baseTrs == null) {
			return;
		}

		for (int i = 0; i < baseTrs.size(); i++) {
			Element currentTr = baseTrs.get(i);
			String title = currentTr.child(0).text();

			String text = currentTr.children().size() > 1 ? currentTr.child(1).text() : null;

			if (title.contains("机构诚信信息")) {
				info.setIntegrityinfo(text);
			} else if (title.contains("基金管理人全称(中文)")) {
				String[] managerNames = StringUtils.split(text, ' ');
				info.setManagername(managerNames[0]);
			} else if (title.contains("基金管理人全称(英文)")) {
				info.setManagernameen(text);
			} else if (title.contains("登记编号")) {
				info.setRegisterno(text);
			} else if (title.contains("组织机构代码:")) {
				info.setOrganizationcode(text);
			} else if (title.contains("登记时间:")) {
				info.setRegisterdate(text);
				// 成立时间
				info.setEstablishdate(currentTr.child(3).text());
			} else if (title.contains("注册地址:")) {
				info.setRegisteraddress(text);
			} else if (title.contains("办公地址:")) {
				info.setOfficeaddress(text);
			} else if (title.contains("注册资本(万元):")) {
				info.setRegcapital(text);
				// 实缴资本(万元):
				info.setPaidincapital(currentTr.child(3).text());
			} else if (title.contains("企业性质:")) {
				info.setEntnature(text);
				// 注册资本实缴比例:
				info.setRegcapitalpaidinratio(currentTr.child(3).text());
			} else if (title.contains("管理基金主要类别")) {
				info.setPrimaryinvesttype(text);
				// 申请的其他业务类型:
				info.setOtherbiztype(currentTr.child(3).text());
			} else if (title.contains("员工人数:")) {
				info.setEmploynum(text);
				// 机构网址:
				info.setSite(currentTr.child(3).text());
			} else if (title.contains("法律意见书状态:")) {
				info.setLegalopinion(text);
			} else if (title.contains("法定代表人/执行事务合伙人(委派代表)姓名")) {
				info.setArtificialpersonname(text);
			} else if (title.contains("是否有从业资格")) {
				info.setIshascredit(text);
				// 资格取得方式:
				info.setCreditgetway(currentTr.child(3).text());
			} else if (title.contains("法定代表人/执行事务合伙人(委派代表)工作履历")) {
				// 单独处理
				Elements managerTrs = currentTr.child(1).select("table:eq(0) > tbody > tr");
				for (Element managerTr : managerTrs) {
					PofInfoLegalpersonResume personResume = new PofInfoLegalpersonResume();

					personResume.setTenureoffice(managerTr.child(0).text());
					personResume.setTenureent(managerTr.child(1).text());
					personResume.setPosition(managerTr.child(2).text());

					info.getPersonResumes().add(personResume);
				}
			} else if (title.contains("高管情况:")) {
				// 单独处理
				Elements managerTrs = currentTr.child(1).select("table:eq(0) > tbody > tr");
				for (Element managerTr : managerTrs) {
					PofInfoManager fundManager = new PofInfoManager();

					fundManager.setName(managerTr.child(0).text());
					fundManager.setPosition(managerTr.child(1).text());
					fundManager.setIshascredit(managerTr.child(2).text());

					info.getFundManagers().add(fundManager);
				}
			} else if (title.contains("暂行办法实施前成立的基金") || title.contains("暂行办法实施后成立的基金")) {
				// 单独处理
				Elements as = currentTr.child(1).getElementsByTag("a");
				for (Element a : as) {
					String hrefUrl = a.attr("href");
					String fundUrl = UrlStandardization.Normalize(managerUrl, hrefUrl)[0];

					PofInfoFund fund = pofHandle(fundUrl);
					info.getInfoFunds().add(fund);
				}

			} else if (title.contains("机构信息最后更新时间")) {
				info.setLastupdateddate(text);
			} else if (title.contains("特别提示信息")) {
				info.setSpecialtips(text);
			}
		}
	}

	/**
	 * 以前就有的基金管理人 只更新基金列表
	 * 
	 * @param info
	 * @param baseTrs
	 */
	private void oldManagerHandle(PofInfo info, Elements baseTrs) {
		if (null == info || baseTrs == null) {
			return;
		}

		for (int i = 0; i < baseTrs.size(); i++) {
			Element currentTr = baseTrs.get(i);
			String title = currentTr.child(0).text();

			if (title.contains("暂行办法实施前成立的基金") || title.contains("暂行办法实施后成立的基金")) {
				// 单独处理
				Elements as = currentTr.child(1).getElementsByTag("a");
				for (Element a : as) {
					String hrefUrl = a.attr("href");
					String fundUrl = UrlStandardization.Normalize(managerUrl, hrefUrl)[0];

					PofInfoFund fund = pofHandle(fundUrl);
					info.getInfoFunds().add(fund);
				}

			}
		}
	}

	private PofInfoFund pofHandle(String fundUrl) {

		String html = HttpclientUtils.downloadHtmlRetry(fundUrl);
		Document doc = Jsoup.parse(html);
		Elements baseTrs = doc.select("div[class=\"m-manager-list m-list-details\"] > table > tbody > tr");

		PofInfoFund fund = new PofInfoFund();

		for (int i = 0; i < baseTrs.size(); i++) {
			Element currentTr = baseTrs.get(i);
			String title = currentTr.child(0).text();

			String text = currentTr.children().size() > 1 ? currentTr.child(1).text() : null;

			if (title.contains("基金名称:")) {
				fund.setName(text);
			} else if (title.contains("基金编号:")) {
				fund.setFundno(text);
			} else if (title.contains("成立时间:")) {
				fund.setEstablishdate(text);
			} else if (title.contains("备案时间:")) {
				fund.setRegisterdate(text);
			} else if (title.contains("基金备案阶段:")) {
				fund.setFilingphase(text);
			} else if (title.contains("基金类型:")) {
				fund.setFundtype(text);
			} else if (title.contains("币种:")) {
				fund.setCurrency(text);
			} else if (title.contains("基金管理人名称:")) {
				fund.setPofmanagername(text);
			} else if (title.contains("管理类型:")) {
				fund.setManagetype(text);
			} else if (title.contains("托管人名称:")) {
				fund.setCustodianname(text);
			} else if (title.contains("主要投资领域:")) {
				fund.setInvestmentfield(text);
			} else if (title.contains("运作状态:")) {
				fund.setOperationstate(text);
			} else if (title.contains("基金信息最后更新时间:	")) {
				fund.setLastupdateddate(text);
			} else if (title.contains("基金协会特别提示（针对基金）:")) {
				fund.setSpecialtips(text);
			}
		}

		return fund;
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

	/**
	 * 私募基金处理，从私募基金入口
	 */
	public void pofFundHandle() {
		logger.info("开始处理私募基金");

		String url = "http://gs.amac.org.cn/amac-infodisc/api/pof/fund?rand=0.5135618324280553&page=%s&size=100";// page从0开始,size=100
		String referUrl = "http://gs.amac.org.cn/amac-infodisc/res/pof/fund/index.html";

		JsonObject params = new JsonObject();
		params.addProperty("rand", "0.5135618324280553");
		params.addProperty("page", "0");
		params.addProperty("size", "100");

		isPofFund = true;
		JSONObject baseObject = multipleDownload(String.format(url, 0), referUrl, params);
		isPofFund = false;

		pofHandle(parsePofListFromFund(baseObject));

		Integer totalPages = baseObject.getInteger("totalPages");
		if (null != totalPages) {
			for (int i = 1; i < totalPages; i++) {
				params = new JsonObject();
				params.addProperty("rand", "0.5135618324280553");
				params.addProperty("page", Integer.toString(i));
				params.addProperty("size", "100");

				isPofFund = true;
				baseObject = multipleDownload(String.format(url, i), referUrl, params);
				isPofFund = false;

				pofHandle(parsePofListFromFund(baseObject));
			}
		}
	}

	/**
	 * 解析私募基金管理人从基金产品页
	 * 
	 * @param object
	 * @return
	 */
	private List<PofList> parsePofListFromFund(JSONObject object) {
		List<PofList> list = new ArrayList<>();
		Date now = new Date();
		JSONArray datas = object.getJSONArray("content");
		for (int i = 0; i < datas.size(); i++) {
			JSONObject item = datas.getJSONObject(i);

			PofList model = new PofList();

			model.setManagername(item.getString("managerName"));
			model.setUrl(item.getString("managerUrl").substring(11));

			list.add(model);
		}

		return list;
	}

	private boolean needUpdate(PofInfo info, Document doc) {
		if (info == null) {
			return true;
		}

		Elements baseTrs = doc.select("div[class=\"m-manager-list m-list-details\"] > table > tbody > tr");

		if (baseTrs != null) {
			for (int i = 0; i < baseTrs.size(); i++) {
				Element currentTr = baseTrs.get(i);
				String title = currentTr.child(0).text();

				String text = currentTr.children().size() > 1 ? currentTr.child(1).text() : null;

				if (title.contains("机构信息最后更新时间")){
					if (!StringUtil.isBlank(text) && text.compareToIgnoreCase(info.getLastupdateddate()) > 0) {
						return true;
					} else {
						return false;
					}
				}
			}
		}

		return false;
	}
}
