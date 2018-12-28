package com.mws.ourmws.service;

import com.mws.ourmws.DAO.AmazonAccountMapper;
import com.mws.ourmws.model.AmazonAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmazonAccountService {

    @Autowired
    private AmazonAccountMapper amazonAccountMapper;

    /**
     * 根据账户名查找账户信息
     */
    public AmazonAccount selectByName(String accountName){
        return amazonAccountMapper.selectByName(accountName);
    }
}
