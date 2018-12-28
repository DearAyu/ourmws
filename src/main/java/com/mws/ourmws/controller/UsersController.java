package com.mws.ourmws.controller;

import com.mws.ourmws.model.AmazonAccount;
import com.mws.ourmws.model.SalesOfSku;
import com.mws.ourmws.model.Users;
import com.mws.ourmws.service.AmazonAccountService;
import com.mws.ourmws.service.InventoryService;
import com.mws.ourmws.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private AmazonAccountService amazonAccountService;
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/")
    public String toLogin(){
        return "login";
    }

    @PostMapping("login")
    public String login(Users users, String accountName, Model model, HttpSession session){
        Users u = usersService.Login(users);
        if (u!=null){
            AmazonAccount account=amazonAccountService.selectByName(accountName);
            List<SalesOfSku> list=inventoryService.findInventoryMsg(accountName);
            if (account!=null){
                model.addAttribute("users",u);
                model.addAttribute("account",account);
                model.addAttribute("inventory",list);
                session.setAttribute("userId",u.getUserId());
                session.setAttribute("accountName",account.getAmazonAccountName());

                return "page/Home";
            }else {
                return "login";
            }
        }else{
            return "login";
        }
    }

    @GetMapping("changeAccount")
    public String changeAccount(HttpSession session,Model model){
        int id= (int) session.getAttribute("userId");
        Users u = usersService.findUser(id);
        model.addAttribute("User",u);
        session.removeAttribute("accountName");
        session.removeAttribute("userId");
        return "changeAccount";
    }

}
