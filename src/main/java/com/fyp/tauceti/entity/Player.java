package com.fyp.tauceti.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * The Player entity maps to the PLAYER database table
 */
@Entity
@Table(name = "PLAYER")
public class Player {
    /**
     * The unique ID for a player that is also the primary key of the table
     */
    @Id
    @GeneratedValue
    @Column(name = "PLAYER_ID", nullable = false)
    private Long id;

    /**
     * The display name, or gamer tag, a player uses in game
     */
    @Column(name = "DISPLAY_NAME")
    private String displayName;

    /**
     * A foreign key to the PLAYER_STAT table
     */
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PlayerStat> playerStat;

    /**
     * Default constructor
     */
    public Player() { }

    /**
     * Parameterised constructor
     * @param id A unique ID for the primary key
     * @param displayName the player name in game
     */
    public Player(Long id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    /**
     * Get the players display name
     * @return displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the players display name
     * @param displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns all information about a player as a string
     * @return string
     */
    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
