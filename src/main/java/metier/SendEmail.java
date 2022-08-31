package metier;

import java.util.Properties;	
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public void SendMail(String email, String password, String subject, String commentaire) {
		String host = "smtp.gmail.com";
		
		String receiver = "amineyassir2001@gmail.com";
		
		Properties properties = System.getProperties();
		
		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.debug", "true");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		// Get the session Object // username and apssword
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email,password);
			}
		});
		
		//User to debug SMTP issues
		session.setDebug(true);
		try {
			// Create a default MimeMessage object
			MimeMessage message = new MimeMessage(session);
			
			// Set From: Header field of the header
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			
			//Set To: header field to of the header
			message.setFrom(email);
			
			//Set Subject: Header field
			message.setSubject(subject);
			
			//Now set the actual text
			message.setText(commentaire);
			
			System.out.println("sending...");
			//Send message
			Transport.send(message);
			System.out.println("Sent message successfully.....");
			
		}catch(MessagingException mex) {
			mex.printStackTrace();
		}
		
	} 

}
