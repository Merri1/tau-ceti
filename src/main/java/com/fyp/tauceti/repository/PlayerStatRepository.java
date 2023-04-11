package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.Game;
import com.fyp.tauceti.entity.PlayerStat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for generating SQL commands to apply to the PLAYER_STAT database table
 */
public interface PlayerStatRepository extends JpaRepository<PlayerStat, Long> {
    // Find PlayerStat record with a specific Game and playerName
    PlayerStat findPlayerStatByGameAndPlayerDisplayName(Game game, String playerName);
}
