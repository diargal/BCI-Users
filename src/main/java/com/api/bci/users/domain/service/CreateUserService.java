package com.api.bci.users.domain.service;

import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.CreateUserRepository;

public class CreateUserService {
    private final CreateUserRepository repository;

    public CreateUserService(CreateUserRepository repository) {
        this.repository = repository;
    }

    public UserResponse execute(UserRequest userRequest) {
        return repository.execute(userRequest);
    }
}
