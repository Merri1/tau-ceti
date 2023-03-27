package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.Player;
import com.fyp.tauceti.entity.PlayerStat;
import com.fyp.tauceti.repository.PlayerStatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerStatController {
    private final PlayerStatRepository repository;

    PlayerStatController(PlayerStatRepository repository) { this.repository = repository; }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/player-stats")
    List<PlayerStat> allPlayerStats() { return repository.findAll(); }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/player-stats/update/{playerTag}")
    PlayerStat newPlayerStat(@RequestBody PlayerStat updatePlayerStat, @PathVariable String playerTag) {
        Player player = new Player();
        player.setDisplayName(playerTag);

        updatePlayerStat.setPlayer(player);

        return repository.save(updatePlayerStat);
    }
}
