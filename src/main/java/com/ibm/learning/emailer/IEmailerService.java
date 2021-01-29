package com.ibm.learning.emailer;

import javax.mail.MessagingException;

public interface IEmailerService {
	 void sendEmail(String emailID,String subject,String mailContent) throws MessagingException;
}
