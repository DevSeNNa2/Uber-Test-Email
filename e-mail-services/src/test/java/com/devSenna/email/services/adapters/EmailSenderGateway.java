package com.devSenna.email.services.adapters;

public interface EmailSenderGateway {
    void sendEmail(String to, String subject, String body);
}
