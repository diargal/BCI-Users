package com.api.bci.users.infrastructure.adapter.persistence;

import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.UpdateUserRepository;
import com.api.bci.users.domain.validation.exception.UserNotFoundException;
import com.api.bci.users.infrastructure.adapter.persistence.mapper.UserEntityMapper;
import com.api.bci.users.infrastructure.adapter.persistence.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateUserPersistence implements UpdateUserRepository {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UpdateUserPersistence(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public UserResponse execute(String email, UserRequest userRequest) {
        return userRepository.findByEmail(email)
                .map(userEntity -> {
                    userEntityMapper.updateUserFromModel(userRequest, userEntity);
                    return userEntityMapper.toModel(userRepository.save(userEntity));
                })
                .orElseThrow(() -> new UserNotFoundException("No se encontró registro."));
    }
}
