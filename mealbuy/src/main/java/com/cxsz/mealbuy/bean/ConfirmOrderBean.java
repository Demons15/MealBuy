package com.cxsz.mealbuy.bean;

import java.util.List;

public class ConfirmOrderBean {

    /**
     * appId : 9751170B6C1D9645E5680126E6BB62A4
     * timestamp : 2018-08-28 18:23:13
     * nonceStr : sanjitongchuanandchanxingshenzhou
     * signature : E1618A63B54F20D20EF4B7EBA9A5BA7B04577AB5
     * cardNumber : 80082088200
     * goodsRelevance : [{"goodsId":"b2a132cab6964bfc8fd9802c4db7230c"}]
     */

    private String appId;
    private String timestamp;
    private String nonceStr;
    private String signature;
    private String cardNumber;
    private List<GoodsRelevanceBean> goodsRelevance;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<GoodsRelevanceBean> getGoodsRelevance() {
        return goodsRelevance;
    }

    public void setGoodsRelevance(List<GoodsRelevanceBean> goodsRelevance) {
        this.goodsRelevance = goodsRelevance;
    }

    public static class GoodsRelevanceBean {
        /**
         * goodsId : b2a132cab6964bfc8fd9802c4db7230c
         */

        private String goodsId;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }
    }
}
