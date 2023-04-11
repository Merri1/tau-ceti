package com.fyp.tauceti.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The SiteUser entity maps to the SITE_USER database table
 */
@Entity
@Table(name = "SITE_USER")
public class SiteUser {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "K_NUMBER")
    private String kNumber;

    @Column(name = "REGISTRATION_DATE", nullable = false)
    private LocalDateTime registrationDate;

    @OneToMany(mappedBy = "siteUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Game> game;

    @OneToMany(mappedBy = "siteUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LoginRecord> loginRecord;

    public SiteUser() {
    }

    public SiteUser(String firstName, String lastName, String email, String password, String kNumber, LocalDateTime registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.kNumber = kNumber;
        this.registrationDate = registrationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getKNumber() {
        return kNumber;
    }

    public void setKNumber(String kNumber) {
        this.kNumber = kNumber;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", kNumber='" + kNumber + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
