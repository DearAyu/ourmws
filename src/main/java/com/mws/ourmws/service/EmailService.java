package com.mws.ourmws.service;

import com.mws.ourmws.DAO.EmailAccountDAO;
import com.mws.ourmws.DAO.EmailDAO;
import com.mws.ourmws.DAO.OrdersMapper;
import com.mws.ourmws.model.Email;
import com.mws.ourmws.model.EmailAccount;
import com.mws.ourmws.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailDAO emailDAO;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private EmailAccountDAO emailAccountDAO;
    @Autowired
    private OrdersMapper ordersMapper;

    public void addEmail() throws MessagingException {
        EmailAccount emailAccount=emailAccountDAO.selectByAmazonAccountId(1);
        JavaMailSender mailSender=new JavaMailSenderImpl();
        ((JavaMailSenderImpl) mailSender).setUsername(emailAccount.getUsername());
        ((JavaMailSenderImpl) mailSender).setPassword(emailAccount.getPassword());
        ((JavaMailSenderImpl) mailSender).setHost(emailAccount.getHost());
        ((JavaMailSenderImpl) mailSender).setPort(emailAccount.getPort());
        String amazonOrderId="114-0405849-2781023";
        Orders orders=ordersMapper.selectByAmazonOrderId(amazonOrderId);
        String ASIN=ordersMapper.selectAsinByAmazonOrderId(amazonOrderId).get(0);
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true,"UTF-8");
        helper.setFrom(emailAccount.getUsername());
        helper.setTo(orders.getBuyeremail());
        helper.setSubject("[Important]How is your order?");
        Context context=new Context();
        context.setVariable("buyerName",orders.getBuyername());
        context.setVariable("ASIN",ASIN);
        context.setVariable("ASINUrl","https://www.amazon.com/gp/product/"+ASIN);
        context.setVariable("orderId",orders.getAmazonorderid());
        context.setVariable("orderTime",orders.getPurchasedate());
        context.setVariable("feedbackUrl","https://www.amazon.com/gp/feedback/leave-consolidated-feedback.html/ref=cfb_su_el?ie=UTF8&amp;marketplaceID=ATVPDKIKX0DER&amp;mode=eligibility");
        context.setVariable("reviewUrl","https://www.amazon.com/review/create-review?asin="+ASIN);
        context.setVariable("accountName","Sunnolimit");
        String emailContent=templateEngine.process("template",context);
        helper.setText(emailContent,true);
        mailSender.send(message);
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        String sendTime=format.format(date);
        Email email=new Email();
        email.setAmazonOrderId(orders.getAmazonorderid());
        email.setASIN(ASIN);
        email.setRecipient(orders.getBuyeremail());
        email.setTitle("[Important]How is your order?");
        email.setSender("Sunnolimit");
        email.setDate(sendTime);
        int type=emailDAO.insert(email);
        if (type==1){
            System.out.println("发送成功");
        }else {
            System.out.println("发送失败");
        }
    }

    /**
     * 查找所有我的账户已发送的邮件
     * @param sender
     * @return
     */
    public List<Email> findMyEamil(String sender){
        return emailDAO.selectBySender(sender);
    }

    /**
     * 查找单个邮件信息
     * @param amazonOrderId
     * @return
     */
    public Email findThisEmail(String amazonOrderId){
        return emailDAO.selectByAmazonOrderId(amazonOrderId);
    }
}
