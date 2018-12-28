package com.mws.ourmws.controller;

import com.mws.ourmws.model.Email;
import com.mws.ourmws.model.LayuiJson;
import com.mws.ourmws.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    /**
     * 显示当前账户的所有邮件，并分页
     * @param session
     * @return
     */
    public LayuiJson myEmail(HttpSession session){
        String sender= (String) session.getAttribute("accountName");
        List<Email> list=emailService.findMyEamil(sender);
        return LayuiJson.success(list.size()).add(list);
    }

}
