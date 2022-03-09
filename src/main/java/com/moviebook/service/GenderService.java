package com.moviebook.service;

import com.moviebook.entities.Gender;

import java.util.List;
import java.util.Optional;

public interface GenderService {

    Optional<Gender> findById(String id);
    Gender save(Gender Gender);
    List<Gender> saveAll(List<Gender> gender);
    void deleteById(String id);
    List<Gender> findAll();

}
