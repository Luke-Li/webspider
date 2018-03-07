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
import com.chinaventure.webspider.bean.ChoiceEntBean;
import com.chinaventure.webspider.bean.ChoiceEntBeanNew;
import com.chinaventure.webspider.model.jfinal.ChoiceErrorLog;
import com.chinaventure.webspider.model.jfinal.ChoiceStockANew;
import com.chinaventure.webspider.model.jfinal.ChoiceStockASeed;
import com.chinaventure.webspider.service.impl.ZbusService;
import com.chinaventure.webspider.util.FileUtil;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.NumberUtil;
import com.chinaventure.webspider.util.PropertiesUtil;
import com.chinaventure.webspider.util.StringUtil;

import net.kernal.spiderman.worker.download.Downloader;
import sealion.core.Job;

/**
 * 测试用的，数据将写到choice_stock_a_new
 */
public class ChoiceStockJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		params.put("zbus", PropertiesUtil.getProperty("zbus"));
		params.put("isInitSeed", PropertiesUtil.getProperty("is_init"));
		new ChoiceStockJob().execute(params);
	}

	private Downloader.Request getChoiceRequest(String url, String referer, String code) {
		String stock_market = code.startsWith("60") ? ".SH" : ".SZ";

		if (StringUtils.isEmpty(referer)) {
//			referer = MessageFormat.format("http://app.jg.eastmoney.com/html_f9/index.html?securitycode={0}{1}&HeadHidden=1", code, stock_market);
			referer = MessageFormat.format("http://app.jg.eastmoney.com/html_f9/index.html?securitycode={0}{1}", code, stock_market);
		} else {
			referer = MessageFormat.format(referer, code);
		}

		if (url.contains("{1}")) {
			url = MessageFormat.format(url, code, stock_market);
		} else {
			url = MessageFormat.format(url, code);
		}

		Downloader.Request request = new Downloader.Request(url);

		request.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
//		request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.59 Safari/537.36");
		request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.94 Safari/537.36");
		request.addHeader("X-Requested-With", "XMLHttpRequest");
		request.addHeader("Referer", referer);
		request.addHeader("Accept-Encoding", "gzip,deflate");
		request.addHeader("Accept-Language", "en-us,en");
//		request.addCookie("emstat_bc_emcount", "38614422101921477329");
//		request.addCookie("emstat_ss_emcount", "0_1498148878_182160029");
//		request.addCookie("st_pvi", "29896496352739");
//		request.addCookie("st_si", "96428275923244");
		request.addCookie(".ASPXAUTH", "492631068A452A96168CE9AD2B08E0F2F05C770AA35B0DF55A2A582226B28584CB1D5E75FAD14440BF7AFC48B1A707A21107D0EA1E31BC2F8884EA6ED6028A52A506D1146B5C87BB54F6AFF22FA078055C68166AD801F8A68791FDD599B64082B9F402CDA0EBA34629D9FFC8F5C2DB933BC3CDD9031E1ED76C5669192FE9A2E1411CA9BB302771624CCB8377D1C8FED892E204322CC9B3CCF23236D3BABF36CD81F2C7826450DFFC8FDF188F937EA8702CDB5B3F37805B9B1947DE289B928948F7BEC2DB21B2034B3FB7858C3979A439E3C1987275909846C6360EED83E80674208F1192340A518C845C78DAD2D56A9472D9FB05CF9FAE4ABA85821ECB2FEA64CAFD017BCA4BEF89C1A2086715C4EC6A1EF2333554B8F5F77D5D6D973227652BE0EFBB1EE5A76AEC1CD748B97B7F5D3B719FEECCF00A0FDFFB8B0B44BFC3159BC93A369D08D364CD34B84DA3A902CC5A3FDF9DD3979322EC9514CB8E54F4107809BEA439CA0473E14CED32E45FBF5E7E3FB1C6F6B8F5BE050C0DD74CC5FF4361");
		request.addCookie("ct", "aaxCYUr5RH8vCOMIxjybdXkoX4CpAlChK3FjDpHnvTuow8OkLn7r0N7IiTKPnXDiMv8PjEeF7HF0_LqscxG6HFqCnwOq4tUwgjriSZQt3yXBwdnMoQX_MEizQ3x4t2NKztaJ8g3q1DAFM5GsKEcTEbf1dtvYlu0WQtFN8xlFqv4");
		request.addCookie("ut", "FobyicMgeV74_Lz6VQjygdsJb-mwmvo-KZoh7v6d7TdHaqoYmMm5TZIYju0QUhNuloQBXfSFBKtWUB7M3FwM7z18t1zunozs7Us2tfVY0oSFV5etNiBEMDR9f1jsm656-1CzG-_P0vtKbpLsGKUjyPLwUrdSpLo31CuxxeU9HamzRD6d-Qg7ZEGbiiwC_dGwvZQV2LINmnwUazY6jbvnu7Rzj05-LF0XPfxptvNt-W7s0K2OnjUwzzqg5G-DH-E6lyQAGVG3p9mu54Sv6lUw2EfrlmJuXgZKm5D0a9gBsHWQFbkKPnU865CZOS_YvSfm");
		request.addCookie("pi", "2968044966403974%3bx2968044966403974%3b%e8%82%a1%e5%8f%8bUZNFas%3bmT6xt8Z70mbcuZ2PPfOQ3mTOWMiBGQ1E9ZW0xKOZTDpXVu3C3Ofq%2bRsmltKksKWCrFio%2f2f484wES47QiIBQ%2fMLTxlumBd09Fv6af0fmp8BKwTPtCXu7OYJZnT9rzsCYqNP8wwLGigwpEIDznFOlzZJdeLYLetRpc7vlJS6qR19CAZdSosK%2bkAGa4S6pLDJGlXespPP1%3bKTybsKTor%2bx4ydDQ%2fVPCJzmYUn5PXPBoOVDZi9Lo1%2bwr1yUSnlDCCInDtV%2bcBAhYv9udvJ1veI9rs0csTROfir%");
		

		return request;
	}

	/**
	 * 下载失败的列表
	 */
	private ConcurrentLinkedQueue<ChoiceStockASeed> errorRecords = new ConcurrentLinkedQueue<>();

	/**
	 * 队列名称
	 */
	String mpName = "Choice-AStock";

	/**
	 * 消费者
	 */
	private Consumer consumer;

	@Override
	public void execute(Map<String, String> params) {
		try {
			JFConfig.start();

			/**
			 * broker
			 */
			Broker broker = new ZbusBroker(params.get("zbus"));

			consumer = new Consumer(broker, mpName);
			
			Boolean isInitSeed = Boolean.parseBoolean(params.get("isInitSeed"));


			
			//handleStock(ChoiceStockASeed.dao.findById(365));
			 

			if (null != isInitSeed && true == isInitSeed) {

				ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

				service.scheduleAtFixedRate(new Runnable() {
					@Override
					public void run() {
						logger.info("开始加载种子");

						try {
							Producer producer = new Producer(broker, mpName);
							producer.createMQ();

							if (ZbusService.mqLength(producer) < 5) {
								logger.info("种子队列为空,可以进行初始化");

								// logger.info("开始清空上一批数据");
								// Db.update(" truncate table " +
								// ChoiceStockA.TableName);

								logger.info("正在加载种子");
								List<ChoiceStockASeed> list = ChoiceStockASeed.dao.find(String.format("select id,code,name from %s", ChoiceStockASeed.TableName));

								if (null != list) {
									for (ChoiceStockASeed stock : list) {
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
				}, 0, 60 * 60 * 24 * 7, TimeUnit.SECONDS);

			}

			consumer.start(new ConsumerHandler() {
				@Override
				public void handle(Message msg, Consumer consumer) {
					ChoiceStockASeed stock = SerializationUtils.deserialize(msg.getBody());
					handleStock(stock);
				}
			});

			// 阻止线程退出
			while (true) {
				threadSleep(15);
				while (!errorRecords.isEmpty()) {
					logger.warn(String.format("开始处理异常队列中的数据，队列中种子数:%s", errorRecords.size()));
					ChoiceStockASeed stock = errorRecords.remove();
					
					handleStock(stock);
				}
			}
		} catch (Exception e) {
			logger.fatal("A股数据抓取", e);
		}
	}

	/**
	 * 处理逻辑
	 * 
	 * @param stock
	 */
	private synchronized void handleStock(ChoiceStockASeed stock) {
		try {
			String name = stock.getStr("name"), code = stock.getStr("code");
			logger.info(String.format("公司:%s--%s 开始处理", code, name));
			if (StringUtils.isNotBlank(code))
				downloadEnt(stock);
			else {
				logger.error(String.format("公司:%s--%s 未获取到CODE值，抓取跳过", code, name));
			}
		} catch (Exception e) {
			if (stock.failCountPlus() < 3) {
				errorRecords.add(stock);
			} else {
				ChoiceErrorLog log = new ChoiceErrorLog();
				log.set("name", stock.getStr("name"));
				log.set("code", stock.getStr("code"));
				log.set("type", 1);
				log.set("description", e.toString());
				log.set("create_time", new Date());
				log.save();
			}
			logger.error(String.format("公司:%s--%s 出现未处理的异常", stock.getStr("code"), stock.getStr("name")), e);
		}
	}

	/**
	 * 抓取公司数据
	 * 
	 * @param pair
	 * @throws IOException
	 */
	private synchronized void downloadEnt(ChoiceStockASeed stock) throws Exception {
		// 当前股票代码
		String code = stock.getStr("code");

//		ChoiceEntBeanNew bean = new ChoiceEntBeanNew();
		ChoiceEntBeanNew bean = new ChoiceEntBeanNew();

		for (String[] item : ChoiceEntBean.EntItems) {
			String name = item[0], url = item[1], referfer = item[2];

			Downloader.Request request = getChoiceRequest(url, referfer, code);
			String html = StringUtil.decodeUnicode(HttpclientUtils.downloadHtmlRetry(request));
			
			
			switch (name) {
			case "info":
				Map<String, Object> map = new HashMap<String, Object>();
				Object tmp = JSONArray.parse(html);
				map = (Map<String,Object>)tmp;
				Map<String,Object> basicInfo = (Map<String,Object>)map.get("companyInfo");
				String entName = (String)basicInfo.get("COMPANYNAME");
				bean.setCode(code);
				bean.setName(entName);
				bean.setCreateTime(new Date());
				bean.setUpdateTime(new Date());
				/*JSONArray array = JSONArray.parseArray(html);
				bean.setInfo(array);
				bean.setCode(code);
				bean.setName(array.getJSONObject(0).getString("col1"));
				bean.setCreateTime(new Date());
				bean.setUpdateTime(new Date());*/
				bean.setInfo(html);
				break;
			/*case "name_history":
				setInfo(bean, html, "曾用名");
				break;
			case "ManageAnalysis":
				setInfo(bean, html, "经营分析");
				break;
			case "SimpleAnalysis":
				setInfo(bean, html, "简史");
				break;*/

			case "EquityCnotrolledCompany":
				bean.EquityCnotrolledCompany = html;// 参控股公司
				break;
			case "StockStructure":
				bean.StockStructure = html;// 股本结构
				break;

			case "Top10Holder":
				// html = parseTop10HolderTable(html, 1);

				bean.Top10Holder = html;// 10大股东明细
				break;
			case "Top10CirculationShareHolder":
				// html = parseTop10HolderTable(html, 1);
				bean.Top10CirculationShareHolder = html;// 10大流通股东
				break;
			case "InstitutionInvestor":
				html = parseTop10HolderTable(html, 0);
				bean.InstitutionInvestor = html;// 机构投资者 HTML格式
				break;
			case "FundHoldStatistic":
				html = parseTop10HolderTable(html, 0);
				bean.FundHoldStatistic = html;// 基金持股统计 HTML格式
				break;

			case "ManagerInfoType1":
				bean.ManagerInfoType1 = html;//
				break;
			case "ManagerInfoType2":
				bean.ManagerInfoType2 = html;//
				break;
			case "ManagerInfoType3":
				bean.ManagerInfoType3 = html;//
				break;
			case "ManagerInfoType4":
				bean.ManagerInfoType4 = html;//
				break;
			case "ManagementRemuneration":
				bean.ManagementRemuneration = html;//
				break;
			case "ManagementStockChange":
				bean.ManagementStockChange = html;//
				break;
			case "DailyMarketData":
				bean.DailyMarketData = html;//
				break;
			case "AssetDebtOrdinary":
				bean.AssetDebtOrdinary = html;//
				break;
			case "AssetDebtSales":	
				bean.AssetDebtSales = html;//
				break;
			case "AssetDebtAssets":	
				bean.AssetDebtAssets = html;//
				break;
			case "AssetDebtGrowth":	
				bean.AssetDebtGrowth = html;//
				break;
			case "ProfitTableOrdinary":
				bean.ProfitTableOrdinary = html;//
				break;
			case "ProfitTableSales":	
				bean.ProfitTableSales = html;//
				break;
			case "ProfitTableGrowth":	
				bean.ProfitTableGrowth = html;//
				break;
			case "CashFlowTableOrdinary":
				bean.CashFlowTableOrdinary = html;//
				break;
			case "CashFlowTableGrowth":	
				bean.CashFlowTableGrowth = html;//
				break;
			case "ShareRed":
				bean.ShareRed = html;//
				break;
			case "MatchStock":
				bean.MatchStock = html;//
				break;
			case "ZengFa":
				bean.ZengFa = html;//
				break;
			case "EachStockIndex":
				bean.EachStockIndex = html;//
				break;
			case "ProfitAndQuantity":
				bean.ProfitAndQuantity = html;//
				break;
			case "CapitalAndRepay":
				bean.CapitalAndRepay = html;//
				break;
			case "BussinessAbility":
				bean.BussinessAbility = html;//
				break;
			case "GrowthAbility":
				bean.GrowthAbility = html;//
				break;
			case "CashFlow":
				bean.CashFlow = html;//
				break;
			case "DuBangAnaysis":
				bean.DuBangAnaysis = html;//
				break;
			case "SingleMonthFinanceIndex":
				bean.SingleMonthFinanceIndex = html;//
				break;
			case "BankIndex":
				bean.BankIndex = html;
				break;

			case "IndustryInfo":
				bean.IndustryInfo = html;
				break;

			case "MainBusinessStructReport_ProjectName":
				bean.MainBusinessStructReport_ProjectName = html;
				break;

			case "MainBusinessStructReport_Industy":
				bean.MainBusinessStructReport_Industy = html;
				break;

			case "MainBusinessStructReport_Product":
				bean.MainBusinessStructReport_Product = html;
				break;

			case "MainBusinessStructReport_Area":
				bean.MainBusinessStructReport_Area = html;
				break;

			default:
				break;
			}

			threadSleep(randDom());
		}
		// 数据入库
		bean.setCookie(FileUtil.getLocalIp());

		ChoiceStockANew.dao.insertOrUpdate(bean);

		logger.info(MessageFormat.format("end download code :{0}  name:{1}!", code, stock.getStr("name")));
	}

	/*private void setInfo(ChoiceEntBeanNew bean, String html, String fieldName) {
		bean.getInfo().forEach(b -> {
			JSONObject o = (JSONObject) b;
			if (StringUtils.equalsIgnoreCase(o.getString("col0"), fieldName)) {
				o.put("col1", html);
			}
		});
	}*/

	/**
	 * 把TABLE解析成JSON字符串格式
	 */
	public String parseTop10HolderTable(String html, int colOffset) {

		html = html.trim();
		html = StringUtils.removeStart(html, "\"");
		html = StringUtils.removeEnd(html, "\"");
		html = StringUtil.decodeUnicode(html);
		html = StringEscapeUtils.unescapeJava(html);

		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("div[class=\"bigbox clearFix\"]");

		if (null == elements) {
			return StringUtils.EMPTY;
		}
		JSONArray array = JSONArray.parseArray("[]");
		for (Element element : elements) {
			String date = element.select("p[class=\"h2_style\"]>span").get(0).text();
			Element table = element.getElementsByTag("table").get(0);

			Elements rows = table.getElementsByTag("tr");
			Elements cols = rows.get(0).getElementsByTag("th");
			for (int i = 1; i < rows.size() - 1; i++) {
				JSONObject object = JSONObject.parseObject("{}");
				object.put("date", date);
				int offset = 0;
				for (int j = 0; j < cols.size() - colOffset; j++) {
					String styleStr = rows.get(i).child(j).attr("style");
					if (styleStr != null && StringUtils.containsIgnoreCase(styleStr, "display:none")) {
						offset++;
					}
					object.put(cols.get(j).text(), rows.get(i).child(j + offset).text());
				}
				array.add(object);
			}
		}
		return array.toJSONString();
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
