package com.mws.ourmws.service;

import com.mws.ourmws.DAO.UsersMapper;
import com.mws.ourmws.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 登录
     */
    public Users Login(Users users){
        Users u = usersMapper.selectByUserNameAndPwd(users.getUserName(),users.getUserPassword());
        return u;
    }

    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    public Users findUser(int id){
        Users u=usersMapper.selectById(id);
        return u;
    }
}
