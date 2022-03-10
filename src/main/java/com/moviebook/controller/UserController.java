package com.moviebook.controller;

import com.moviebook.dto.UserDto;
import com.moviebook.entities.User;
import com.moviebook.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    private static final Log log = LogFactory.getLog(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDto> getUsers(){
        return this.userService.findAll();
    }

    @PostMapping()
    public ResponseEntity<UserDto> save(@RequestBody UserDto newUser){
        return this.userService.save(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable String id, @RequestBody UserDto userUpdate){
        return this.userService.update(id, userUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteById(@PathVariable String id) {
        return this.userService.deleteById(id);

    }

}
