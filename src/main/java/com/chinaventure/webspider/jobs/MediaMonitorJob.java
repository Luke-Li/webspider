package com.chinaventure.webspider.jobs;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Consumer;
import org.zbus.mq.Consumer.ConsumerHandler;
import org.zbus.net.http.Message;

import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.model.jfinal.OpsMonitorMedia;
import com.chinaventure.webspider.model.jfinal.OpsMonitorMediaIndex;
import com.chinaventure.webspider.textextraction.ExtractionResult;
import com.chinaventure.webspider.textextraction.ParseListDocument;
import com.chinaventure.webspider.textextraction.TextExtraction;
import com.chinaventure.webspider.util.FileUtil;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.KafkaProducerHelper;
import com.chinaventure.webspider.util.NumberUtil;
import com.chinaventure.webspider.util.PropertiesUtil;
import com.chinaventure.webspider.util.url.UrlStandardization;

import sealion.core.Job;

/***
 * 微信公众号JOB
 */
public class MediaMonitorJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		params.put("host", "media_monior");
		params.put("zbus", PropertiesUtil.getProperty("zbus"));

		new MediaMonitorJob().execute(params);
	}

	/**
	 * 动态含COOKIE信息的下载器
	 */
	QxbDownloader downloadWorker;

	/**
	 * 下载失败的列表
	 */
	// private ConcurrentLinkedQueue<WechatSogouPublicNo> errorRecords = new
	// ConcurrentLinkedQueue<>();
	/**
	 * 队列名称
	 */
	String mpName = "MediaMonitor";
	/**
	 * 消费者队列
	 */
	Consumer consumer;
	
	//TTransport transport = null;
	
	com.chinaventure.webspider.service.impl.TopicService.Client client;
	
	@Override
	public void execute(Map<String, String> params) {
		try {
			JFConfig.start(JFConfig.Database.OpsRdd);
			
			downloadWorker = new QxbDownloader(params.get("host"));
			
			logger.info("媒体监控任务开始启动,版本V1.4");

			//logger.info(String.format("媒体TOPIC开始处理 ：地址 %s : %s ","192.168.0.67","18090"));
			//transport = new TSocket("192.168.0.67", 18090, 30000);
			// 协议要和服务端一致
			//TProtocol protocol = new TBinaryProtocol(transport);
			//client = new com.chinaventure.webspider.service.impl.TopicService.Client(protocol);
			//transport.open();
			
			/**
			 * broker
			 */
			Broker broker = new ZbusBroker(params.get("zbus"));

			
			//814---http://robot.ofweek.com/CATList-8321200-8100-robot.html
			//774---http://www.lieyunwang.com/d/shejiao
			/*
			MediaMonitor tempStock = service.selectByKey(774);
			handleStock(tempStock);
			
			tempStock = service.selectByKey(814);
			handleStock(tempStock);
			
			if(true)return;
			*/
			
			
			
			/**
			 * 消费者--主要是关系属性(解析投资和股东,0：是股东,1：是投资)
			 */
			consumer = new Consumer(broker, mpName);

			consumer.start(new ConsumerHandler() {
				@Override
				public void handle(Message msg, Consumer consumer) {
					OpsMonitorMedia stock = SerializationUtils.deserialize(msg.getBody());
					handleStock(stock);
				}
			});
			
			
			/**
			 * 阻止线程退出
			 */
			while (true) {
				threadSleep(15);
			}
		} catch (Exception e) {
			logger.fatal("媒体监控", e);
		}finally {
			//if (null != transport) {
			//	transport.close();
			//}
		}
	}

	/**
	 * 处理逻辑
	 * 
	 * @param stock
	 */
	private synchronized void handleStock(OpsMonitorMedia stock) {
		Integer id = stock.getInt("id");
		String url = stock.getStr("url");
		try {
			logger.info(String.format("媒体:%s---%s 开始处理",id , url));
			if (StringUtils.isNotBlank(url))
				downloadEnt(stock);
			else {
				logger.error(String.format("媒体:%s---%s 未获取到CODE值，抓取跳过", id, url));
			}
		} catch (Exception e) {
			logger.error(String.format("媒体:%s---%s 出现未处理的异常", id, url), e);
			stock.set("is_success",false);
			stock.set("result_note","抓取异常:" + e.getMessage());
			stock.set("update_time", new Date());
			
			stock.update();
		}
	}

	/**
	 * 抓取公司数据
	 * 
	 * @param pair
	 * @throws IOException
	 */
	private synchronized void downloadEnt(OpsMonitorMedia stock) throws Exception {

		// 切换下载器
		downloadWorker.nextDownloadWorkerRandom();

		String url = stock.getStr("url");

		String html = HttpclientUtils.downloadHtmlRetry(url, downloadWorker.current.getDownloadWorker());

		if (stock.getInt("id") == 4) {
			html = StringUtils.replaceEach(html, new String[] { "document.writeln(\"", "\");" }, new String[] { "", "" });
		}

		Elements elements;
		// 如果已定义表达式，则按表达式处理，如未定义就使用智能提取算法
		String list_expression = stock.getStr("list_expression");
		if (StringUtils.isNotBlank(list_expression)) {
			Document doc = Jsoup.parse(html);
			elements = doc.select(list_expression);
		} else {
			ParseListDocument parseDocument = new ParseListDocument(html);
			elements = new Elements(parseDocument.getList());
		}

		Elements eleTagA = new Elements();
		for (Element element : elements) {
			if (!StringUtils.endsWith(list_expression, " a")) {
				eleTagA.addAll(element.getElementsByTag("a"));
			} else {
				eleTagA.add(element);
			}
		}

		if (eleTagA.size() > 0) {
			for (Element element : eleTagA) {
				aticleHandle(stock, element);
			}
			stock.set("result_note","提取文章数量:" + eleTagA.size());
		} else {
			stock.set("result_note","未提取到信息请检查,ajax,表达式,");
		}

		stock.set("is_success",true);
		// 数据入库
		stock.update();
		logger.info(MessageFormat.format("end download code :{0}  name:{1}!", stock.getInt("id"), url));
		threadSleep(randDom());
	}

	
	private void aticleHandle(OpsMonitorMedia publicNo, Element element) throws TException, InterruptedException, ExecutionException {
		OpsMonitorMediaIndex aticleModel = new OpsMonitorMediaIndex();

		aticleModel.set("ref_id",publicNo.getInt("id"));
		aticleModel.set("type",1);

		String href = element.attr("href");
		if(href == null || href.trim().length()<2){
			return;
		}
		
		String url;
		if (href.startsWith("javascript:")) {
			url = publicNo.getStr("url") + "?clipperUrl=" + StringUtils.replaceEach(href, new String[] { "javascript:goToInfoDetail('", "');" }, new String[] { "", "" });
		} else {
			url = UrlStandardization.Normalize(publicNo.getStr("url"), href)[0];
		}

		if(url.startsWith("http://intl.ce.cn/intlpic/") ||  url.startsWith("http://intl.ce.cn/qqss/")){
			return;
		}
		
		if(OpsMonitorMediaIndex.dao.containsUrl(url)){
			logger.warn("URL:"+url+" 已经包含在数据库中！");
			return;
		}
		
		if (!url.endsWith(".pdf")) {
			aticleModel.set("create_time",new Date());

			aticleModel.set("url",url);
				//&& !publicNo.containsTitle(aticleModel.getTitle()) 根据TITLE过滤
			if(aticleCrawle(publicNo,aticleModel) ){

				String title = aticleModel.getStr("title");

				if(StringUtils.isBlank(title) || StringUtils.containsAny(title, "Error","�","404","403","503","无法找到该","感谢您的浏览","<!---->","连接报错","无法找到该页","504")){
					
				}else if(StringUtils.equalsIgnoreCase(title, "-[中财网]")){
					
				}else if(StringUtils.isBlank(aticleModel.getContent())){
					
				}else{
					title = title.replace("_中国产业经济网", "");
					
					//Kafka begin
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					
					String[] datas = new String[11];
					
					datas[0] =  publicNo.getStr("area");//地域 
					datas[1] =  String.valueOf(publicNo.getInt("id"));//来源媒体ID
					datas[2] =  url;//url
					datas[3] =  aticleModel.getStr("title");//文章标题
					datas[4] =  "";//文章主题
					datas[5] =  aticleModel.getContent();//文章内容
					aticleModel.set("len", aticleModel.getContent() == null?0:aticleModel.getContent().length());
					datas[6] =  String.valueOf(publicNo.getInt("frequency"));//监控频率（1-10）
					datas[7] =  "";//数据来源
					datas[8] =  String.valueOf(1);//
					
					datas[9] =  format.format(new Date());//建立时间
					datas[10] =  format.format(new Date());//最后更新时间

					//入库时再判断一次
					if(OpsMonitorMediaIndex.dao.containsUrl(url)){
						logger.warn("URL:"+url+" 已经包含在数据库中！");
						return;
					}
					
					KafkaProducerHelper.getInstance().send("media",url, datas);
					//Kafka end

					aticleModel.set("ip",FileUtil.getLocalIp()); 
					aticleModel.save();
				}
			}else{
				logger.info(String.format("url:%s 被过滤可能原因是未提取到正文内容",url));
			}
			
			threadSleep(3);
		}
	}

	// Pattern patSource = Pattern.compile("(来\\s*源[：:].+)");
	/**
	 * 文章详情页面处理
	 * 
	 * @param aticle
	 */
	private boolean aticleCrawle(OpsMonitorMedia publicNo,OpsMonitorMediaIndex aticle) {
		String html = HttpclientUtils.downloadHtmlRetry(aticle.getStr("url"), downloadWorker.current.getDownloadWorker());
		if (null != html) {
			ExtractionResult result = TextExtraction.extraction(html);
			aticle.set("title",result.getTitle());
			
			String title_expression = publicNo.getStr("title_expression");
			if(StringUtils.isNoneBlank(title_expression)){
				Elements eleTitle = Jsoup.parse(html).select(title_expression);
				if(null != eleTitle && eleTitle.size()>0){
					if(eleTitle.get(0).text().length() < 1500){
						aticle.set("title",eleTitle.get(0).text());
					}
				}
			}

			if(result.getContent() != null && result.getContent().length()>51789){
				return false;
			}
			
			aticle.setContent(result.getContent());
			return true;
		} else
			return false;
	}

	/** 一些通用方法 **/

	/**
	 * 随机生成7到20之间的随机数
	 * 
	 * @return
	 */
	private int randDom() {
		int max = 1;
		int min = 3;

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
