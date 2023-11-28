package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.application.dto.UserResponseDto;
import com.api.bci.users.application.handler.FindUserHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/bci/user")
public class FindUserGetController {

    private final FindUserHandler findUserHandler;

    public FindUserGetController(FindUserHandler findUserHandler) {
        this.findUserHandler = findUserHandler;
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestParam UUID id) {
        return ResponseEntity.ok(findUserHandler.execute(id));
    }
}
