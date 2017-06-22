package com.chinaventure.webspider.util;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.chinaventure.webspider.model.KafkaTest;

public class KafkaTestDeseralizer implements Deserializer<KafkaTest>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub

	}
	@Override
	public KafkaTest deserialize(String topic, byte[] bytes) {
		 return (KafkaTest)SerializeUtil.deserialize(bytes,KafkaTest.class);
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}
}
