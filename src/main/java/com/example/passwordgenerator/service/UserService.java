package com.example.passwordgenerator.service;

import com.example.passwordgenerator.repository.UserRepository;
import com.example.passwordgenerator.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean canLogin(String name, String password, String email){
        return userRepository.existsByUsername(name) && userRepository.existsByPassword(password) && userRepository.existsByEmail(email);
    }
    public void saveUser(String name, String password, String email){
        userRepository.save(new User(name,password,email));
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
