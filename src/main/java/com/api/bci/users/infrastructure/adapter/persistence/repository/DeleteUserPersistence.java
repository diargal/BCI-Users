package com.api.bci.users.infrastructure.adapter.persistence.repository;

import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.DeleteUserRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class DeleteUserPersistence implements DeleteUserRepository {

    @Override
    public UserResponse execute(UUID id) {
        return new UserResponse();
    }
}
