package com.springBoot.journalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Disabled
    @Test
    void testSendEmail()
    {
        emailService.sendEmail("tejasneswi2709@gmail.com", "Testing java mail sender", "Hello, How are you all ?");
    }
}
