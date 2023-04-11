package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.LoginRecord;
import com.fyp.tauceti.entity.SiteUser;
import com.fyp.tauceti.repository.LoginRecordRepository;
import com.fyp.tauceti.repository.SiteUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

/**
 * Spring Controller for interacting with the SITE_USER database table through web APIs
 * @see com.fyp.tauceti.repository.SiteUserRepository
 * @see com.fyp.tauceti.repository.LoginRecordRepository
 * @see org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
 */
@RestController
public class SiteUserController {
    private final SiteUserRepository repository;
    private final LoginRecordRepository loginRecordRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Paramterised Constructor
     * @param repository SiteUserRepository object for CRUD operations on SITE_USER database table
     * @param loginRecordRepository LoginRecordRepository object for CRUD operations on LOGIN_RECORD database table
     */
    public SiteUserController(SiteUserRepository repository, LoginRecordRepository loginRecordRepository) {
        this.repository = repository;
        this.loginRecordRepository = loginRecordRepository;
    }

    /**
     * "new-user" endpoint: Accepts POST requests containing a new SiteUser details
     * @param newSiteUser New SiteUser to be added to the database
     * @return The saved SiteUser
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/new-user")
    public SiteUser newSiteUser(@RequestBody SiteUser newSiteUser) {
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
            // Else return a blank new SiteUser
            return new SiteUser();
        }
    }

    /**
     * "/login" endpoint: Accepts POST request when a user tries to login to the site
     * @param loginSiteUser The details of the SiteUser logging in
     * @return SiteUser record if login is valid, else a blank SiteUser record
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public SiteUser loginSiteUser(@RequestBody SiteUser loginSiteUser) {
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

    /**
     * "/users/delete-user" endpoint: Accepts DELETE requests for deleting a SiteUser record from the database
     * @param siteUser the SiteUser to be deleted
     */
    @DeleteMapping("/users/delete-user")
    public void deleteSiteUser(@RequestBody SiteUser siteUser) {
        // Not implemented yet in the frontend but this would delete a user from the database
        repository.delete(siteUser);
    }
}
