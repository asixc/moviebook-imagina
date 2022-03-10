package com.moviebook.service;

import com.moviebook.dto.FilmDto;
import com.moviebook.entities.Film;
import com.moviebook.entities.Gender;
import org.springframework.http.ResponseEntity;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface FilmsService {

    Optional<Film> findById(Long id);
    ResponseEntity<FilmDto> save(FilmDto film);
    ResponseEntity<FilmDto> update(Long id, FilmDto film);
    List<FilmDto> saveAll(List<Film> film);
    ResponseEntity<FilmDto> deleteById(Long id);
    List<FilmDto> findAll();
    List<Film> findByName(String nameFilm);
    List<Film> findAllByDurationOrderByDuration();
    List<Film> findAllForYearAndOrderByYearOfFilm(Year year);
    List<Film> findByRoleDistributionContaining(String actorName);
    long countAllByRateGreaterThanEqual(byte rate);
    List<Film> findAllByGender(Gender gender);
    List<Film> findAllByGenders(List<Gender> genders);
    long countFilms();

}
