package com.spring.cocomarket.controllers;

import com.spring.cocomarket.interfaces.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    ChatService chatService;




}
