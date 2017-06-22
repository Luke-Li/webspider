package com.test.kafka;

import org.zbus.broker.Broker;
import org.zbus.broker.ZbusBroker;
import org.zbus.mq.Consumer;
import org.zbus.mq.Consumer.ConsumerHandler;
import org.zbus.net.http.Message;

public class ConsumerZbus {
	public static void main(String[] args) {
		try {
			Broker broker = new ZbusBroker("10.27.224.63:15555");
			Consumer consumer1 = new Consumer(broker, "test");

			consumer1.start(new ConsumerHandler() {
				@Override
				public void handle(Message msg, Consumer consumer) {
					System.out.println("the message is: " + msg.getBodyString());
				}
			});

			Thread.sleep(3000000);
			consumer1.close();
		}catch(Exception e){
			System.out.println("found exception: "+e.getMessage());
		}
	}
}
