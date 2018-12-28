package com.mws.ourmws.controller;

import com.mws.ourmws.model.JsonMsg;
import com.mws.ourmws.model.LayuiJson;
import com.mws.ourmws.model.OrdersAnalysis;
import com.mws.ourmws.model.SalesOfSku;
import com.mws.ourmws.service.InventoryService;
import com.mws.ourmws.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
public class OrdersController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private InventoryService inventoryService;

    /**
     * 分析每月的销售情况
     * @param month
     * @return 成功返回相应的JSON数据，失败返回空JSON
     */
    @GetMapping("ordersAnalysis/month/{month}")
    public JsonMsg analysisMonth(@PathVariable(name = "month") String month,HttpSession session){
        String accountName= (String) session.getAttribute("accountName");
        int m=Integer.parseInt(month);
       if(m>0 && m<=12) {
           List<OrdersAnalysis> list = orderService.thisMonthAnalysis(month,accountName);
           return JsonMsg.success().add("analysis", list);
       }else{
           return JsonMsg.fail();
       }
    }

    /**
     * 查询最近30天每个尺寸售出的数量占比
     * @return
     */
    @GetMapping(value = "perSalesShare")
    public JsonMsg perSalesShare(HttpSession session){
        String accountName= (String) session.getAttribute("accountName");
        List<OrdersAnalysis> list=orderService.perSalesShare(accountName);
        return JsonMsg.success().add("share",list);
    }

    /**
     * 查询最近30天的销售情况
     * @return
     */
    @GetMapping(value="perSalesMsg")
    public JsonMsg perSalesMsg(HttpSession session){
        String accountName= (String) session.getAttribute("accountName");
        List<OrdersAnalysis> list=orderService.perSalesMsg(accountName);
        return JsonMsg.success().add("analysis",list);
    }

    /**
     * 查询库存信息，并分页
     * @param session
     * @param page
     * @param limit
     * @return
     */
    @GetMapping(value="inventory")
    public LayuiJson Inventory(HttpSession session,int page,int limit){
        String accountName= (String) session.getAttribute("accountName");
        List<SalesOfSku> list=inventoryService.findInventoryMsg(accountName);
        List<SalesOfSku> pageList;
        int start,end;
        start=(page-1)*limit;
        if((page*limit)>list.size()) {
            end=list.size();
        }else{
            end = page * limit;
        }
        pageList=list.subList(start,end);
        return LayuiJson.success(list.size()).add(pageList);
    }

    /**
     * 查询账户每个SKU的限售情况
     * @param session
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("salesOfSku")
    public LayuiJson salesOfSku(HttpSession session,int page,int limit){
        String accountName= (String) session.getAttribute("accountName");
        List<SalesOfSku> list=orderService.SalesOfSKU(accountName);
        List<SalesOfSku> pageList;
        int start,end;
        start=(page-1)*limit;
        if((page*limit)>list.size()) {
            end=list.size();
        }else{
            end = page * limit;
        }
        pageList=list.subList(start,end);
        return LayuiJson.success(list.size()).add(pageList);
    }

    /**
     *  查询账户每个尺寸的限售情况
     * @param session
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("salesOfSize")
    public LayuiJson salesOfSize(HttpSession session,int page,int limit){
        String accountName= (String) session.getAttribute("accountName");
        List<SalesOfSku> list=orderService.SalesOfSize(accountName);
        List<SalesOfSku> pageList;
        int start,end;
        start=(page-1)*limit;
        if((page*limit)>list.size()) {
            end=list.size();
        }else{
            end = page * limit;
        }
        pageList=list.subList(start,end);
        return LayuiJson.success(list.size()).add(pageList);
    }

    /**
     *  查询账户每个颜色的限售情况
     * @param session
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("salesOfColor")
    public LayuiJson salesOfColor(HttpSession session,int page,int limit){
        String accountName= (String) session.getAttribute("accountName");
        List<SalesOfSku> list=orderService.SalesOfColor(accountName);
        List<SalesOfSku> pageList;
        int start,end;
        start=(page-1)*limit;
        if((page*limit)>list.size()) {
            end=list.size();
        }else{
            end = page * limit;
        }
        pageList=list.subList(start,end);
        return LayuiJson.success(list.size()).add(pageList);
    }
}
