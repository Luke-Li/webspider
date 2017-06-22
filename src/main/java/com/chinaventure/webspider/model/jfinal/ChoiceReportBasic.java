package com.chinaventure.webspider.model.jfinal;

import com.chinaventure.webspider.JFConfig;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

public class ChoiceReportBasic extends Model<ChoiceReportBasic>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2790150664360333323L;
	public static ChoiceReportBasic dao = new ChoiceReportBasic();
	
	public final String TableName = JFConfig.getTableName(getClass());
	
	public Boolean existByInnerid(String inner_id) {
		return Db.queryLong("select count(0) from "+TableName+" where inner_id = ? ",inner_id)>0; 
	}
}
