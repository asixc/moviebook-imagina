package com.moviebook.repository;


import com.moviebook.entities.Film;
import com.moviebook.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Year;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository <Film, Long>{

    List<Film> findAllByOrderByDurationDesc(); //findAllByOrderByFirstNameDesc
    List<Film> findByNameFilm(String nameFilm);
    List<Film> findAllByYearOfFilmOrderByYearOfFilm(Year yearTarget);
    List<Film> findByRoleDistributionContaining(String actorName);
  //  List<Film> findByGendersContaining(String gender); jpa before Gender is an entity
    List<Film> findAllDistinctByGendersIn(List<Gender> genders);

    long countAllByRatingGreaterThanEqual(byte rate);
    List<Film> findByGenders_gender(String gender);

}