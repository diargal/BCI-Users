package com.api.bci.users.infrastructure.adapter.security;

import com.api.bci.users.domain.model.LoginRequest;
import com.api.bci.users.domain.model.LoginResponse;
import com.api.bci.users.domain.port.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class JwtAdapter implements AuthRepository {
    @Override
    public LoginResponse execute(LoginRequest loginRequest) {
        return new LoginResponse("");
    }
}