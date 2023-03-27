package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.SiteUser;
import com.fyp.tauceti.repository.SiteUserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@RestController
class SiteUserController {
    private final SiteUserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    SiteUserController(SiteUserRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    List<SiteUser> allSiteUsers() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/new-user")
    SiteUser newSiteUser(@RequestBody SiteUser newSiteUser) {
        SiteUser siteUser = repository.findSiteUserByEmail(newSiteUser.getEmail());

        if(siteUser == null) {
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
        SiteUser existingUser = repository.findSiteUserByEmail(loginSiteUser.getEmail());

        if(existingUser != null) {
            if (bCryptPasswordEncoder.matches(loginSiteUser.getPassword(), existingUser.getPassword())) {
                return existingUser;
            }
        }

        return new SiteUser();
    }

    @DeleteMapping("/users/delete-all")
    void deleteAllSiteUsers() {
        repository.deleteAll();
    }

    @DeleteMapping("/users/delete-user")
    void deleteSiteUser(@RequestBody SiteUser siteUser) {
        repository.delete(siteUser);
    }
}
