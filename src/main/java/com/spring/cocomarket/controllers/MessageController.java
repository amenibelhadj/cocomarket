package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.Message;
import com.spring.cocomarket.entities.ReadReceiptRequest;
import com.spring.cocomarket.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    /*@GetMapping(value = "/messages/{channelId}")
    public Page<Message> findMessages(Pageable pageable, @PathVariable("channelId") String channelId) {
        return messageRepository.findAllByChannel(channelId, pageable);
    }

    @PostMapping(value = "/messages")

    public void sendReadReceipt(@RequestBody ReadReceiptRequest request) {
        messageRepository.sendReadReceipt(request.getChannel(), request.getUsername());
    }*/
}
