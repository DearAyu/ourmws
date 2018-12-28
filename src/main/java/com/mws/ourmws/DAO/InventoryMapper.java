package com.mws.ourmws.DAO;

import com.mws.ourmws.model.SalesOfSku;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InventoryMapper {

    @Select("SELECT COUNT(*) as num,IFNULL(inventory.totalSupplyQuantity,0) as inventoryNum FROM inventory where ASIN=#{ASIN}")
    SalesOfSku selectInventoryNum(String ASIN);

    @Select("SELECT" +
            " orderitems.ASIN," +
            "\torderitems.sellerSKU," +
            "\torderitems.Title as Title ," +
            "\tinventory.totalSupplyQuantity as inventoryNum " +
            "FROM" +
            "\tinventory," +
            "\torderitems " +
            "WHERE\n" +
            "\torderitems.ASIN = inventory.ASIN " +
            "\tAnd inventory.shopName=#{shopName}"+
            "GROUP BY" +
            "\tinventory.ASIN;")
    List<SalesOfSku> selectInventoryMsg(String shopName);
}
