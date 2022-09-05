package com.example.passwordgenerator.controller;

import com.example.passwordgenerator.password.Password;
import com.example.passwordgenerator.service.PasswordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PasswordController.class)
class PasswordControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PasswordService passwordServiceTest;

    @Test
    public void shouldNotBeNullMockMvc(){
        assertNotNull(mockMvc);
    }

    @Test
    public void shouldReturnAListWithAllThePasswords() throws Exception{
        List<Password> list = new ArrayList<>();
        list.add(new Password());
        list.add(new Password());
        Mockito.when(passwordServiceTest.getAllPasswords()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/passwords")).andExpect(status().isOk());
    }

    @Test
    public void shouldAddANewPassword() throws Exception{
        Mockito.doNothing().when(passwordServiceTest).generateNewPassword();
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/passwords/put")).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteThePasswordWithTheId() throws Exception{
        Mockito.doNothing().when(passwordServiceTest).deletePasswordBasedOnId(1L);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/passwords/delete1")).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteAllThePasswords() throws Exception{
        Mockito.doNothing().when(passwordServiceTest).deleteAllPasswords();
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/passwords/delete-all")).andExpect(status().isOk());
    }

    @Test
    public void shouldBeEmpty() throws Exception{
        Boolean isEmpty=true;
        Mockito.when(passwordServiceTest.isEmpty()).thenReturn(isEmpty);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/passwords/check-if-empty")).andExpect(status().isOk()).andExpect(content().string(isEmpty.toString()));
    }

    @Test
    public void shouldFindByThisId() throws  Exception{
        Boolean exists = true;
        Mockito.doNothing().when(passwordServiceTest).generateNewPassword();
        Mockito.when(passwordServiceTest.checkIfExistsById(1L)).thenReturn(exists);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/passwords/exists1")).andExpect(status().isOk()).andExpect(content().string(exists.toString()));
    }
}