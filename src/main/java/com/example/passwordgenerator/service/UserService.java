package com.example.passwordgenerator.service;

import com.example.passwordgenerator.repository.UserRepository;
import com.example.passwordgenerator.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }
}
