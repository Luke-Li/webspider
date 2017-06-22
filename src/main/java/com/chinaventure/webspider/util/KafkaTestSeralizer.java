package com.chinaventure.webspider.util;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.chinaventure.webspider.model.KafkaTest;

public class KafkaTestSeralizer implements Serializer<KafkaTest>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub

	}
	@Override
	public byte[] serialize(String topic, KafkaTest data) {
		 return SerializeUtil.serialize(data);
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}
}
