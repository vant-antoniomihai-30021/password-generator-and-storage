package com.example.passwordgenerator.repository;

import com.example.passwordgenerator.password.Password;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PasswordRepositoryTest {

    @Autowired
    private PasswordRepository passwordRepositoryTest;

    @Test
    public void shouldFindPasswordById(){
        //given
        Password password = new Password();
        passwordRepositoryTest.save(password);
        //when
        boolean exists = passwordRepositoryTest.existsById(7L);
        //then
       assertTrue(exists);
    }
    @Test
    public void shouldAddThisPasswordToTheDatabase(){
        //given
        Password password = new Password();
        passwordRepositoryTest.save(password);
        //when
        boolean exists = passwordRepositoryTest.findAll().get(0).equals(password);
        //then
        assertTrue(exists);
    }
    @Test
    public void shouldDeleteThisPassword(){
        //given
        Password password = new Password();
        passwordRepositoryTest.save(password);
        //when
        passwordRepositoryTest.delete(password);
        boolean exists = passwordRepositoryTest.findAll().contains(password);
        //then
        assertFalse(exists);
    }
    @Test
    public void shouldDeleteAllThePasswords(){
        //given
        Password password = new Password();
        passwordRepositoryTest.save(password);
        password = new Password();
        passwordRepositoryTest.save(password);
        password = new Password();
        passwordRepositoryTest.save(password);
        password = new Password();
        passwordRepositoryTest.save(password);
        //when
        passwordRepositoryTest.deleteAll();
        boolean isEmpty = passwordRepositoryTest.findAll().isEmpty();
        //then
        assertTrue(isEmpty);
    }
    @Test
    public void shouldGetAllThePasswords(){
        //given
        List<Password> passwordList = new ArrayList<>();
        Password password = new Password();
        passwordRepositoryTest.save(password);
        passwordList.add(password);
        password = new Password();
        passwordRepositoryTest.save(password);
        passwordList.add(password);
        password = new Password();
        passwordRepositoryTest.save(password);
        passwordList.add(password);
        password = new Password();
        passwordRepositoryTest.save(password);
        passwordList.add(password);
        //when
        List<Password> currentPasswordList = passwordRepositoryTest.findAll();
        //then
        assertEquals(passwordList,currentPasswordList);
    }
}