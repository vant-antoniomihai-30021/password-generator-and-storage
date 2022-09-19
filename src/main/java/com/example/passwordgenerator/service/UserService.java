package com.example.passwordgenerator.service;

import com.example.passwordgenerator.repository.UserRepository;
import com.example.passwordgenerator.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public void deleteByUsername(String username){
        userRepository.deleteByUsername(username);
    }
}
