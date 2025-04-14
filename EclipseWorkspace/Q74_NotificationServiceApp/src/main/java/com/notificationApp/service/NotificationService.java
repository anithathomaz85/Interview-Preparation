package com.notificationApp.service;

/**
 * Notification service that sends messages via a specific channel.
 */
public class NotificationService {
    
    private String type;

    // Constructor injection for notification type (like Email, SMS)
    public NotificationService(String type) {
        this.type = type;
    }

    // Method to simulate sending a message
    public void send(String message) {
        System.out.println("[" + type + "] " + message);
    }
}
