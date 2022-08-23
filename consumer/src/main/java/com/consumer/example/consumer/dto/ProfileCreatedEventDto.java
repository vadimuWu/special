package com.consumer.example.consumer.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class ProfileCreatedEventDto {
    String firstName;
    String lastName;
    String password;
    String email;
}
