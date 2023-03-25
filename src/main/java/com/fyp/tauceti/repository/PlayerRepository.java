package com.fyp.tauceti.repository;

import com.fyp.tauceti.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
