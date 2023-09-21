package com.naythan.naythan.aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naythan.naythan.adapters.EmailSendGateway;
import com.naythan.naythan.core.EmailSendUserCase;

@Service
public class EmailSendServece implements EmailSendUserCase {

    private final EmailSendGateway emailSendGateway;

    @Autowired
    public EmailSendServece(EmailSendGateway emailSendGateway) {
        this.emailSendGateway = emailSendGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSendGateway.sendEmail(to, subject, body);
    }

}
