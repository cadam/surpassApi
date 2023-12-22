package com.surpass.controllers;

import com.surpass.exceptions.ResourceNotFoundException;
import com.surpass.entities.User;
import com.surpass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(Pageable page) {
        return userService.getAllUsers(page).toList();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/users/count")
    public long getUsersCount() {
        return userService.getUsersCount();
    }

//    delete user by id
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) throws ResourceNotFoundException {

        userService.deleteUserById(id);

        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

    }

//    put user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,
                           @PathVariable Long id) {

        return new ResponseEntity<User>(userService.updateUser(id, user), HttpStatus.OK);

    }
}
