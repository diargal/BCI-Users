package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.application.handler.CreateUserHandler;
import com.api.bci.users.infrastructure.controller.dto.UserRequestDto;
import com.api.bci.users.infrastructure.controller.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class CreateUserPostController {

    private final CreateUserHandler createUserHandler;

    public CreateUserPostController(CreateUserHandler createUserHandler) {
        this.createUserHandler = createUserHandler;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(createUserHandler.execute(userRequestDto));
    }
}
