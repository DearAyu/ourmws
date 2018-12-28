package com.mws.ourmws.DAO;

import com.mws.ourmws.model.EmailAccount;
import org.apache.ibatis.annotations.Select;

public interface EmailAccountDAO {
    @Select("select * from eamilAccount where amazonAccountId=#{id}")
    EmailAccount selectByAmazonAccountId(int id);

}
