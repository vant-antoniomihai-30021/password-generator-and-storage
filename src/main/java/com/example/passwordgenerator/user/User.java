package com.example.passwordgenerator.user;
import com.example.passwordgenerator.password.Password;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user_table")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_generator")
    @SequenceGenerator(name="user_generator",sequenceName = "user_generator",allocationSize = 1)
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToMany
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<Password> passwordList = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public List<Password> getPasswordList() {
        return passwordList;
    }

    public void setPasswordList(List<Password> passwordList) {
        this.passwordList = passwordList;
    }
}
