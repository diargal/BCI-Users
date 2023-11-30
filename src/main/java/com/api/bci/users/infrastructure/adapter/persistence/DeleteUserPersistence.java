package com.api.bci.users.infrastructure.adapter.persistence;

import com.api.bci.users.domain.port.DeleteUserRepository;
import com.api.bci.users.domain.validation.exception.UserNotFoundException;
import com.api.bci.users.infrastructure.adapter.persistence.entity.UserEntity;
import com.api.bci.users.infrastructure.adapter.persistence.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DeleteUserPersistence implements DeleteUserRepository {
    private final UserRepository userRepository;

    public DeleteUserPersistence(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);

        if (userEntity.isPresent()) {
            userRepository.delete(userEntity.get());
        } else {
            throw new UserNotFoundException("No se encontró registro.");
        }
    }
}
