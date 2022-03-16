package com.moviebook.dto;

import com.moviebook.domain.FormatType;
import com.moviebook.entities.Director;
import com.moviebook.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private String owner;
}
