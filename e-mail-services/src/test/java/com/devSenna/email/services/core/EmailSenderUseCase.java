package com.devSenna.email.services.core;

public interface EmailSenderUseCase {
    void sendEmail(String to, String subject, String body);
}
