package com.kafka.producer.kafkaproducer.controller;

import java.net.URI;

import javax.validation.Valid;

import com.kafka.producer.kafkaproducer.data.EventFeed;
import com.kafka.producer.kafkaproducer.service.KafkaProducer001;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@ResponseStatus(HttpStatus.CREATED)
public class KafkaProducerController {

	@Autowired
	KafkaProducer001 kafkaProducer001;

	@PostMapping("/kafkaEvents")
	public ResponseEntity<URI> sendMessageToKafka(@Valid @RequestBody EventFeed eventFeed) {

		System.out.println("request::" + eventFeed);

        RecordMetadata response = kafkaProducer001.sendMessage(eventFeed.toString());
		System.out.println("response::" + response);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build()
				.toUri();
		return ResponseEntity.created(location).build();

//        return response;
    }

}