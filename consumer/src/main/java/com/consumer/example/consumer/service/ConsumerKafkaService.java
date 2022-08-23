package com.consumer.example.consumer.service;

import com.consumer.example.consumer.dto.ProfileCreatedEventDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumerKafkaService {
    private static final String topic = "${topic.name}";
    private final ObjectMapper objectMapper;
    private final KafkaService kafkaService;

    @KafkaListener(topics = topic)
    public void consumeMessage(String message) throws JsonProcessingException {
        ProfileCreatedEventDto profileCreatedEventDto = objectMapper.readValue(message, ProfileCreatedEventDto.class);
        kafkaService.persistProfileCreatedEvent(profileCreatedEventDto);
    }
}
