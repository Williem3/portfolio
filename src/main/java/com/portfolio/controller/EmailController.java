package com.portfolio.controller;

import com.portfolio.Service.EmailService;
import com.portfolio.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/contact")
public class EmailController {

    @Autowired
    public EmailService emailService;

    protected Optional<String> getPreviousPageByRequest(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl);
    }

    @PostMapping("/send")
    public String sendContact(@ModelAttribute("email")Email email, HttpServletRequest request) throws IOException, MessagingException {

        // Create string to capture the current request header to return for page mapping

        // call email service method sendSimpleMessage and pass Email object values
        emailService.sendSimpleMessage(
                email.getFrom(),
                email.getName(),
                email.getContent());

        System.out.println(email.getContent() + email.getFrom() + email.getName());

        // return to the homepage... need to figure out how to return to current page and not just homepage
        return getPreviousPageByRequest(request).orElse("/home");
    }
}
