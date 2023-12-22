package com.surpass.services;

import com.surpass.entities.User;
import com.surpass.entities.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> getAllUsers(Pageable page);

    User getUserById(Long id);

    void deleteUserById(Long id);

    long getUsersCount();

    User createUser(UserModel user);

    User updateUser(Long id, User user);

}
