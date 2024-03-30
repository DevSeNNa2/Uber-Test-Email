package com.devSenna.email.services.Aplication;

import com.devSenna.email.services.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase{

    private final EmailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway){
        this.EmailSenderGateway = emailGateway;
    }
    @Override
    public void sendEmail(String to, String subject, String body) {
    this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
