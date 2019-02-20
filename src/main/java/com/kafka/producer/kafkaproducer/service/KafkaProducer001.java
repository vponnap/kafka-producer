package com.kafka.producer.kafkaproducer.service;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer001 {
	
	@Autowired
	private Producer<String, String> kafkaProducer;
    
	@Autowired
	private String topicc;
   
	
	@Autowired
    public KafkaProducer001(Producer<String, String> kafkaProducer, String topicc) {
		this.kafkaProducer = kafkaProducer;
		this.topicc = topicc;
	}

    
    public RecordMetadata sendMessage(String eventFeed) {
        RecordMetadata producerResponse = null;
      
//       for( int i=0; i<topicc.length; i++) {
        
        try {
			ProducerRecord<String, String> record = new ProducerRecord<>(topicc, eventFeed);
            producerResponse = kafkaProducer.send(record).get();
            System.out.println("Message send to topic::" + record.topic()+ "Partition is"+ record.partition() + 
            		"Time is" + record.timestamp());

        } catch (Exception e) {
            e.printStackTrace();
        }
//       }
        return producerResponse;
        
    }
   
    
}
