package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.application.handler.FindUserHandler;
import com.api.bci.users.infrastructure.controller.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class FindUserGetController {

    private final FindUserHandler findUserHandler;

    public FindUserGetController(FindUserHandler findUserHandler) {
        this.findUserHandler = findUserHandler;
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> findUser(@RequestParam String email) {
        return ResponseEntity.ok(findUserHandler.execute(email));
    }
}
