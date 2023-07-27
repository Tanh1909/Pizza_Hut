package com.example.projectbase.email;

import java.util.concurrent.CompletableFuture;

public interface MailSender {
    CompletableFuture<String> sendMail(String to, String email);
}
