package com.spring.cocomarket.controllers;

import com.spring.cocomarket.entities.Mail;
import com.spring.cocomarket.interfaces.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private IMailService mailService;

    @PostMapping("/send")
    public void sendMail(@RequestParam("from") String from, @RequestBody Mail mail) {
        mail.setFrom(from);
        mailService.sendMail(mail);
    }

    @GetMapping("/receive")
    public void receiveMail() {
        mailService.receiveMail();
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('MODERATOR')")
    public String helloFunction(){
        return "hello world";
    }
}
