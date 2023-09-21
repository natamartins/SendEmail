package com.naythan.naythan.core;

public interface EmailSendUserCase {
    void sendEmail(String to, String subject, String body);
}
