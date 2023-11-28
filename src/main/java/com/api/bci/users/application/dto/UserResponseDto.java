package com.api.bci.users.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private UUID id;
    private UserRequestDto userRequest;
    private LocalDate created;
    private LocalDate lastLogin;
    private String token;
    private boolean isActive;
}
