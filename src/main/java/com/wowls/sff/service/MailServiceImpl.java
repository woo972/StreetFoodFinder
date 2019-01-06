package com.wowls.sff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl{

    private JavaMailSender emailSender;
    
    @Autowired
    public MailServiceImpl(JavaMailSender emailSender) {
    	this.emailSender = emailSender;
    }
 
    public void sendSimpleMessage(String to, String subject, String text, String from) 
    	throws MailException{
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        message.setFrom(from);
        emailSender.send(message);
    }

}
