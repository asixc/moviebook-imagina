package com.moviebook.service.impl;

import com.moviebook.dto.FilmDto;
import com.moviebook.dto.mapper.FilmMapper;
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
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmsService {

    private static final Log log = LogFactory.getLog(FilmServiceImpl.class);
    private final FilmRepository repository;
    private final UserService userService;
    private final FilmMapper filmMapper;


    public FilmServiceImpl(FilmRepository repository, UserService userService, FilmMapper filmMapper) {
        this.repository = repository;
        this.userService = userService;
        this.filmMapper = filmMapper;
    }

    @Override
    public ResponseEntity<FilmDto> save(FilmDto film) {
        if (!this.userService.existsById(film.getOwner()))
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        var filmUpdated = this.repository.save(filmMapper.mapperDtoToFilmEntity(film));
        return ResponseEntity.ok(this.filmMapper.mapperEntityToFilmDto(filmUpdated));
    }

    @Override
    public ResponseEntity<FilmDto> update(Long id, FilmDto film) {
        if (!this.userService.existsById(film.getOwner())
                || !this.repository.existsById(id))
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        film.setId(id);

        return this.save(film);
    }

    @Override
    public List<FilmDto> saveAll(List<Film> films) {
        log.info("saving...");
        return this.repository.saveAll(films).stream()
                .map(filmMapper::mapperEntityToFilmDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<FilmDto> deleteById(Long id) {
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
    public List<FilmDto> findAll() {
        var films = this.repository.findAll().stream()
                .map(this.filmMapper::mapperEntityToFilmDto)
                .collect(Collectors.toList());
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
