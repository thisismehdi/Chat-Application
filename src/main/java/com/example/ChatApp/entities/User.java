package com.example.ChatApp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity @Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    @OneToMany
    private List<Message> sentMessages;
    @OneToMany
    private List<Message> receivedMessages;


   public User(User user){
       this.setEmail(user.getEmail());
       this.setPassword(user.getPassword());
       this.setUsername(user.getUsername());
       this.setSentMessages(user.getSentMessages());
       this.setReceivedMessages(user.getReceivedMessages());
   }

}
