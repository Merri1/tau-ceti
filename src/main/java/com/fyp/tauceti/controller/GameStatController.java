package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.GameStat;
import com.fyp.tauceti.repository.GameStatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameStatController {
    private final GameStatRepository repository;

    GameStatController(GameStatRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "https://localhost:4200")
    @GetMapping("/game-stats")
    List<GameStat> allGameStats() {
        return repository.findAll();
    }

    @PostMapping("/game-stats-new")
    GameStat newGameStat(@RequestBody GameStat newGameStat) {
        return repository.save(newGameStat);
    }
}
