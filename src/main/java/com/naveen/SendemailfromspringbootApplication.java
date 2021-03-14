package com.naveen;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SendemailfromspringbootApplication {
	
	@Autowired
	private EmailService service;

	public static void main(String[] args) {
		SpringApplication.run(SendemailfromspringbootApplication.class, args);
	}
	
    @EventListener(ApplicationReadyEvent.class)
	public void triggerMail1()
	{
		service.sendSimpleEmail("anaveen431@gmail.com",
				"this is email body",
				"subject here springboot email service ");
	}
	
    @EventListener(ApplicationReadyEvent.class)
   	public void triggerMail2() throws MessagingException
   	{
   		service.sendEmailWithAttachment("anaveen431@gmail.com",
   				"this is email body with attachment",
   				"subject here springboot email service with attachmenment ","E:\\NaveenResume.pdf");
   	}
   	
	

}
