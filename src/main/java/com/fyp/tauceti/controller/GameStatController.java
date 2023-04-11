package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.Game;
import com.fyp.tauceti.entity.GameStat;
import com.fyp.tauceti.repository.GameRepository;
import com.fyp.tauceti.repository.GameStatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Spring Controller for interacting with the GAME database table through web APIs
 * @see com.fyp.tauceti.repository.GameRepository
 * @see com.fyp.tauceti.repository.GameStatRepository
 * @see com.fyp.tauceti.entity.Game
 * @see com.fyp.tauceti.entity.GameStat
 */
@RestController
public class GameStatController {
    private final GameStatRepository repository;
    private final GameRepository gameRepository;

    /**
     * Parameterised Constructor
     * @param repository GameStatRepository object for CRUD operations on GAME_STAT database table
     * @param gameRepository GameRepository object for CRUD operations on GAME database table
     */
    public GameStatController(GameStatRepository repository, GameRepository gameRepository) {
        this.repository = repository;
        this.gameRepository = gameRepository;
    }

    /**
     * "/game-stats" endpoint: Accepts GET requests
     * @return A list of all GameStats records in the database
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/game-stats")
    public List<GameStat> allGameStats() {
        return repository.findAll();
    }

    /**
     * "/game-stats/{id}" endpoint: Accepts GET requests for a specific GameStat record. Searches database for any GameStat
     * records matching the passed ID
     * @param id The ID for a specific Game
     * @return The requested GameStat record if it exists, or else an empty GameStat record
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/game-stats/{id}")
    public GameStat gameStat(@PathVariable UUID id) {
        // Search GameStat for one with the passed Game ID
        GameStat gameStat = repository.findGameStatByGame_Id(id);

        // If GameStat exists for passed ID then return it
        if(gameStat != null) {
            return gameStat;
        }
        else {
            // If not, create a new empty GameStat record for the game ID that was passed
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

    /**
     * "/game-stats/update/{gameId}" endpoint: Accepts POST request for updating a GameStat record in the database
     * @param updatedGameStat new GameStat record to be updated in the database
     * @param gameId The ID for a specific Game
     * @return the saved GameStat record
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/game-stats/update/{gameId}")
    public GameStat newGameStat(@RequestBody GameStat updatedGameStat, @PathVariable UUID gameId) {
        // Create a new Game object and assign it the Game ID passed with the request
        Game game = new Game();
        game.setId(gameId);

        // Update the Game object for the updated GameStat
        updatedGameStat.setGame(game);

        // Save updated GameStat record to database
        return repository.save(updatedGameStat);
    }
}
