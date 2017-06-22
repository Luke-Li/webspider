package com.chinaventure.webspider;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.log4j.Logger;
import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Producer;
import org.zbus.net.http.Message;

import com.chinaventure.webspider.model.jfinal.ChoiceStockA;
import com.chinaventure.webspider.model.jfinal.ChoiceStockASeed;
import com.chinaventure.webspider.model.jfinal.ChoiceStockThirdboard;
import com.chinaventure.webspider.model.jfinal.ChoiceStockThirdboardSeed;

public class ChoiceSeedSupplementJob {
	static Logger logger = Logger.getLogger(ChoiceSeedSupplementJob.class);

	public static void main(String[] args) throws IOException {
		JFConfig.start();

		Broker broker = new ZbusBroker("192.168.0.72:15555");

		
		zbusInit(broker, "Choice-Thirdboard");
		thirdboardStock();
		
		
		//zbusInit(broker, "Choice-AStock");
		//aStock();
		
		
		logger.info("complete!");
		// thirdboardStock();
	}

	static Producer producer;

	private static void zbusInit(Broker broker, String mqName) {
		producer = new Producer(broker, mqName);
		try {
			producer.createMQ();
		} catch (Exception ex) {
			logger.error("init zbus", ex);
		}
	}

	private static void thirdboardStock() {
		HashSet<String> existCodes = new HashSet<>();

		List<ChoiceStockThirdboard> listExisting = ChoiceStockThirdboard.dao.find(String.format("select id,code,name from %s", ChoiceStockThirdboard.TableName));
		listExisting.forEach(m -> {
			existCodes.add(m.getStr("code"));
		});

		
		
		List<ChoiceStockThirdboardSeed> list = ChoiceStockThirdboardSeed.dao.find(String.format("select id,code,name from %s", ChoiceStockThirdboardSeed.TableName));
		list.forEach(m -> {
			if (!existCodes.contains(m.getStr("code"))) {
				try{
					Message msg = new Message();
					msg.setBody(SerializationUtils.serialize(m));
					producer.sendSync(msg);
					
					logger.info("code: "+ m.getStr("code") + " name:"+m.getStr("name"));
				}catch(Exception ex){
					logger.error("zbus mq", ex);
				}
			}
		});
	}

	private static void aStock() {
		HashSet<String> existCodes = new HashSet<>();
		List<ChoiceStockA> listExisting = ChoiceStockA.dao.find(String.format("select id,code,name from %s", ChoiceStockA.TableName));
		listExisting.forEach(m -> {
			existCodes.add(m.getStr("code"));
		});
		
		List<ChoiceStockASeed> list = ChoiceStockASeed.dao.find(String.format("select id,code,name from %s", ChoiceStockASeed.TableName));
		list.forEach(m -> {
			if (!existCodes.contains(m.getStr("code"))) {
				try{
					Message msg = new Message();
					msg.setBody(SerializationUtils.serialize(m));
					producer.sendSync(msg);
					
					logger.info("code: "+ m.getStr("code") + " name:"+m.getStr("name"));
				}catch(Exception ex){
					logger.error("zbus mq", ex);
				}
			}
		});
	}

}
