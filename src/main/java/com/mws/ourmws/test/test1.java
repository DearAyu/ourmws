package com.mws.ourmws.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test1 {
    public static void main(String[] args) {
        String[] size=new String[]{"17","54","70","102","108","126","132"};
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String endTime = format.format(date) + "T00:00:00Z";
        String startTime1 = "";
        String startTime2 = "";
        String startTime3 = "";
        String startTime4 = "";
        Calendar calc = Calendar.getInstance();
        try {
            calc.setTime(format.parse(endTime));
            calc.add(calc.DATE, -30);
            Date minDate1 = calc.getTime();
            startTime1 = format.format(minDate1);
            startTime1 = startTime1 + "T00:00:00Z";
            calc.add(calc.DATE, -60);
            Date minDate = calc.getTime();
            startTime2 = format.format(minDate);
            startTime2 = startTime2 + "T00:00:00Z";
            calc.add(calc.DATE, -90);
            Date minDate3 = calc.getTime();
            startTime3 = format.format(minDate3);
            startTime3 = startTime3 + "T00:00:00Z";
            calc.add(calc.DATE, -180);
            Date minDate4 = calc.getTime();
            startTime4 = format.format(minDate4);
            startTime4 = startTime4 + "T00:00:00Z";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(startTime1);
        System.out.println(startTime2);
        System.out.println(startTime3);
        System.out.println(startTime4);
    }
}
