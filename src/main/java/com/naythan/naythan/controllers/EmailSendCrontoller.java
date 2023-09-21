package com.naythan.naythan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.Response;
import com.naythan.naythan.aplication.EmailSendServece;
import com.naythan.naythan.core.EmailRequest;
import com.naythan.naythan.core.exceptions.EmailServiceException;

@RestController
@RequestMapping
public class EmailSendCrontoller {

    public final EmailSendServece emailSendServece;

    @Autowired
    public EmailSendCrontoller(EmailSendServece emailServece) {
        this.emailSendServece = emailServece;
    }

    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            this.emailSendServece.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("email send successfully");
        } catch (EmailServiceException ex) {
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR).body("Erro while sending email"));
        }
    }

}
