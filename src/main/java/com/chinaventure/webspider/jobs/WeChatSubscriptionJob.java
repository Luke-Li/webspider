package com.chinaventure.webspider.jobs;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
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
import org.zbus.net.http.Message;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.model.jfinal.OpsMonitorMediaIndex;
import com.chinaventure.webspider.model.jfinal.OpsMonitorWechat;
import com.chinaventure.webspider.textextraction.ExtractionResult;
import com.chinaventure.webspider.textextraction.TextExtraction;
import com.chinaventure.webspider.util.FileUtil;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.KafkaProducerHelper;
import com.chinaventure.webspider.util.NumberUtil;
import com.chinaventure.webspider.util.url.UrlStandardization;

import net.kernal.spiderman.worker.download.Downloader;
import sealion.core.Job;

/***
 * 微信公众号JOB
 */
public class WeChatSubscriptionJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		params.put("host", "wechatsubscription");
		params.put("zbus", "192.168.0.72:15555");
		
		new WeChatSubscriptionJob().execute(params);
	}

	/**
	 * 动态含COOKIE信息的下载器
	 */
	QxbDownloader downloadWorker;

	/**
	 * 队列名称
	 */
	String mpName = "Wechat-Sogou";
	
	/**
	 * 下载失败的列表
	 */
	//private ConcurrentLinkedQueue<WechatSogouPublicNo> errorRecords = new ConcurrentLinkedQueue<>();

	/**
	 * 消费者线程
	 */
	Consumer consumer;
	
	@Override
	public void execute(Map<String, String> params) { 
		try {
			JFConfig.start(JFConfig.Database.OpsRdd);
			downloadWorker = new QxbDownloader(params.get("host"));
			
			logger.info("微信监控任务开始启动,版本V1.5");
			
			/**
			 * broker
			 */
			Broker broker = new ZbusBroker(params.get("zbus"));
			
			/* 测试代码
			OpsMonitorWechat stockTemp = OpsMonitorWechat.dao.findFirst(String.format(" select * from %s where id = 128 limit 1", OpsMonitorWechat.TableName));
			handleStock(stockTemp);
			
			if(true)return;
			 */
			
			/**
			 * 消费者--主要是关系属性(解析投资和股东,0：是股东,1：是投资)
			 */
			consumer = new Consumer(broker, mpName);
			consumer.start(new ConsumerHandler() {
				@Override
				public void handle(Message msg, Consumer consumer) {
					OpsMonitorWechat stock = SerializationUtils.deserialize(msg.getBody());
					handleStock(stock);
				}
			});

			/**
			 * 阻止线程退出
			 */
			while (true) {
				threadSleep(100);
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
	private synchronized void handleStock(OpsMonitorWechat stock) {
		Integer id = stock.getInt("id");
		String name = stock.getStr("name");
		try {
			
			logger.info(String.format("公众号:%s---%s 开始处理", id, name));
			if (StringUtils.isNotBlank(name))
				downloadEnt(stock);
			else {
				logger.error(String.format("公众号:%s---%s 未获取到CODE值，抓取跳过", id, name));
			}
		} catch (Exception e) {
			stock.set("crawle_message","抓取异常:" + e.getMessage());
			stock.set("update_time", new Date());
			stock.update();
			logger.error(String.format("公众号:%s---%s 出现未处理的异常", id, name), e);
		}
	}

	/**
	 * 抓取公司数据
	 * 
	 * @param pair
	 * @throws IOException
	 */
	private synchronized void downloadEnt(OpsMonitorWechat stock) throws Exception {
		// 当前股票代码
		String name = stock.getStr("name");
		// 切换下载器
		downloadWorker.nextDownloadWorkerRandom();
		
		stock.set("update_time", new Date());

		String url = String.format("http://weixin.sogou.com/weixin?type=1&query=%s&ie=utf8&_sug_=n&_sug_type_=", URLEncoder.encode(name,"utf-8"));
		
		String html = HttpclientUtils.downloadHtmlRetry(url, downloadWorker.current.getDownloadWorker());

		//FileUtil.writeContent("C:\\Users\\Administrator\\Desktop\\weixin.html", "utf-8", html);
		
		Document doc = Jsoup.parse(html);

		Elements elements = doc.select("ul[class=\"news-list2\"] li");
		
		for (Element element : elements) {
			Element eleTitle = element.select("div[class=\"txt-box\"] p[class=\"tit\"] a").get(0);
			if (name.equalsIgnoreCase(eleTitle.text())) {
				String publicNoUrl = eleTitle.attr("href");
				if(StringUtils.isNotBlank(publicNoUrl)){
					//处理公众号
					Downloader.Request request = new Downloader.Request(publicNoUrl);
					request.addHeader("Referer", url);

					html = HttpclientUtils.downloadHtmlRetry(request, downloadWorker.current.getDownloadWorker());
					
					Document docPublicNo = Jsoup.parse(html);
					Element profile_info = docPublicNo.select("div[class=\"profile_info_area\"]").get(0);
					
					//微信号
					Elements accountEles = profile_info.select("p[class=\"profile_account\"]");
					if(accountEles.size()>0){
						String wechat_no = accountEles.get(0).text();
						stock.set("wechat_no",wechat_no);
					}
					//头像
					String match_pic = profile_info.select("span[class=\"radius_avatar profile_avatar\"] img").get(0).attr("src");
					stock.set("match_pic",match_pic);

					Elements descElements = profile_info.select("ul[class=\"profile_desc\"] li div[class=\"profile_desc_value\"]");
					//介绍 
					String description = descElements.get(0).text();
					stock.set("description",description);
					//主体 
					String subject = descElements.get(1).text();
					stock.set("subject",subject);
					
					
					
					
					stock.setAticleList(OpsMonitorWechat.dao.selectWechatAticle(stock.getInt("id")));
					
					
						String josnStr = StringUtils.substringBetween(html, "var msgList = ", "seajs.use(\"sougou/profile.js\");");
						
						josnStr = StringUtils.substring(josnStr, 0, StringUtils.lastIndexOf(josnStr, ';'));
						
						JSONObject object = JSONObject.parseObject(josnStr);
						JSONArray array = object.getJSONArray("list");
						for (int i = 0; i < array.size(); i++) {
							JSONObject objItem = array.getJSONObject(i);

							Date newsDate = new Date(objItem.getJSONObject("comm_msg_info").getLong("datetime"));
							
							JSONObject app_msg = objItem.getJSONObject("app_msg_ext_info");
							//JSONArray multi_app = app_msg.getJSONArray("multi_app_msg_item_list");
							
							aticleHandle(stock,app_msg,newsDate,publicNoUrl);

							/*for (int j = 0; j < multi_app.size(); j++) {
								JSONObject objItemSub = multi_app.getJSONObject(j);
								aticleHandle(stock,objItemSub,newsDate,publicNoUrl);
							}*/
						}
					
					
					// 数据入库		
					stock.update();
					logger.info(MessageFormat.format("end download name:{0}!", name));
				}
				break;
			}
		}
		threadSleep(randDom());
	}

	private void aticleHandle(OpsMonitorWechat publicNo,JSONObject app_msg,Date time,String publicNoUrl) throws InterruptedException, ExecutionException{
		OpsMonitorMediaIndex aticleModel = new OpsMonitorMediaIndex();
		
		
		aticleModel.set("ref_id",publicNo.getInt("id"));
		aticleModel.set("type",2);
		aticleModel.set("ip",FileUtil.getLocalIp()); 
		
		aticleModel.set("create_time",new Date());

		String title = app_msg.getString("title");

		if(!publicNo.containAticle(title)){

			String digest = app_msg.getString("digest");//subject
			String source = app_msg.getString("author");
			String content_url = app_msg.getString("content_url");
			content_url = UrlStandardization.Normalize(publicNoUrl, StringEscapeUtils.unescapeHtml(StringEscapeUtils.unescapeJava(content_url)))[0];
			aticleModel.set("url",content_url);

			aticleCrawle(aticleModel);
			aticleModel.set("title",title);

			//String cover = app_msg.getString("cover");
			//if(null != cover)aticleModel.setMatchPic(StringEscapeUtils.unescapeHtml(StringEscapeUtils.unescapeJava(cover)));
			//Kafka begin
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String[] datas = new String[11];
			
			datas[0] =  publicNo.getStr("area");//地域 
			datas[1] =  String.valueOf(publicNo.getInt("id"));//来源媒体ID
			datas[2] =  content_url;//url
			datas[3] =  aticleModel.getStr("title");//文章标题
			datas[4] =  digest;//文章主题
			datas[5] =  aticleModel.getContent();//文章内容
			aticleModel.set("len", aticleModel.getContent() == null?0:aticleModel.getContent().length());
			datas[6] =  String.valueOf(publicNo.getInt("frequency"));//监控频率（1-10）
			datas[7] =  source;//数据来源
			datas[8] =  String.valueOf(2);//
			
			datas[9] =  format.format(new Date());//建立时间
			datas[10] =  format.format(new Date());//最后更新时间

			KafkaProducerHelper.getInstance().send("media",content_url, datas);
			//Kafka end
			
			
			aticleModel.save();
		}
		threadSleep(randDom());
	}
	
	//Pattern patSource = Pattern.compile("(来\\s*源[：:].+)");
	/**
	 * 文章详情页面处理
	 * @param aticle
	 */
	private void aticleCrawle(OpsMonitorMediaIndex aticle){
		String html = HttpclientUtils.downloadHtmlRetry(aticle.getStr("url"), downloadWorker.current.getDownloadWorker());
		
		ExtractionResult result = TextExtraction.extraction(html);
		aticle.setContent(result.getContent());
	}
	
	/** 一些通用方法 **/

	/**
	 * 随机生成7到20之间的随机数
	 * 
	 * @return
	 */
	private int randDom() {
		int max = 2;
		int min = 6;

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
