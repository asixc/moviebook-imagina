package com.moviebook.service.impl;

import com.moviebook.domain.Role;
import com.moviebook.entities.User;
import com.moviebook.repository.UserRepository;
import com.moviebook.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Log log = LogFactory.getLog(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(String id) {
        log.info("UserService FindById:" + id);
        return this.userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        user.setActivated(false);
        user.setRol(Role.USER);
        return this.userRepository.save(user);
    }

    @Override
    public User update(String userId, User user) {
        var lastUser = this.userRepository.getById(userId);
        user.setEmail(userId);
        user.setRegistrationInformation(lastUser.getRegistration());
        return this.userRepository.save(user);
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return this.userRepository.saveAll(users);
    }

    @Override
    public void deleteById(String id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        var users= this.userRepository.findAll();
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
