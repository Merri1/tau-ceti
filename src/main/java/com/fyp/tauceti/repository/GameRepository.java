package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> { }

