package com.chinaventure.webspider.jobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.model.KrEnt;
import com.chinaventure.webspider.service.KrService;
import com.chinaventure.webspider.util.NumberUtil;
import com.google.gson.JsonObject;

import sealion.core.Job;

/**
 * 36kr的监测JOB
 * 
 * @author Administrator
 *
 */
public class KrMonitorJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		new KrMonitorJob().execute(null);
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
				//method.setEntity(new StringEntity(params.toString(), Charset.forName("UTF-8")));
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
	private KrService service;

	@Override
	public void execute(Map<String, String> params) {
		try {
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
			service = context.getBean(KrService.class);

			entHandle();

			logger.info("数据处理完成");

		} catch (Exception e) {
			logger.fatal("36KR数据抓取", e);
		}
	}

	/**
	 * 多次重试下载
	 * @param url
	 * @param referUrl
	 * @param params
	 * @return
	 */
	private JSONObject multipleDownload(String url,String referUrl,JsonObject params){
		for (int i = 0; i < 5; i++) {
			try {
				String html = getJsonContent(url,referUrl,params);
				JSONObject baseObject = JSONObject.parseObject(html);
				
				return baseObject;	
			} catch (Exception e) {
				logger.error("基金下载",e);
				threadSleep(randDom());
			}
		}
		return null;
	}
	
	/**
	 * 公司结构解析
	 * 
	 * @param object
	 * @return
	 */
	private List<KrEnt> parseEnt(JSONObject object) {
		List<KrEnt> list = new ArrayList<>();
		Date now = new Date();
		JSONArray datas = object.getJSONObject("data").getJSONObject("page").getJSONArray("data");
		for (int i = 0; i < datas.size(); i++) {
			JSONObject item = datas.getJSONObject(i).getJSONObject("company");
			
			KrEnt model = new KrEnt();
			
			model.setAddress1(item.getInteger("address1"));
			model.setAddress2(item.getInteger("address2"));
			
			model.setBrief(item.getString("brief"));
			model.setCompanytype(item.getString("companyType"));
			model.setCreatedate(item.getLong("createDate"));
			model.setCreatetime(now);
			model.setCrowdfundingid(item.getInteger("crowdfundingId"));
			model.setFaid(item.getInteger("faId"));
			model.setFinanceeventid(item.getInteger("financeEventId"));
			
			model.setFinancephase(item.getString("financePhase"));
			
			model.setFounder(datas.getJSONObject(i).getString("founder"));
			
			model.setFullname(item.getString("fullName"));
			model.setFundid(item.getInteger("fundId"));
			model.setHasmanager(item.getBoolean("hasManager"));
			
			model.setIndustry(item.getString("industry"));
			model.setIndustry2(item.getInteger("industry2"));
			model.setInnerid(item.getInteger("id"));
			
			model.setLogo(item.getString("logo"));
			
			model.setManagerid(item.getInteger("managerId"));
			model.setName(item.getString("name"));
			model.setStartdate(item.getLong("startDate"));
			model.setStatus(item.getString("status"));
			model.setUpdatedate(item.getLong("updateDate"));
			model.setUpdatetime(now);
			
			list.add(model);
		}

		return list;
	}

	/**
	 * 直投基金处理
	 */
	private void entHandle() {
		//
		JSONArray industrys = JSONArray.parseArray("[{\"desc\":\"其它\",\"id\":0,\"value\":\"OTHER\"},{\"desc\":\"电子商务\",\"id\":1,\"value\":\"E_COMMERCE\"},{\"desc\":\"社交网络\",\"id\":2,\"value\":\"SOCIAL_NETWORK\"},{\"desc\":\"智能硬件\",\"id\":5,\"value\":\"INTELLIGENT_HARDWARE\"},{\"desc\":\"媒体门户\",\"id\":6,\"value\":\"MEDIA\"},{\"desc\":\"工具软件\",\"id\":7,\"value\":\"SOFTWARE\"},{\"desc\":\"消费生活\",\"id\":8,\"value\":\"CONSUMER_LIFESTYLE\"},{\"desc\":\"金融\",\"id\":9,\"value\":\"FINANCE\"},{\"desc\":\"医疗健康\",\"id\":10,\"value\":\"MEDICAL_HEALTH\"},{\"desc\":\"企业服务\",\"id\":11,\"value\":\"SERVICE_INDUSTRIES\"},{\"desc\":\"旅游户外\",\"id\":12,\"value\":\"TRAVEL_OUTDOORS\"},{\"desc\":\"房产家居\",\"id\":13,\"value\":\"PROPERTY_AND_HOME_FURNISHINGS\"},{\"desc\":\"数字娱乐\",\"id\":14,\"value\":\"CULTURE_SPORTS_ART\"},{\"desc\":\"在线教育\",\"id\":15,\"value\":\"EDUCATION_TRAINING\"},{\"desc\":\"汽车交通\",\"id\":16,\"value\":\"AUTO\"},{\"desc\":\"物流\",\"id\":19,\"value\":\"LOGISTICS\"},{\"desc\":\"非TMT\",\"id\":20,\"value\":\"NON_TMT\"}]");
		
		
		logger.info("开始处理kr公司数据。");
		

		
		String url = "https://rong.36kr.com/api/company?city=%s&fincephase=%s&fincestatus=0&industry=%s&page=%s&type=";// page从1开始,size=100
		String referUrl = "https://rong.36kr.com/company/list/?isfinaceStatus=0&page=1&go=0";
		//https://rong.36kr.com/api/company?fincestatus=0&industry=E_COMMERCE&page=1&type=
		//https://rong.36kr.com/api/company?city=101&fincephase=ANGEL&fincestatus=0&industry=E_COMMERCE&page=1&type=
		
		//
		String[] fincephase = {"ANGEL","PRE_A","A","A_PLUS","B","B_PLUS","C","D","E","IPO","NONE"};//天使轮	Pre-A轮	A轮	A+轮		B轮		B+轮		C轮	D轮	E轮及以后	上市   未融资

		String[] citys = {"101","109","21903","21901","21101","22301","102","90000",//北京市	上海市		深圳市		广州市		杭州市		成都市天	津市	海外
				"122","112","134","113","128","119","120","124",//重庆市	安徽省		澳门	福建省		甘肃省		广东省		广西		贵州省
				"121","103","116","108","117","118","107","110",//海南省	河北省		河南省		黑龙江省	湖北省		湖南省		吉林省		江苏省
				"114","106","105","130","129","115","104","127",//江西省	辽宁省		内蒙古		宁夏	青海省		山东省		山西省		陕西省
				"123","132","126","133","131","125","111"//四川省	台湾省		西藏	香港	新疆	云南省		浙江省
		};
		
		for (int i = 0; i < industrys.size(); i++) {
			JSONObject industryObject = industrys.getJSONObject(i);
			 String industry = industryObject.getString("value");
			 for (String city : citys) {
				for (String phase : fincephase) {
					
					logger.info(String.format("city:%s phase:%s  industry:%s 开始处理", city,phase,industry));
					
					logger.info("开始处理第一页数据。");
					int endPage = 1;
					for (int j = 1; j <= endPage; j++) {
						logger.info("开始处理第"+j+"页数据。");
						JSONObject baseObject = multipleDownload(String.format(url,city,phase,industry,j), referUrl,null);
						
						/*修正页面数量*/
						Integer totalPages = baseObject.getJSONObject("data").getJSONObject("page").getInteger("totalPages");
						if(j == 1){endPage = totalPages;}
						
						List<KrEnt> list = new ArrayList<>();

						list.addAll(parseEnt(baseObject));
						service.updateEnts(list);
					}
					
					logger.info(String.format("city:%s phase:%s  industry:%s 处理完成", city,phase,industry));
				}
			}
			 
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
