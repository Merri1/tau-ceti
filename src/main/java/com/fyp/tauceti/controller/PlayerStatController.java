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

@RestController
public class PlayerStatController {
    private final PlayerStatRepository repository;
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    PlayerStatController(PlayerStatRepository repository, PlayerRepository playerRepository, GameRepository gameRepository) {
        this.repository = repository;
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/player-stats")
    List<PlayerStat> allPlayerStats() {
        // Return all player stats records
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/player-stats/{gameId}/{playerTag}")
    PlayerStat playerStats(@PathVariable UUID gameId, @PathVariable String playerTag) {
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/player-stats/update/{gameId}/{playerTag}")
    PlayerStat newPlayerStat(@RequestBody PlayerStat updatePlayerStat, @PathVariable UUID gameId, @PathVariable String playerTag) {
        // Set player name to value passed at the end of the URL
        Player player = playerRepository.findPlayerByDisplayName(playerTag);

        if(player != null) {
            updatePlayerStat.setPlayer(player);
        }

        Game existingGame = gameRepository.findById(gameId);

        PlayerStat existingPlayerStat = repository.findPlayerStatByGameAndPlayerDisplayName(existingGame, playerTag);

        // If player exists update stat values for that player
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
            // Pull Game based on game token passed as path variable
            Game game = gameRepository.findById(gameId);
            Player newPlayer = new Player();
            PlayerStat newPlayerStat = new PlayerStat();

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
