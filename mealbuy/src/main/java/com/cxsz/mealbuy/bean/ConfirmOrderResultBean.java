package com.cxsz.mealbuy.bean;

import java.util.List;

public class ConfirmOrderResultBean {

    /**
     * body : {"goodsSize":1,"goodsRelevance":[{"goodsId":"755979c532c57bcde0535c111eac942a","customType":"1","settlementMode":"1","validityDuration":"3","unitPrice":0.01,"goodsName":"畅行卡季度套餐包","packageType":"3","effectiveMode":[{"mode":"5","dealMode":"5","modeText":"原套餐失效后生效","packageActiveTime":"2020-01-01 00:00:01","packageEndTime":"2020-03-31 23:59:59","oldPackageEndTime":"2019-06-30 23:59:59","priceType":2,"retailsPrice":0.01,"cardGoodsPrice":0.01}]}]}
     * code : 1
     * message : 确认订单成功！
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
         * goodsSize : 1
         * goodsRelevance : [{"goodsId":"755979c532c57bcde0535c111eac942a","customType":"1","settlementMode":"1","validityDuration":"3","unitPrice":0.01,"goodsName":"畅行卡季度套餐包","packageType":"3","effectiveMode":[{"mode":"5","dealMode":"5","modeText":"原套餐失效后生效","packageActiveTime":"2020-01-01 00:00:01","packageEndTime":"2020-03-31 23:59:59","oldPackageEndTime":"2019-06-30 23:59:59","priceType":2,"retailsPrice":0.01,"cardGoodsPrice":0.01}]}]
         */

        private int goodsSize;
        private List<GoodsRelevanceBean> goodsRelevance;

        public int getGoodsSize() {
            return goodsSize;
        }

        public void setGoodsSize(int goodsSize) {
            this.goodsSize = goodsSize;
        }

        public List<GoodsRelevanceBean> getGoodsRelevance() {
            return goodsRelevance;
        }

        public void setGoodsRelevance(List<GoodsRelevanceBean> goodsRelevance) {
            this.goodsRelevance = goodsRelevance;
        }

        public static class GoodsRelevanceBean {
            /**
             * goodsId : 755979c532c57bcde0535c111eac942a
             * customType : 1
             * settlementMode : 1
             * validityDuration : 3
             * unitPrice : 0.01
             * goodsName : 畅行卡季度套餐包
             * packageType : 3
             * effectiveMode : [{"mode":"5","dealMode":"5","modeText":"原套餐失效后生效","packageActiveTime":"2020-01-01 00:00:01","packageEndTime":"2020-03-31 23:59:59","oldPackageEndTime":"2019-06-30 23:59:59","priceType":2,"retailsPrice":0.01,"cardGoodsPrice":0.01}]
             */

            private String goodsId;
            private String customType;
            private String settlementMode;
            private String validityDuration;
            private double unitPrice;
            private String goodsName;
            private String packageType;
            private List<EffectiveModeBean> effectiveMode;

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getCustomType() {
                return customType;
            }

            public void setCustomType(String customType) {
                this.customType = customType;
            }

            public String getSettlementMode() {
                return settlementMode;
            }

            public void setSettlementMode(String settlementMode) {
                this.settlementMode = settlementMode;
            }

            public String getValidityDuration() {
                return validityDuration;
            }

            public void setValidityDuration(String validityDuration) {
                this.validityDuration = validityDuration;
            }

            public double getUnitPrice() {
                return unitPrice;
            }

            public void setUnitPrice(double unitPrice) {
                this.unitPrice = unitPrice;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getPackageType() {
                return packageType;
            }

            public void setPackageType(String packageType) {
                this.packageType = packageType;
            }

            public List<EffectiveModeBean> getEffectiveMode() {
                return effectiveMode;
            }

            public void setEffectiveMode(List<EffectiveModeBean> effectiveMode) {
                this.effectiveMode = effectiveMode;
            }

            public static class EffectiveModeBean {
                /**
                 * mode : 5
                 * dealMode : 5
                 * modeText : 原套餐失效后生效
                 * packageActiveTime : 2020-01-01 00:00:01
                 * packageEndTime : 2020-03-31 23:59:59
                 * oldPackageEndTime : 2019-06-30 23:59:59
                 * priceType : 2
                 * retailsPrice : 0.01
                 * cardGoodsPrice : 0.01
                 */

                private String mode;
                private String dealMode;
                private String modeText;
                private String packageActiveTime;
                private String packageEndTime;
                private String oldPackageEndTime;
                private int priceType;
                private double retailsPrice;
                private double cardGoodsPrice;

                public String getMode() {
                    return mode;
                }

                public void setMode(String mode) {
                    this.mode = mode;
                }

                public String getDealMode() {
                    return dealMode;
                }

                public void setDealMode(String dealMode) {
                    this.dealMode = dealMode;
                }

                public String getModeText() {
                    return modeText;
                }

                public void setModeText(String modeText) {
                    this.modeText = modeText;
                }

                public String getPackageActiveTime() {
                    return packageActiveTime;
                }

                public void setPackageActiveTime(String packageActiveTime) {
                    this.packageActiveTime = packageActiveTime;
                }

                public String getPackageEndTime() {
                    return packageEndTime;
                }

                public void setPackageEndTime(String packageEndTime) {
                    this.packageEndTime = packageEndTime;
                }

                public String getOldPackageEndTime() {
                    return oldPackageEndTime;
                }

                public void setOldPackageEndTime(String oldPackageEndTime) {
                    this.oldPackageEndTime = oldPackageEndTime;
                }

                public int getPriceType() {
                    return priceType;
                }

                public void setPriceType(int priceType) {
                    this.priceType = priceType;
                }

                public double getRetailsPrice() {
                    return retailsPrice;
                }

                public void setRetailsPrice(double retailsPrice) {
                    this.retailsPrice = retailsPrice;
                }

                public double getCardGoodsPrice() {
                    return cardGoodsPrice;
                }

                public void setCardGoodsPrice(double cardGoodsPrice) {
                    this.cardGoodsPrice = cardGoodsPrice;
                }
            }
        }
    }
}
