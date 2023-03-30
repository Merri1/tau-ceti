package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.Game;
import com.fyp.tauceti.entity.PlayerStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatRepository extends JpaRepository<PlayerStat, Long> {
    PlayerStat findPlayerStatByGameAndPlayerDisplayName(Game game, String playerName);
}
