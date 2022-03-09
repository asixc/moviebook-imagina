package com.moviebook.service.impl;

import com.moviebook.entities.Film;
import com.moviebook.entities.Gender;
import com.moviebook.repository.FilmRepository;
import com.moviebook.service.FilmsService;
import com.moviebook.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmsService {

    private static final Log log = LogFactory.getLog(FilmServiceImpl.class);
    private final FilmRepository repository;
    private final UserService userService;


    public FilmServiceImpl(FilmRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Film> save(Film film) {
        if (!this.userService.existsById(film.getOwner().getEmail()))
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(this.repository.save(film));
    }

    @Override
    public ResponseEntity<Film> update(Long id, Film film) {
        if (!this.userService.existsById(film.getOwner().getEmail())
                || !this.repository.existsById(id))
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        film.setId(id);
        return ResponseEntity.ok(this.repository.save(film));
    }

    @Override
    public List<Film> saveAll(List<Film> films) {
        log.info("saving...");
        return this.repository.saveAll(films);
    }

    @Override
    public ResponseEntity<Film> deleteById(Long id) {
        if (id == null)
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        if (!this.repository.existsById(id)){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public Optional<Film> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Film> findAll() {
        var films = this.repository.findAll();
        return films;
    }

    @Override
    public List<Film> findByName(String nameFilm) {
        return this.repository.findByNameFilm(nameFilm);
    }

    @Override
    public List<Film> findAllByDurationOrderByDuration() {
        return this.repository.findAllByOrderByDurationDesc();
    }

    @Override
    public List<Film> findAllForYearAndOrderByYearOfFilm(Year yearTarget) {
        return this.repository.findAllByYearOfFilmOrderByYearOfFilm(yearTarget);
    }

    @Override
    public List<Film> findByRoleDistributionContaining(String actorName) {
        return this.repository.findByRoleDistributionContaining(actorName);
    }

    @Override
    public long countAllByRateGreaterThanEqual(byte rate) {
        return this.repository.countAllByRatingGreaterThanEqual(rate);
    }

    @Override
    public List<Film> findAllByGender(Gender gender) {
        return this.repository.findByGenders_gender(gender.getGender());
    }

    @Override
    public List<Film> findAllByGenders(List<Gender> genders) {
        return this.repository.findAllDistinctByGendersIn(genders);
    }

    @Override
    public long countFilms() {
        return this.repository.count();
    }
}
