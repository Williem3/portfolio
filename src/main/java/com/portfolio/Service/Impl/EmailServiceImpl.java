package com.portfolio.Service.Impl;

import com.portfolio.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    // autowire JavaMailSenderImpl for sendSimpleMessage to pass value message
    @Autowired
    public JavaMailSenderImpl emailSender;

    public void sendSimpleMessage(String from, String name, String content) {

        SimpleMailMessage message = new SimpleMailMessage();

        // set person contacting you as from
        message.setFrom(from);
        // set to as you, as you're the one receiving all these contacts
        message.setTo("dev.wmangram@gmail.com");
        // subject as the users name so you know who is emailing you
        message.setSubject(name);
        // set the Text to content and from so you can
        message.setText(content + "" + "         - " + from);

        emailSender.send(message);
    }
}
