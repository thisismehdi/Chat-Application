package com.example.ChatApp.controllers;

import com.example.ChatApp.entities.Message;
import com.example.ChatApp.services.MessageService;
import com.example.ChatApp.services.MessageServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {
    private MessageService messageService;

    @GetMapping("/Messages")
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("/Messages/{MessageId}")
    public Message getMessageById(@RequestParam Long messageId){
        return messageService.getMessageById(messageId);
    }

    @PostMapping("/Message")
    public Message saveMessage(@RequestBody Message message){
        return messageService.saveMessage(message);
    }

    @DeleteMapping("/Message/{messageId}")
    public void deleteMessage(@PathVariable Long messageId){
        messageService.deleteMessage(messageId);
    }

    @PutMapping("/Message/{messageId}")
    public Message updateMessage(@PathVariable Long messageId, @RequestBody Message message){
        return messageService.updateMesssage(messageId,message);
    }
}
