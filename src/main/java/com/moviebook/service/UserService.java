package com.moviebook.service;

import com.moviebook.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(String id);
    User save(User user);
    User update(String userId, User user);
    List<User> saveAll(List<User> film);
    void deleteById(String id);
    List<User> findAll();
    List<User> findByName(String userName);
    boolean existsById(String userId);


}
