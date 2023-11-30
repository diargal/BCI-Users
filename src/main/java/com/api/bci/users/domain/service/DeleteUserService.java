package com.api.bci.users.domain.service;

import com.api.bci.users.domain.port.DeleteUserRepository;

public class DeleteUserService {
    private final DeleteUserRepository repository;

    public DeleteUserService(DeleteUserRepository repository) {
        this.repository = repository;
    }

    public void execute(String email) {
        repository.execute(email);
    }
}
