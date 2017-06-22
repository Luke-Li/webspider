package com.chinaventure.webspider.model.jfinal;

import com.chinaventure.webspider.JFConfig;
import com.jfinal.plugin.activerecord.Model;

public class ChoiceStockThirdboardSeed extends Model<ChoiceStockThirdboardSeed> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1924618217091833528L;
   
	public static ChoiceStockThirdboardSeed dao = new ChoiceStockThirdboardSeed();
	
	public static String TableName = JFConfig.getTableName(ChoiceStockThirdboardSeed.class);
	
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