package com.api.bci.users.infrastructure.config;

import com.api.bci.users.domain.port.CreateUserRepository;
import com.api.bci.users.domain.port.DeleteUserRepository;
import com.api.bci.users.domain.port.FindUserRepository;
import com.api.bci.users.domain.port.UpdateUserRepository;
import com.api.bci.users.domain.service.CreateUserService;
import com.api.bci.users.domain.service.DeleteUserService;
import com.api.bci.users.domain.service.FindUserService;
import com.api.bci.users.domain.service.UpdateUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public CreateUserService createUserServiceBean(CreateUserRepository repository) {
        return new CreateUserService(repository);
    }

    @Bean
    public UpdateUserService updateUserServiceBean(UpdateUserRepository userRepository) {
        return new UpdateUserService(userRepository);
    }

    @Bean
    public DeleteUserService deleteUserServiceBean(DeleteUserRepository userRepository) {
        return new DeleteUserService(userRepository);
    }

    @Bean
    public FindUserService findUserServiceBean(FindUserRepository userRepository) {
        return new FindUserService(userRepository);
    }
}
