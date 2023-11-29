package com.api.bci.users.application.handler;

import com.api.bci.users.infrastructure.controller.dto.UserRequestDto;
import com.api.bci.users.infrastructure.controller.dto.UserResponseDto;
import com.api.bci.users.infrastructure.controller.mapper.UserMapper;
import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.service.CreateUserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUserHandler {
    private final CreateUserService service;
    private final UserMapper mapper;

    public CreateUserHandler(CreateUserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
        // userFactory = new UserFactory();
    }

    public UserResponseDto execute(UserRequestDto userRequestDto) {
        UserRequest userRequest = mapper.requestToModel(userRequestDto);
        return mapper.responseToDto(service.execute(userRequest));
    }
}
