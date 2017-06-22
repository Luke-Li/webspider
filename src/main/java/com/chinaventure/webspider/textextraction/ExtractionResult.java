package com.chinaventure.webspider.textextraction;

import java.io.Serializable;

public class ExtractionResult implements Serializable {
    
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String content;

    private String title;

    private String keyworkds;
    
    private String description;
    
    /**
     * construct method
     * @param title title
     * @param content main content
     */
    public ExtractionResult(String title, String content,String keyworkds,String description) {
    	this.title = title;
    	this.content = content;
    	this.keyworkds = keyworkds;
    	this.description = description;
	}

	/**/
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyworkds() {
		return keyworkds;
	}

	public void setKeyworkds(String keyworkds) {
		this.keyworkds = keyworkds;
	}
}
