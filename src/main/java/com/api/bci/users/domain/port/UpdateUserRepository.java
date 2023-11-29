package com.api.bci.users.domain.port;

import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;

@FunctionalInterface
public interface UpdateUserRepository {
    UserResponse execute(String email, UserRequest userRequest);

}
