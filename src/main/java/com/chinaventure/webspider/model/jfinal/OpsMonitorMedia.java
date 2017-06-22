package com.chinaventure.webspider.model.jfinal;

import com.chinaventure.webspider.JFConfig;
import com.jfinal.plugin.activerecord.Model;

public class OpsMonitorMedia extends Model<OpsMonitorMedia>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 218850628944464225L;

	public static String TableName = JFConfig.getTableName(OpsMonitorMedia.class);
	
	public static OpsMonitorMedia dao = new OpsMonitorMedia();

	
}
