package com.chinaventure.webspider.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

public class KafkaConsumerHelper {
	private static KafkaConsumerHelper instance = new KafkaConsumerHelper();

	public static KafkaConsumerHelper getInstance() {
		return instance;
	}

    private static KafkaConsumer<String, Object> kc= null;
    public KafkaConsumer<String, Object> getConsumer(String kafkaHost, String groupId) {
        if(kc == null) {
            Properties props = new Properties();
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
            props.put("group.id", groupId);
            props.put("enable.auto.commit", "true");
            props.put("auto.offset.reset", "earliest");
            props.put("auto.commit.interval.ms", "30000");
            props.put("session.timeout.ms", "30000");
            props.put("receive.buffer.bytes", 20*1024*1024);
            props.put("max.partition.fetch.bytes", 20*1024*1024);
            props.put("zookeeper.connect", "10.27.224.63:2181");
            props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//            props.put("value.deserializer", "com.chinaventure.webspider.util.KafkaTestDeseralizer");

            props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
            kc = new KafkaConsumer<String, Object>(props);
        }
        return kc;
    }

    public static void main(String[] args) throws IOException, InterruptedException {

    	String topic = "test3";
        KafkaConsumer<String, Object> consumer = KafkaConsumerHelper.getInstance().getConsumer("10.27.224.63:9092", topic);

        consumer.subscribe(Arrays.asList("test2"));
        int messagecounter = 0;
//        Map<String, List<PartitionInfo>> map = consumer.listTopics();


        while(true) {
            ConsumerRecords<String, Object> records = consumer.poll(100);
            for(ConsumerRecord<String, Object> record : records) {
            	System.out.println("receive object, key:"+record.key());
//            	KafkaTest tmp = (KafkaTest) record.value();
//            	System.out.println("the game name: "+ tmp.getName());
            	messagecounter++;
            }
            System.out.println("received messages:"+messagecounter);
//            Thread.sleep(3000);
        }

    }
}
