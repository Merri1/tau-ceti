package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.GameStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameStatRepository extends JpaRepository<GameStat, Long> { }
