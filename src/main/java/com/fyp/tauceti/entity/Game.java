package com.fyp.tauceti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "GAME")
public class Game {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "OWNER", nullable = false)
    private SiteUser siteUser;

    @OneToOne(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private GameStat gameStat;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PlayerStat> playerStat;

    public Game() { }

    public Game(String name, String genre, LocalDateTime registrationDate, SiteUser siteUser) {
        this.name = name;
        this.genre = genre;
        this.registrationDate = registrationDate;
        this.siteUser = siteUser;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SiteUser getOwner() {
        return siteUser;
    }

    public void setOwner(SiteUser siteUser) {
        this.siteUser = siteUser;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "SiteUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + siteUser.getId() + '\'' +
                ", genre='" + genre + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
