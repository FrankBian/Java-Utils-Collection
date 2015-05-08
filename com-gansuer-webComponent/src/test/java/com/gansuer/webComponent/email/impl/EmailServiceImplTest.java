package com.gansuer.webComponent.email.impl;

import com.gansuer.webComponent.email.EmailService;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

/**
 * Created by Frank on 5/8/15.
 */
public class EmailServiceImplTest {

    private GreenMail greenMail;  //使用greenMail作为测试邮件服务器

    @Before
    public void setUp() throws Exception {
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("test@ganuser.com","123456");
        greenMail.start();
    }

    @Test
    public void testSendEmail() throws Exception {
        ApplicationContext ctx  = new ClassPathXmlApplicationContext("test-email.xml");

        EmailService emailService = (EmailService) ctx.getBean("emailService");
        String subject = "test";
        String htmlContent = "<h1>TEST</h1>";
        emailService.sendEmail("test@gansuer.com",subject,htmlContent);

        greenMail.waitForIncomingEmail(2000, 1);
        Message[] msgs = greenMail.getReceivedMessages();

        Assert.assertEquals(1,msgs.length);
        Assert.assertEquals(subject,msgs[0].getSubject());
        Assert.assertEquals(htmlContent, GreenMailUtil.getBody(msgs[0]).trim());


    }

    @After
    public void tearDown() throws Exception {
        greenMail.stop();
    }
}