package com.chinaventure.webspider.textextraction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

public class ParseElement {

	private Element element;
	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	private List<TextNode> texts;
	private float weight;
	private int position;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	//private static final Pattern BLANK_REGEXP = Pattern.compile("\\S",Pattern.CASE_INSENSITIVE);
			

	private static boolean checkLength(TextNode node) {
		return StringUtils.isNotBlank(node.text());
//		return BLANK_REGEXP.matcher(node.text()).matches();
	}

	private static final Pattern TINY_REGEXP = Pattern.compile("comment",
			Pattern.CASE_INSENSITIVE);

	private static boolean checkMinorContent(Node node) {
		return TINY_REGEXP.matcher(node.attr("id") + " " + node.attr("class"))
				.matches();
	}

	@SuppressWarnings("serial")
	private static final HashSet<String> IGNORE_TAGS = new HashSet<String>() {
		{
			add("textarea");
			add("a");
			add("dd");
			add("dt");
			add("ol");
			add("option");
			add("dl");
			add("dd");
			add("script");
			add("style");
			add("ul");
			add("li");
			add("iframe");
		}
	};

	private static boolean checkTagName(Element element) {
		return !IGNORE_TAGS.contains(element.tagName().toLowerCase());
	}

	private static final Pattern MAJOR_REGEXP = Pattern.compile(
			"article|entry|post|body|column|main|content|detail|text|details|detail",
			Pattern.CASE_INSENSITIVE);

	private static boolean checkMajorAttr(String attr) {
		return MAJOR_REGEXP.matcher(attr).matches();
	}
	
	private static final Pattern MINOR_REGEXP = Pattern.compile("comment|combx|disqus|foot|header|menu|rss|shoutbox|sidebar|sponsor|wrapper",Pattern.CASE_INSENSITIVE);
	private static boolean checkMinorAttr(String attr) {
		return MINOR_REGEXP.matcher(attr).matches();
	}
	
	public ParseElement(Element element,int position) {
		this.element = element;
		this.position = position;

		this.texts = getAllTexts(element, 6);
		this.weight = calcWeight();
	}

	private float calcWeight() {
		
//		System.out.println("struct:"+ calcStructWeight());
//		System.out.println("conten:"+ calcContentWeight());
		return this.calcStructWeight() * this.calcContentWeight();
	}

	private float calcStructWeight() {
		float t = 0;
		for (int n = 0, r = this.texts.size(); n < r; n++) {
			TextNode i = this.texts.get(n);
			int s = StringUtils.trim(i.text()).length(); 
			float o = 1;
			
			if (s < 20)
				continue;
			for (Node u = i.parent(); null != u && u != this.element; u = u.parent())
				o -= .136;//这个值原来是.1，但由于一些网页图文混排太严重

			t += Math.pow(o * s, 1.25);
		}
		return t;
	}

	private float calcContentWeight(){
        float e = 1;
        for (Element t = this.element;null != t; t = t.parent()) {
        	if(StringUtils.isNotBlank(t.id()) && checkMajorAttr(t.id())){
                e += .4;
            }
        	if(StringUtils.isNotBlank(t.className()) && checkMajorAttr(t.className())){
                e += .4;
            }
            
            if (StringUtils.isNotBlank(t.id()) && checkMinorAttr(t.id())) {
                e -= .8;
            }
            if (StringUtils.isNotBlank(t.className()) && checkMinorAttr(t.className())) {
                e -= .8;
            }
        }
        return e;
    }

	public List<TextNode> getAllTexts(Element element, int level) {
		List<TextNode> result = new ArrayList<TextNode>();
		if (level > 0) {
			if(element.childNodeSize()>0){
				
				Node child = element.childNode(0);
				
				while (null != child) {
					if (child instanceof TextNode) {
						
						TextNode sourceText = (TextNode) child;
						
						if (checkLength(sourceText)) {
							Node s = child.parent(), o = s.parent();

							if (!checkMinorContent(s) && !checkMinorContent(o) && StringUtils.isNotBlank(sourceText.text())) {
								result.add(sourceText);
							}
						}
					} else if (child instanceof Element) {
						Element sourceEl = (Element) child;
						if (checkTagName(sourceEl)) {
							result.addAll(getAllTexts(sourceEl, level - 1));
						}
					}
					child = child.nextSibling();
				}
			}
		}
		return result;
	}
}
