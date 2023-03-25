package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.PlayerStat;
import com.fyp.tauceti.repository.PlayerStatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerStatController {
    private final PlayerStatRepository repository;

    PlayerStatController(PlayerStatRepository repository) { this.repository = repository; }

    @CrossOrigin(origins = "https://localhost:4200")
    @GetMapping("/player-stats")
    List<PlayerStat> allPlayerStats() { return repository.findAll(); }

    @PostMapping("/update-player-stats")
    PlayerStat newPlayerStat(@RequestBody PlayerStat newPlayerStat) {
        return repository.save(newPlayerStat);
    }
}
