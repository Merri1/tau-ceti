package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.Game;
import com.fyp.tauceti.repository.GameRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class GameController {
    private final GameRepository repository;

    GameController(GameRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/games")
    List<Game> allGames() {
        return repository.findAll();
    }

    @PostMapping("/games/new")
    Game newGame(@RequestBody Game newGame) {
        return repository.save(newGame);
    }

    @DeleteMapping("/games/delete-game")
    void deleteSiteUser(@RequestBody Game game) {
        repository.delete(game);
    }
}