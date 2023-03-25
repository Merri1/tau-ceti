package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.Player;
import com.fyp.tauceti.repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    private final PlayerRepository repository;

    PlayerController(PlayerRepository repository) { this.repository = repository; }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/player")
    List<Player> allPlayers() { return repository.findAll(); }

    @PostMapping("/update-player")
    Player newPlayer(@RequestBody Player newPlayer) { return repository.save(newPlayer); }
}
