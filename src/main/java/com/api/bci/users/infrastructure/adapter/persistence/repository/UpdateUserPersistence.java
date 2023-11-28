package com.api.bci.users.infrastructure.adapter.persistence.repository;

import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.UpdateUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateUserPersistence implements UpdateUserRepository {

    @Override
    public UserResponse execute(UserRequest userRequest) {
        return new UserResponse();
    }
}
