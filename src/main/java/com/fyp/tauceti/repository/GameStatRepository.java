package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.GameStat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameStatRepository extends JpaRepository<GameStat, Long> {
    GameStat findGameStatByGame_Id(UUID gameId);

    GameStat findGameStatById(Long id);
}
