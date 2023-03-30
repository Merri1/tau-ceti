package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.Game;
import com.fyp.tauceti.entity.GameStat;
import com.fyp.tauceti.repository.GameRepository;
import com.fyp.tauceti.repository.GameStatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class GameStatController {
    private final GameStatRepository repository;
    private final GameRepository gameRepository;

    GameStatController(GameStatRepository repository, GameRepository gameRepository) {
        this.repository = repository;
        this.gameRepository = gameRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/game-stats")
    List<GameStat> allGameStats() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/game-stats/{id}")
    GameStat gameStat(@PathVariable UUID id) {
        GameStat gameStat = repository.findGameStatByGame_Id(id);

        // If GameStat exisits for passed ID then return it
        if(gameStat != null) {
            return gameStat;
        }
        else {
            // If not create a new empty GameStat record for the game ID that was passed
            GameStat newGameStat = new GameStat();
            newGameStat.setGame(gameRepository.findById(id));
            newGameStat.setTotalPlayerCount(0L);
            newGameStat.setTotalPlayTime(0L);
            newGameStat.setWinCount(0L);
            newGameStat.setLossCount(0L);
            newGameStat.setTotalSessions(0L);

            // Save new empty record and then return it
            return repository.save(newGameStat);
        }

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
