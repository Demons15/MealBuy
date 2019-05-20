package com.cxsz.mealbuy.bean;

import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;
import java.util.List;

public class SimPackageBean implements Serializable{

    /**
     * body : [{"relationType":3,"useCallDuration":3,"callDuration":100,"packageSourceid":"0966345b778b4816b3176271f0c6504c","simGoodsId":"cc092dde440c48d98927671924bf8fc7","goodsId":"6df71430b18b0b49e0535c111eac826d","goodsTypeName":"含套餐卡","useMessage":0,"useTraffic":-0.1692,"remark":"3","settlementMode":"1","packageType":1,"orgId":"fb92fe0ca7974337ac183a30d12ccdcd","packageTraffic":-1,"packageTrafficHistory":0,"packageSource":"2","simId":"deabb6d0ebb944ee8b70cbcf253675f3","productTypeName":"语音卡","goodsName":"**移动11位语音卡 无限流量+100分钟/月","packageState":1,"actualTraffic":30,"productType":"3","carrierOperator":"1","silentPhaseGoods":6,"isExperience":0,"updateTime":"2019-04-20 10:59:24","goodsType":"1","monthPrice":30,"packageStateName":"已启用","packageEndTime":"2020-03-31 23:59:59","createTime":"2019-04-20 10:59:24","validityDuration":12,"packageActiveTime":"2019-04-20 10:59:24","createUser":"d798969b9b194354a11ef5f958de74ef","goods_type":"1","isUpgrade":1,"ifDouble":0}]
     * code : 1
     * message : 查询未启用套餐成功
     */

    private int code;
    private String message;
    private List<BodyBean> body;

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

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean implements Serializable{
        /**
         * relationType : 3
         * useCallDuration : 3
         * callDuration : 100
         * packageSourceid : 0966345b778b4816b3176271f0c6504c
         * simGoodsId : cc092dde440c48d98927671924bf8fc7
         * goodsId : 6df71430b18b0b49e0535c111eac826d
         * goodsTypeName : 含套餐卡
         * useMessage : 0
         * useTraffic : -0.1692
         * remark : 3
         * settlementMode : 1
         * packageType : 1
         * orgId : fb92fe0ca7974337ac183a30d12ccdcd
         * packageTraffic : -1
         * packageTrafficHistory : 0
         * packageSource : 2
         * simId : deabb6d0ebb944ee8b70cbcf253675f3
         * productTypeName : 语音卡
         * goodsName : **移动11位语音卡 无限流量+100分钟/月
         * packageState : 1
         * actualTraffic : 30
         * productType : 3
         * carrierOperator : 1
         * silentPhaseGoods : 6
         * isExperience : 0
         * updateTime : 2019-04-20 10:59:24
         * goodsType : 1
         * monthPrice : 30
         * packageStateName : 已启用
         * packageEndTime : 2020-03-31 23:59:59
         * createTime : 2019-04-20 10:59:24
         * validityDuration : 12
         * packageActiveTime : 2019-04-20 10:59:24
         * createUser : d798969b9b194354a11ef5f958de74ef
         * goods_type : 1
         * isUpgrade : 1
         * ifDouble : 0
         */

        private int relationType;
        private int useCallDuration;
        private int callDuration;
        private int useMessage;
        private double useTraffic;
        private int packageType;
        private int packageTraffic;
        private int packageTrafficHistory;
        private int packageState;
        private int actualTraffic;
        private int silentPhaseGoods;
        private int isExperience;
        private int monthPrice;
        private int validityDuration;
        private int isUpgrade;
        private int ifDouble;


        private String packageSourceid;
        private String simGoodsId;
        private String goodsId;
        private String goodsTypeName;
        private String remark;
        private String settlementMode;
        private String orgId;
        private String packageSource;
        private String simId;
        private String productTypeName;
        private String goodsName;
        private String productType;
        private String carrierOperator;
        private String updateTime;
        private String goodsType;
        private String packageStateName;
        private String packageEndTime;
        private String createTime;
        private String packageActiveTime;
        private String createUser;
        private String goods_type;

        public int getRelationType() {
            return relationType;
        }

        public void setRelationType(int relationType) {
            this.relationType = relationType;
        }

        public int getUseCallDuration() {
            return useCallDuration;
        }

        public void setUseCallDuration(int useCallDuration) {
            this.useCallDuration = useCallDuration;
        }

        public int getCallDuration() {
            return callDuration;
        }

        public void setCallDuration(int callDuration) {
            this.callDuration = callDuration;
        }

        public String getPackageSourceid() {
            return packageSourceid;
        }

        public void setPackageSourceid(String packageSourceid) {
            this.packageSourceid = packageSourceid;
        }

        public String getSimGoodsId() {
            return simGoodsId;
        }

        public void setSimGoodsId(String simGoodsId) {
            this.simGoodsId = simGoodsId;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsTypeName() {
            return goodsTypeName;
        }

        public void setGoodsTypeName(String goodsTypeName) {
            this.goodsTypeName = goodsTypeName;
        }

        public int getUseMessage() {
            return useMessage;
        }

        public void setUseMessage(int useMessage) {
            this.useMessage = useMessage;
        }

        public double getUseTraffic() {
            return useTraffic;
        }

        public void setUseTraffic(double useTraffic) {
            this.useTraffic = useTraffic;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getSettlementMode() {
            return settlementMode;
        }

        public void setSettlementMode(String settlementMode) {
            this.settlementMode = settlementMode;
        }

        public int getPackageType() {
            return packageType;
        }

        public void setPackageType(int packageType) {
            this.packageType = packageType;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public int getPackageTraffic() {
            return packageTraffic;
        }

        public void setPackageTraffic(int packageTraffic) {
            this.packageTraffic = packageTraffic;
        }

        public int getPackageTrafficHistory() {
            return packageTrafficHistory;
        }

        public void setPackageTrafficHistory(int packageTrafficHistory) {
            this.packageTrafficHistory = packageTrafficHistory;
        }

        public String getPackageSource() {
            return packageSource;
        }

        public void setPackageSource(String packageSource) {
            this.packageSource = packageSource;
        }

        public String getSimId() {
            return simId;
        }

        public void setSimId(String simId) {
            this.simId = simId;
        }

        public String getProductTypeName() {
            return productTypeName;
        }

        public void setProductTypeName(String productTypeName) {
            this.productTypeName = productTypeName;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public int getPackageState() {
            return packageState;
        }

        public void setPackageState(int packageState) {
            this.packageState = packageState;
        }

        public int getActualTraffic() {
            return actualTraffic;
        }

        public void setActualTraffic(int actualTraffic) {
            this.actualTraffic = actualTraffic;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getCarrierOperator() {
            return carrierOperator;
        }

        public void setCarrierOperator(String carrierOperator) {
            this.carrierOperator = carrierOperator;
        }

        public int getSilentPhaseGoods() {
            return silentPhaseGoods;
        }

        public void setSilentPhaseGoods(int silentPhaseGoods) {
            this.silentPhaseGoods = silentPhaseGoods;
        }

        public int getIsExperience() {
            return isExperience;
        }

        public void setIsExperience(int isExperience) {
            this.isExperience = isExperience;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }

        public int getMonthPrice() {
            return monthPrice;
        }

        public void setMonthPrice(int monthPrice) {
            this.monthPrice = monthPrice;
        }

        public String getPackageStateName() {
            return packageStateName;
        }

        public void setPackageStateName(String packageStateName) {
            this.packageStateName = packageStateName;
        }

        public String getPackageEndTime() {
            return packageEndTime;
        }

        public void setPackageEndTime(String packageEndTime) {
            this.packageEndTime = packageEndTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getValidityDuration() {
            return validityDuration;
        }

        public void setValidityDuration(int validityDuration) {
            this.validityDuration = validityDuration;
        }

        public String getPackageActiveTime() {
            return packageActiveTime;
        }

        public void setPackageActiveTime(String packageActiveTime) {
            this.packageActiveTime = packageActiveTime;
        }

        public String getCreateUser() {
            return createUser;
        }

        public void setCreateUser(String createUser) {
            this.createUser = createUser;
        }

        public String getGoods_type() {
            return goods_type;
        }

        public void setGoods_type(String goods_type) {
            this.goods_type = goods_type;
        }

        public int getIsUpgrade() {
            return isUpgrade;
        }

        public void setIsUpgrade(int isUpgrade) {
            this.isUpgrade = isUpgrade;
        }

        public int getIfDouble() {
            return ifDouble;
        }

        public void setIfDouble(int ifDouble) {
            this.ifDouble = ifDouble;
        }

        public void getSimPackageInfo(LinkedTreeMap mapData, BodyBean bodyBean) {
            if (((Double) mapData.get("relationType")) != null) {
                double callDuration = ((Double) mapData.get("relationType")).doubleValue();
                bodyBean.setRelationType((int) callDuration);
            }
            if (((Double) mapData.get("useCallDuration")) != null) {
                double callDuration = ((Double) mapData.get("useCallDuration")).doubleValue();
                bodyBean.setUseCallDuration((int) callDuration);
            }
            if (((Double) mapData.get("callDuration")) != null) {
                double callDuration = ((Double) mapData.get("callDuration")).doubleValue();
                bodyBean.setCallDuration((int) callDuration);
            }
            if (((Double) mapData.get("useMessage")) != null) {
                double callDuration = ((Double) mapData.get("useMessage")).doubleValue();
                bodyBean.setUseMessage((int) callDuration);
            }
            if (((Double) mapData.get("useTraffic")) != null) {
                double callDuration = ((Double) mapData.get("useTraffic")).doubleValue();
                bodyBean.setUseTraffic((int) callDuration);
            }
            if (((Double) mapData.get("packageType")) != null) {
                double callDuration = ((Double) mapData.get("packageType")).doubleValue();
                bodyBean.setPackageType((int) callDuration);
            }
            if (((Double) mapData.get("packageTraffic")) != null) {
                double callDuration = ((Double) mapData.get("packageTraffic")).doubleValue();
                bodyBean.setPackageTraffic((int) callDuration);
            }
            if (((Double) mapData.get("packageTrafficHistory")) != null) {
                double callDuration = ((Double) mapData.get("packageTrafficHistory")).doubleValue();
                bodyBean.setPackageTrafficHistory((int) callDuration);
            }
            if (((Double) mapData.get("packageState")) != null) {
                double callDuration = ((Double) mapData.get("packageState")).doubleValue();
                bodyBean.setPackageState((int) callDuration);
            }
            if (((Double) mapData.get("actualTraffic")) != null) {
                double callDuration = ((Double) mapData.get("actualTraffic")).doubleValue();
                bodyBean.setActualTraffic((int) callDuration);
            }
            if (((Double) mapData.get("silentPhaseGoods")) != null) {
                double callDuration = ((Double) mapData.get("silentPhaseGoods")).doubleValue();
                bodyBean.setSilentPhaseGoods((int) callDuration);
            }
            if (((Double) mapData.get("isExperience")) != null) {
                double callDuration = ((Double) mapData.get("isExperience")).doubleValue();
                bodyBean.setIsExperience((int) callDuration);
            }
            if (((Double) mapData.get("monthPrice")) != null) {
                double callDuration = ((Double) mapData.get("monthPrice")).doubleValue();
                bodyBean.setMonthPrice((int) callDuration);
            }
            if (((Double) mapData.get("validityDuration")) != null) {
                double callDuration = ((Double) mapData.get("validityDuration")).doubleValue();
                bodyBean.setValidityDuration((int) callDuration);
            }
            if (((Double) mapData.get("isUpgrade")) != null) {
                double callDuration = ((Double) mapData.get("isUpgrade")).doubleValue();
                bodyBean.setIsUpgrade((int) callDuration);
            }
            if (((Double) mapData.get("ifDouble")) != null) {
                double ifDouble = ((Double) mapData.get("ifDouble")).doubleValue();
                bodyBean.setIfDouble((int) ifDouble);
            }

            String packageSourceid = (String) mapData.get("packageSourceid");
            bodyBean.setPackageSourceid(packageSourceid);
            String simGoodsId = (String) mapData.get("simGoodsId");
            bodyBean.setSimGoodsId(simGoodsId);
            String goodsId = (String) mapData.get("goodsId");
            bodyBean.setGoodsId(goodsId);
            String goodsTypeName = (String) mapData.get("goodsTypeName");
            bodyBean.setGoodsTypeName(goodsTypeName);
            String remark = (String) mapData.get("remark");
            bodyBean.setRemark(remark);
            String settlementMode = (String) mapData.get("settlementMode");
            bodyBean.setSettlementMode(settlementMode);
            String orgId = (String) mapData.get("orgId");
            bodyBean.setOrgId(orgId);
            String packageSource = (String) mapData.get("packageSource");
            bodyBean.setPackageSource(packageSource);
            String simId = (String) mapData.get("simId");
            bodyBean.setSimId(simId);
            String productTypeName = (String) mapData.get("productTypeName");
            bodyBean.setProductTypeName(productTypeName);
            String goodsName = (String) mapData.get("goodsName");
            bodyBean.setGoodsName(goodsName);
            String productType = (String) mapData.get("productType");
            bodyBean.setOrgId(productType);
            String carrierOperator = (String) mapData.get("carrierOperator");
            bodyBean.setCarrierOperator(carrierOperator);
            String updateTime = (String) mapData.get("updateTime");
            bodyBean.setUpdateTime(updateTime);
            String goodsType = (String) mapData.get("goodsType");
            bodyBean.setGoodsType(goodsType);
            String packageStateName = (String) mapData.get("packageStateName");
            bodyBean.setPackageStateName(packageStateName);
            String packageEndTime = (String) mapData.get("packageEndTime");
            bodyBean.setPackageEndTime(packageEndTime);
            String createTime = (String) mapData.get("createTime");
            bodyBean.setCreateTime(createTime);
            String packageActiveTime = (String) mapData.get("packageActiveTime");
            bodyBean.setPackageActiveTime(packageActiveTime);
            String createUser = (String) mapData.get("createUser");
            bodyBean.setCreateUser(createUser);
            String goods_type = (String) mapData.get("goods_type");
            bodyBean.setGoods_type(goods_type);
        }
    }
}
