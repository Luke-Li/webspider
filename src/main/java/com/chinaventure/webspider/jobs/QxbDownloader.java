package com.chinaventure.webspider.jobs;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.chinaventure.webspider.model.jfinal.DynamicCookie;
import com.chinaventure.webspider.util.NumberUtil;

public class QxbDownloader {

	Logger logger = Logger.getLogger(getClass());

	/**
	 * 下载器
	 */
	private List<DynamicCookie> downloadWorkers;

	/**
	 * 当前的下载器编号
	 */
	private int currentDownloadIndex = 0;

	/**
	 * 当前的下载器
	 */
	public DynamicCookie current;

	/**
	 * 初始化一些数据
	 */
	public QxbDownloader(String host) {
		logger.info(String.format("开始初始化COOKIE,host:%s", host));

		downloadWorkers = DynamicCookie.dao.selectCookieByHost(host);
		downloadWorkers.forEach(p -> p.initDownloadWorker());
		logger.info(String.format("初始化完成 COOKIE 数量:%s,host:%s", downloadWorkers.size(), host));
	}

	/**
	 * 切换下载器
	 * 
	 * @return
	 */
	public void nextDownloadWorkerRandom() {
		currentDownloadIndex = NumberUtil.randDom(0, downloadWorkers.size());
		current = downloadWorkers.get(currentDownloadIndex);
	}

	/**
	 * 更新当前异常的COOKIE
	 * 
	 * @param state
	 */
	public void updateCookie(Integer state) {
		Integer failCount = current.getInt("fail_count");

		current.set("fail_count", (++failCount));
		current.set("state", state);
		current.set("update_time", new Date());

		current.update();
	}
}
