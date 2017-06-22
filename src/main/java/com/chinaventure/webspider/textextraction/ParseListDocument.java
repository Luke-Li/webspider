package com.chinaventure.webspider.textextraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class ParseListDocument {
	
	/*文档*/
	private Document doc;
	/*文档中元素的位置*/
	private int index;
	/*主文本元素权重值 一般取500，但由于图片类和视频网站，我们这里暂取400,但如果小于该阀值，我们认为当前网页没有正文*/
	private double weight = 400;
	
	public ParseListDocument(String html) {		
		doc = Jsoup.parse(html);
		index = 1;
	}

	@SuppressWarnings("serial")
	static final HashSet<String> IGNORE_TAGS = new HashSet<String>() {
		{
			add("html");
			add("head");
			add("meta");
			add("title");
			add("script");
			add("style");
			add("link");
			add("img");
			add("form");
			add("input");
			add("body");
			add("button");
			add("textarea");
			add("select");
			add("option");
			add("label");
			add("iframe");
			add("ul");
			add("ol");
			add("li");
			add("dd");
			add("dl");
			add("dt");
			add("a");
			add("object");
			add("param");
			add("embed");
			add("noscript");
			add("em");
			add("b");
			add("strong");
			add("i");
			add("ins");
			add("br");
			add("hr");
			add("pre");
			add("h1");
			add("h2");
			add("h3");
			add("h4");
			add("h5");
			add("cite");
		}
	};

	static boolean checkTagName(Element element) {
		return IGNORE_TAGS.contains(element.tagName().toLowerCase());
	}

	static boolean checkVisibility(Element element) {
		if (element.hasAttr("style")) {
			String style = element.attr("style").toLowerCase();

			String[] items = style.trim().split(";");
			for (String item : items) {
				String[] keyValue = item.split(":");
				if (2 == keyValue.length) {
					String key = keyValue[0].trim();
					String value = keyValue[1].trim();

					if ("display".equalsIgnoreCase(key)) {
						if ("none".equalsIgnoreCase(value))
							return true;
					} else if ("visibility".equalsIgnoreCase(key)) {
						if ("hidden".equalsIgnoreCase(value))
							return true;
					} else if ("width".equalsIgnoreCase(key)
							|| "height".equalsIgnoreCase(key)) {
						if ("0".equalsIgnoreCase(value)
								|| "0px".equalsIgnoreCase(value)) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	private List<ParseListElement> getAllArticle() {
		List<ParseListElement> result = new ArrayList<ParseListElement>();

		Elements eles = doc.getAllElements();

//		System.out.println(eles.size());
		
		for (Element element : eles) {
			index++;

			if (!(element.tagName().equalsIgnoreCase("#root") || element.tagName().equalsIgnoreCase("header") || element.tagName().equalsIgnoreCase("body")) && element.text().length() > 15){
				if (!checkTagName(element) && !checkVisibility(element)) {
					result.add(new ParseListElement(element,index));
				}
			}
		}

		return result;
	}

	public Element getMainArticle() {
		
		List<ParseListElement> n = this.getAllArticle();
		
		if (null == n || 0 == n.size())return null;
		
		Collections.sort(n, new Comparator<ParseListElement>() {
			public int compare(ParseListElement a, ParseListElement b) {
				return (int)(b.getWeight() - a.getWeight());
			}});
		
		/**滤波算法
		 * 
		 *主要因素：
		 *
		 *	1，位置  总位置除以当前元素的位置可以得到当前元素的大概位置
		 *		 比如当前元素位置为86，总元素位置是175  那么 86/175 = 0.49425
		 *		 可以推理出当前元素位置应该在网页中间。
		 * 
		 *	2，权重  正常文本设置为500，图片类型网站视情况而定
		 * 
		 * 	3，按权重排序以后，一般我们只需要判断到第二个元素
		 *  
		 *  4,算法流程介绍
		 * 	权重最高的元素并且位置介于20% -- 80%时，我们取第一个元素
		 * 	
		 * 	当第二个元素权重和第一个元素相当时（公式：【e.getWeight() - t.getWeight())/e.getWeight() < 0.15 】)，我们再按第二个元素的位置取加权
		 * 
		 * 	最终选出正文元素节点
		 * 	
		 */
		
		ParseListElement e = n.get(0),t = null;

		if(e.getWeight() > weight){
			
			float totalPosition = index;
			float pe = e.getPosition()/totalPosition;
			
			if(0.2 < pe && pe < 0.8)
			{
				
			}else {
				if(1 < n.size()){
					t = n.get(1);
					pe = t.getPosition()/totalPosition;
					
					if(0.2 < pe && pe < 0.8 && (e.getWeight() - t.getWeight())/e.getWeight() < 0.15)
					{
						return t.getElement();
					}
				}	
			}

			return e.getElement();
		}else {
			return null;
		}

	}
	
	private static final Pattern LIST_REGEXP = Pattern.compile("pre|Previous|next|Previous Page|Next Page|其它|评论|条相关|更多|首页|上一页|下一页|末页|\\d+|\\[\\w+\\]",
			Pattern.CASE_INSENSITIVE);
	
	
	
	public List<Element> getList(){
		List<Element> listA = new ArrayList<>();
		
		Element listEle = getMainArticle();
		if(null != listEle){
		Elements as = listEle.getElementsByTag("a");
		if(null != as){
			int i = 0;
			for (Element aEle : as) {
				if(!LIST_REGEXP.matcher(aEle.text().trim()).matches() && checkAtag(aEle)){
					Element chooseEle = choseAtag(aEle);
					if(null != chooseEle && !containsAtag(listA,chooseEle)){
						listA.add(chooseEle);
						i++;
						if(i>=50){
							break;
						}
					}
				}
			}
		}
		}
		return listA;
	} 

	private static final Pattern LIST_HREF_REGEXP = Pattern.compile(".*tag=.*|.*/tag/.*|.*/user/.*|.*/space/.*",Pattern.CASE_INSENSITIVE);
	private boolean checkAtag(Element chooseEle){
		if(StringUtils.isNotBlank(chooseEle.text()) && StringUtils.isNotBlank(chooseEle.attr("href")) && !LIST_HREF_REGEXP.matcher(chooseEle.attr("href")).matches() && chooseEle.text().trim().length()>4){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean containsAtag(List<Element> listA,Element chooseEle){
		for (Element element : listA) {
			if(element.attr("href").equalsIgnoreCase(chooseEle.attr("href"))){
				return true;
			}
		}
		return false;
	}
	
	private Element choseAtag(Element aEle){
		Element s = aEle.parent(), o = s.parent(),k=o.parent();
		
		Elements[] preAsArray = {k.getElementsByTag("a"),o.getElementsByTag("a"),s.getElementsByTag("a")};
		for (Elements preAs : preAsArray) {
			if(preAs.size()<4){
				Element current = null;
				for (Element element : preAs) {
					if(null != current){
						String eleText = element.text().trim();
						if(eleText.length() > current.text().length() && !LIST_REGEXP.matcher(eleText).matches()){
							current = element;
						}
					}else{
						current = element;
					}
				}
				return current;
			}
		}
		return null;
	}
	
	public String getKeywords()
	{
		Element head = doc.head();
		if (null != head) {
			Elements select = head.select("meta[name=keywords]");
			if(null != select)
			{
				return select.attr("content") == null ? StringUtils.EMPTY : select.attr("content");
			}			
		}
		
		return StringUtils.EMPTY;
	}
	
	public String getDescription()
	{
		Element head = doc.head();
		if (null != head) {
			Elements select = head.select("meta[name=description]");
			if(null != select)
			{
				return select.attr("content") == null ? StringUtils.EMPTY : select.attr("content");
			}			
		}
		
		return StringUtils.EMPTY;
	}
	
	public String getTitle(){
		
        String curTitle = doc.title();
        
        if(StringUtils.isNotBlank(curTitle)){
        	char ch1 = '-',ch2 = '_';
        	if(curTitle.indexOf(ch1) > 0){
        		curTitle = separatorTitle(curTitle,ch1);
        	}else if(curTitle.indexOf(ch2)>0){
        		curTitle = separatorTitle(curTitle,ch2);
			}
        }

		return curTitle;
	}
	
	private String separatorTitle(String title,char ch)
	{
		String[] titles = StringUtils.split(title, ch);
		if(titles[0].length()>titles[1].length())
        return titles[0];else{
        	return title;
        }
	}
}
