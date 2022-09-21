package com.example.passwordgenerator.controller;

import com.example.passwordgenerator.password.Password;
import com.example.passwordgenerator.service.PasswordService;
import com.example.passwordgenerator.service.UserService;
import com.example.passwordgenerator.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("api/v1/passwords")
public class PasswordController {
    private final PasswordService passwordService;
    @Autowired
    private UserService userService;
    ArrayList<User> list = new ArrayList<>();


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
//        if(!list.contains(userService.findByUsername(authentication.getName()))){
//            System.out.println("it doesn't contain "+userService.findByUsername(authentication.getName()));
//            list.add(userService.findByUsername(authentication.getName()));}
//        System.out.println(list.size()); => ADD A FOR INSTEAD OF IF BECAUSE IT DOESN'T WORK, IT SAYS THAT IT DOESN'T CONTAIN EVEN IF IT DOES

        userService.findByUsername(authentication.getName()).setPasswordList(passwordService.getAllPasswords());

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
