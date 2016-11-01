package com.swapit.ws.service;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.swapit.ws.model.MessegesBuildModel;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication; 
public class SendMail {
	private String mailSMTPServer;
	private String mailSMTPServerPort;
	private String from = "swapit.contact@gmail.com";
	private String pass = "wJusRP6u3iHZw";
		
	public SendMail() {
		super();
		mailSMTPServer = "smtp.gmail.com";
		mailSMTPServerPort = "465";
	}
	
	SendMail(String mailSMTPServer, String mailSMTPServerPort) { //Para outro Servidor
		this.mailSMTPServer = mailSMTPServer;
		this.mailSMTPServerPort = mailSMTPServerPort;
	}
	@SuppressWarnings("static-access")
	public void sendMail(String to, String personID ) {
		MessegesBuildModel msgBuild = new MessegesBuildModel();
		String subject = msgBuild.ACTIVETITLE;
		String message = msgBuild.activeMessege(personID);
		Properties props = new Properties();
                // quem estiver utilizando um SERVIDOR PROXY descomente essa parte e atribua as propriedades do SERVIDOR PROXY utilizado
                /*
                props.setProperty("proxySet","true");
                props.setProperty("socksProxyHost","192.168.155.1"); // IP do Servidor Proxy
                props.setProperty("socksProxyPort","1080");  // Porta do servidor Proxy
                */
		props.put("mail.transport.protocol", "smtp"); 
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.host", mailSMTPServer); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.user", from); 
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", mailSMTPServerPort); 
		props.put("mail.smtp.socketFactory.port", mailSMTPServerPort); 
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		SimpleAuth auth = null;
		auth = new SimpleAuth ("swapit.contact@gmail.com", "wJusRP6u3iHZw");
		
		Session session = Session.getDefaultInstance(props, auth);
		session.setDebug(true); 
		Message msg = new MimeMessage(session);
		try {
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setFrom(new InternetAddress(from));
			msg.setSubject(subject);
			msg.setContent(message,"text/plain");
		} catch (Exception e) {
			System.out.println(">> Erro: Completar Mensagem");
			e.printStackTrace();
		}
		Transport tr;
		try {
			tr = session.getTransport("smtp"); 
			tr.connect(mailSMTPServer, from, pass);
			msg.saveChanges(); 
			tr.sendMessage(msg, msg.getAllRecipients());
			tr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(">> Erro: Envio Mensagem");
			e.printStackTrace();
		}
	}
}
class SimpleAuth extends Authenticator {
	public String username = null;
	public String password = null;
	public SimpleAuth(String user, String pwd) {
		username = user;
		password = pwd;
	}
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication (username,password);
	}
}