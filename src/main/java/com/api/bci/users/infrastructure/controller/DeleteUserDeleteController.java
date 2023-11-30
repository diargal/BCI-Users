package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.application.handler.DeleteUserHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class DeleteUserDeleteController {

    private final DeleteUserHandler deleteUserHandler;

    public DeleteUserDeleteController(DeleteUserHandler deleteUserHandler) {
        this.deleteUserHandler = deleteUserHandler;
    }


    @DeleteMapping
    public void deleteUser(@RequestParam String email) {
        deleteUserHandler.execute(email);
    }
}
