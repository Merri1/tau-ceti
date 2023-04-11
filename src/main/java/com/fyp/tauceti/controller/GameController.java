package com.fyp.tauceti.controller;

import com.fyp.tauceti.entity.Game;
import com.fyp.tauceti.repository.GameRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Spring Controller for interacting with the GAME database table through web APIs
 * @see com.fyp.tauceti.repository.GameRepository
 * @see com.fyp.tauceti.entity.Game
 */
@RestController
public class GameController {
    private final GameRepository repository;

    /**
     * Parameterised Constructor
     * @param repository GameRepository object for CRUD operations on GAME database table
     */
    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    /**
     * "/games" endpoint: Accepts GET requests
     * @return A list of all Game records in database
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/games")
    public List<Game> allGames() {
        return repository.findAll();
    }

    /**
     * "/games/new" endpoint: Accepts POST request containing a Game object in body and saves it to the database
     * @param newGame A Game object retrieved from the HTTP request body
     * @return The saved Game object
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/games/new")
    public Game newGame(@RequestBody Game newGame) {
        newGame.setRegistrationDate(LocalDateTime.now());
        return repository.save(newGame);
    }

    /**
     * "/games/delete-game" endpoint: Accepts DELETE request and removes a Game object from the database
     * @param game The Game object to be deleted
     */
    @DeleteMapping("/games/delete-game")
    public void deleteGame(@RequestBody Game game) {
        repository.delete(game);
    }
}