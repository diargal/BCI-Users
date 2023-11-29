package com.api.bci.users.domain.port;

import com.api.bci.users.domain.model.UserResponse;

@FunctionalInterface
public interface FindUserRepository {
    UserResponse execute(String email);
}
