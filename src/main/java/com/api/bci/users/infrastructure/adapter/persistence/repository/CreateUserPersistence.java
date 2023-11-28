package com.api.bci.users.infrastructure.adapter.persistence.repository;

import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.CreateUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CreateUserPersistence implements CreateUserRepository {
    @Override
    public UserResponse execute(UserRequest userRequest) {
        return new UserResponse();
    }
}
