package com.api.bci.users.domain.port;

import com.api.bci.users.domain.model.UserResponse;

import java.util.UUID;

@FunctionalInterface
public interface DeleteUserRepository {
    UserResponse execute(UUID id);
}