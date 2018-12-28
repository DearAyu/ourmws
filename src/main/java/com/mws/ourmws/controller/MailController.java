package com.mws.ourmws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {

    @RequestMapping("test")
    public String Test(){
        return "test";
    }
}
