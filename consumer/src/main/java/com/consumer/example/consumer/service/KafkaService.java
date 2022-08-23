package com.consumer.example.consumer.service;

import com.consumer.example.consumer.dto.ProfileCreatedEventDto;
import com.consumer.example.consumer.model.ProfileCreatedEvent;
import com.consumer.example.consumer.repository.ProfileCreatedEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    private final ProfileCreatedEventRepository profileCreatedEventRepository;
    private final ModelMapper modelMapper;
    public void persistProfileCreatedEvent(ProfileCreatedEventDto profileCreatedEventDto) {
        ProfileCreatedEvent profileCreatedEvent = modelMapper.map(profileCreatedEventDto, ProfileCreatedEvent.class);
        ProfileCreatedEvent persistProfileCreatedEvent = profileCreatedEventRepository.save(profileCreatedEvent);
        log.info("profileCreatedEvent persisted {}", persistProfileCreatedEvent);
    }
}
