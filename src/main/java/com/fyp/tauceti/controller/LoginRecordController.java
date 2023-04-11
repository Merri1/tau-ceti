package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.LoginRecord;
import com.fyp.tauceti.repository.LoginRecordRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Spring Controller for interacting with the LOGIN_RECORD database table through web APIs
 */
@RestController
public class LoginRecordController {
    private final LoginRecordRepository repository;

    /**
     * Paramterised Constructor
     * @param repository LoginRecordRepository object for CRUD operations on LOGIN_RECORD database table
     */
    public LoginRecordController(LoginRecordRepository repository) {
        this.repository = repository;
    }

    /**
     * "/login-record" endpoint: Accepts GET requests
     * @return A list of all LoginRecord records in the database
     */
    @CrossOrigin(origins = "https://localhost:4200")
    @GetMapping("/login-record")
    public List<LoginRecord> logins() {
        return repository.findAll();
    }
}
