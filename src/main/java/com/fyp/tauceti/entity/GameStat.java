package com.fyp.tauceti.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "GAME_STAT")
public class GameStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "WIN_COUNT")
    private Long winCount;

    @Column(name = "LOSS_COUNT")
    private Long lossCount;

    @Column(name = "TOTAL_PLAYTIME")
    private Long totalPlayTime;

    @Column(name = "TOTAL_SESSIONS")
    private Long totalSessions;

    @Column(name = "TOTAL_PLAYER_COUNT")
    private Long totalPlayerCount;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    public GameStat() {
    }

    public GameStat(Long winCount, Long lossCount, Long totalplaytime, Long totalSessions, Long totalPlayerCount, Game game) {
        this.winCount = winCount;
        this.lossCount = lossCount;
        this.totalPlayTime = totalplaytime;
        this.totalSessions = totalSessions;
        this.totalPlayerCount = totalPlayerCount;
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWinCount() {
        return winCount;
    }

    public void setWinCount(Long winCount) {
        this.winCount = winCount;
    }

    public Long getLossCount() {
        return lossCount;
    }

    public void setLossCount(long lossCount) {
        this.lossCount = lossCount;
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

    public Long getTotalPlayerCount() {
        return totalPlayerCount;
    }

    public void setTotalPlayerCount(Long totalPlayerCount) {
        this.totalPlayerCount = totalPlayerCount;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "GameStat{" +
                "id=" + id +
                ", winCount=" + winCount +
                ", lossCount=" + lossCount +
                ", totalplaytime=" + totalPlayTime +
                ", totalSessions=" + totalSessions +
                ", totalPlayerCount=" + totalPlayerCount +
                ", game=" + game +
                '}';
    }
}
