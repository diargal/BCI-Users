package com.api.bci.users.domain.service;

import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.FindUserRepository;

public class FindUserService {
    private final FindUserRepository repository;

    public FindUserService(FindUserRepository repository) {
        this.repository = repository;
    }

    public UserResponse execute(String email) {
        return repository.execute(email);
    }
}
