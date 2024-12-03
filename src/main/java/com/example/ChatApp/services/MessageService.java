package com.example.ChatApp.services;

import com.example.ChatApp.entities.Message;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessages();
    Message getMessageById(Long messageId);
    Message saveMessage(Message message);
    void deleteMessage(Long messageId);
    Message updateMesssage(Long messageId,Message message);
}
