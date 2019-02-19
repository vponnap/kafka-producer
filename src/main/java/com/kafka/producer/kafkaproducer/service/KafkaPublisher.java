package com.kafka.producer.kafkaproducer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisher {


	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
    
	@Autowired
	private String[] topic;
   
    @Autowired
    public KafkaPublisher(KafkaTemplate<String, String> kafkaTemplate, String[] topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

    public SendResult<String, String> sendMessage(String eventFeed) {
        SendResult<String, String> producerResponse = null;
      
       for( int i=0; i<topic.length; i++) {
        
        try {
			ProducerRecord<String, String> record = new ProducerRecord<>(topic[i], eventFeed);
            producerResponse = kafkaTemplate.send(record).get();
            System.out.println("Message send to topic::" + record.topic()+ "Partition is"+ record.partition() + 
            		"Timne is" + record.timestamp());

        } catch (Exception e) {
            e.printStackTrace();
        }
       }
        return producerResponse;
        
    }
   
    
}
