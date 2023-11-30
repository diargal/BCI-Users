package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.BciJavaApplication;
import com.api.bci.users.domain.model.LoginRequest;
import com.api.bci.users.domain.model.LoginResponse;
import com.api.bci.users.domain.port.AuthRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest(classes = BciJavaApplication.class)
class UserAuthPostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AuthRepository authRepository;

    @Test
    void findUser_Successful() throws Exception {
        String token = "I'm a Token";
        String email = "email@gmail.com";
        String password = "pass123";
        LoginRequest loginRequest = new LoginRequest(email, password);
        LoginResponse loginResponse = new LoginResponse(token);

        when(authRepository.execute(any())).thenReturn(loginResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.token").value(token))
                .andDo(print());
    }
}