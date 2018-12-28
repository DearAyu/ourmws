package com.mws.ourmws.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {
    public static void main(String[] args) {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        String sendTime=format.format(date);
        System.out.println(sendTime);
    }
}
