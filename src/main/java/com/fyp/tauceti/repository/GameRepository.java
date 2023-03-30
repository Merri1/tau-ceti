package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, Long> {
    Game findById(UUID id);
}

