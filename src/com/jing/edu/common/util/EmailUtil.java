package com.jing.edu.common.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class EmailUtil {
	public static final String USERNAME = "381367041";
	public static final String PASSWORD = "hycnepfpnybkbghf";// 授权码
	public static final String MAILHOST = "smtp.qq.com";
	public static final String MAILNAME = "381367041@qq.com";

	/**
	 * 
	 * @param email		email用户名
	 * @param title			标题
	 * @param content		内容
	 */
	public static void sendEmail(String email, String title, String content) {
		Properties properties = new Properties();
		properties.setProperty("mail.host", MAILHOST);
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");

		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);

		Session session = Session.getInstance(properties);
		session.setDebug(true);

		Transport transport = null;
		try {
			transport = session.getTransport();
			transport.connect(MAILHOST, USERNAME, PASSWORD);
			Message message = createMail(session, email, title, content);
			transport.sendMessage(message, message.getAllRecipients());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				transport.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

	public static MimeMessage createMail(Session session, String email, String title, String content) {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		try {
			// 指明邮件的发件人
			message.setFrom(new InternetAddress(MAILNAME));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=utf-8");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return message;

	}

	public static void main(String[] args) {
		EmailUtil.sendEmail("381367041@qq.com", "密码找回[在线家教网]","你好");
	}
}
