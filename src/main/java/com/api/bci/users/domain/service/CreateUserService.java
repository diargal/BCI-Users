package com.api.bci.users.domain.service;

import com.api.bci.users.domain.model.LoginRequest;
import com.api.bci.users.domain.model.LoginResponse;
import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.AuthRepository;
import com.api.bci.users.domain.port.CreateUserRepository;

import java.time.LocalDateTime;

public class CreateUserService {
    private final CreateUserRepository createUserRepository;
    private final AuthRepository authRepository;

    public CreateUserService(CreateUserRepository createUserRepository, AuthRepository authRepository) {
        this.createUserRepository = createUserRepository;
        this.authRepository = authRepository;
    }

    public UserResponse execute(UserRequest userRequest) {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        userRequest.setCreated(dateTimeNow);
        userRequest.setLastLogin(dateTimeNow);
        userRequest.setModified(dateTimeNow);
        userRequest.setActive(Boolean.TRUE);
        LoginRequest loginRequest = new LoginRequest(userRequest.getEmail(), userRequest.getPassword());
        UserResponse userResponse = createUserRepository.execute(userRequest);
        LoginResponse loginResponse = authRepository.execute(loginRequest);
        userResponse.setToken(loginResponse.getToken());

        return userResponse;
    }
}
