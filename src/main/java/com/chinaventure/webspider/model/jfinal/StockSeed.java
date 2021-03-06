package com.chinaventure.webspider.model.jfinal;

import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.util.TimeUtil;
import com.jfinal.plugin.activerecord.Model;

public class StockSeed extends Model<StockSeed>{

	private static final long serialVersionUID = -6057105866308614723L;

	public static final String TableName = JFConfig.getTableName(StockSeed.class);

	public static StockSeed dao = new StockSeed();
	
	
	public void addSeed(String name, String code){
		if(!isStored(code)){
			StockSeed seed = StockSeed.dao.findFirst("select * from stock_seed where name=? and code=?",name,code);
			if(seed == null){
				seed = new StockSeed();
				seed.set("code", code);
				seed.set("name", name);
				if(code.contains("SH") || code.contains("SZ")){
					seed.set("type", 0);//A股
				}else{
					seed.set("type", 1);//三版
				}
				seed.save();
			}
		}
	}
	
	public boolean isStored(String code){
		try{
			String sql = String.format("select * from %s where code = ?",TableName);
			
			if(dao.findFirst(sql,code) == null){
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean isUpdated(String code){
		try{
			String sql = String.format("select * from %s where code = ?",TableName);
			StockSeed seed = dao.findFirst(sql,code);
			
			if(seed == null){
				return false;
			}else{
				if(seed.get("updated").equals(1)){
					return true;
				}else{
					return false;
				}
			}
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean isSeedCrawled(){
		try{
			String storeDate = TimeUtil.getCurrentTime("yyyyMMdd");
			String sql = String.format("select * from %s where createTime> ?",TableName);
			StockSeed seed = dao.findFirst(sql,storeDate);
			
			if(seed == null){
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
			return false;
		}
	}
	
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
