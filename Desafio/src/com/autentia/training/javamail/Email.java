package com.autentia.training.javamail;

import java.util.Properties;
import java.security.InvalidParameterException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Date;
import javax.mail.internet.AddressException;


public class Email {
	static final String FROM="remitente@correo.es";
	static final String FROMNAME="NombreEmitente";
	static final String TO="destino@correo.es";
	static final String SMTP_USERNAME ="servidor@correo.es";
	static final String SMTP_PASSWORD="contraseña correo";
	static final String CONFIGSET="ConfingSet";
	static final String HOST="servidot@correo.es";
	static final int PORT = 587;
	static final String SUBJECT="envio de correo desde java";
	static final String BODY= String.join(System.getProperty("line.separator"),
			"prueba de envio de correo de javamail", "<h1>Hola amig@</h1>",
			"Este correo a sido enviado con tecnologia JaVA");
	
	public static void main(String[] args) throws Exception {
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", "PORT");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props); 
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(FROM, FROMNAME));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
		msg.setSubject(SUBJECT);
		msg.setContent(BODY, "text/html");
		msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
		Transport transport =session.getTransport();
		
		
		try {
			System.out.println("Enviando mensaje...");
			transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Mensaje Enviado!!!");

		}
		
		catch (Exception ex) {
			System.out.println("El correo no se a podido enviar");
			System.out.println("Error: " + ex.getMessage());

		}
		
		finally {
		     transport.close();
		}
		
		


		

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*private final Properties properties = new Properties();
	
	private String password;
 
	private Session session;
	
	
	private void init() {
		 
		properties.put("mail.smtp.host", "mail.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port",25);
		properties.put("mail.smtp.mail.sender","emisor@gmail.com");
		properties.put("mail.smtp.user", "usuario");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
	}
	
	
	public void sendEmail(){
		 
		init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("receptor@gmail.com"));
			message.setSubject("Prueba");
			message.setText("Texto");
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), "password");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
                        //Aqui se deberia o mostrar un mensaje de error o en lugar
                        //de no hacer nada con la excepcion, lanzarla para que el modulo
                        //superior la capture y avise al usuario con un popup, por ejemplo.
			return;
		}
		
	}
	
	
	
*/
}
