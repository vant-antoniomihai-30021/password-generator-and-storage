package com.example.passwordgenerator.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    //This test should just check if the generated password is the one stored in the Password object's string
    @Test
    public void shouldBeTrueIfThePasswordIsTheGeneratedOne(){
        Password password = new Password();
        String theOne=password.getPassword();
        assertEquals(password.getPassword(),theOne);
    }
    @Test
    public void shouldBeTrueForTheSetPassword(){
        String setPassword = "thisPassword";
        Password password = new Password();
        password.setPassword(setPassword);
        assertEquals(setPassword,password.getPassword());
    }

}