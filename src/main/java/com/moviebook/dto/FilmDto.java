package com.moviebook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moviebook.domain.FormatType;
import com.moviebook.entities.Director;
import com.moviebook.entities.Gender;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Collections;
import java.util.List;

public class FilmDto {
    private Long id;
    private String nameFilm;
    private FormatType format;
    private String synopsis;
    private String country;
    private short duration;
    private byte rating;
    private float purchasePrice;
    private LocalDateTime created;
    private LocalDateTime lastUpdated;
    private Year yearOfFilm;
    private String placeOfPurchase;
    private String producers;
    private String roleDistribution;
    private String movieGroups;
    private Director director;
    private List<Gender> genders;

   // @JsonProperty("user.email")
    private String owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public FormatType getFormat() {
        return format;
    }

    public void setFormat(FormatType format) {
        this.format = format;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Year getYearOfFilm() {
        return yearOfFilm;
    }

    public void setYearOfFilm(Year yearOfFilm) {
        this.yearOfFilm = yearOfFilm;
    }

    public String getPlaceOfPurchase() {
        return placeOfPurchase;
    }

    public void setPlaceOfPurchase(String placeOfPurchase) {
        this.placeOfPurchase = placeOfPurchase;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getRoleDistribution() {
        return roleDistribution;
    }

    public void setRoleDistribution(String roleDistribution) {
        this.roleDistribution = roleDistribution;
    }

    public String getMovieGroups() {
        return movieGroups;
    }

    public void setMovieGroups(String movieGroups) {
        this.movieGroups = movieGroups;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Gender> getGenders() {
        return Collections.unmodifiableList(genders);
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
