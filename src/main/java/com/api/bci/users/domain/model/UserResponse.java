package com.api.bci.users.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private UUID id;
    private UserRequest userRequest;
    private LocalDate created;
    private LocalDate lastLogin;
    private String token;
    private boolean isActive;
}
