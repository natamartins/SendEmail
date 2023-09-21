package com.naythan.naythan.adapters;

public interface EmailSendGateway {
    void sendEmail(String to, String subject, String body);
}
