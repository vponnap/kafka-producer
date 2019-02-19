package com.kafka.producer.kafkaproducer.controller;

import java.net.URI;

import javax.validation.Valid;

import com.kafka.producer.kafkaproducer.data.EventFeed;
import com.kafka.producer.kafkaproducer.service.KafkaPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@ResponseStatus(HttpStatus.CREATED)
public class KafkaPublishController {

	@Autowired
	KafkaPublisher kafkaPublisher;

	@PostMapping("/kafkaevents")
	public ResponseEntity<URI> sendMessageToKafka(@Valid @RequestBody EventFeed eventFeed) {

		System.out.println("request::" + eventFeed);

        SendResult<String, String> response = kafkaPublisher.sendMessage(eventFeed.toString());
		System.out.println("response::" + response);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build()
				.toUri();
		return ResponseEntity.created(location).build();

//        return response;
    }

}