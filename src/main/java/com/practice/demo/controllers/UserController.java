package com.practice.demo.controllers;

import com.practice.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.practice.demo.services.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return this.userService.findById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.updateUser(user), HttpStatus.OK);
    }

}
