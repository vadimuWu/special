package com.producer.example.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producer.example.producer.dto.AccountCreatedEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final ProducerKafkaService producerKafkaService;
    public String writeToTheTopic(AccountCreatedEventDto accountCreatedEventDto) throws JsonProcessingException {
        return producerKafkaService.sendMessage(accountCreatedEventDto);
    }
}
