package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.application.dto.UserRequestDto;
import com.api.bci.users.application.dto.UserResponseDto;
import com.api.bci.users.application.handler.UpdateUserHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bci/user")
public class UpdateUserPutController {

    private final UpdateUserHandler updateUserHandler;

    public UpdateUserPutController(UpdateUserHandler updateUserHandler) {
        this.updateUserHandler = updateUserHandler;
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(updateUserHandler.execute(userRequestDto));
    }
}
