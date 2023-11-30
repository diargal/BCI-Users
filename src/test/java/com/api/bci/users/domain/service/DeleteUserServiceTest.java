package com.api.bci.users.domain.service;

import com.api.bci.users.domain.port.DeleteUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteUserServiceTest {

    @Mock
    private DeleteUserRepository userRepository;

    @InjectMocks
    private DeleteUserService deleteUserService;


    @Test
    void testExecute_UserDeletedSuccessfully() {
        // Arrange
        String userEmail = "john.doe@example.com";

        // Act
        deleteUserService.execute(userEmail);

        // Assert
        verify(userRepository, times(1)).execute(userEmail);
    }
}
