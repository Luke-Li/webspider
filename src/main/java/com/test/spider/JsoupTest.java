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
			doc = Jsoup.connect("http://gs.amac.org.cn/amac-infodisc/res/pof/manager/101000031615.html").get();

//			Element content = doc.getElementById("zaiyaocontent");
			Elements baseTrs = doc.select("div[class=\"m-manager-list m-list-details\"] > table > tbody > tr");
			
			for (int i = 0; i < baseTrs.size(); i++) {
				Element currentTr = baseTrs.get(i);
				String title = currentTr.child(0).text();

				String text = currentTr.children().size() > 1 ? currentTr.child(1).text() : null;
				
				if(title.contains("机构信息最后更新时间")){
					System.out.println(text);
				}
			}
			
//			Elements gujg = content.getElementsByTag("table");
//			for(int i=0;i<gujg.size();i++){
//				Elements trs = gujg.get(i).getElementsByTag("tr");
//				for(int j=0; j<trs.size();j++){
//					Elements tds = trs.get(j).getElementsByTag("td");
//					for(int k=0; k<tds.size();k++){
//						System.out.println(tds.get(k).text());
//					}
//				}
//			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
