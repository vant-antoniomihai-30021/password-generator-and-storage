package com.example.passwordgenerator.user;
import javax.persistence.*;


@Entity
@Table(name = "users_table")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "password_generator")
    @SequenceGenerator(name="password_generator",sequenceName = "password_generator",allocationSize = 1)
    private Long id;
    private String username;
    private String password;
    private String email;

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
}
