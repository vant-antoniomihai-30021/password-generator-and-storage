package com.example.passwordgenerator.controller;

import com.example.passwordgenerator.password.Password;
import com.example.passwordgenerator.repository.PasswordRepository;
import com.example.passwordgenerator.service.PasswordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@ExtendWith(MockitoExtension.class)
@WebMvcTest(PasswordController.class)
class PasswordControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PasswordService passwordServiceTest;
    @MockBean
    private PasswordRepository passwordRepositoryTest;

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
    public void shouldAddANewPassword()throws Exception{
        Password passwordToAdd = new Password();
        Mockito.doNothing().when(passwordServiceTest).saveThisPassword(passwordToAdd);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/passwords/put")).andExpect(status().isOk());
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/passwords")).andExpect(status().isOk()).andReturn();
    }



}