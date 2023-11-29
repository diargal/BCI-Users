package com.api.bci.users.infrastructure.adapter.persistence;

import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.CreateUserRepository;
import com.api.bci.users.domain.validation.exception.ExistEmailException;
import com.api.bci.users.infrastructure.adapter.persistence.entity.UserEntity;
import com.api.bci.users.infrastructure.adapter.persistence.mapper.UserEntityMapper;
import com.api.bci.users.infrastructure.adapter.persistence.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CreateUserPersistence implements CreateUserRepository {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public CreateUserPersistence(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public UserResponse execute(UserRequest userRequest) {
        UserEntity userEntity = userEntityMapper.toEntity(userRequest);

        if (userRepository.findByEmail(userRequest.getEmail()).isPresent())
            throw new ExistEmailException("El email ya se encuentra registrado.");

        return userEntityMapper.toModel(userRepository.save(userEntity));
    }
}