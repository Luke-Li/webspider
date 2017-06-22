package com.chinaventure.webspider.model.jfinal;

import java.util.List;

import com.chinaventure.webspider.JFConfig;
import com.jfinal.plugin.activerecord.Model;

import net.kernal.spiderman.kit.Properties;
import net.kernal.spiderman.worker.download.DownloadWorker;
import net.kernal.spiderman.worker.download.impl.HttpClientDownloader;

public class DynamicCookie extends Model<DynamicCookie>{

	private DownloadWorker downloadWorker;
	
	public DownloadWorker getDownloadWorker() {
		return downloadWorker;
	}

	public void setDownloadWorker(DownloadWorker downloadWorker) {
		this.downloadWorker = downloadWorker;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7127869077638287275L;

	public static final String TableName = JFConfig.getTableName(DynamicCookie.class);
	
	public static DynamicCookie dao = new DynamicCookie();
	
	/**
	 * 根据HOST查询COOKIE
	 * @param host
	 * @return
	 */
	public List<DynamicCookie> selectCookieByHost(String host){
		return dao.find(String.format("select * from %s where host = ? ",TableName), host);
	}

	/**
	 * 初始化下载工人
	 */
	public void initDownloadWorker() {
		Properties props = new Properties();
		props.put("-Cookie",getStr("cookie"));
		downloadWorker = new DownloadWorker(new HttpClientDownloader(props));
	}
}
