package com.fyp.tauceti.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PLAYER")
public class Player {
    @Id
    @GeneratedValue
    @Column(name = "PLAYER_ID", nullable = false)
    private Long id;

    @Column(name = "DISPLAY_NAME")
    private String displayName;

    @OneToOne(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PlayerStat playerStat;

    public Player() { }

    public Player(Long id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
