package com.surpass.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users/count")
    public long getUsersCount() {
        return userService.getUsersCount();
    }

//    delete user by id
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

//    post user
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/users/add")
    public User addUser(@Valid @RequestBody User user) {

        return userService.addUser(user);

    }

//    put user
    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user,
                           @PathVariable Long id) {

        return userService.updateUser(id, user);

    }
}
