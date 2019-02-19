//package com.kafka.producer.kafkaproducer.service;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KafkaProducer001 {
//
//
//	@Autowired
//	private KafkaProducer<String, String> kafkaProducer;
//    
//	@Autowired
//	private String[] topic;
//   
//    @Autowired
//    public KafkaProducer001(KafkaProducer<String, String> kafkaProducer, String[] topic) {
//		this.kafkaProducer = kafkaProducer;
//		this.topic = topic;
//	}
//
//    public RecordMetadata sendMessage(String eventFeed) {
//        RecordMetadata producerResponse = null;
//      
//       for( int i=0; i<topic.length; i++) {
//        
//        try {
//			ProducerRecord<String, String> record = new ProducerRecord<>(topic[i], eventFeed);
//            producerResponse = kafkaProducer.send(record).get();
//            System.out.println("Message send to topic::" + record.topic()+ "Partition is"+ record.partition() + 
//            		"Timne is" + record.timestamp());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//       }
//        return producerResponse;
//        
//    }
//   
//    
//}
