package com.example.ChatApp.services;

import com.example.ChatApp.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User saveUser(User user);
    void deleteUser(Long userId);
    User updateUser(Long userId,User user);
}
