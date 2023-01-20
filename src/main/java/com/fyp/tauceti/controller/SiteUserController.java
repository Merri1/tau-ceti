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

    @GetMapping("/users")
    List<SiteUser> allSiteUsers() {
        return repository.findAll();
    }

    @PostMapping("/users/new")
    SiteUser newSiteUser(@RequestBody SiteUser newSiteUser) {
        return repository.save(newSiteUser);
    }

    @DeleteMapping("/users/delete-all")
    void deleteSiteUser() {
        repository.deleteAll();
    }
}