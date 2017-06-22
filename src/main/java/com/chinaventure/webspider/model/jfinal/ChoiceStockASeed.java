package com.chinaventure.webspider.model.jfinal;

import com.chinaventure.webspider.JFConfig;
import com.jfinal.plugin.activerecord.Model;


public class ChoiceStockASeed extends Model<ChoiceStockASeed>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2969539890925021916L;
  
	public static ChoiceStockASeed dao = new ChoiceStockASeed();
	
	public static String TableName = JFConfig.getTableName(ChoiceStockASeed.class);
	
	/**
	 * 抓取失败的次数
	 */
	public Integer failCount = 0;

	public Integer getFailCount() {
		return failCount;
	}

	public Integer failCountPlus() {
		return this.failCount++;
	}
}