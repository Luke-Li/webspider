package com.chinaventure.webspider.service.impl;

import org.apache.log4j.Logger;
import org.zbus.mq.MqAdmin;
import org.zbus.net.http.Message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ZbusService {
	
	static Logger logger = Logger.getLogger(ZbusService.class);
	
	/**
	 * 查询未处理的队列数量
	 */
	public static Integer mqLength(MqAdmin admin) {
		try {
			Message msg =  admin.queryMQ();
			JSONObject object = JSON.parseObject(msg.getBodyString());
			return object.getInteger("unconsumedMsgCount");
		} catch (Exception e) {
			logger.error("查询队列信息",e);
		}
		
		return 0;
	}
}
