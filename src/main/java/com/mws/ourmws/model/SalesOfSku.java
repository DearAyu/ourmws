package com.mws.ourmws.model;

public class SalesOfSku {
    private String ASIN;
    private String sellerSKU;
    private String Title;
    private int monthNum;
    private int seasonNum;
    private int halfYearNum;
    private int YearNum;
    private int num;
    private String color;
    private String size;
    private int inventoryNum;

    public String getASIN() {
        return ASIN;
    }

    public void setASIN(String ASIN) {
        this.ASIN = ASIN;
    }

    public String getSellerSKU() {
        return sellerSKU;
    }

    public void setSellerSKU(String sellerSKU) {
        this.sellerSKU = sellerSKU;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(int monthNum) {
        this.monthNum = monthNum;
    }

    public int getSeasonNum() {
        return seasonNum;
    }

    public void setSeasonNum(int seasonNum) {
        this.seasonNum = seasonNum;
    }

    public int getHalfYearNum() {
        return halfYearNum;
    }

    public void setHalfYearNum(int halfYearNum) {
        this.halfYearNum = halfYearNum;
    }

    public int getYearNum() {
        return YearNum;
    }

    public void setYearNum(int yearNum) {
        YearNum = yearNum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(int inventoryNum) {
        this.inventoryNum = inventoryNum;
    }
}
