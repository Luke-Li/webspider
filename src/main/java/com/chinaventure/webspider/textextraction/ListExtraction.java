package com.chinaventure.webspider.textextraction;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

import com.chinaventure.webspider.util.HttpclientUtils;
import com.google.common.base.Stopwatch;

/**
 * Hello world!
 * 
 */
public class ListExtraction {

	public static void extraction(String html) {
		if (StringUtils.isNotBlank(html)) {
			ParseListDocument parseDocument = new ParseListDocument(html);
			
			System.out.println("------------------------------begin------------------------------");
			for (Element item : parseDocument.getList()) {
				System.out.println(item);
			}
			System.out.println("------------------------------end------------------------------");
		}
	}

	public static void main(String[] args) throws IOException {
		/*String[] urls = {"http://www.sem.tsinghua.edu.cn/portalweb/appmanager/portal/sem?_nfpb=true&_pageLabel=P20800273141323412956223",
		"http://www.fashionlife.net.cn/a/edu/","http://www.time-weekly.com/html/caijing/","http://robot.ofweek.com/CATList-8321200-8100-robot.html","http://jingji.cctv.com/shiping/index.shtml"};*/
		//http://www.tmtpost.com/tag/299451
		
		String url;
		Scanner scan = new Scanner(System.in);
		while( StringUtils.isNotBlank(url = scan.nextLine())){
			String html = HttpclientUtils.downloadHtmlRetry(url);

			if (StringUtils.isNotBlank(html)) {
				Stopwatch sw = Stopwatch.createStarted();
				extraction(html);
				/*for (int i = 0; i < 100; i++) {
					extraction(html);
				}*/
				sw.stop();

				System.out.println(MessageFormat.format("耗时:{0} 毫秒",sw.elapsed(TimeUnit.MILLISECONDS)));
			}
		}
		scan.close();
	}
}
