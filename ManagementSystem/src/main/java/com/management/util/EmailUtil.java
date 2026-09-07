package com.management.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	public static void sendEmail() {

			// Setup SMTP Server Properties
			Properties prop = new Properties();

			try {
				FileInputStream fis = new FileInputStream("E:\\application_secret\\email_secrets.properties");
				prop.load(fis);
			}catch(IOException e) {
				e.printStackTrace();
				return;
			}
			
			final String username = prop.getProperty("mail.username");
			final String password = prop.getProperty("mail.password");

			// Create Session
			Session session = Session.getInstance(prop, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			try {
				// Compose Message
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("narayandeep020@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("singraul20codeblog@gmail.com,devendra20790@outlook.com,satyamlodhi137@gmail.com"));

				message.setSubject("Testing Java Email API");
				message.setText("Hello! This is a test email sent from a java program calling by listener.");

				// Send Email
				Transport.send(message);
				System.out.println("Email sent successfully!");

			} catch (MessagingException e) {
				e.printStackTrace();
			}

		}
		
	}

