package com.kafka.producer.kafkaproducer.data;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventFeed {

	private String brand;
	private String channel;
	private String economicRegion;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate startDate;
	private List<String> status;
	boolean isForDSCache;
	private String market;
}