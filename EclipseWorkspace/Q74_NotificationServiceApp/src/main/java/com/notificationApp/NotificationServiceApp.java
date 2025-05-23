package com.notificationApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 * */

/**
 * Spring Boot application starts * 
 * AppConfig creates two NotificationService beans: * 
 * 			emailService
 * 			smsService
 * AlertManager is created and its fields are injected:
 * 		 emailService bean injected by name
 *  	 smsService bean injected by name
 * @PostConstruct runs
 *      Console prints: * 
 *      	[Email] Welcome via Email! 
 *      	[SMS] Welcome via SMS!
 */
@SpringBootApplication
public class NotificationServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApp.class, args);
	}
}
