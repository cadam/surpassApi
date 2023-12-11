package com.surpass.user;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUserById(Long id);

    long getUsersCount();

    User addUser(User user);

    User updateUser(Long id, User user);

}
