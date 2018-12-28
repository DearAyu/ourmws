package com.mws.ourmws.model;

public class OrdersAnalysis {
    private String month;
    private int totalOrdersNum;
    private float totalPriceNum;
    private int totalGoodsNum;
    //尺寸
    private String inch;
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getTotalOrdersNum() {
        return totalOrdersNum;
    }

    public void setTotalOrdersNum(int totalOrdersNum) {
        this.totalOrdersNum = totalOrdersNum;
    }

    public float getTotalPriceNum() {
        return totalPriceNum;
    }

    public void setTotalPriceNum(float totalPriceNum) {
        this.totalPriceNum = totalPriceNum;
    }

    public int getTotalGoodsNum() {
        return totalGoodsNum;
    }

    public void setTotalGoodsNum(int totalGoodsNum) {
        this.totalGoodsNum = totalGoodsNum;
    }

    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch;
    }
}
