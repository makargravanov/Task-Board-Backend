package com.example.taskboardbackend.Core.Domain.EmailUtility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Service
public class IsValidEmailUseCase {
    @Value("spring.mail.username")
    private String notifyEmail;
    public boolean execute(String email){
        try {
            new InternetAddress(email).validate();
            return !email.equalsIgnoreCase(notifyEmail);
        } catch (AddressException e) {
            return false;
        }
    }
}
