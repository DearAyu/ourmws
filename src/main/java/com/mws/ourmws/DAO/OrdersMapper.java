package com.mws.ourmws.DAO;

import com.mws.ourmws.model.Orders;
import com.mws.ourmws.model.OrdersAnalysis;
import com.mws.ourmws.model.SalesOfSku;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersMapper {

    //查询本月的销售情况
    @Select("SELECT" +
            " DATE_FORMAT( PurchaseDate, '%d' ) AS month," +
            " count( DISTINCT amazonOrders.BuyerName ) AS totalOrdersNum," +
            " ROUND(SUM(orderitems.itemPriceAmount ),2) AS totalPriceNum," +
            " SUM( orderitems.quantityOrdered ) AS totalGoodsNum" +
            " FROM" +
            " amazonOrders," +
            " orderitems" +
            " where" +
            " amazonOrders.AmazonOrderId=orderitems.amazonOrderId AND" +
            " amazonOrders.OrderStatus='Shipped' AND" +
            " AND orderitems.ShopName=#{shopName}"+
            " DATE_FORMAT( PurchaseDate, '%m' )=#{month}" +
            " GROUP BY" +
            " month;")
    List<OrdersAnalysis> thisMonthAnalysis(String shopName,String month);

    //查询最近30天的销售情况
    @Select("SELECT" +
            " DATE_FORMAT( PurchaseDate, '%d' ) AS month," +
            " count( DISTINCT amazonOrders.BuyerName ) AS totalOrdersNum," +
            " ROUND(SUM(orderitems.itemPriceAmount ),2) AS totalPriceNum," +
            " SUM( orderitems.quantityOrdered ) AS totalGoodsNum" +
            " FROM" +
            " amazonOrders," +
            " orderitems" +
            " where" +
            " amazonOrders.AmazonOrderId=orderitems.amazonOrderId AND" +
            " amazonOrders.OrderStatus='Shipped'" +
            " AND orderitems.ShopName=#{shopName}"+
            " AND amazonOrders.PurchaseDate BETWEEN #{startTime} AND #{endTime}" +
            " GROUP BY" +
            " month;")
    List<OrdersAnalysis> perSalesMsg(String shopName,String startTime,String endTime);

    //查询最近30天每个尺寸售出的数量占比
    @Select("SELECT" +
            " count( DISTINCT orders.BuyerName ) AS totalOrdersNum," +
            " ROUND(SUM(orderitems.itemPriceAmount ),2) AS totalPriceNum," +
            " SUM( orderitems.quantityOrdered ) AS totalGoodsNum" +
            " FROM" +
            " amazonOrders," +
            " orderitems" +
            " WHERE" +
            " amazonOrders.AmazonOrderId = orderitems.amazonOrderId" +
            " AND amazonOrders.PurchaseDate BETWEEN #{startTime} AND #{endTime}" +
            " AND amazonOrders.OrderStatus = 'Shipped'" +
            " AND orderitems.ShopName=#{shopName}"+
            " AND Title like CONCAT('%',#{inch},'%');")
    OrdersAnalysis perSalesShare(String shopName,String startTime,String endTime,String inch);

    //查询每个SKU近30天、近90天、近180天、近1年的销量
    @Select("SELECT"+
            " orderitems.Title,"+
            " orderitems.ASIN,"+
            " orderitems.sellerSKU,"+
            " ifnull(SUM( orderitems.quantityOrdered ),0) AS num"+
            " FROM"+
            " orderitems,"+
            " amazonOrders"+
            " WHERE"+
            " orderitems.amazonOrderId = amazonOrders.AmazonOrderId"+
            " AND orderitems.ASIN = #{ASIN}"+
            " AND orderitems.ShopName=#{shopName}"+
            " AND amazonOrders.PurchaseDate BETWEEN #{startTime} AND #{endTime};")
    SalesOfSku  SalesOfSKU(String shopName,String ASIN,String startTime,String endTime);

    //查询所有的ASIN的基本信息
    @Select("SELECT"+
            " orderitems.ASIN,"+
            " orderitems.sellerSKU,"+
            " LEFT(orderitems.Title, 80) as Title"+
            " FROM"+
            " orderitems"+
            " WHERE"+
            " orderitems.shopName=#{shopName}"+
            " GROUP BY"+
            " orderitems.ASIN;")
    List<SalesOfSku> selectGoodsMsg(String shopName);

    //查询每个尺寸近30天、近90天、近180天、近1年的销量

    @Select("SELECT"+
            " ifnull(SUM( orderitems.quantityOrdered ),0) AS num"+
            " FROM"+
            " amazonOrders,"+
            " orderitems"+
            " WHERE"+
            " amazonOrders.AmazonOrderId = orderitems.amazonOrderId"+
            " AND amazonOrders.PurchaseDate BETWEEN #{startTime} AND #{endTime}"+
            " AND amazonOrders.OrderStatus = 'Shipped'"+
            " AND orderitems.ShopName=#{shopName}"+
            " AND Title LIKE CONCAT('%',#{size},'%');")
    int SalesOfSize(String shopName,String size,String startTime,String endTime);

    //查询每个颜色近30天、近90天、近180天、近1年的销量
    @Select("SELECT"+
            " ifnull(SUM( orderitems.quantityOrdered ),0) AS num"+
            " FROM"+
            " amazonOrders,"+
            " orderitems"+
            " WHERE"+
            " amazonOrders.AmazonOrderId = orderitems.amazonOrderId"+
            " AND amazonOrders.PurchaseDate BETWEEN #{startTime} AND #{endTime}"+
            " AND amazonOrders.OrderStatus = 'Shipped'"+
            " AND orderitems.ShopName=#{shopName}"+
            " AND Title LIKE CONCAT('%',#{color},'%');")
    int SalesOfColor(String shopName,String color,String startTime,String endTime);

    //根据amazonOrderId查询订单信息
    @Select("select * from amazonOrders where amazonOrders.AmazonOrderId=#{amazonOrderId}")
    Orders selectByAmazonOrderId(String amazonOrderId);

    //根据amazonOrderId查询ASIN
    @Select("SELECT orderitems.ASIN FROM orderitems where amazonOrderId=#{amazonOrderId}")
    List<String> selectAsinByAmazonOrderId(String amazonOrderId);
}
