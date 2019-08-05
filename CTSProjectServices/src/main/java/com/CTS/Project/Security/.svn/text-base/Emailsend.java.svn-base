package com.CTS.Project.Security;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Emailsend {

	@Autowired
	public JavaMailSender emailSender;

	public Boolean sendSimpleMessage(String to, String cc, String bcc, String subject, String text) {
		try {
			MimeMessage mimeMessage = emailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setTo(to.split(","));
			if (cc!=null && !cc.equals("") && !cc.equals("null") && !cc.equals("undefined")) {
				mimeMessageHelper.setCc(cc.split(","));
			}
			if (bcc!=null && !bcc.equals("") && !bcc.equals("null") && !bcc.equals("undefined")) {
				mimeMessageHelper.setBcc(bcc.split(","));
			}
			mimeMessageHelper.setText(text);
			emailSender.send(mimeMessage);
			return true;
		} catch (Exception e) {
			System.err.println("Error in Email sending :" + e);
			return false;
		}
	}

	public Boolean sendMailWithAttachment(String to, String cc, String bcc, String subject, String text,
			MultipartFile file) {
		try {
			MimeMessage mimeMessage = emailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(subject);
			// mimeMessageHelper.setFrom(email.getFrom());
			mimeMessageHelper.setTo(to.split(","));
			if (cc!=null && !cc.equals("") && !cc.equals("null") && !cc.equals("undefined")) {
				mimeMessageHelper.setCc(cc.split(","));
			}
			if (bcc!=null && !bcc.equals("") && !bcc.equals("null") && !bcc.equals("undefined")) {
				mimeMessageHelper.setBcc(bcc.split(","));
			}
//			if (file!=null && !file.equals("") && !file.equals("null") && !file.equals("undefined")) {
//				//FileSystemResource file = new FileSystemResource(new File(filePath));
//				
//			}
			mimeMessageHelper.addAttachment(file.getOriginalFilename(), file);
			mimeMessageHelper.setText(text);
			emailSender.send(mimeMessage);
			
			return true;
		} catch (Exception e) {
			System.err.println("Error in Email sending :" + e);
			return false;
		}
	}

}
