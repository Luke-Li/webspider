package com.chinaventure.webspider.model.jfinal;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.chinaventure.webspider.JFConfig;
import com.jfinal.plugin.activerecord.Model;

public class OpsMonitorWechat extends Model<OpsMonitorWechat>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2939333425426781969L;

	public static String TableName = JFConfig.getTableName(OpsMonitorWechat.class);
	
	public static OpsMonitorWechat dao = new OpsMonitorWechat();

	public List<OpsMonitorMediaIndex> selectWechatAticle(Integer refId){
		return OpsMonitorMediaIndex.dao.find(String.format("select title from %s where type = 2 and ref_id = ?", OpsMonitorMediaIndex.TableName), refId);
	}
	
	private List<OpsMonitorMediaIndex> aticleList;

	public void setAticleList(List<OpsMonitorMediaIndex> aticleList) {
		this.aticleList = aticleList;
	}
	
	/**
	 * 微信中是否包含标题
	 * @param title
	 * @return
	 */
	public boolean containAticle(String title){
		for (OpsMonitorMediaIndex aticle : aticleList) {
			if(StringUtils.equalsIgnoreCase(aticle.getStr("title"),title)){
				return true;
			}
		}
		
		return false;
	}
}
