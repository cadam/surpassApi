package com.surpass.serviceImplementations;

import com.surpass.exceptions.ItemAlreadyExistsException;
import com.surpass.exceptions.ResourceNotFoundException;
import com.surpass.repositories.UserRepository;
import com.surpass.services.UserService;
import com.surpass.entities.User;
import com.surpass.entities.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

//    gets

    @Override
    public Page<User> getAllUsers(Pageable page) {

        return userRepo.findAll(page);

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

        throw new ResourceNotFoundException("User is not found for the id " + id);

    }

//    delete

    @Override
    public void deleteUserById(Long id) {

        User user = getUserById(id);

        userRepo.delete(user);

    }

//    posts
    @Override
    public User createUser(UserModel user) {

        if(userRepo.existsByEmail(user.getEmail())) {
            throw new ItemAlreadyExistsException("User is already register with email " + user.getEmail());
        }

        User newUser = new User();

        BeanUtils.copyProperties(user, newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));

        return userRepo.save(newUser);

    }

//    updates

    @Override
    public User updateUser(Long id, User user) {

        User existingUser = getUserById(id);

        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ?
                bcryptEncoder.encode(user.getPassword()) : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());

        return userRepo.save(existingUser);
    }
}
