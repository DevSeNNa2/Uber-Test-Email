package com.devSenna.email.services.infra.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.devSenna.email.services.adapters.EmailSenderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;

@Service
//@Service serve para o Spring entender e fazer as injeções de dependências depois
public class SesEmailSenders implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;
    @Autowired
    public SesEmailSenders(AmazonSimpleEmailService amazonSimpleEmailService){
        this..amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailResquest request = new SendemailRequest()
                .withSource("vinirlcha18@hotmail.com")
                .withDestination(new Destination().withToAdresses(to))
                .withMessage(new Message()
                        .withSubject(new Contact(subject))
                        .withBody(new Body ().withText(new Content(body)))
                );
        try {
            this.amazonSimpleEmailService.sendEmail(resquest);
        } catch (AmazonServiceException exception) {
        throw new EmailSenderException("Failure while sending email");
        }
    }
}
