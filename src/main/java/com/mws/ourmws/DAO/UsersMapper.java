package com.mws.ourmws.DAO;

import com.mws.ourmws.model.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersMapper {

    @Select("Select * from users where user_name=#{userName} and user_password=#{password}")
    Users selectByUserNameAndPwd(String userName,String password);

    @Select("Select * from users where user_id=#{id}")
    Users selectById(int id);
}
