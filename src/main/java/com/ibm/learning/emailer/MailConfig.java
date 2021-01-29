package com.ibm.learning.emailer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

/*this class will be use to configure the beans of DummyEmailSender.java and SmtpemailSender.java
 * as we may dont have source of these class but we want to use them as Spring bean.
 */
@Configuration
public class MailConfig {
	//IEmailerService emailService = new DummyEmailSender();
	
	@Bean
	@ConditionalOnProperty(name="smtp.mail.host",havingValue="foo",matchIfMissing=true)
	public IEmailerService dummyEmailSender() {
		return new DummyEmailSender();
	}

	@Bean
	@ConditionalOnProperty("smtp.mail.host")
	public IEmailerService smtpEmailSender(JavaMailSender javaMailSender) {
		return new SmtpEmailSender(javaMailSender);
	}
}
