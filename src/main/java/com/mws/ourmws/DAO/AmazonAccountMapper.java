package com.mws.ourmws.DAO;

import com.mws.ourmws.model.AmazonAccount;
import org.apache.ibatis.annotations.Select;

public interface AmazonAccountMapper {

    @Select("select * from amazonaccount where amazonAccountName=#{accountName}")
    AmazonAccount selectByName(String accountName);

}
