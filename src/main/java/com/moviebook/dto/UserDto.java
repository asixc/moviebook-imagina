package com.moviebook.dto;

import com.moviebook.domain.Role;
import com.moviebook.entities.Film;
import com.moviebook.entities.RegistrationInformation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDto {

    private String email;

    private String nickname;

    private String firstName;

    private String lasName;

    private LocalDateTime lastUpdated;

    private boolean activated = false;

    private Role rol;

    private List<Film> films = new ArrayList<>();

    private RegistrationInformation registrationInformation;

    public UserDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
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

    public List<Film> getFilms() {
        return Collections.unmodifiableList(films);
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void setRegistrationInformation(RegistrationInformation registrationInformation) {
        this.registrationInformation = registrationInformation;
    }
}
