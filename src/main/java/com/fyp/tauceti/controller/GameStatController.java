package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.Game;
import com.fyp.tauceti.entity.GameStat;
import com.fyp.tauceti.repository.GameStatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class GameStatController {
    private final GameStatRepository repository;

    GameStatController(GameStatRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/game-stats")
    List<GameStat> allGameStats() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/game-stats/{id}")
    GameStat gameStat(@PathVariable UUID id) {
        return repository.findGameStatByGame_Id(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/game-stats/update/{gameId}")
    GameStat newGameStat(@RequestBody GameStat updatedGameStat, @PathVariable UUID gameId) {
        Game game = new Game();
        game.setId(gameId);

        updatedGameStat.setGame(game);

        return repository.save(updatedGameStat);
    }
}
