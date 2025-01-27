package com.test.oraclejdbc;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public String generateOTP() {
		Random random = new Random();
		int otp = random.nextInt(9999); // Generates a 4-digit OTP
		return String.format("%04d", otp);
		// return String.valueOf(otp);
	}

	// Method to send OTP to the provided email
	public boolean sendEmail(User user) throws MessagingException {

		boolean test = false;

		
		String toEmail = user.getEmail();
		String formEmail = "0.outfithub@gmail.com"; // Your email address
		String password = "OUTfit0HUB@_";
		
		try {
			
			Properties properties = new Properties();
			properties.setProperty("mail.smtp.host", "smtp.mail.com");
			properties.setProperty("mail.smtp.port", "587");
			properties.setProperty("mail.smtp.auth", "true");
			properties.setProperty("mail.smtp.starttls.enable", "true"); // TLS security
			properties.put("mail.smtp.socketFactory.port", "587");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(formEmail, password);
				}
			});
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(formEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("Your OTP for Application");
			message.setText(" Verification Email "); 

			Transport.send(message);
			test = true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	
		return test;
	}
}
