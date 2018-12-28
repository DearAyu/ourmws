package com.mws.ourmws.DAO;

import com.mws.ourmws.model.Email;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmailDAO {

    @Insert("insert into email(sender,recipient,amazonOrderId,ASIN,title,content,date) values(#{sender},#{recipient},#{amazonOrderId},#{ASIN},#{title},#{content},#{date});")
    int insert(Email email);

    @Select("select * from email where sender=#{sender};")
    List<Email> selectBySender(String sender);

    @Select("select * from email where amazonOrderId=#{amazonOrderId};")
    Email selectByAmazonOrderId(String amazonOrderId);

}
