package com.test.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
	public static void main(String argv[]) {

		try {
			Document doc;
			doc = Jsoup.connect("http://stockdata.stock.hexun.com/2009_gbjg_000001.shtml").get();

			Element content = doc.getElementById("zaiyaocontent");
			Elements gujg = content.getElementsByTag("table");
			for(int i=0;i<gujg.size();i++){
				Elements trs = gujg.get(i).getElementsByTag("tr");
				for(int j=0; j<trs.size();j++){
					Elements tds = trs.get(j).getElementsByTag("td");
					for(int k=0; k<tds.size();k++){
						System.out.println(tds.get(k).text());
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
