package com.mws.ourmws.util;


import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateToXml {
	/**
	 * 将普通时间格式转化为MWS系统认可的格式为 ISO 8601 的日期（）
	 * @param DateTime:日期（格式为yyyy-MM-dd)
	 * @return XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar xmlToDate(String DateTime){
			int year=Integer.parseInt(DateTime.split("-")[0]);
			int month=Integer.parseInt(DateTime.split("-")[1]);
			int day=Integer.parseInt(DateTime.split("-")[2]);
	    	GregorianCalendar cal = new GregorianCalendar();
	    	Calendar calendar=Calendar.getInstance();
	    	calendar.set(year,month,day); 
	    	Date date=calendar.getTime();
	    	cal.setTime(date);  
	        XMLGregorianCalendar gc = null;  
	        try {
	            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);  
	        } catch (Exception e) {  
	             e.printStackTrace();  
	        }  
	    return gc;  
	}

    public static void main(String[] args) {
		String str="";
    }
}
