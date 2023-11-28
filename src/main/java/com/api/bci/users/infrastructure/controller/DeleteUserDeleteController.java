package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.application.dto.UserResponseDto;
import com.api.bci.users.application.handler.DeleteUserHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/bci/user")
public class DeleteUserDeleteController {

    private final DeleteUserHandler deleteUserHandler;

    public DeleteUserDeleteController(DeleteUserHandler deleteUserHandler) {
        this.deleteUserHandler = deleteUserHandler;
    }


    @DeleteMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestParam UUID id) {
        return ResponseEntity.ok(deleteUserHandler.execute(id));
    }
}
