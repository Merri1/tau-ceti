package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.GameStat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for generating SQL commands to apply to the GAME_STAT database table
 */
public interface GameStatRepository extends JpaRepository<GameStat, Long> {
    // Find GameStat with a foreign key of gameId
    GameStat findGameStatByGame_Id(UUID gameId);
}
