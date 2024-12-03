package com.example.ChatApp.services;

import com.example.ChatApp.entities.Message;
import com.example.ChatApp.repositories.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImp implements MessageService{
    private MessageRepository messageRepository;
    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessageById(Long messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }

    @Override
    public Message saveMessage(Message message) {
        Message savedMessage = messageRepository.save(message);
        return savedMessage;
    }

    @Override
    public void deleteMessage(Long messageId) {
        if(messageRepository.existsById(messageId))
            messageRepository.deleteById(messageId);
    }

    @Override
    public Message updateMesssage(Long messageId, Message updateMessage) {
        Message existingMessage = getMessageById(messageId);

        if(updateMessage.getMessage()!=null && !updateMessage.getMessage().isEmpty()){
            existingMessage.setMessage(updateMessage.getMessage());
        }

        return messageRepository.save(existingMessage);
    }
}
