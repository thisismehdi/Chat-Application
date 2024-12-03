package com.example.ChatApp.controllers;

import com.example.ChatApp.entities.User;
import com.example.ChatApp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private UserService userService;

    @GetMapping("/Users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/Users/{userId}")
    public User getUserById(@RequestParam Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/User")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/User/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/User/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user){
        return userService.updateUser(userId,user);
    }


}
