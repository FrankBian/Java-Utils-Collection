package com.gansuer.webComponent.email.impl;

import com.gansuer.webComponent.email.EmailException;
import com.gansuer.webComponent.email.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Frank on 5/8/15.
 */
public class EmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    /**
     * system email account
     */
    private String systemEmail;

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }

    /**
     * send email
     *
     * @param to          receiver email account
     * @param subject     mail subject
     * @param htmlContent mail content(html format)
     * @return true if mail sent successfully
     */
    @Override
    public boolean sendEmail(String to, String subject, String htmlContent) throws EmailException {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper(mimeMessage);

            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            msgHelper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new EmailException("Fail to send email", e);
        }

        return true;
    }

}
