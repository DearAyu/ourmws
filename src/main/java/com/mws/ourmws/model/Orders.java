package com.mws.ourmws.model;

public class Orders {
    private Integer orderid;

    private String amazonorderid;

    private String sellerorderid;

    private String purchasedate;

    private String lastupdatedate;

    private String orderstatus;

    private String fulfillmentchannel;

    private String saleschannel;

    private String shipservicelevel;

    private String name;

    private String addressline1;

    private String addressline2;

    private String city;

    private String stateorregion;

    private String postalcode;

    private String countrycode;

    private String currencycode;

    private String amount;

    private String numberofitemsshipped;

    private String numberofitemsunshipped;

    private String paymentmethod;

    private String paymentmethoddetail;

    private String marketplaceid;

    private String buyeremail;

    private String buyername;

    private String shipmentservicelevelcategory;

    private String ordertype;

    private String earliestshipdate;

    private String latestshipdate;

    private Boolean isbusinessorder;

    private Boolean isprime;

    private Boolean ispremiumorder;

    private Boolean isreplacementorder;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getAmazonorderid() {
        return amazonorderid;
    }

    public void setAmazonorderid(String amazonorderid) {
        this.amazonorderid = amazonorderid == null ? null : amazonorderid.trim();
    }

    public String getSellerorderid() {
        return sellerorderid;
    }

    public void setSellerorderid(String sellerorderid) {
        this.sellerorderid = sellerorderid == null ? null : sellerorderid.trim();
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        this.purchasedate = purchasedate == null ? null : purchasedate.trim();
    }

    public String getLastupdatedate() {
        return lastupdatedate;
    }

    public void setLastupdatedate(String lastupdatedate) {
        this.lastupdatedate = lastupdatedate == null ? null : lastupdatedate.trim();
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
    }

    public String getFulfillmentchannel() {
        return fulfillmentchannel;
    }

    public void setFulfillmentchannel(String fulfillmentchannel) {
        this.fulfillmentchannel = fulfillmentchannel == null ? null : fulfillmentchannel.trim();
    }

    public String getSaleschannel() {
        return saleschannel;
    }

    public void setSaleschannel(String saleschannel) {
        this.saleschannel = saleschannel == null ? null : saleschannel.trim();
    }

    public String getShipservicelevel() {
        return shipservicelevel;
    }

    public void setShipservicelevel(String shipservicelevel) {
        this.shipservicelevel = shipservicelevel == null ? null : shipservicelevel.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1 == null ? null : addressline1.trim();
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2 == null ? null : addressline2.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getStateorregion() {
        return stateorregion;
    }

    public void setStateorregion(String stateorregion) {
        this.stateorregion = stateorregion == null ? null : stateorregion.trim();
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode == null ? null : postalcode.trim();
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode == null ? null : currencycode.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getNumberofitemsshipped() {
        return numberofitemsshipped;
    }

    public void setNumberofitemsshipped(String numberofitemsshipped) {
        this.numberofitemsshipped = numberofitemsshipped == null ? null : numberofitemsshipped.trim();
    }

    public String getNumberofitemsunshipped() {
        return numberofitemsunshipped;
    }

    public void setNumberofitemsunshipped(String numberofitemsunshipped) {
        this.numberofitemsunshipped = numberofitemsunshipped == null ? null : numberofitemsunshipped.trim();
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod == null ? null : paymentmethod.trim();
    }

    public String getPaymentmethoddetail() {
        return paymentmethoddetail;
    }

    public void setPaymentmethoddetail(String paymentmethoddetail) {
        this.paymentmethoddetail = paymentmethoddetail == null ? null : paymentmethoddetail.trim();
    }

    public String getMarketplaceid() {
        return marketplaceid;
    }

    public void setMarketplaceid(String marketplaceid) {
        this.marketplaceid = marketplaceid == null ? null : marketplaceid.trim();
    }

    public String getBuyeremail() {
        return buyeremail;
    }

    public void setBuyeremail(String buyeremail) {
        this.buyeremail = buyeremail == null ? null : buyeremail.trim();
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername == null ? null : buyername.trim();
    }

    public String getShipmentservicelevelcategory() {
        return shipmentservicelevelcategory;
    }

    public void setShipmentservicelevelcategory(String shipmentservicelevelcategory) {
        this.shipmentservicelevelcategory = shipmentservicelevelcategory == null ? null : shipmentservicelevelcategory.trim();
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype == null ? null : ordertype.trim();
    }

    public String getEarliestshipdate() {
        return earliestshipdate;
    }

    public void setEarliestshipdate(String earliestshipdate) {
        this.earliestshipdate = earliestshipdate == null ? null : earliestshipdate.trim();
    }

    public String getLatestshipdate() {
        return latestshipdate;
    }

    public void setLatestshipdate(String latestshipdate) {
        this.latestshipdate = latestshipdate == null ? null : latestshipdate.trim();
    }

    public Boolean getIsbusinessorder() {
        return isbusinessorder;
    }

    public void setIsbusinessorder(Boolean isbusinessorder) {
        this.isbusinessorder = isbusinessorder;
    }

    public Boolean getIsprime() {
        return isprime;
    }

    public void setIsprime(Boolean isprime) {
        this.isprime = isprime;
    }

    public Boolean getIspremiumorder() {
        return ispremiumorder;
    }

    public void setIspremiumorder(Boolean ispremiumorder) {
        this.ispremiumorder = ispremiumorder;
    }

    public Boolean getIsreplacementorder() {
        return isreplacementorder;
    }

    public void setIsreplacementorder(Boolean isreplacementorder) {
        this.isreplacementorder = isreplacementorder;
    }
}