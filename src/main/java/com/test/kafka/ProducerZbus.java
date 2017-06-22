package com.test.kafka;

import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Producer;
import org.zbus.net.http.Message;

public class ProducerZbus {
	public static void main(String[] args) {
		try {
			Broker broker = new ZbusBroker("10.27.224.63:15555");

			Producer producer = new Producer(broker, "test");
			producer.createMQ();

			int count = 20;
			while(count-- > 0){
				Message msg = new Message();
				msg.setBody("hello test!");
				producer.sendSync(msg);
				System.out.println("send message!");
			}

		} catch (Exception e) {
			System.out.println("found exception: "+e.getMessage());
		}

	}

}
