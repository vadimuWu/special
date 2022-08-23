package com.producer.example.producer.dto;

import lombok.Data;
import lombok.Value;


@Data
@Value
public class AccountCreatedEventDto {
    String firstName;
    String lastName;
    String password;
    String email;
}
