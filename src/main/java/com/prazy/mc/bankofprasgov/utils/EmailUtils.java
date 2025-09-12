package com.prazy.mc.bankofprasgov.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
public class EmailUtils {
	
     Logger logger = LoggerFactory.getLogger(EmailUtils.class);
	
	 String FROM = "govindarajuprasath@gmail.com";
     String FROMNAME = "Prasath, Loans Department";
     String TO = "itsmeprazy@gmail.com";
     String SMTP_USERNAME = StringUtils.getSESaKey();
     String SMTP_PASSWORD = StringUtils.getSESsKey();
     String HOST = "email-smtp.us-east-2.amazonaws.com";
     int PORT = 587;
     String SUBJECT = "Loan Applied Successfully in Bank of Prazy!";
     String BODY =  "<h1>Bank of Prazy</h1>" +
             "<p> Your Loan is approved! "
             + "Enjoy seamless banking experience with us! Thank you! </p> ";
     
     public void sendLoanAppliedEmail(String toEmailAddress) {
    	 
    	 Properties props = System.getProperties();
    	  props.put("mail.transport.protocol", "smtp");
    	  props.put("mail.smtp.port", PORT);
    	  props.put("mail.smtp.starttls.enable", "true");
    	  props.put("mail.smtp.auth", "true");
    	  
    	  Transport transport = null;
        try {
        	Session session = Session.getDefaultInstance(props);
        	
        	MimeMessage msg = new MimeMessage(session);
        	
			msg.setFrom(new InternetAddress(FROM,FROMNAME));
	        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmailAddress));
	        msg.setSubject(SUBJECT);
	        msg.setContent(BODY,"text/html");
	        
	        transport = session.getTransport();
	        
	        transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);

	        transport.sendMessage(msg, msg.getAllRecipients());
		
		} catch (UnsupportedEncodingException e) {
			logger.debug("UnsupportedEncodingException while sending email! "+e.getMessage());
		} catch (MessagingException e) {
			logger.debug("MessagingException while sending email! "+e.getMessage());
		} finally {
				try {
					if(transport!=null)
						transport.close();
				} catch (MessagingException e) {
					logger.debug("MessagingException while closing Transport! "+e.getMessage());
				}
		}
        
     }

}
