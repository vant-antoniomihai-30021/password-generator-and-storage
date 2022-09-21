package com.example.passwordgenerator.password;


import com.example.passwordgenerator.user.User;

import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Table(name="password_table")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "password_generator")
    @SequenceGenerator(name="password_generator",sequenceName = "password_generator",allocationSize = 1)
    private Long id;

    private String password;
    private Integer user_id;
    public static int counter=1;
    private int indOfThisPassword;

    public Password() {
        String bigLetters= "QWERTYUIOPASDFGHJKLZXCVBNM";
        String smallLetters= "qwertyuiopasdfghjklzxcvbnm";
        String numbers= "1234567890";
        String otherChars= "{}:!@#$%^&*();?";
        StringBuilder sb = new StringBuilder();
        int length = (int)(Math.random()*16+1);
        while(length<16)
            length = (int)(Math.random()*16+1);

        for(int i =0;i<length/4;i++){
            sb.append(bigLetters.charAt((int)(Math.random()*bigLetters.length())));
            sb.append(smallLetters.charAt((int)(Math.random()*smallLetters.length())));
            sb.append(numbers.charAt((int)(Math.random()*numbers.length())));
            sb.append(otherChars.charAt((int)(Math.random()*otherChars.length())));
        }
        this.password = sb.toString();
        indOfThisPassword =counter;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIndOfThisPassword() {
        return indOfThisPassword;
    }

    public void setIndOfThisPassword(int indOfThisPassword) {
        this.indOfThisPassword = indOfThisPassword;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
