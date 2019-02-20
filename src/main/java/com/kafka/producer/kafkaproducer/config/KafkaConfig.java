package com.kafka.producer.kafkaproducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
@EnableKafka
public class KafkaConfig {
	

	
	//@Value("${kafka.bootstrap.servers}")
	@Value("${kafka.bootstrap.cluster}")
    private String bootStrapServers;
	
	@Value("${kafka.producer.topicc}")
	private String topicc;

    private Map<String, Object> producerConfiguration() {
        Map<String, Object> configuationMap = new HashMap<>();
        configuationMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        configuationMap.put(ProducerConfig.RETRIES_CONFIG, 0);
        configuationMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configuationMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        return configuationMap;
    }
    
    
    @Bean
    public Producer<String, String> kafkaProducer() {
        return new KafkaProducer<>(producerConfiguration());
    }  
    
    @Bean
    public String setTopicc() {
        return topicc;
    }

	
   
    
 
}
