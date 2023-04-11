package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.Game;
import com.fyp.tauceti.entity.Player;
import com.fyp.tauceti.entity.PlayerStat;
import com.fyp.tauceti.repository.GameRepository;
import com.fyp.tauceti.repository.PlayerRepository;
import com.fyp.tauceti.repository.PlayerStatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Spring Controller for interacting with the PLAYER_STAT database table through web APIs
 * @see com.fyp.tauceti.repository.PlayerStatRepository
 * @see com.fyp.tauceti.repository.PlayerRepository
 * @see com.fyp.tauceti.repository.GameRepository
 */
@RestController
public class PlayerStatController {
    private final PlayerStatRepository repository;
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    /**
     * Paramterised Constructor
     * @param repository PlayerStatRepository object for CRUD operations on PLAYER_STAT database table
     * @param playerRepository PlayerRepository object for CRUD operations on PLAYER database table
     * @param gameRepository GameRepository object for CRUD operations on GAME database table
     */
    public PlayerStatController(PlayerStatRepository repository, PlayerRepository playerRepository, GameRepository gameRepository) {
        this.repository = repository;
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    /**
     * "/player-stats" endpoint: Accepts GET requests
     * @return List of all PlayerStat records in the database
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/player-stats")
    public List<PlayerStat> allPlayerStats() {
        // Return all player stats records
        return repository.findAll();
    }

    /**
     * "/player-stats/{gameId}/{playerTag}" endpoing: Accepts GET requests for a single PlayerStat record
     * @param gameId The ID for a specific Game
     * @param playerTag The playerTag for a specific Player
     * @return A PlayerStat record for a single Player for a single Game
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/player-stats/{gameId}/{playerTag}")
    public PlayerStat playerStats(@PathVariable UUID gameId, @PathVariable String playerTag) {
        Game existingGame = gameRepository.findById(gameId);
        PlayerStat existingPlayerStat = repository.findPlayerStatByGameAndPlayerDisplayName(existingGame, playerTag);

        // if player stat exists for that playerTag return it
        if(existingPlayerStat != null) {
            return existingPlayerStat;
        }
        else {
            // else return a new blank player stat record
            PlayerStat newPlayerStat = new PlayerStat();
            newPlayerStat.setId(0L);
            newPlayerStat.setKillCount(0L);
            newPlayerStat.setDeathCount(0L);
            newPlayerStat.setTotalScore(0L);
            newPlayerStat.setTotalPlayTime(0L);
            newPlayerStat.setTotalSessions(0L);

            return newPlayerStat;
        }
    }

    /**
     * "/player-stats/update/{gameId}/{playerTag}" endpoint: Accepts POST requests to update an existing PlayerStat record
     * @param updatePlayerStat new PlayerStat values to be updated
     * @param gameId The ID for a specific game
     * @param playerTag The playerTag for a specific Player
     * @return PlayerStat record that was updated or created in database
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/player-stats/update/{gameId}/{playerTag}")
    public PlayerStat newPlayerStat(@RequestBody PlayerStat updatePlayerStat, @PathVariable UUID gameId, @PathVariable String playerTag) {
        // Check if player with passed playerTag value already exists
        Player player = playerRepository.findPlayerByDisplayName(playerTag);

        if(player != null) {
            // Set updatePlayerStat Player object to existing Player
            updatePlayerStat.setPlayer(player);
        }

        // Find Game record that matches passed gameId value
        Game existingGame = gameRepository.findById(gameId);

        // Check if PlayerStat record exists for the passed playerTag and gameId values
        PlayerStat existingPlayerStat = repository.findPlayerStatByGameAndPlayerDisplayName(existingGame, playerTag);

        // If PlayerStat exists update stat values for that player
        if(existingPlayerStat != null) {
            existingPlayerStat.setDeathCount(updatePlayerStat.getDeathCount());
            existingPlayerStat.setKillCount(updatePlayerStat.getKillCount());
            existingPlayerStat.setTotalPlayTime(updatePlayerStat.getTotalPlayTime());
            existingPlayerStat.setTotalSessions(updatePlayerStat.getTotalSessions());
            existingPlayerStat.setTotalScore(updatePlayerStat.getTotalScore());

            // Save player with updated stats
            return repository.save(existingPlayerStat);
        }
        else {
            // If player has no existing stats create a new one.
            Game game = gameRepository.findById(gameId);
            Player newPlayer = new Player();
            PlayerStat newPlayerStat = new PlayerStat();

            // Set playerTag and then save new Player
            newPlayer.setDisplayName(playerTag);
            playerRepository.save(newPlayer);

            // Update new player stat values from those passed from game
            newPlayerStat.setPlayer(playerRepository.findPlayerByDisplayName(playerTag));
            newPlayerStat.setGame(game);
            newPlayerStat.setDeathCount(updatePlayerStat.getDeathCount());
            newPlayerStat.setKillCount(updatePlayerStat.getKillCount());
            newPlayerStat.setTotalPlayTime(updatePlayerStat.getTotalPlayTime());
            newPlayerStat.setTotalSessions(updatePlayerStat.getTotalSessions());
            newPlayerStat.setTotalScore(updatePlayerStat.getTotalScore());

            // Save new player stats
            return repository.save(newPlayerStat);
        }
    }
}
