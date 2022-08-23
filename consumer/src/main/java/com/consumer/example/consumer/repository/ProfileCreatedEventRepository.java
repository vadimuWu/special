package com.consumer.example.consumer.repository;

import com.consumer.example.consumer.model.ProfileCreatedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileCreatedEventRepository extends JpaRepository<ProfileCreatedEvent, Long> {
}
