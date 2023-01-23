package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.SiteUser;
import com.fyp.tauceti.repository.SiteUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class SiteUserController {
    private final SiteUserRepository repository;

    SiteUserController(SiteUserRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    List<SiteUser> allSiteUsers() {
        return repository.findAll();
    }

    @PostMapping("/users/new")
    SiteUser newSiteUser(@RequestBody SiteUser newSiteUser) {
        return repository.save(newSiteUser);
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
