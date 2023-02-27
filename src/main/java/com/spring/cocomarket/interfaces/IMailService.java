package com.spring.cocomarket.interfaces;

import com.spring.cocomarket.entities.Mail;

public interface IMailService {
    public void sendMail(Mail mail);
    public void receiveMail();
}
