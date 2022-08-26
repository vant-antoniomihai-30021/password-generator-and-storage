package com.example.passwordgenerator.service;

import com.example.passwordgenerator.password.Password;
import com.example.passwordgenerator.repository.PasswordRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
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
        //given

        willDoNothing().given(passwordRepositoryTest).deleteById(1L);

        //when
        passwordServiceTest.deletePasswordBasedOnId(1L);

        //then
        verify(passwordRepositoryTest).deleteById(1L);

    }

    @Test
    public void deleteAllPasswords(){

        passwordServiceTest.deleteAllPasswords();
        verify(passwordRepositoryTest).deleteAll();
    }

    @Test
    @Disabled
    public void isEmpty(){
        passwordServiceTest.generateNewPassword();
        passwordServiceTest.saveThisPassword(new Password());
        passwordServiceTest.deleteAllPasswords();
        assertTrue(passwordServiceTest.isEmpty());
    }

}