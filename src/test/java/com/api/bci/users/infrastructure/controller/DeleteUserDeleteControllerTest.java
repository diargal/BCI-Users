package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.BciJavaApplication;
import com.api.bci.users.domain.port.DeleteUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest(classes = BciJavaApplication.class)
class DeleteUserDeleteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private DeleteUserRepository deleteUserRepository;

    @Test
    void deleteUser_Successful() throws Exception {
        String userEmail = "digarciaalt@gmail.com";
        Mockito.doNothing().when(deleteUserRepository).execute(userEmail);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/user?email=" + userEmail)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

}