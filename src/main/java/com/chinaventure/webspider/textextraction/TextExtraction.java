package com.chinaventure.webspider.textextraction;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.chinaventure.webspider.util.AppConst;
import com.chinaventure.webspider.util.HttpclientUtils;
import com.google.common.base.Stopwatch;

/**
 * Hello world!
 * 
 */
public class TextExtraction {

	public static ExtractionResult extraction(String html) {
		if (StringUtils.isNotBlank(html)) {

			ParseDocument parseDocument = new ParseDocument(html);

			ExtractionResult result = new ExtractionResult(parseDocument.getTitle(), parseDocument.getMainArticle(),
					parseDocument.getKeywords(), parseDocument.getDescription());

			return result;
		} else {
			return null;
		}

	}

	public static void main(String[] args) throws IOException {
		//String url = "http://www.lieyunwang.com/news/45760";
		//String url = "http://news.qq.com/a/20150716/003730.htm?tu_biz=1.114.1.0";
		//String url = "http://economy.caijing.com.cn/20160707/4144693.shtml";
		//String url = "http://gold.hexun.com/2016-07-06/184787391.html";
		//String url = "http://money.163.com/16/0706/14/BRA2RJ4G00253B0H.html";
		//String url = "http://www.ebusinessreview.cn/politics-1";
		//String url = "http://finance.jrj.com.cn/tech/2016/07/08111821166006.shtml";
		//String url = "http://stock.jrj.com.cn/2016/07/11102621172200.shtml";
		String url = "http://www.cfi.net.cn/p20160802000491.html";
		
		//String url = "http://news.china.com.cn/live/2016-07/26/content_36575411.htm";
		
		String html = HttpclientUtils.downloadHtmlRetry(url);

		if (StringUtils.isNotBlank(html)) {
			ExtractionResult result = TextExtraction.extraction(html.toString());

			/*
			Stopwatch sw = Stopwatch.createStarted();
			for (int i = 0; i < 100; i++) {
				result = TextExtraction.extraction(html.toString());
			}*/
			String content = result.getContent();
			String title = result.getTitle();

			//sw.stop();

			System.out.println(MessageFormat.format("title:{0} {1}content:{1}{2}{1}", title,AppConst.NewLineSymbol, content));
		}
	}
}
