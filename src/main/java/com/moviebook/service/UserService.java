package com.moviebook.service;

import com.moviebook.dto.UserDto;
import com.moviebook.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(String id);
    ResponseEntity<UserDto> save(UserDto user);
   // List<User> saveAll(List<User> film);
    ResponseEntity<UserDto> update(String userId, UserDto userToUpdate);
    ResponseEntity<UserDto> deleteById(String id);
    List<UserDto> findAll();
    List<User> findByName(String userName);
    boolean existsById(String userId);


}
