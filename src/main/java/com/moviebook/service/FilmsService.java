package com.moviebook.service;

import com.moviebook.entities.Film;
import com.moviebook.entities.Gender;
import org.springframework.http.ResponseEntity;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface FilmsService {

    Optional<Film> findById(Long id);
    ResponseEntity<Film> save(Film film);
    ResponseEntity<Film> update(Long id, Film film);
    List<Film> saveAll(List<Film> film);
    ResponseEntity<Film> deleteById(Long id);
    List<Film> findAll();
    List<Film> findByName(String nameFilm);
    List<Film> findAllByDurationOrderByDuration();
    List<Film> findAllForYearAndOrderByYearOfFilm(Year year);
    List<Film> findByRoleDistributionContaining(String actorName);
    long countAllByRateGreaterThanEqual(byte rate);
    List<Film> findAllByGender(Gender gender);
    List<Film> findAllByGenders(List<Gender> genders);
    long countFilms();

}
