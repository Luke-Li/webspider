package com.chinaventure.webspider.model.jfinal;

import com.chinaventure.webspider.JFConfig;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

public class ChoiceReportType extends Model<ChoiceReportType>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1387218135009268342L;
	
	public static ChoiceReportType dao = new ChoiceReportType();

	public final String TableName = JFConfig.getTableName(getClass());
	

	public Boolean existByInnerid(String inner_id) {
		return Db.queryLong("select count(0) from "+TableName+" where inner_id = ? ",inner_id)>0; 
	}
}
