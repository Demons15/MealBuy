package com.cxsz.mealbuy.bean;

public class CreatOrderRequestBean {

    /**
     * dealMode : 5
     * packageEndTimeNew : 2020-02-29 23:59:59
     * nonceStr : sanjitongchuanandchanxingshenzhou
     * goodsId : 1d742bc31fcc48e5be88075ee785e03c
     * packageEndTime : 2019-08-31 23:59:59
     * cardNumber : 17234230132
     * appId : CFBBFBD78EC2731A4208A4802E4A3DE9
     * signature : A8A6E7E22CEBF0D0FC454F62C38C1E60CAD00137
     * timestamp : 2019-04-17 18:24:46
     * goodsDescribe : 1111
     */

    private String dealMode;
    private String packageEndTimeNew;
    private String nonceStr;
    private String goodsId;
    private String packageEndTime;
    private String cardNumber;
    private String appId;
    private String signature;
    private String timestamp;
    private String goodsDescribe;

    public String getDealMode() {
        return dealMode;
    }

    public void setDealMode(String dealMode) {
        this.dealMode = dealMode;
    }

    public String getPackageEndTimeNew() {
        return packageEndTimeNew;
    }

    public void setPackageEndTimeNew(String packageEndTimeNew) {
        this.packageEndTimeNew = packageEndTimeNew;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getPackageEndTime() {
        return packageEndTime;
    }

    public void setPackageEndTime(String packageEndTime) {
        this.packageEndTime = packageEndTime;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }
}
