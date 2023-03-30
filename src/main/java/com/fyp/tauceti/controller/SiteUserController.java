package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.LoginRecord;
import com.fyp.tauceti.entity.SiteUser;
import com.fyp.tauceti.repository.LoginRecordRepository;
import com.fyp.tauceti.repository.SiteUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@RestController
class SiteUserController {
    private final SiteUserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private final LoginRecordRepository loginRecordRepository;

    SiteUserController(SiteUserRepository repository, LoginRecordRepository loginRecordRepository) {
        this.repository = repository;
        this.loginRecordRepository = loginRecordRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/new-user")
    SiteUser newSiteUser(@RequestBody SiteUser newSiteUser) {
        // Search for record with new email to see if it already exists
        SiteUser siteUser = repository.findSiteUserByEmail(newSiteUser.getEmail());

        if(siteUser == null) {
            // If user doesn't already exist, hash their chosen password and write user info to database
            String hashedPassword = bCryptPasswordEncoder.encode(newSiteUser.getPassword());
            newSiteUser.setPassword(hashedPassword);
            newSiteUser.setRegistrationDate(LocalDateTime.now());
            return repository.save(newSiteUser);
        }
        else {
            return new SiteUser();
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    SiteUser loginSiteUser(@RequestBody SiteUser loginSiteUser) {
        // Return site user with matching email as login
        SiteUser existingUser = repository.findSiteUserByEmail(loginSiteUser.getEmail());

        // Check if site user exists
        if(existingUser != null) {
            // Check if login password matches hashed password for that user
            if (bCryptPasswordEncoder.matches(loginSiteUser.getPassword(), existingUser.getPassword())) {
                LoginRecord loginRecord = new LoginRecord();

                // Add a new entry to the login record table for user
                loginRecord.setLoginTime(LocalDateTime.now());
                loginRecord.setSiteUser(existingUser);
                loginRecordRepository.save(loginRecord);

                return existingUser;
            }
        }

        // Return blank user if email not found or password doesn't match
        return new SiteUser();
    }

    @DeleteMapping("/users/delete-user")
    void deleteSiteUser(@RequestBody SiteUser siteUser) {
        // Not implemented yet in the frontend but this would delete a user from the database
        repository.delete(siteUser);
    }
}
