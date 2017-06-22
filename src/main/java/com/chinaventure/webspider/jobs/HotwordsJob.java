package com.chinaventure.webspider.jobs;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.chinaventure.webspider.util.SqlHelper;
import com.chinaventure.webspider.util.StringUtil;

import net.kernal.spiderman.worker.download.Downloader;
import sealion.core.Job;
/**
 * 热词解析
 * @author Administrator
 *
 */
public class HotwordsJob  extends Job {
	Logger logger = Logger.getLogger(getClass());
	
	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		params.put("interval", "-24");
		params.put("frequency", "5");
		new HotwordsJob().execute(params);
	}

	/**
	 * spring
	 */
	//private static ApplicationContext context;

	@Override
	public void execute(Map<String, String> params){
		try {
			//context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			Integer interval = Integer.parseInt(params.get("interval"));
			//Integer frequency = Integer.parseInt(params.get("frequency"));
			
			LocalDateTime dateStart = LocalDateTime.now();
			dateStart = dateStart.plusHours(interval);
			//LocalDateTime dateEnd = null; //LocalDateTime.now();
			
			/*
			List<MediaMonitorLog> listLog = service.selectMediaLogByDate(dateStart,dateEnd);
			logger.info("本次摘取文章数量:"+listLog.size());
			HashMap<String, Integer> wordFrequency = new HashMap<>();
			for (MediaMonitorLog mediaMonitorLog : listLog) {
				List<String> words = WordSegmentUtil.getWordSegment(mediaMonitorLog.getTitle());
				if(null != words){
					for (String word : words) {
						if(wordFrequency.containsKey(word)){
							wordFrequency.put(word, wordFrequency.get(word)+1);
						}else{
							wordFrequency.put(word,1);
						}
					}
				}
			}
			String sql = " INSERT INTO `media_hotwords` (`keyword`, `frequency`, `create_time`, `begin_time`) VALUES (?, ?, ?, ?) ";
			Object[] parameters = new Object[4];
			parameters[2] = new Date();
			for (Entry<String, Integer> result : wordFrequency.entrySet()) {
				if(result.getValue()>frequency){
					parameters[0] = result.getKey();
					parameters[1] = result.getValue();
					parameters[3] = dateStart;
					SqlHelper.executeUpdate(sql,parameters);
				}
			}*/
			
			
			HashSet<String> words = new HashSet<>();
			
			String selectSql = " select keyword from media_hotwords where create_time > ? ";
			Object[] parameters =  {dateStart};
			ResultSet rs = SqlHelper.executeQuery(selectSql, parameters);
			while(rs.next()){
				String keyword = rs.getString("keyword");
				words.add(keyword);
			}  
			
			//我们简单暴力的使用百度的结果
			Downloader.Request request = new Downloader.Request("http://news.baidu.com/n?m=rddata&v=hot_word&type=6&date=");
			request.addHeader("Referer", "http://news.baidu.com/n?cmd=1&class=reci");
			
			String html = HttpclientUtils.downloadHtmlRetry(request);
			Integer count = 0;
			Integer totalCount = 0;
			if(null != html){
				html = StringUtil.decodeUnicode(html);
				JSONObject rootObject = JSON.parseObject(html);
				JSONArray dataArray = rootObject.getJSONArray("data");
				
				/* "title": "人民币中间价跌破6.6",
            "desc": "人民币中间价上调59点,6.7关口料不...",
            "query_word": "人民币 中间价",
            "image": "",
            "image_v": ""*/
				
				String insertSql = "INSERT INTO `media_hotwords` (`keyword`, `frequency`, `desc`, `query_word`, `image`, `image_v`, `create_time`) VALUES (?, ?, ?, ?, ?, ?, ?)";
				
				parameters = new Object[7];
				parameters[6] = new Date();
				for (int i = 0; i < dataArray.size(); i++) {
					JSONObject object = dataArray.getJSONObject(i);
					String title = object.getString("title");
					totalCount++;
					
					if(!words.contains(title)){
						parameters[0] = title;
						parameters[1] = 1;
						parameters[2] = object.getString("desc");
						parameters[3] = object.getString("query_word");
						parameters[4] =  object.getString("image");
						parameters[5] = object.getString("image_v");
	
						SqlHelper.executeUpdate(insertSql,parameters);
						count++;
					}
				}
			}
			
			logger.info(String.format("热词发现执行结束，前端返回热词数量:%s 入库数量 ：%s",totalCount,count));
			
		} catch (Exception e) {
			logger.error("热词发现服务",e);
		}
	}
}
