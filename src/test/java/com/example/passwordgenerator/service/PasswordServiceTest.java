package com.example.passwordgenerator.service;

import com.example.passwordgenerator.password.Password;
import com.example.passwordgenerator.repository.PasswordRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PasswordServiceTest {

    private PasswordService passwordServiceTest;
    @Mock
    private PasswordRepository passwordRepositoryTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        passwordServiceTest = new PasswordService(passwordRepositoryTest);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void getAllPasswords(){
        //when
        passwordServiceTest.getAllPasswords();
        //then
        verify(passwordRepositoryTest).findAll();
    }

    @Test
    public void addNewPassword(){
        //given
        Password password = new Password();
        //when
        passwordServiceTest.saveThisPassword(password);
        //then
        ArgumentCaptor<Password> passwordArgumentCaptor =
                ArgumentCaptor.forClass(Password.class);
        verify(passwordRepositoryTest).save(passwordArgumentCaptor.capture());
        Password capturedPassword= passwordArgumentCaptor.getValue();
        assertEquals(capturedPassword,password);
    }

    @Test
    @Disabled
    public void deletePasswordWithTheId(){


    }

    @Test
    @Disabled
    public void deleteAllPasswords(){

    }

    @Test
    @Disabled
    public void isEmpty(){

    }

}