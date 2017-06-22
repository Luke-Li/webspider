package com.chinaventure.webspider.util;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.chinaventure.webspider.model.KafkaTest;

public class KafkaProducerHelper {
	//private static Logger logger = LoggerFactory.getLogger(KafkaProducerHelper.class);

	private KafkaProducer<String, Object> kafkaProducer = null;
	private static Map<String, KafkaProducerHelper> host2ProducerHelper = new ConcurrentHashMap<String, KafkaProducerHelper>();

	public static KafkaProducerHelper getInstance() {
		return getInstance("10.27.224.63:9092");
	}

	public static KafkaProducerHelper getInstance(String kafkaHosts) {
		KafkaProducerHelper inst = host2ProducerHelper.get(kafkaHosts);
		if (inst==null){
			synchronized (KafkaProducerHelper.class) {
				inst = host2ProducerHelper.get(kafkaHosts);
				if (inst==null){
					inst = new KafkaProducerHelper(kafkaHosts);
					host2ProducerHelper.put(kafkaHosts, inst);
				}
			}
		}

		return inst;

	}

	public KafkaProducerHelper(String kafkaHosts) {
			Properties props = new Properties();
			props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
					kafkaHosts);
			props.setProperty(ProducerConfig.ACKS_CONFIG, "1");
			props.setProperty(ProducerConfig.RETRIES_CONFIG, "1");
			props.setProperty(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, "120000");
			props.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "16384");
			props.setProperty(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "8388608");
			props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
					"org.apache.kafka.common.serialization.StringSerializer");
//			props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//					"com.chinaventure.webspider.util.KafkaTestSeralizer");
			props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
					"org.apache.kafka.common.serialization.ByteArraySerializer");
			kafkaProducer = new KafkaProducer<String, Object>(props);
	}

	static {

	}

	public void send(String topic, String key, String[] values) throws InterruptedException, ExecutionException {
		final String SPLITOR = "\u0001";
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < values.length - 1; index++) {
			sb.append(values[index]).append(SPLITOR);
		}
		sb.append(values[values.length - 1]);

		String sendString = sb.toString().replace("\n", "");
		sendString.replace("\r", "");
		ProducerRecord<String, Object> record = new ProducerRecord<String, Object>(topic, key, sendString);
		Future<RecordMetadata> result = kafkaProducer.send(record);
		// 等待发送完成
		RecordMetadata recordMetadata = result.get();
	}

	public void send(String topic, String key, Object value) throws InterruptedException, ExecutionException {

		ProducerRecord<String, Object> record = new ProducerRecord<String, Object>(topic, key, value);
		Future<RecordMetadata> result = kafkaProducer.send(record);
		// 等待发送完成
		RecordMetadata recordMetadata = result.get();
	}


	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String topic = "test1";

		KafkaTest tmp = new KafkaTest();
		tmp.setId("123");
		tmp.setName("王者荣耀");
		int count = 1;

		//Mysql
		while (true) {

			KafkaProducerHelper.getInstance("10.27.224.63:9092").send(topic, "123456", tmp);
			Thread.sleep(1000);
			System.out.println("producer queue: " + count++);
		}
	}
}
