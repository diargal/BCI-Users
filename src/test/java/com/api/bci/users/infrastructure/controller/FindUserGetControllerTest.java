package com.api.bci.users.infrastructure.controller;

import com.api.bci.users.BciJavaApplication;
import com.api.bci.users.domain.model.Phone;
import com.api.bci.users.domain.model.UserResponse;
import com.api.bci.users.domain.port.FindUserRepository;
import com.api.bci.users.domain.validation.exception.UserNotFoundException;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest(classes = BciJavaApplication.class)
class FindUserGetControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private FindUserRepository findUserRepository;

    @Test
    void findUser_Successful() throws Exception {
        UUID id = UUID.randomUUID();
        String name = "Jhon Doe";
        String userEmail = "john.doe.155@example.com";
        String password = "password123";
        String cellphone = "+579863333";
        String cityCode = "05757";
        String countryCode = "57";
        String token = "I'm a Token";
        LocalDateTime now = LocalDateTime.now();
        Phone phone = new Phone(cellphone, cityCode, countryCode);
        List<Phone> phones = List.of(phone);
        UserResponse response = new UserResponse(id, name, userEmail, password,
                phones, now, now, null, true, token);

        when(findUserRepository.execute(any())).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user?email=" + userEmail)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(userEmail))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value(password))
                .andExpect(MockMvcResultMatchers.jsonPath("$.active").value(Boolean.TRUE))
                .andDo(print());
    }

    @Test
    void findUser_EmailNotFound_ThrownException() throws Exception {
        String userEmail = "john.doe.89666@example.com";
        when(findUserRepository.execute(any())).thenThrow(new UserNotFoundException("No se encontró registro."));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user?email=" + userEmail)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No se encontró registro."))
                .andDo(print());
    }

}