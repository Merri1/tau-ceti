package com.fyp.tauceti.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "GAME_STAT")
public class GameStat {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "WIN_COUNT")
    private Long winCount;

    @Column(name = "LOSS_COUNT")
    private long lossCount;

    @Column(name = "TOTAL_PLAYTIME")
    private Long totalplaytime;

    @Column(name = "TOTAL_SESSIONS")
    private Long totalSessions;

    @Column(name = "TOTAL_PLAYER_COUNT")
    private Long totalPlayerCount;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "GAME_ID", nullable = false)
    private Game game;

    public GameStat() {
    }

    public GameStat(Long winCount, long lossCount, Long totalplaytime, Long totalSessions, Long totalPlayerCount, Game game) {
        this.winCount = winCount;
        this.lossCount = lossCount;
        this.totalplaytime = totalplaytime;
        this.totalSessions = totalSessions;
        this.totalPlayerCount = totalPlayerCount;
        this.game = game;
    }

    public Long getWinCount() {
        return winCount;
    }

    public void setWinCount(Long winCount) {
        this.winCount = winCount;
    }

    public long getLossCount() {
        return lossCount;
    }

    public void setLossCount(long lossCount) {
        this.lossCount = lossCount;
    }

    public Long getTotalplaytime() {
        return totalplaytime;
    }

    public void setTotalplaytime(Long totalplaytime) {
        this.totalplaytime = totalplaytime;
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
                ", totalplaytime=" + totalplaytime +
                ", totalSessions=" + totalSessions +
                ", totalPlayerCount=" + totalPlayerCount +
                ", game=" + game +
                '}';
    }
}
