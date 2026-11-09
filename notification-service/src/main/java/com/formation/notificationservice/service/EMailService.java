package com.formation.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EMailService {


    @Autowired
    private JavaMailSender mailSender;


    public void SendMail(String email, String object, String message){
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom("no-reply@preoder.com");
        mail.setTo(email);
        mail.setText(message);
        mail.setSubject(object);

        mailSender.send(mail);
    }
}
