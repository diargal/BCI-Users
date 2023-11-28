package com.api.bci.users.domain.service;

import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.UpdateUserRepository;

public class UpdateUserService {
    private final UpdateUserRepository repository;

    public UpdateUserService(UpdateUserRepository repository) {
        this.repository = repository;
    }

    public UserResponse execute(UserRequest userRequest) {
        return repository.execute(userRequest);
    }
}
