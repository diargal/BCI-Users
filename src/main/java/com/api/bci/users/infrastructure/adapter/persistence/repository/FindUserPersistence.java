package com.api.bci.users.infrastructure.adapter.persistence.repository;

import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.FindUserRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class FindUserPersistence implements FindUserRepository {

    @Override
    public UserResponse execute(UUID id) {
        return new UserResponse();
    }
}
