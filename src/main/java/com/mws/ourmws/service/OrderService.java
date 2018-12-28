package com.mws.ourmws.service;

import com.mws.ourmws.DAO.InventoryMapper;
import com.mws.ourmws.DAO.OrdersMapper;
import com.mws.ourmws.model.OrdersAnalysis;
import com.mws.ourmws.model.SalesOfSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private InventoryMapper inventoryMapper;

    /**
     * 分析每月销售情况
     * @param month
     * @return
     */
    @Cacheable(cacheNames = "thisMonthAnalysis")
    public List<OrdersAnalysis> thisMonthAnalysis(String month,String accountName){
        if(month.length()==1){
            month="0"+month;
        }
            return ordersMapper.thisMonthAnalysis(accountName,month);
    }

    /**
     * 查询最近30天的销售情况
     * @return
     */
    @Cacheable(cacheNames = "perSalesMsg")
    public List<OrdersAnalysis> perSalesMsg(String accountName){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String startTime="";
        String endTime=format.format(date)+"T00:00:00Z";
        Calendar calc =Calendar.getInstance();
        try {
            calc.setTime(format.parse(endTime));
            calc.add(calc.DATE, -30);
            Date minDate = calc.getTime();
            startTime = format.format(minDate);
            startTime=startTime+"T00:00:00Z";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ordersMapper.perSalesMsg(accountName,startTime,endTime);
    }
    /**
     * 查询最近30天每个尺寸售出的数量占比
     * @return
     */
    @Cacheable(cacheNames = "perSalesShare")
    public List<OrdersAnalysis> perSalesShare(String accountName){
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String startTime="";
        String endTime=format.format(date)+"T00:00:00Z";
        Calendar calc =Calendar.getInstance();
        try {
            calc.setTime(format.parse(endTime));
            calc.add(calc.DATE, -30);
            Date minDate = calc.getTime();
            startTime = format.format(minDate);
            startTime=startTime+"T00:00:00Z";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> inchList=new ArrayList<>();
        inchList.add("132");
        inchList.add("126");
        inchList.add("102");
        inchList.add("54");
        inchList.add("70");
        inchList.add("108");
        inchList.add("17");
        List<OrdersAnalysis> list=new ArrayList<>();
        for(String s:inchList) {
            OrdersAnalysis analysis = ordersMapper.perSalesShare(accountName,startTime, endTime, s);
            analysis.setInch(s+"inch");
            list.add(analysis);
        }
        return list;
    }

    @Cacheable(cacheNames = "salesOfSku")
    public List<SalesOfSku> SalesOfSKU(String shopName){
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
        List<SalesOfSku> list=ordersMapper.selectGoodsMsg(shopName);
        for(SalesOfSku s:list) {
            String ASIN = s.getASIN();
            SalesOfSku salesOfSku1 = ordersMapper.SalesOfSKU(shopName, ASIN, startTime1, endTime);
            SalesOfSku salesOfSku2 = ordersMapper.SalesOfSKU(shopName, ASIN, startTime2, endTime);
            SalesOfSku salesOfSku3 = ordersMapper.SalesOfSKU(shopName, ASIN, startTime3, endTime);
            SalesOfSku salesOfSku4 = ordersMapper.SalesOfSKU(shopName, ASIN, startTime4, endTime);
            SalesOfSku salesOfSku5 = inventoryMapper.selectInventoryNum(ASIN);
            s.setMonthNum(salesOfSku1.getNum());
            s.setSeasonNum(salesOfSku2.getNum());
            s.setHalfYearNum(salesOfSku3.getNum());
            s.setYearNum(salesOfSku4.getNum());
            s.setInventoryNum(salesOfSku5.getInventoryNum());
        }
        return list;
    }

    @Cacheable(cacheNames = "salesOfSize")
    public List<SalesOfSku> SalesOfSize(String shopName){
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
        List<SalesOfSku> list=new ArrayList<>();
        for (String s:size){
            SalesOfSku sku=new SalesOfSku();
            sku.setSize(s);
            sku.setMonthNum(ordersMapper.SalesOfSize(shopName,s,startTime1,endTime));
            sku.setSeasonNum(ordersMapper.SalesOfSize(shopName,s,startTime2,endTime));
            sku.setHalfYearNum(ordersMapper.SalesOfSize(shopName,s,startTime3,endTime));
            sku.setYearNum(ordersMapper.SalesOfSize(shopName,s,startTime4,endTime));
            list.add(sku);
        }
        return list;
    }

    @Cacheable(cacheNames = "salesOfColor")
    public List<SalesOfSku> SalesOfColor(String shopName){
        String[] color=new String[]{"Apple Green","Baby Blue", "Beige", "Black", "Caribbean", "Chocolate", "Coral", "Dark Gray", "Fuchsia", "Green",
                "Hunter Green", "ivory", "Lavender", "Nave Blue", "Pink", "Purple", "Red","Royal Blue","Silver","Turquoise","White","Wine", "Yellow"};
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
        List<SalesOfSku> list=new ArrayList<>();
        for (String s:color){
           SalesOfSku sku=new SalesOfSku();
            sku.setColor(s);
            sku.setMonthNum(ordersMapper.SalesOfColor(shopName,s,startTime1,endTime));
            sku.setSeasonNum(ordersMapper.SalesOfColor(shopName,s,startTime2,endTime));
            sku.setHalfYearNum(ordersMapper.SalesOfColor(shopName,s,startTime3,endTime));
            sku.setYearNum(ordersMapper.SalesOfColor(shopName,s,startTime4,endTime));
            list.add(sku);
        }
        return list;
    }

}
