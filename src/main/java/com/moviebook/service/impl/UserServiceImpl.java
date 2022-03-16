package com.moviebook.service.impl;

import com.moviebook.domain.Role;
import com.moviebook.dto.UserDto;
import com.moviebook.dto.mapper.UserMapper;
import com.moviebook.entities.User;
import com.moviebook.repository.UserRepository;
import com.moviebook.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Log log = LogFactory.getLog(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findById(String id) {
        log.info("UserService FindById:" + id);
        return this.userRepository.findById(id);
    }

    @Override
    public ResponseEntity<UserDto> save(UserDto newUser) {
        if( newUser.getEmail().isBlank() || this.userRepository.existsById(newUser.getEmail()) )
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        newUser.setActivated(false);
        newUser.setRol(Role.USER);
        var userSaved = this.userRepository.save(this.userMapper.toEntity(newUser));

        return ResponseEntity.ok(this.userMapper.toDto(userSaved));
    }

    @Override
    public ResponseEntity<UserDto> update(String userId, UserDto userToUpdate) {
        if (!this.userRepository.existsById(userId))
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        var lastUser = this.userRepository.getById(userId);
        userToUpdate.setEmail(userId);
        userToUpdate.setRegistrationInformation(lastUser.getRegistrationInformation());
        var userSaved = this.userRepository.save(this.userMapper.toEntity(userToUpdate));

        return ResponseEntity.ok(this.userMapper.toDto(userSaved));
    }

    @Override
    public ResponseEntity<UserDto> deleteById(String id) {
        if (!this.userRepository.existsById(id))
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        this.userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @Override
    public List<UserDto> findAll() {
        var users= this.userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
        return users;
    }
    @Override
    public boolean existsById(String userId) {
        return this.userRepository.existsById(userId);
    }
    @Override
    public List<User> findByName(String userName) {
        return this.userRepository.findByFirstNameContaining(userName);
    }
}
