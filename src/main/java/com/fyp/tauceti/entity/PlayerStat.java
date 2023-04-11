package com.fyp.tauceti.entity;

import jakarta.persistence.*;

/**
 * The PlayerStat entity maps to the PLAYER_STAT database table
 */
@Entity
@Table(name = "PLAYER_STAT")
public class PlayerStat {
    @Id
    @GeneratedValue
    @Column(name = "STAT_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    @Column(name = "PLAYER_KILLS")
    private Long killCount;

    @Column(name = "PLAYER_DEATHS")
    private Long deathCount;

    @Column(name = "TOTAL_SCORE")
    private Long totalScore;

    @Column(name = "TOTAL_PLAYTIME")
    private Long totalPlayTime;

    @Column(name = "TOTAL_SESSIONS")
    private Long totalSessions;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "PLAYER_ID", nullable = false)
    private Player player;

    public PlayerStat() { }

    public PlayerStat(Game game, Long killCount, Long deathCount, Long totalScore, Long totalPlayTime, Long totalSessions) {
        this.game = game;
        this.killCount = killCount;
        this.deathCount = deathCount;
        this.totalScore = totalScore;
        this.totalPlayTime = totalPlayTime;
        this.totalSessions = totalSessions;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Long getKillCount() {
        return killCount;
    }

    public void setKillCount(Long killCount) {
        this.killCount = killCount;
    }

    public Long getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(Long deathCount) {
        this.deathCount = deathCount;
    }

    public Long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Long totalScore) {
        this.totalScore = totalScore;
    }

    public Long getTotalPlayTime() {
        return totalPlayTime;
    }

    public void setTotalPlayTime(Long totalPlayTime) {
        this.totalPlayTime = totalPlayTime;
    }

    public Long getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(Long totalSessions) {
        this.totalSessions = totalSessions;
    }

    public Player getPlayer() { return player; }

    public void setPlayer(Player player) { this.player = player; }

    @Override
    public String toString() {
        return "PlayerStat{" +
                "id=" + id +
                ", game=" + game +
                ", killCount=" + killCount +
                ", deathCount=" + deathCount +
                ", totalScore=" + totalScore +
                ", totalPlayTime=" + totalPlayTime +
                ", totalSessions=" + totalSessions +
                '}';
    }
}


