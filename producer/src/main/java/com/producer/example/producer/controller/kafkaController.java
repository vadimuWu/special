package com.producer.example.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producer.example.producer.dto.AccountCreatedEventDto;
import com.producer.example.producer.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class kafkaController {
    private final KafkaService kafkaService;

    @PostMapping
    public String singUp(@RequestBody AccountCreatedEventDto accountCreatedEventDto) throws JsonProcessingException {
        return kafkaService.writeToTheTopic(accountCreatedEventDto);
    }

}
