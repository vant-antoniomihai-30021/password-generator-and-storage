package com.example.passwordgenerator.user;

import javax.persistence.*;

@Entity
@Table(name = "users_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "password_generator")
    @SequenceGenerator(name="password_generator",sequenceName = "password_generator",allocationSize = 1)
    private Long id;
    private String username;
    private String password;
    private String email;

    public User(String username, String password,String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }
}