package metier;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
	public static void sendMail(String recepient) throws Exception{
		
		System.out.println("Preparing to send message ");
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth",  "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host",  "smtp.gmail.com");
		properties.put("mail.smtp.port",  "587");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		String myAccountEmail = "anasatmani8@gmail.com";
		String password = "sqcxlkyxuctubszp";
		
		
Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail,password);
			}
		});

Message message = prepareMessage(session, myAccountEmail, recepient);

Transport.send(message);
System.out.println("Message sent successfully");

		
}
	
	public static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("myFirst Email from java App");
			message.setText("Hey There, \n Look my Email !");
			return message;
			
		}catch (Exception ex) {
			Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null , ex);
		}
		return null;
	}

}