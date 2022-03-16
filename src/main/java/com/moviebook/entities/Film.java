package com.moviebook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moviebook.domain.FormatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "films")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_film", length = 200)
    private String nameFilm;

    private FormatType format;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    @Column(length = 100)
    private String country;

    private short duration;

    private byte rating;

    @Column(name = "purchase_price")
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
    @Column(columnDefinition = "TEXT")
    private String roleDistribution;

    @Column(name = "movie_groups")
    private String movieGroups;

    @JoinColumn(name = "FK_DIRECTOR", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Director director;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User owner;

    /* @JoinTable( opcional, permite configurar la tabla que se va a generar
            name = "films_genders",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "gender_id", referencedColumnName = "gender")
    )*/
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Gender> genders = new ArrayList<>();

}
