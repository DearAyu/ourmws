package com.mws.ourmws;

import com.mws.ourmws.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OurmwsApplicationTests {
    @Autowired
    private EmailService emailService;

    @Test
    public void sendSimpleMail() throws Exception {
        emailService.addEmail();
    }

}
