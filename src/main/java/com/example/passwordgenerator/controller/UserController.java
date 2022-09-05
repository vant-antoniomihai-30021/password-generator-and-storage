package com.example.passwordgenerator.controller;


import com.example.passwordgenerator.service.UserService;
import com.example.passwordgenerator.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("api/v1/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllTheUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/save-user-{username}-{password}")
    public void saveUser(@PathVariable("username")String name, @PathVariable("password")String password){
        userService.saveUser(name,password);
    }

    @GetMapping("exists-{username}-{password}")
    public boolean canLogin(@PathVariable("username")String name,@PathVariable("password")String password){
        return userService.canLogin(name,password);
    }
}
