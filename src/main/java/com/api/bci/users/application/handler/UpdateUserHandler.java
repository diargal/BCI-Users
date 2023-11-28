package com.api.bci.users.application.handler;

import com.api.bci.users.application.dto.UserRequestDto;
import com.api.bci.users.application.dto.UserResponseDto;
import com.api.bci.users.application.mapper.UserMapper;
import com.api.bci.users.domain.model.UserRequest;
import com.api.bci.users.domain.service.UpdateUserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserHandler {
    private final UpdateUserService service;
    private final UserMapper mapper;

    public UpdateUserHandler(UpdateUserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public UserResponseDto execute(UserRequestDto userRequestDto) {
        UserRequest userRequest = mapper.requestToModel(userRequestDto);
        return mapper.responseToDto(service.execute(userRequest));
    }
}
