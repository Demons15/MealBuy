package com.cxsz.mealbuy.bean;

import com.google.gson.annotations.SerializedName;

public class CreateOrderResultBean {

    /**
     * body : {"orderNo":"201904291716369784","payType":1,"billMoney":0.02,"orderCardNumber":"17234248248","goodsName":"移动20分钟语音叠加包","timeStamp":"1556529396","nonceStr":"u9gOEI7NeLNTZmZjRypystJTBcAHj1is","package":"Sign=WXPay","partnerId":"1408265802","prepayId":"wx29171636786201cdda7f696d0983744873","sign":"FF3165875D735BEA628368576C6D8510"}
     * code : 1
     * message : success
     */

    private BodyBean body;
    private int code;
    private String message;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class BodyBean {
        /**
         * orderNo : 201904291716369784
         * payType : 1
         * billMoney : 0.02
         * orderCardNumber : 17234248248
         * goodsName : 移动20分钟语音叠加包
         * timeStamp : 1556529396
         * nonceStr : u9gOEI7NeLNTZmZjRypystJTBcAHj1is
         * package : Sign=WXPay
         * partnerId : 1408265802
         * prepayId : wx29171636786201cdda7f696d0983744873
         * sign : FF3165875D735BEA628368576C6D8510
         */

        private String orderNo;
        private int payType;
        private double billMoney;
        private String orderCardNumber;
        private String goodsName;
        private String timeStamp;
        private String nonceStr;
        @SerializedName("package")
        private String packageX;
        private String partnerId;
        private String prepayId;
        private String sign;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public double getBillMoney() {
            return billMoney;
        }

        public void setBillMoney(double billMoney) {
            this.billMoney = billMoney;
        }

        public String getOrderCardNumber() {
            return orderCardNumber;
        }

        public void setOrderCardNumber(String orderCardNumber) {
            this.orderCardNumber = orderCardNumber;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getPartnerId() {
            return partnerId;
        }

        public void setPartnerId(String partnerId) {
            this.partnerId = partnerId;
        }

        public String getPrepayId() {
            return prepayId;
        }

        public void setPrepayId(String prepayId) {
            this.prepayId = prepayId;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }
    }
}
