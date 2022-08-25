package com.example.passwordgenerator.service;

import com.example.passwordgenerator.password.Password;
import com.example.passwordgenerator.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {
    private final PasswordRepository passwordRepository;

    @Autowired
    public PasswordService(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }

    public List<Password> getAllPasswords(){
        return passwordRepository.findAll();
    }

    public void generateNewPassword(){
        Password password = new Password();
        Password.counter++;
        passwordRepository.save(password);
    }
    public void deletePasswordBasedOnId(Long id) {
        if(!passwordRepository.existsById(id)) System.out.println("The password with the id "+ id+ " does not exist.");
        else {
            passwordRepository.deleteById(id);
            if(passwordRepository.existsById(id+1))
              passwordRepository.findById(id+1).get().setIndOfThisPassword(Password.counter-1);
        }
    }
    public void deleteAllPasswords(){
        passwordRepository.deleteAll();
    }
    public boolean isEmpty(){
        return passwordRepository.count() == 0;
    }
}
