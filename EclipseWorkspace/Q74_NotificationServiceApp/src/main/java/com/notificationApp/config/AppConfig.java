package com.notificationApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.notificationApp.service.NotificationService;

/**
 * Application Configuration to define beans.
 * Both beans return new instances of NotificationService with different type
 */
@Configuration
public class AppConfig {

    @Bean(name = "emailService")
    public NotificationService emailService() {
        return new NotificationService("Email");
    }

    @Bean(name = "smsService")
    public NotificationService smsService() {
        return new NotificationService("SMS");
    }
}
