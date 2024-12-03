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

}
