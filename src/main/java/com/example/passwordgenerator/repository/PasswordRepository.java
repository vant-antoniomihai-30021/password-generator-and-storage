package com.example.passwordgenerator.repository;

import com.example.passwordgenerator.password.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password,Long> {
}
