package com.chinaventure.webspider.jobs;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.log4j.Logger;
import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Producer;
import org.zbus.net.http.Message;

import com.chinaventure.webspider.JFConfig;
import com.chinaventure.webspider.model.jfinal.OpsMonitorMedia;
import com.chinaventure.webspider.service.impl.ZbusService;
import com.chinaventure.webspider.util.PropertiesUtil;

import sealion.core.Job;

/***
 * 微信公众号JOB
 */
public class MediaServiceJob extends Job {

	Logger logger = Logger.getLogger(getClass());

	public static void main(String[] args) throws Exception {
		Map<String, String> params = new HashMap<>();
		params.put("zbus", PropertiesUtil.getProperty("zbus"));

		new MediaServiceJob().execute(params);
	}

	/**
	 * 队列名称
	 */
	String mpName = "MediaMonitor";

	@Override
	public void execute(Map<String, String> params) throws Exception {
		JFConfig.start(JFConfig.Database.OpsRdd);

		/**
		 * broker
		 */
		Broker broker = new ZbusBroker(params.get("zbus"));

		Producer producer = new Producer(broker, mpName);
		producer.createMQ();

		producer.removeMQ();
		
		/**
		 * 上一次执行是的时间
		 */
		int preHourly = 0;

		while (true) {
			try {
				logger.info("开始获取取监控种子");

				if (ZbusService.mqLength(producer) > 0) {
					logger.info("队列中有未处理的数据，放弃本次种子获取");
				} else {
					LocalTime time = LocalTime.now();
					List<OpsMonitorMedia> list = null;

					if (preHourly != time.getHour()) {
						logger.info("开始获取全量种子");
						preHourly = time.getHour();
						list = OpsMonitorMedia.dao.find(String.format(" select * from %s where status = true ", OpsMonitorMedia.TableName));
					}

					if (null != list) {
						logger.info("种子数量:" + list.size());
						for (OpsMonitorMedia stock : list) {
							Message msg = new Message();
							msg.setBody(SerializationUtils.serialize(stock));

							producer.sendSync(msg);
							
							threadSleep(3500/list.size());
						}
					} else {
						logger.fatal("未从数据库中获取到种子");
					}
				}

				logger.info("获取取监控种子结束");
				threadSleep(1 * 60);
			} catch (Exception e) {
				logger.fatal("媒体监控服务端", e);
			}
		}
	}

	/**
	 * 线程睡眠一定的时间
	 * 
	 * @param seconds
	 */
	private void threadSleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
