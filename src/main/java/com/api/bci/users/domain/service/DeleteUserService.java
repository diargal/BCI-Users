package com.api.bci.users.domain.service;

import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.DeleteUserRepository;

import java.util.UUID;

public class DeleteUserService {
    private final DeleteUserRepository repository;

    public DeleteUserService(DeleteUserRepository repository) {
        this.repository = repository;
    }

    public UserResponse execute(UUID id) {
        return repository.execute(id);
    }
}
