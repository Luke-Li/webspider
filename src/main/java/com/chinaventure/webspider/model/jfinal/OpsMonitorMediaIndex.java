package com.chinaventure.webspider.model.jfinal;

import com.chinaventure.webspider.JFConfig;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

public class OpsMonitorMediaIndex extends Model<OpsMonitorMediaIndex>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7848753454491818678L;

	public static String TableName = JFConfig.getTableName(OpsMonitorMediaIndex.class);
	
	public static OpsMonitorMediaIndex dao = new OpsMonitorMediaIndex();

	/**
	 * 是否包含URL
	 * @param url
	 * @return
	 */
	public boolean containsUrl(String url) {
		return Db.queryLong(String.format("select count(0) from %s where url = ? ", TableName), url)>0;
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
