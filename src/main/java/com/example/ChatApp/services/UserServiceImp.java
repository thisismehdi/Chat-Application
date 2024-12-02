package com.example.ChatApp.services;

import com.example.ChatApp.entities.User;
import com.example.ChatApp.repositories.UserRepository;

import java.util.List;

public class UserServiceImp implements UserService{
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        if(userRepository.existsById(userId))
            userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = getUserById(userId);
        if (updatedUser.getUsername() != null && !updatedUser.getUsername().isEmpty()) {
            existingUser.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getEmail() != null && !updatedUser.getEmail().isEmpty()) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existingUser.setPassword(updatedUser.getPassword());
        }
        return userRepository.save(existingUser);

    }
}
