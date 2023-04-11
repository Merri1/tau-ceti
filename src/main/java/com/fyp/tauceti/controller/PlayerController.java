package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.Player;
import com.fyp.tauceti.repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring Controller for interacting with the PLAYER database table through web APIs
 * @see com.fyp.tauceti.repository.PlayerRepository
 * @see com.fyp.tauceti.entity.Player
 */
@RestController
public class PlayerController {
    private final PlayerRepository repository;

    /**
     * Paramaterised Constructor
     * @param repository PlayerRepository object for CRUD operations on LOGIN_RECORD database table
     */
    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    /**
     * "/player" endpoint: Accepts GET requests
     * @return List of all Player records in database
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/player")
    public List<Player> allPlayers() {
        return repository.findAll();
    }

    /**
     * "/update-player" endpoint: Accepts POST requests
     * @param newPlayer Player object to be added to database
     * @return The Player object that was saved
     */
    @PostMapping("/update-player")
    public Player newPlayer(@RequestBody Player newPlayer) {
        return repository.save(newPlayer);
    }
}
