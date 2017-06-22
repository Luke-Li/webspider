package com.chinaventure.webspider;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.chinaventure.webspider.util.HttpclientUtils;
import com.google.common.io.Files;

public class WangyiJob {
	private static HashSet<String> urls = new HashSet<>();
	private static LinkedBlockingQueue<String> pageQueue = new LinkedBlockingQueue<>();

	private static void addQueue(String url) throws InterruptedException{
		if(!urls.contains(url)){
			pageQueue.put(url);
		}
	}
	
	private static void saveFile(String url,String content){
		try {
			Files.write(content, new File("D:\\html\\lady\\"+URLEncoder.encode(url)), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			pageQueue.put("http://news.163.com/special/0001386F/rank_lady.html");

			while (pageQueue.size() > 0) {
				String url = pageQueue.take();
				if(urls.contains(url))continue;
			
				urls.add(url);
				
				String html = HttpclientUtils.downloadHtmlRetry(url);
				
				if(null == html)continue;
				
				Document doc = Jsoup.parse(html);
				Elements eles = doc.select("div[class=\"pages\"] a");
				if (null != eles) {
					for (Element elementPage : eles) {
						addQueue(elementPage.attr("href"));
					}
				}
				
				eles = doc.select("div[class=\"tabBox\"] a");
				if (null != eles) {
					for (Element elementContent : eles) {
						url = elementContent.attr("href");
						if(urls.contains(url))continue;else{
							urls.add(url);
						}
						
						html = HttpclientUtils.downloadHtmlRetry(url);
						
						if(null == html)continue;
						doc = Jsoup.parse(html);
						eles = doc.select("div[id=\"endText\"]");
						
						if(null != eles && eles.size()>0){
							String htmlContent = eles.get(0).text();
							if(htmlContent != null && htmlContent.length()>30){
								htmlContent = htmlContent.replace("本文来源：网易娱乐", "").replace("责任编辑：", "");
								
								saveFile(url, htmlContent);
							}
						}
						
						TimeUnit.SECONDS.sleep(2);
					}
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
