package com.producer.example.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producer.example.producer.dto.AccountCreatedEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProducerKafkaService {
    @Value("${topic.name}")
    private String topic;
    //TopicPartition partition0 = new TopicPartition(topic, 0);
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(AccountCreatedEventDto accountCreatedEventDto) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(accountCreatedEventDto);
        kafkaTemplate.send(topic, orderAsMessage);
        return "message sent";
    }
}
