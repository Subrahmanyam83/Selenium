package com.tbb.framework;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * This class provides functionality to create a rar file having all results
 * files and provides function to send an email having attached results to
 * required recipients.
 * 
 * @author Xebia
 * 
 */
public class MailHelper {
	
	public static void main(String args[]) 
	{
		createResultsRarFile();
		sendMail();
		
	}
/**
 * This method sends inline index.html and results.rar having all results/log files to required recipients.
 */
	public static void sendMail() {
		try {
		/*	String host = "smtp.gmail.com";
			String from = "xebia.automation@gmail.com";
			String pass = "makeover@xebia";*/
			
			String host = "owa.exchange-login.net";
			String from = "gbansal@xebia.com";
			String pass = "Kadio@1981";
			
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true"); 
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			
			//String[] to = { "gbansal@xebia.com" };
			//String[] to = { "jgupta@xebia.com" }; 
			String[] to = { "SJain@BEACHBODY.COM" };

			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for (int i = 0; i < to.length; i++) { 
				toAddress[i] = new InternetAddress(to[i]);
			}
			System.out.println("Sending result file to SJain@BEACHBODY.COM........");

			for (int i = 0; i < toAddress.length; i++) { 
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
			message.setSubject("Xebia Automation Framework Results");
			message.setText("Please find attached logs.");

			MimeBodyPart body = new MimeBodyPart();
			body.setText("Please find attached TestNG logs.");
			// do attachment
			MimeBodyPart attachMent = new MimeBodyPart();
			FileDataSource dataSource = new FileDataSource(new File(
					"C:\\workspace\\autoFramework\\consolidated_results.rar"));
			attachMent.setDataHandler(new DataHandler(dataSource));
			attachMent.setFileName("consolidated_results.rar");
			//attachMent.setDisposition(MimeBodyPart.ATTACHMENT);
			attachMent.setDisposition(MimeBodyPart.INLINE);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(body);
			multipart.addBodyPart(attachMent);
			message.setContent(multipart);

			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {

		}

	}


	/**
	 * This method creates rar file for test-output directory and then move that file to particular sub-directory under Results directory.
	 */
	public static void createResultsRarFile() {
		try {
			//System.out.println("MOVE /Y C:\\workspace\\autoFramework\\target\\surefire-reports\\html C:\\workspace\\autoFramework\\results");
			//Runtime.getRuntime().exec("MOVE //Y C:\\workspace\\autoFramework\\target\\surefire-reports\\html C:\\workspace\\autoFramework\\results");
			Runtime.getRuntime().exec("rar a consolidated_results.rar C:\\workspace\\autoFramework\\target\\surefire-reports\\html");
		} catch (Exception e) {
			// TODO: Other error handling
			e.printStackTrace();
		}
	}
}
