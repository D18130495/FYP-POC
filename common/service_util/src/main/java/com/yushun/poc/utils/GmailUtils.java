package com.yushun.poc.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GmailUtils {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("990415zys@gmail.com");
        msg.setTo("d18130495@mytudublin.ie");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
    }
}