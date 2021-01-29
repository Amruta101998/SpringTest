package com.ibm.learning.emailer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

//The objects gets created by using @Component are referred as Beans

public class SmtpEmailSender implements IEmailerService{
	// Initilize the logger
		private static Log log=LogFactory.getLog(SmtpEmailSender.class);
		private JavaMailSender javaMailSender;

	
		public SmtpEmailSender(JavaMailSender javaMailSender) {
			// TODO Auto-generated constructor stub
		
			this.javaMailSender = javaMailSender;
		}



	@Override
	public void sendEmail(String emailID, String subject, String mailContent) throws MessagingException {
		// TODO Auto-generated method stub
		log.info("SMTP Mail receiver ID :"+emailID);
		log.info("SMTP Mail Subject :"+subject);
		log.info("SMTP Mail Body :"+mailContent);
		log.warn("This is just SMTP email sender");
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(message, true); // true indicates
 					  				                   // multipart message
		helper.setSubject("This is first message that is sent");
		helper.setTo("hulaguramruta325@gmail.com");
		helper.setText("<h1> Body </h1>", true); // true indicates html

		// continue using helper for more functionalities
        // like adding attachments, etc.
		
		javaMailSender.send(message);                               
		
	}

}
