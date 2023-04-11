package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for generating SQL commands to apply to the PLAYER database table
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Find players with a displayName matching the passed value
    Player findPlayerByDisplayName(String displayName);
}
