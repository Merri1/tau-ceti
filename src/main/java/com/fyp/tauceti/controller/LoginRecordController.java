package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.LoginRecord;
import com.fyp.tauceti.repository.LoginRecordRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginRecordController {
    private final LoginRecordRepository repository;

    LoginRecordController(LoginRecordRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "https://localhost:4200")
    @GetMapping("/login-record")
    List<LoginRecord> logins() {
        return repository.findAll();
    }
}
