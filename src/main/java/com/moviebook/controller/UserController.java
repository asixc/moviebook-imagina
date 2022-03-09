package com.moviebook.controller;

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
    public List<User> getUsers(){
        return this.userService.findAll();
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User newUser){
       return  newUser.getEmail().isBlank() || this.userService.existsById(newUser.getEmail())?
               ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)
               : ResponseEntity.ok(this.userService.save(newUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User userUpdate){
        return this.userService.existsById(id) ?
                ResponseEntity.ok(this.userService.update(id, userUpdate))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable String id) {
        if (!this.userService.existsById(id))
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
