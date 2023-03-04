package com.fyp.tauceti.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "LOGIN_RECORD")
public class LoginRecord {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "LOGIN_TIME", nullable = false)
    private LocalDateTime loginTime;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SITE_USER", nullable = false)
    private SiteUser siteUser;

    public LoginRecord() {
    }

    public LoginRecord(LocalDateTime timestamp, SiteUser siteUser) {
        this.loginTime = timestamp;
        this.siteUser = siteUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime timestamp) {
        this.loginTime = timestamp;
    }

    public SiteUser getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(SiteUser siteUserLoggedIn) {
        this.siteUser = siteUserLoggedIn;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", timestamp=" + loginTime +
                ", siteUser=" + siteUser +
                '}';
    }
}
