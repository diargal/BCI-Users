package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.infrastructure.controller.dto.LoginRequestDto;
import com.api.bci.users.infrastructure.controller.dto.LoginResponseDto;
import com.api.bci.users.application.handler.LoginHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginAuthPostController {

    private final LoginHandler loginHandler;

    public LoginAuthPostController(LoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(loginHandler.execute(loginRequestDto));
    }
}
