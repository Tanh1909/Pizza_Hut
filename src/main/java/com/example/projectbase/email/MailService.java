package com.example.projectbase.email;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class MailService implements MailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${gmail}")
    private String gmail;

    @Async
    @Override
    public CompletableFuture<String> sendMail(String to, String email) {
        try {
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mailMessage, StandardCharsets.UTF_8.name());
            mimeMessageHelper.setText(email, true);
            mimeMessageHelper.setSubject("Notification !");
            mimeMessageHelper.setFrom(gmail);
            mimeMessageHelper.setTo(to);
            javaMailSender.send(mailMessage);
            return CompletableFuture.completedFuture("Sent mail SuccessFully !");
        } catch (MessagingException e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture("Sent mail Failed !");
        }
    }

}