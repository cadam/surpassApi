package com.surpass.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Page<User> getAllUsers(Pageable page);

    User getUserById(Long id);

    void deleteUserById(Long id);

    long getUsersCount();

    User addUser(User user);

    User updateUser(Long id, User user);

}
