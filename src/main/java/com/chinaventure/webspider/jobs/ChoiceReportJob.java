package com.chinaventure.webspider.jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.log4j.Logger;
import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Producer;
import org.zbus.net.http.Message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.model.jfinal.ChoiceReportBasic;
import com.chinaventure.webspider.model.jfinal.ChoiceReportType;
import com.chinaventure.webspider.model.jfinal.ChoiceStockASeed;
import com.chinaventure.webspider.model.jfinal.ChoiceStockThirdboardSeed;
import com.chinaventure.webspider.util.HttpclientFileUtils;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.NumberUtil;
import com.chinaventure.webspider.util.PropertiesUtil;
import com.chinaventure.webspider.util.StringUtil;

import net.kernal.spiderman.worker.download.Downloader;
import sealion.core.Job;

/**
 * Choice报告的监测JOB
 * 
 * @author Administrator
 *
 */
public class ChoiceReportJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) throws InterruptedException {
		System.out.println("init jfinal start!");
		
		JFConfig.start();

		System.out.println("init jfinal end!");
		
		while (true) {

			Map<String, String> params = new HashMap<>();
			params.put("savePath", PropertiesUtil.getProperty("reportSavePath"));
			params.put("zbus", PropertiesUtil.getProperty("zbus"));
			params.put("start", PropertiesUtil.getProperty("start"));
			params.put("end", PropertiesUtil.getProperty("end"));

			new ChoiceReportJob().execute(params);

			TimeUnit.SECONDS.sleep(60 * 60 * 24);
		}
	}

	Broker broker = null;

	/**
	 * 队列名称-主板
	 */
	String mpNameAStock = "Choice-AStock";
	Producer producerAStock = null;
	/**
	 * 队列名称-新三板
	 */
	String mpNameThirboard = "Choice-Thirdboard";
	Producer producerThirboard = null;

	@Override
	public void execute(Map<String, String> params) {
		try {

			System.out.println("init zbus!");

			broker = new ZbusBroker(params.get("zbus"));

			producerAStock = new Producer(broker, mpNameAStock);
			producerAStock.createMQ();
			producerThirboard = new Producer(broker, mpNameThirboard);
			producerThirboard.createMQ();

			System.out.println("init zbus end!");

			String savePath = params.get("savePath");

			int start = StringUtil.parseInt(params.get("start"),0);
			int end = StringUtil.parseInt(params.get("end"),999);

			String Referer = "http://app.jg.eastmoney.com/html_Notice/index.html?LeftMenuId=F013";

			ReportEntity[] types = {

					new ReportEntity(1, "股转系统公告->定期报告", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=S013001&pageIndex=1&limit=50&sort=date&order=desc"),

					new ReportEntity(2, "股转系统公告->重大事项->资产重组报告书", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=T013006001&pageIndex=1&limit=50&sort=date&order=desc"),

					new ReportEntity(11, "沪深股票公告->IPO", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=S004004&pageIndex=1&limit=50&sort=date&order=desc"),

					new ReportEntity(12, "沪深股票公告->定期报告", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=S004001&pageIndex=1&limit=50&sort=date&order=desc"),

					new ReportEntity(13, "沪深股票公告->重大事项->股份增减持", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=T004002002&pageIndex=1&limit=50&sort=date&order=desc"),

					new ReportEntity(14, "沪深股票公告->重大事项->资产重组", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=T004002004&pageIndex=1&limit=50&sort=date&order=desc"),

					new ReportEntity(15, "沪深股票公告->重大事项->收购兼并", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=T004002005&pageIndex=1&limit=50&sort=date&order=desc"),

					new ReportEntity(16, "沪深股票公告->重大事项->合同协议", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=T004002006&pageIndex=1&limit=50&sort=date&order=desc"),

					new ReportEntity(17, "沪深股票公告->重大事项->资金投向", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=T004002007&pageIndex=1&limit=50&sort=date&order=desc"),

					new ReportEntity(18, "沪深股票公告->重大事项->关联交易", "http://app.jg.eastmoney.com/Notice/GetNoticeById.do?id=T004002008&pageIndex=1&limit=50&sort=date&order=desc"),

					// 下面的是另一种结构
					new ReportEntity(31, "研究报告平台->按报类型->宏观研究->宏观评论", "http://app.jg.eastmoney.com/Report/GetReportByTreeNode.do?id=T004021002&request=simpleSearch&cid=6269014649756994&pageIndex=1&limit=50&sort=datetime&order=desc"),

					new ReportEntity(32, "研究报告平台->按报类型->宏观研究->宏观专题研究", "http://app.jg.eastmoney.com/Report/GetReportByTreeNode.do?id=T004021015&request=simpleSearch&cid=6269014649756994&pageIndex=1&limit=50&sort=datetime&order=desc"),

					new ReportEntity(33, "研究报告平台->按报类型->行业研究（按类型）->行业深度研究", "http://app.jg.eastmoney.com/Report/GetReportByTreeNode.do?id=T004023003&request=simpleSearch&cid=6269014649756994&pageIndex=1&limit=50&sort=datetime&order=desc"),

					new ReportEntity(34, "研究报告平台->按报类型->其他报告->并购重组", "http://app.jg.eastmoney.com/Report/GetReportByTreeNode.do?id=T004013003&request=simpleSearch&cid=6269014649756994&pageIndex=1&limit=50&sort=datetime&order=desc"),

					// 按概念的
			};

			ArrayList<ReportEntity> entitys = new ArrayList<>(Arrays.asList(types));

			JSONArray concepts = JSONArray.parseArray(
					"[{Id:'S007053',Name:'虚拟现实'},{Id:'S007052',Name:'健康产业'},{Id:'S007051',Name:'PPP模式'},{Id:'S007050',Name:'航母概念'},{Id:'S007049',Name:'5G概念'},{Id:'S007048',Name:'2025规划'},{Id:'S007047',Name:'一带一路'},{Id:'S007046',Name:'量子通信'},{Id:'S007045',Name:'体育产业'},{Id:'S007044',Name:'无人机'},{Id:'S007043',Name:'充电桩'},{Id:'S007042',Name:'国产软件'},{Id:'S007041',Name:'在线旅游'},{Id:'S007040',Name:'阿里概念'},{Id:'S007039',Name:'举牌概念'},{Id:'S007038',Name:'国企改革'},{Id:'S007037',Name:'智能家居'},{Id:'S007036',Name:'蓝宝石'},{Id:'S007035',Name:'国家安防'},{Id:'S007034',Name:'电商概念'},{Id:'S007033',Name:'在线教育'},{Id:'S007032',Name:'民营医院'},{Id:'S007031',Name:'智能电视'},{Id:'S007030',Name:'网络安全'},{Id:'S007029',Name:'丝绸之路'},{Id:'S007028',Name:'养老概念'},{Id:'S007027',Name:'智能穿戴'},{Id:'S007026',Name:'4G概念'},{Id:'S007025',Name:'网络金融'},{Id:'S007024',Name:'大数据'},{Id:'S007023',Name:'北斗导航'},{Id:'S007022',Name:'智慧城市'},{Id:'S007021',Name:'美丽中国'},{Id:'S007020',Name:'3D打印'},{Id:'S007019',Name:'石墨烯'},{Id:'S007018',Name:'PM2.5'},{Id:'S007017',Name:'互联网'},{Id:'S007016',Name:'油气设服'},{Id:'S007015',Name:'金融改革'},{Id:'S007014',Name:'页岩气'},{Id:'S007013',Name:'太阳能'},{Id:'S007012',Name:'大订单'},{Id:'S007011',Name:'智能电网'},{Id:'S007010',Name:'云计算'},{Id:'S007009',Name:'核能核电'},{Id:'S007008',Name:'手机支付'},{Id:'S007007',Name:'物联网'},{Id:'S007006',Name:'生物疫苗'},{Id:'S007005',Name:'迪士尼'},{Id:'S007004',Name:'数字电视'},{Id:'S007003',Name:'整体上市'},{Id:'S007002',Name:'节能环保'},{Id:'S007001',Name:'军工'}]");

			String conceptUrl = "http://app.jg.eastmoney.com/Report/GetReportByTreeNode.do?id=%s&request=simpleSearch&cid=6269014649756994&pageIndex=1&limit=100&sort=datetime&order=desc";

			for (int i = 0; i < concepts.size(); i++) {

				String id = concepts.getJSONObject(i).getString("Id");
				String name = concepts.getJSONObject(i).getString("Name");
				ReportEntity entity = new ReportEntity(51 + i, "研究报告平台->按概念->" + name, String.format(conceptUrl, id));
				entitys.add(entity);
			}

			for (int i = 0; i < entitys.size(); i++) {

				ReportEntity entiry = entitys.get(i);

				if (entiry.typeId > end || entiry.typeId < start) {
					continue;
				}

				logger.info(String.format("begin handle %s %s ", entiry.typeId, entiry.typeName));

				Downloader.Request request = new Downloader.Request(entiry.typeUrl);
				request.addHeader("Referer", Referer);

				String jsonHtml = HttpclientUtils.downloadHtmlRetry(request);
				JSONObject baseObject = JSONObject.parseObject(jsonHtml);

				JSONArray records = baseObject.getJSONArray("records");

				for (int j = 0; j < records.size(); j++) {

					JSONObject record = records.getJSONObject(j);
					// 判断报告是否已经存在库中
					String inner_id = record.getString("id");

					Boolean bl = false;
					if (entiry.typeId < 30) {
						bl = ChoiceReportBasic.dao.existByInnerid(inner_id);
					} else {
						bl = ChoiceReportType.dao.existByInnerid(inner_id);
					}

					if (bl) {
						logger.warn(String.format("报告: %s 已经存在,路过本次抓取", record.getString("title")));
						continue;
					}

					logger.info(String.format("开始处理报告: %s", record.getString("title")));
					String[] attachParams = downloadAttach(record, entiry.typeUrl, savePath);

					if (entiry.typeId < 30) {
						ChoiceReportBasic basic = new ChoiceReportBasic();

						basic.set("attachment", attachParams[3]);
						basic.set("file_size", attachParams[0]);
						basic.set("pagenum", attachParams[1]);
						basic.set("url", attachParams[2]);

						basic.set("importLevel", record.getInteger("importLevel"));
						basic.set("report_date", record.getString("date"));

						basic.set("inner_id", record.getString("id"));

						JSONArray secuList = record.getJSONArray("secuList");
						if (secuList.size() > 0) {
							JSONObject secu = secuList.getJSONObject(0);

							basic.set("secuFullCode", secu.getString("secuFullCode"));
							basic.set("secuSName", secu.getString("secuSName"));
							basic.set("secuTypeCode", secu.getString("secuTypeCode"));
						}

						basic.set("title", record.getString("title"));

						basic.set("type", entiry.typeId);

						// 日期
						basic.set("create_time", new Date());
						basic.set("update_time", new Date());

						// 判断报告是否已经存在于库中

						if (entiry.typeId == 1 || entiry.typeId == 12) {// 股转系统公告->定期报告
																		// 新三板
																		// 沪深股票公告->定期报告
																		// A股
							intoZbus(basic);
						}

						basic.save();
					} else {
						ChoiceReportType model = new ChoiceReportType();

						model.set("attachment", attachParams[3]);
						model.set("file_size", attachParams[0]);
						model.set("pagenum", attachParams[1]);
						model.set("url", attachParams[2]);

						// 作者处理
						JSONArray authorList = record.getJSONArray("authorList");
						if (authorList.size() > 0) {
							String auths = StringUtils.EMPTY;
							for (int k = 0; k < authorList.size(); k++) {
								JSONObject authorObject = authorList.getJSONObject(k);
								String auth = authorObject.getString("auth");

								auths += k == 0 ? auth : ("," + auth);
							}

							model.set("author_list", auths);
						}

						model.set("change", record.getString("change"));
						model.set("industry", record.getString("industry"));
						model.set("industrycode", record.getString("industrycode"));
						model.set("inner_id", record.getString("id"));
						model.set("org", record.getString("org"));
						model.set("orgcode", record.getString("orgcode"));
						model.set("publish_date", record.getString("date"));
						model.set("rate", record.getString("rate"));
						model.set("report_date", record.getString("reportDate"));
						model.set("rtype", record.getString("rtype"));
						model.set("rtypecode", record.getString("rtypecode"));
						model.set("title", record.getString("title"));

						model.set("type", entiry.typeId);

						model.set("create_time", new Date());
						model.set("update_time", new Date());

						model.save();
					}
				}

				threadSleep(randDom());
			}

			logger.info("数据处理完成");

		} catch (Exception e) {
			logger.fatal("Choice 报告数据抓取异常", e);
		}
	}

	private Hashtable<String, ChoiceReportBasic> unIntoZbus = new Hashtable<>();

	/**
	 * type =1,新三板 type = 12 A股
	 */
	private void intoZbus(ChoiceReportBasic basic) {
		String code = basic.getStr("secuFullCode");
		String name = basic.getStr("secuSName");
		Integer type = basic.getInt("type");

		if (StringUtils.isNotBlank(code)) {
			code = StringUtils.split(code, '.')[0];
		}

		if (!unIntoZbus.containsKey(code)) {
			unIntoZbus.put(code, basic);
			try {
				Message msg = new Message();
				if (type == 1) {
					ChoiceStockThirdboardSeed stock = new ChoiceStockThirdboardSeed();
					stock.set("code", code);
					stock.set("name", name);

					msg.setBody(SerializationUtils.serialize(stock));

					producerThirboard.sendSync(msg);
				} else if (type == 12) {
					ChoiceStockASeed stock = new ChoiceStockASeed();
					stock.set("code", code);
					stock.set("name", name);

					msg.setBody(SerializationUtils.serialize(stock));

					producerAStock.sendSync(msg);
				}
			} catch (Exception e) {
				logger.error("zbus入队列", e);
			}
		}
	}

	private String[] downloadAttach(JSONObject record, String pageUrl, String savePath) {

		String[] attachParams = new String[4];

		JSONArray attachs = record.getJSONArray("attach");
		if (attachs.size() > 0) {
			JSONObject object = attachs.getJSONObject(0);

			String fileSize = object.getString("fileSize");
			String pagenum = object.getString("pagenum");
			String attachUrl = object.getString("url");

			attachParams[0] = fileSize;
			attachParams[1] = pagenum;
			attachParams[2] = attachUrl;

			HttpGet httpGet = new HttpGet(attachUrl);

			httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpGet.addHeader("Accept-Encoding", "gzip, deflate, sdch");
			httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
			httpGet.addHeader("Connection", "keep-alive");
			httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");

			httpGet.addHeader("Referer", pageUrl);

			threadSleep(randDom());
			String fileName = HttpclientFileUtils.download(httpGet, savePath, null);

			attachParams[3] = fileName;
		}

		return attachParams;
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

/**
 * 报告实体
 */
class ReportEntity {
	public ReportEntity(Integer typeId, String typeName, String typeUrl) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeUrl = typeUrl;
	}

	public Integer typeId;
	public String typeName;
	public String typeUrl;
}
