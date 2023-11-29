package com.api.bci.users.infrastructure.adapter.persistence;

import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.FindUserRepository;
import com.api.bci.users.domain.validation.exception.UserNotFoundException;
import com.api.bci.users.infrastructure.adapter.persistence.mapper.UserEntityMapper;
import com.api.bci.users.infrastructure.adapter.persistence.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FindUserPersistence implements FindUserRepository {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public FindUserPersistence(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public UserResponse execute(String email) {
        return userRepository.findByEmail(email)
                .map(userEntityMapper::toModel)
                .orElseThrow(() -> new UserNotFoundException("No se encontró registro."));
    }
}
