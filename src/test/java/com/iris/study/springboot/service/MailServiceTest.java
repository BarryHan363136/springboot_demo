package com.iris.study.springboot.service;

import com.iris.study.springboot.base.BaseTest;
import com.iris.study.springboot.service.mail.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MailServiceTest extends BaseTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendHtmlEmail(){
        mailService.sendHtmlMail("363136830@qq.com", "test send email", "HTB TEST EMAIL WITH SPRING BOOT");
    }

}
