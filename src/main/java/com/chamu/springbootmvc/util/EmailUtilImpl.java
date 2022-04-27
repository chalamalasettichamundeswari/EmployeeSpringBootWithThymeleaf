package com.chamu.springbootmvc.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil {

	private String SUBJECT="Employee Registration Details";
	private String BODY="please find your Registration Details Attachement" ;
	@Autowired
	private JavaMailSender sender;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtilImpl.class);
	
	@Override
	public void sendEmail(String toAddress,String filePath) {
		MimeMessage message = sender.createMimeMessage();
	    try {
	    	MimeMessageHelper helper = new MimeMessageHelper(message,true);//true means want to send an attachment.optional parameter.By default false.
			helper.setTo(toAddress);
			helper.setSubject(SUBJECT);
			helper.setText(BODY);
			helper.addAttachment("Employee",new File(filePath));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Exception inside Email"+e);
		}
		sender.send(message);
	}

}
