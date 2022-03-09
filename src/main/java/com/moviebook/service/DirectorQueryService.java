package com.moviebook.service;

import com.moviebook.entities.Director;

import java.util.List;

public interface DirectorQueryService {
    /* @Query
     * update
     * insert
     * delete
     */

    Director insertDirector(Director director);
    void deleteDirector(Director director);
    Director updatetDirector(Director director);
    List<Director> findAll();
}
