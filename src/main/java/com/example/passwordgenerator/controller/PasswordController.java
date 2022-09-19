package com.example.passwordgenerator.controller;

import com.example.passwordgenerator.password.Password;
import com.example.passwordgenerator.service.PasswordService;
import com.example.passwordgenerator.service.UserService;
import com.example.passwordgenerator.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("api/v1/passwords")
public class PasswordController {
    private final PasswordService passwordService;
    @Autowired
    private UserService userService;

    private Map<User,Boolean> map = new HashMap<>();

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping
    public List<Password> getAllPasswords(){
        return passwordService.getAllPasswords();
    }

    @PutMapping("/put")
    public void generateNewPassword(){passwordService.generateNewPassword();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userService.findByUsername(authentication.getName()).setPasswordList(passwordService.getAllPasswords());
        userService.saveUser(userService.findByUsername(authentication.getName()));
    }

    @DeleteMapping("/delete{passwordId}")
    public void deletePasswordBasedOnId(@PathVariable("passwordId") Long id){
        passwordService.deletePasswordBasedOnId(id);
    }

    @DeleteMapping("/delete-all")
    public void deleteAllPassWords(){
        passwordService.deleteAllPasswords();
    }

    @GetMapping("/check-if-empty")
    public boolean isEmpty(){
        return passwordService.isEmpty();
    }

    @PutMapping("/save-this-password{passwordToSave}")
    public void saveThisPassword(@PathVariable("passwordToSave") String password){
        Password passwordToSave=new Password();
       passwordToSave.setPassword(password);
       passwordService.saveThisPassword(passwordToSave);
    }

    @GetMapping("/exists{passwordId}")
    public boolean checkIfThisIdExists(@PathVariable("passwordId")Long id){
        return passwordService.checkIfExistsById(id);
    }

}
