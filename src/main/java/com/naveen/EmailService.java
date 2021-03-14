package com.naveen;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendSimpleEmail(String toEmail, String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("your email");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		javaMailSender.send(message);
		System.out.println("mail send ...");

	}

	public void sendEmailWithAttachment(String toEmail, String body, String subject,String attachment) throws MessagingException
	{
		
		MimeMessage mime=javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(mime,true);
		
		helper.setFrom("your email");
		helper.setTo(toEmail);
		helper.setText(body);
		helper.setSubject(subject);
		
		FileSystemResource file=new FileSystemResource(new File(attachment));
		
		helper.addAttachment(file.getFilename(),file);
		
		
		javaMailSender.send(mime);
		System.out.println("mail send with attachment");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
