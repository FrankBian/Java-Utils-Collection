package com.gansuer.web.email;

public interface EmailService {

    /**
     * 发送邮件
     *
     * @param to          收件人
     * @param subject     主题
     * @param htmlContent html格式的邮件内容
     * @return true if mail sent successfully
     */
    boolean sendEmail(String to, String subject, String htmlContent) throws EmailException;

}