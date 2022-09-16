package com.example.passwordgenerator.controller;

import com.example.passwordgenerator.service.UserService;
import com.example.passwordgenerator.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register.html")
    public ModelAndView home(Model model){
        model.addAttribute("user", new User());
        return new ModelAndView("register");
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute User user, Model model){
        model.addAttribute("user",user);
        userService.saveUser(user);
        return new ModelAndView("login");
    }


}
