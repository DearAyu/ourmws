package com.mws.ourmws.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@Controller
public class PageController {

    @RequestMapping("/Home")
    public String Home(){
        return "page/Home";
    }

    @RequestMapping("/StockReference")
    public String StockReference(){
        return "page/StockReference";
    }

}
