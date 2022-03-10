package com.moviebook.controller;

import com.moviebook.dto.FilmDto;
import com.moviebook.entities.Film;
import com.moviebook.entities.User;
import com.moviebook.service.FilmsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    private static final Log log = LogFactory.getLog(FilmController.class);

    private final FilmsService service;

    public FilmController(FilmsService service) {
        this.service = service;
    }


    @GetMapping
    public List<FilmDto> getFilms() { return this.service.findAll();}

    @PostMapping()
    public ResponseEntity<FilmDto> save(@RequestBody FilmDto newFilm){
        return this.service.save(newFilm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDto> update(@PathVariable Long id,@RequestBody FilmDto filmUpdate){
        return this.service.update(id, filmUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FilmDto> deleteById(@PathVariable Long id) {
        return this.service.deleteById(id);
    }
}
