package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.application.handler.UpdateUserHandler;
import com.api.bci.users.infrastructure.controller.dto.UserRequestDto;
import com.api.bci.users.infrastructure.controller.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UpdateUserPutController {

    private final UpdateUserHandler updateUserHandler;

    public UpdateUserPutController(UpdateUserHandler updateUserHandler) {
        this.updateUserHandler = updateUserHandler;
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> updateUser(@RequestParam String email,
                                                      @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.ok(updateUserHandler.execute(email, userRequestDto));
    }
}
