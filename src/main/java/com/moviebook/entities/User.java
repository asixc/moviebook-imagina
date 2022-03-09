package com.moviebook.entities;

import com.moviebook.domain.Role;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Person {

    @Column(length = 100, unique = true)
    private String nickname;

    @Id
    @Column(unique = true, nullable = false, length = 150)
    private String email;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lasName;

    @PrePersist
    @PreUpdate
    private void prepareEmail() {
        this.email = email == null ? null : email.toLowerCase();
    }

    @Column(name = "last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    private boolean activated = false;

   // @Enumerated(EnumType.STRING)
    private Role rol;

   // @OneToMany(targetEntity = Film.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Film> films = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "register", unique = true, foreignKey = @ForeignKey(name = "fk_user_registration"))
    private RegistrationInformation registrationInformation;

    public User() {
    }

    public User(String nickname, String email, String firstName, String lasName, boolean isReferred) {
        this.nickname = nickname;
        this.email = email;
        this.firstName = firstName;
        this.lasName = lasName;
        this.activated = false;
        this.rol = Role.USER;
        this.registrationInformation = new RegistrationInformation("fake until add dependency", isReferred);
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public RegistrationInformation getRegistrationInformation() {
        return registrationInformation;
    }

    public void setRegistrationInformation(RegistrationInformation registrationInformation) {
        this.registrationInformation = registrationInformation;
    }

    public RegistrationInformation getRegistration() {
        return registrationInformation;
    }
}
