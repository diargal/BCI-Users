package com.api.bci.users.infrastructure.adapter.persistence;

import com.api.bci.users.domain.port.DeleteUserRepository;
import com.api.bci.users.infrastructure.adapter.persistence.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteUserPersistence implements DeleteUserRepository {
    private final UserRepository userRepository;

    public DeleteUserPersistence(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute(String email) {
        userRepository.deleteByEmail(email);
    }
}
