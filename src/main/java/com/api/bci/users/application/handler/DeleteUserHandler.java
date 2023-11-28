package com.api.bci.users.application.handler;

import com.api.bci.users.application.dto.UserResponseDto;
import com.api.bci.users.application.mapper.UserMapper;
import com.api.bci.users.domain.service.DeleteUserService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteUserHandler {
    private final DeleteUserService service;
    private final UserMapper mapper;

    public DeleteUserHandler(DeleteUserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    public UserResponseDto execute(UUID id) {
        return mapper.responseToDto(service.execute(id));
    }
}
