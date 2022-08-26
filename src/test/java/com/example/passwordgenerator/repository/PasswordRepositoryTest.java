package com.example.passwordgenerator.repository;

import com.example.passwordgenerator.password.Password;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        boolean exists = passwordRepositoryTest.existsById(1L);
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
}