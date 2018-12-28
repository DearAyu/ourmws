package com.mws.ourmws.service;

import com.mws.ourmws.DAO.InventoryMapper;
import com.mws.ourmws.model.SalesOfSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryMapper inventoryMapper;

    public List<SalesOfSku> findInventoryMsg(String accountName){
        return inventoryMapper.selectInventoryMsg(accountName);
    }

}
