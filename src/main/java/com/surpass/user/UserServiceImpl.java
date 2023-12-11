package com.surpass.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

//    gets

    @Override
    public List<User> getAllUsers() {

        return userRepo.findAll();

    }

    @Override
    public long getUsersCount() {

        return userRepo.count();

    }

    @Override
    public User getUserById(Long id) {

        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            return user.get();
        }

        throw new RuntimeException("User is not found for the id " + id);

    }

//    delete

    @Override
    public void deleteUserById(Long id) {

        userRepo.deleteById(id);

    }

//    posts
    @Override
    public User addUser(User user) {

        return userRepo.save(user);

    }

//    updates

    @Override
    public User updateUser(Long id, User user) {

        User existingUser = getUserById(id);

        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());

        return userRepo.save(existingUser);
    }
}
