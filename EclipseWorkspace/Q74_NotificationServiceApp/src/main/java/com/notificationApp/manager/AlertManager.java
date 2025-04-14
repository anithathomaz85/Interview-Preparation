package com.notificationApp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.notificationApp.service.NotificationService;

import jakarta.annotation.PostConstruct;

/**
 * Manager class to handle alerts via different services.
 */
@Component
public class AlertManager {

    // Injecting 'emailService' bean
    @Autowired
    @Qualifier("emailService")
    private NotificationService emailService;

    // Injecting 'smsService' bean
    @Autowired
    @Qualifier("smsService")
    private NotificationService smsService;

    // @PostConstruct ensures the init() method runs automatically 
    // after the bean is fully constructed, triggering both services to send a welcome message.
    @PostConstruct
    public void init() {
        emailService.send("Welcome via Email!");
        smsService.send("Welcome via SMS!");
    }
}