package com.moviebook.entities;

import com.moviebook.domain.FormatType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "films")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name_film", length = 200)
    private String nameFilm;

    private FormatType format;

    @Column(columnDefinition="TEXT")
    private String synopsis;

    @Column(length = 100)
    private String country;

    private short duration;

    private byte rating;

    @Column(name="purchase_price")
    private float purchasePrice;

    @Column(name = "created")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @Column(name = "year_film")
    private Year yearOfFilm;

    @Column(name = "place_of_purchase")
    private String placeOfPurchase;

    private String producers;

    // @Lob fot type object
    @Column(columnDefinition="TEXT")
    private String roleDistribution;

    @Column(name = "movie_groups")
    private String movieGroups;

    @JoinColumn(name = "FK_DIRECTOR", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Director director;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user")
    private User owner;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable( // opcional, permite configurar la tabla que se va a generar
            name = "films_genders",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "gender_id", referencedColumnName = "gender")
    )
    private Set<Gender> genders = new HashSet<>();


    public Film() {}

    public Film(String nameFilm, FormatType format, String synopsis, String country, short duration, byte rating, float purchasePrice, Year yearOfFilm,
                String placeOfPurchase, String producers, String roleDistribution, String movieGroups, Set<Gender> genders, User user, Director director) {
        this.nameFilm = nameFilm;
        this.format = format;
        this.synopsis = synopsis;
        this.country = country;
        this.duration = duration;
        this.rating = rating;
        this.purchasePrice = purchasePrice;
        this.yearOfFilm = yearOfFilm;
        this.placeOfPurchase = placeOfPurchase;
        this.producers = producers;
        this.roleDistribution = roleDistribution;
        this.movieGroups = movieGroups;
        this.genders = genders;
        this.owner = user;
        this.director = director;
    }

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Gender> getGenders() {
        return new ArrayList<>(genders);
    }

    public void setGenders(Set<Gender> genders) {
        this.genders = genders;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", nameFilm='" + nameFilm + '\'' +
                ", format=" + format +
                ", synopsis='" + synopsis + '\'' +
                ", country='" + country + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                ", purchasePrice=" + purchasePrice +
                ", created=" + created +
                ", lastUpdated=" + lastUpdated +
                ", yearOfFilm=" + yearOfFilm +
                ", placeOfPurchase='" + placeOfPurchase + '\'' +
                ", producers='" + producers + '\'' +
                ", roleDistribution='" + roleDistribution + '\'' +
                ", movieGroups='" + movieGroups + '\'' +
                ", director=" + director +
                ", owner=" + owner +
                '}';
    }
}
