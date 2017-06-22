package com.chinaventure.webspider.model.jfinal;

import java.util.List;

import com.chinaventure.webspider.JFConfig;
import com.jfinal.plugin.activerecord.Model;

public class ChoiceStockBizInfo extends Model<ChoiceStockBizInfo>{

	
	/**
	 * 自动生成的唯一ID 
	 */
	private static final long serialVersionUID = 8790204962149698571L;
	
	public static ChoiceStockBizInfo dao = new ChoiceStockBizInfo();
	
	
	public final String TableName = JFConfig.getTableName(ChoiceStockBizInfo.class);
	
	public List<ChoiceStockBizInfo> findAll(){
		return  dao.find(String.format("select * from %s ", TableName));
	}
}
