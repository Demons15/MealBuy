package com.cxsz.mealbuy.bean;

import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;

public class MealInfoBean implements Serializable {

    /**
     * body : {"networkStandard":"2G","supplierId":"285f8fa0e676406190dde9a087e7fd53","hasAccount":0,"activationMode":"3","goodsId":"6df71430b18b0b49e0535c111eac826d","imsi":"460072342408248","supplierCode":"FJYDB","settlementMode":"1","orgId":"fb92fe0ca7974337ac183a30d12ccdcd","carrierOperatorName":"移动","iccid":"898602F31318C0378248","balance":0,"upstreamId":"FJYD","simId":"deabb6d0ebb944ee8b70cbcf253675f3","customerId":"17","goodsName":"**移动11位语音卡 无限流量+100分钟/月","productType":"3","ifRenew":1,"carrierOperator":"1","ifExamine":0,"productId":"76cdbacba27a1844e0535c111eaccc2b","realnameUrl":"http://wap.fj.10086.cn/wlw","simState":"2","apnType":"CMMTM","networkState":1,"goodsType":"4","cashback":0,"realname":0,"cancelPackage":0,"imeiNum":3,"customType":"1","whiteListSwitch":1,"voiceState":"1","packageEndTime":"2020-02-29 23:59:59","simActivationDate":"2019-03-27 10:53:12","imei":"8634740454554440","cardNumber":"17234248248","noBusiness":"0","arrearage":"0","needActivated":"0","packageCount":"1","currentSimPackage":1,"simFlow":{"useCallDuration":0,"useMessageHistory":0,"year":2019,"useCallDurationHistory":0,"useMessage":0,"useTraffic":5.48,"updateTime":"2019-03-27 10:53:12","packageMessage":0,"iccid":"898602F31318C0378248","packageTraffic":-1,"packageCallDuration":100,"month":4,"createTime":"2019-03-27 10:53:12","useTrafficHistory":0,"createUser":"d798969b9b194354a11ef5f958de74ef","flowId":"cfb05dee47d94de1b9be44801a52f541","cardNumber":"17234248248","customerId":"fb92fe0ca7974337ac183a30d12ccdcd","goodsId":"6df71430b18b0b49e0535c111eac826d","orgId":"fb92fe0ca7974337ac183a30d12ccdcd"}}
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

    public static class BodyBean implements Serializable {
        /**
         * networkStandard : 2G
         * supplierId : 285f8fa0e676406190dde9a087e7fd53
         * hasAccount : 0
         * activationMode : 3
         * goodsId : 6df71430b18b0b49e0535c111eac826d
         * imsi : 460072342408248
         * supplierCode : FJYDB
         * settlementMode : 1
         * orgId : fb92fe0ca7974337ac183a30d12ccdcd
         * carrierOperatorName : 移动
         * iccid : 898602F31318C0378248
         * balance : 0
         * upstreamId : FJYD
         * simId : deabb6d0ebb944ee8b70cbcf253675f3
         * customerId : 17
         * goodsName : **移动11位语音卡 无限流量+100分钟/月
         * productType : 3
         * ifRenew : 1
         * carrierOperator : 1
         * ifExamine : 0
         * productId : 76cdbacba27a1844e0535c111eaccc2b
         * realnameUrl : http://wap.fj.10086.cn/wlw
         * simState : 2
         * apnType : CMMTM
         * networkState : 1
         * goodsType : 4
         * cashback : 0
         * realname : 0 //  1未实名 0已实名 2无需实名
         * cancelPackage : 0
         * imeiNum : 3
         * customType : 1
         * whiteListSwitch : 1
         * voiceState : 1
         * packageEndTime : 2020-02-29 23:59:59
         * simActivationDate : 2019-03-27 10:53:12
         * imei : 8634740454554440
         * cardNumber : 17234248248
         * noBusiness : 0
         * arrearage : 0
         * needActivated : 0
         * packageCount : 1
         * currentSimPackage : 1
         * simFlow : {"useCallDuration":0,"useMessageHistory":0,"year":2019,"useCallDurationHistory":0,"useMessage":0,"useTraffic":5.48,"updateTime":"2019-03-27 10:53:12","packageMessage":0,"iccid":"898602F31318C0378248","packageTraffic":-1,"packageCallDuration":100,"month":4,"createTime":"2019-03-27 10:53:12","useTrafficHistory":0,"createUser":"d798969b9b194354a11ef5f958de74ef","flowId":"cfb05dee47d94de1b9be44801a52f541","cardNumber":"17234248248","customerId":"fb92fe0ca7974337ac183a30d12ccdcd","goodsId":"6df71430b18b0b49e0535c111eac826d","orgId":"fb92fe0ca7974337ac183a30d12ccdcd"}
         */


        private int cashback;
        private int realname;
        private int cancelPackage;
        private int imeiNum;
        private int hasAccount;
        private int balance;
        private int ifRenew;
        private int ifExamine;
        private String networkState;
        private int currentSimPackage;

        private String networkStandard;
        private String supplierId;
        private String activationMode;
        private String goodsId;
        private String imsi;
        private String supplierCode;
        private String settlementMode;
        private String orgId;
        private String carrierOperatorName;
        private String iccid;
        private String upstreamId;
        private String simId;
        private String customerId;
        private String goodsName;
        private String productType;
        private String carrierOperator;
        private String productId;
        private String realnameUrl;
        private String simState;
        private String apnType;
        private String goodsType;
        private String customType;
        private String voiceState;
        private String packageEndTime;
        private String simActivationDate;
        private String imei;
        private String cardNumber;
        private String noBusiness;
        private String arrearage;
        private String needActivated;
        private String packageCount;

        private SimFlowBean simFlow;

        public void getSimPackageInfo(LinkedTreeMap mapData, BodyBean bodyBean) {
            if (((Double) mapData.get("cashback")) != null) {
                double cashback = ((Double) mapData.get("cashback")).doubleValue();
                bodyBean.setCashback((int) cashback);
            }
            if (((Double) mapData.get("realname")) != null) {
                double realname = ((Double) mapData.get("realname")).doubleValue();
                bodyBean.setRealname((int) realname);
            }
            if (((Double) mapData.get("cancelPackage")) != null) {
                double cancelPackage = ((Double) mapData.get("cancelPackage")).doubleValue();
                bodyBean.setCancelPackage((int) cancelPackage);
            }
            if (((Double) mapData.get("imeiNum")) != null) {
                double imeiNum = ((Double) mapData.get("imeiNum")).doubleValue();
                bodyBean.setImeiNum((int) imeiNum);
            }
            if (((Double) mapData.get("hasAccount")) != null) {
                double hasAccount = ((Double) mapData.get("hasAccount")).doubleValue();
                bodyBean.setHasAccount((int) hasAccount);
            }
            if (((Double) mapData.get("balance")) != null) {
                double balance = ((Double) mapData.get("balance")).doubleValue();
                bodyBean.setBalance((int) balance);
            }
            if (((Double) mapData.get("ifRenew")) != null) {
                double ifRenew = ((Double) mapData.get("ifRenew")).doubleValue();
                bodyBean.setIfRenew((int) ifRenew);
            }
            if (((Double) mapData.get("ifExamine")) != null) {
                double ifExamine = ((Double) mapData.get("ifExamine")).doubleValue();
                bodyBean.setIfExamine((int) ifExamine);
            }
            if (mapData.get("networkState") != null) {
                String networkState = String.valueOf(mapData.get("networkState"));
                bodyBean.setNetworkState(networkState);
            }
            if (((Double) mapData.get("currentSimPackage")) != null) {
                double currentSimPackage = ((Double) mapData.get("currentSimPackage")).doubleValue();
                bodyBean.setCurrentSimPackage((int) currentSimPackage);
            }


            String networkStandard = (String) mapData.get("networkStandard");
            bodyBean.setNetworkStandard(networkStandard);
            String supplierId = (String) mapData.get("supplierId");
            bodyBean.setSupplierId(supplierId);
            String activationMode = (String) mapData.get("activationMode");
            bodyBean.setActivationMode(activationMode);
            String goodsId = (String) mapData.get("goodsId");
            bodyBean.setGoodsId(goodsId);
            String imsi = (String) mapData.get("imsi");
            bodyBean.setImsi(imsi);
            String supplierCode = (String) mapData.get("supplierCode");
            bodyBean.setSupplierCode(supplierCode);
            String settlementMode = (String) mapData.get("settlementMode");
            bodyBean.setSettlementMode(settlementMode);
            String orgId = (String) mapData.get("orgId");
            bodyBean.setOrgId(orgId);
            String carrierOperatorName = (String) mapData.get("carrierOperatorName");
            bodyBean.setCarrierOperator(carrierOperatorName);
            String iccid = (String) mapData.get("iccid");
            bodyBean.setIccid(iccid);
            String upstreamId = (String) mapData.get("upstreamId");
            bodyBean.setUpstreamId(upstreamId);
            String simId = (String) mapData.get("simId");
            bodyBean.setSimId(simId);
            String customerId = (String) mapData.get("customerId");
            bodyBean.setCustomerId(customerId);
            String goodsName = (String) mapData.get("goodsName");
            bodyBean.setGoodsName(goodsName);
            String productType = (String) mapData.get("productType");
            bodyBean.setProductType(productType);
            String carrierOperator = (String) mapData.get("carrierOperator");
            bodyBean.setCarrierOperator(carrierOperator);
            String productId = (String) mapData.get("productId");
            bodyBean.setProductId(productId);
            String realnameUrl = (String) mapData.get("realnameUrl");
            bodyBean.setRealnameUrl(realnameUrl);
            String simState = (String) mapData.get("simState");
            bodyBean.setSimState(simState);
            String apnType = (String) mapData.get("apnType");
            bodyBean.setApnType(apnType);
            String goodsType = (String) mapData.get("goodsType");
            bodyBean.setGoodsType(goodsType);
            String customType = (String) mapData.get("customType");
            bodyBean.setCustomType(customType);
            String voiceState = (String) mapData.get("voiceState");
            bodyBean.setVoiceState(voiceState);
            String packageEndTime = (String) mapData.get("packageEndTime");
            bodyBean.setPackageEndTime(packageEndTime);
            String simActivationDate = (String) mapData.get("simActivationDate");
            bodyBean.setSimActivationDate(simActivationDate);
            String imei = (String) mapData.get("imei");
            bodyBean.setImei(imei);
            String cardNumber = (String) mapData.get("cardNumber");
            bodyBean.setCardNumber(cardNumber);
            String noBusiness = (String) mapData.get("noBusiness");
            bodyBean.setNoBusiness(noBusiness);
            String arrearage = (String) mapData.get("arrearage");
            bodyBean.setArrearage(arrearage);
            String needActivated = (String) mapData.get("needActivated");
            bodyBean.setNeedActivated(needActivated);
            String packageCount = (String) mapData.get("packageCount");
            bodyBean.setPackageCount(packageCount);

            LinkedTreeMap simFlow = (LinkedTreeMap) mapData.get("simFlow");
            if (simFlow != null) {
                SimFlowBean simFlowBean = new SimFlowBean();
                simFlowBean.setSimFlow(simFlow, simFlowBean);
                bodyBean.setSimFlow(simFlowBean);
            }
        }


        public String getNetworkStandard() {
            return networkStandard;
        }

        public void setNetworkStandard(String networkStandard) {
            this.networkStandard = networkStandard;
        }

        public String getSupplierId() {
            return supplierId;
        }

        public void setSupplierId(String supplierId) {
            this.supplierId = supplierId;
        }

        public int getHasAccount() {
            return hasAccount;
        }

        public void setHasAccount(int hasAccount) {
            this.hasAccount = hasAccount;
        }

        public String getActivationMode() {
            return activationMode;
        }

        public void setActivationMode(String activationMode) {
            this.activationMode = activationMode;
        }

        public String getNetworkState() {
            return networkState;
        }

        public void setNetworkState(String networkState) {
            this.networkState = networkState;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getImsi() {
            return imsi;
        }

        public void setImsi(String imsi) {
            this.imsi = imsi;
        }

        public String getSupplierCode() {
            return supplierCode;
        }

        public void setSupplierCode(String supplierCode) {
            this.supplierCode = supplierCode;
        }

        public String getSettlementMode() {
            return settlementMode;
        }

        public void setSettlementMode(String settlementMode) {
            this.settlementMode = settlementMode;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public String getCarrierOperatorName() {
            return carrierOperatorName;
        }

        public void setCarrierOperatorName(String carrierOperatorName) {
            this.carrierOperatorName = carrierOperatorName;
        }

        public String getIccid() {
            return iccid;
        }

        public void setIccid(String iccid) {
            this.iccid = iccid;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public String getUpstreamId() {
            return upstreamId;
        }

        public void setUpstreamId(String upstreamId) {
            this.upstreamId = upstreamId;
        }

        public String getSimId() {
            return simId;
        }

        public void setSimId(String simId) {
            this.simId = simId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public int getIfRenew() {
            return ifRenew;
        }

        public void setIfRenew(int ifRenew) {
            this.ifRenew = ifRenew;
        }

        public String getCarrierOperator() {
            return carrierOperator;
        }

        public void setCarrierOperator(String carrierOperator) {
            this.carrierOperator = carrierOperator;
        }

        public int getIfExamine() {
            return ifExamine;
        }

        public void setIfExamine(int ifExamine) {
            this.ifExamine = ifExamine;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getRealnameUrl() {
            return realnameUrl;
        }

        public void setRealnameUrl(String realnameUrl) {
            this.realnameUrl = realnameUrl;
        }

        public String getSimState() {
            return simState;
        }

        public void setSimState(String simState) {
            this.simState = simState;
        }

        public String getApnType() {
            return apnType;
        }

        public void setApnType(String apnType) {
            this.apnType = apnType;
        }


        public String getGoodsType() {
            return goodsType;
        }

        public void setGoodsType(String goodsType) {
            this.goodsType = goodsType;
        }

        public int getCashback() {
            return cashback;
        }

        public void setCashback(int cashback) {
            this.cashback = cashback;
        }

        public int getRealname() {
            return realname;
        }

        public void setRealname(int realname) {
            this.realname = realname;
        }

        public int getCancelPackage() {
            return cancelPackage;
        }

        public void setCancelPackage(int cancelPackage) {
            this.cancelPackage = cancelPackage;
        }

        public int getImeiNum() {
            return imeiNum;
        }

        public void setImeiNum(int imeiNum) {
            this.imeiNum = imeiNum;
        }

        public String getCustomType() {
            return customType;
        }

        public void setCustomType(String customType) {
            this.customType = customType;
        }

        public String getVoiceState() {
            return voiceState;
        }

        public void setVoiceState(String voiceState) {
            this.voiceState = voiceState;
        }

        public String getPackageEndTime() {
            return packageEndTime;
        }

        public void setPackageEndTime(String packageEndTime) {
            this.packageEndTime = packageEndTime;
        }

        public String getSimActivationDate() {
            return simActivationDate;
        }

        public void setSimActivationDate(String simActivationDate) {
            this.simActivationDate = simActivationDate;
        }

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public String getNoBusiness() {
            return noBusiness;
        }

        public void setNoBusiness(String noBusiness) {
            this.noBusiness = noBusiness;
        }

        public String getArrearage() {
            return arrearage;
        }

        public void setArrearage(String arrearage) {
            this.arrearage = arrearage;
        }

        public String getNeedActivated() {
            return needActivated;
        }

        public void setNeedActivated(String needActivated) {
            this.needActivated = needActivated;
        }

        public String getPackageCount() {
            return packageCount;
        }

        public void setPackageCount(String packageCount) {
            this.packageCount = packageCount;
        }

        public int getCurrentSimPackage() {
            return currentSimPackage;
        }

        public void setCurrentSimPackage(int currentSimPackage) {
            this.currentSimPackage = currentSimPackage;
        }

        public SimFlowBean getSimFlow() {
            return simFlow;
        }

        public void setSimFlow(SimFlowBean simFlow) {
            this.simFlow = simFlow;
        }

        public static class SimFlowBean implements Serializable {
            /**
             * useCallDuration : 0
             * useMessageHistory : 0
             * year : 2019
             * useCallDurationHistory : 0
             * useMessage : 0
             * useTraffic : 5.48
             * updateTime : 2019-03-27 10:53:12
             * packageMessage : 0
             * iccid : 898602F31318C0378248
             * packageTraffic : -1
             * packageCallDuration : 100
             * month : 4
             * createTime : 2019-03-27 10:53:12
             * useTrafficHistory : 0
             * createUser : d798969b9b194354a11ef5f958de74ef
             * flowId : cfb05dee47d94de1b9be44801a52f541
             * cardNumber : 17234248248
             * customerId : fb92fe0ca7974337ac183a30d12ccdcd
             * goodsId : 6df71430b18b0b49e0535c111eac826d
             * orgId : fb92fe0ca7974337ac183a30d12ccdcd
             */

            private double useCallDuration;
            private double useMessageHistory;
            private double year;
            private double useCallDurationHistory;
            private double useMessage;
            private double useTraffic;
            private double packageMessage;
            private double packageTraffic;
            private double packageCallDuration;
            private double month;
            private double useTrafficHistory;

            private String updateTime;
            private String iccid;
            private String createTime;
            private String createUser;
            private String flowId;
            private String cardNumber;
            private String customerId;
            private String goodsId;
            private String orgId;

            public void setSimFlow(LinkedTreeMap mapData, SimFlowBean bodyBean) {
                if (((Double) mapData.get("useCallDuration")) != null) {
                    double useCallDuration = ((Double) mapData.get("useCallDuration")).doubleValue();
                    bodyBean.setUseCallDuration(useCallDuration);
                }
                if (((Double) mapData.get("useMessageHistory")) != null) {
                    double useMessageHistory = ((Double) mapData.get("useMessageHistory")).doubleValue();
                    bodyBean.setUseMessageHistory(useMessageHistory);
                }
                if (((Double) mapData.get("year")) != null) {
                    double year = ((Double) mapData.get("year")).doubleValue();
                    bodyBean.setYear(year);
                }
                if (((Double) mapData.get("useCallDurationHistory")) != null) {
                    double useCallDurationHistory = ((Double) mapData.get("useCallDurationHistory")).doubleValue();
                    bodyBean.setUseCallDurationHistory(useCallDurationHistory);
                }
                if (((Double) mapData.get("useMessage")) != null) {
                    double useMessage = ((Double) mapData.get("useMessage")).doubleValue();
                    bodyBean.setUseMessage(useMessage);
                }
                if (((Double) mapData.get("useTraffic")) != null) {
                    double useTraffic = ((Double) mapData.get("useTraffic")).doubleValue();
                    bodyBean.setUseTraffic(useTraffic);
                }
                if (((Double) mapData.get("packageMessage")) != null) {
                    double packageMessage = ((Double) mapData.get("packageMessage")).doubleValue();
                    bodyBean.setPackageMessage(packageMessage);
                }
                if (((Double) mapData.get("packageTraffic")) != null) {
                    double packageTraffic = ((Double) mapData.get("packageTraffic")).doubleValue();
                    bodyBean.setPackageTraffic(packageTraffic);
                }
                if (((Double) mapData.get("packageCallDuration")) != null) {
                    double packageCallDuration = ((Double) mapData.get("packageCallDuration")).doubleValue();
                    bodyBean.setPackageCallDuration(packageCallDuration);
                }
                if (((Double) mapData.get("month")) != null) {
                    double month = ((Double) mapData.get("month")).doubleValue();
                    bodyBean.setMonth(month);
                }
                if (((Double) mapData.get("useTrafficHistory")) != null) {
                    double useTrafficHistory = ((Double) mapData.get("useTrafficHistory")).doubleValue();
                    bodyBean.setUseTrafficHistory((int) useTrafficHistory);
                }

                String updateTime = (String) mapData.get("updateTime");
                bodyBean.setUpdateTime(updateTime);
                String iccid = (String) mapData.get("iccid");
                bodyBean.setIccid(iccid);
                String createTime = (String) mapData.get("createTime");
                bodyBean.setCreateTime(createTime);
                String createUser = (String) mapData.get("createUser");
                bodyBean.setCreateUser(createUser);
                String flowId = (String) mapData.get("flowId");
                bodyBean.setFlowId(flowId);
                String cardNumber = (String) mapData.get("cardNumber");
                bodyBean.setCardNumber(cardNumber);
                String customerId = (String) mapData.get("customerId");
                bodyBean.setCustomerId(customerId);
                String goodsId = (String) mapData.get("goodsId");
                bodyBean.setGoodsId(goodsId);
                String orgId = (String) mapData.get("orgId");
                bodyBean.setOrgId(orgId);
            }

            public double getUseCallDuration() {
                return useCallDuration;
            }

            public void setUseCallDuration(double useCallDuration) {
                this.useCallDuration = useCallDuration;
            }

            public double getUseMessageHistory() {
                return useMessageHistory;
            }

            public void setUseMessageHistory(double useMessageHistory) {
                this.useMessageHistory = useMessageHistory;
            }

            public double getYear() {
                return year;
            }

            public void setYear(double year) {
                this.year = year;
            }

            public double getUseCallDurationHistory() {
                return useCallDurationHistory;
            }

            public void setUseCallDurationHistory(double useCallDurationHistory) {
                this.useCallDurationHistory = useCallDurationHistory;
            }

            public double getUseMessage() {
                return useMessage;
            }

            public void setUseMessage(double useMessage) {
                this.useMessage = useMessage;
            }

            public double getUseTraffic() {
                return useTraffic;
            }

            public void setUseTraffic(double useTraffic) {
                this.useTraffic = useTraffic;
            }

            public double getPackageMessage() {
                return packageMessage;
            }

            public void setPackageMessage(double packageMessage) {
                this.packageMessage = packageMessage;
            }

            public double getPackageTraffic() {
                return packageTraffic;
            }

            public void setPackageTraffic(double packageTraffic) {
                this.packageTraffic = packageTraffic;
            }

            public double getPackageCallDuration() {
                return packageCallDuration;
            }

            public void setPackageCallDuration(double packageCallDuration) {
                this.packageCallDuration = packageCallDuration;
            }

            public double getMonth() {
                return month;
            }

            public void setMonth(double month) {
                this.month = month;
            }

            public double getUseTrafficHistory() {
                return useTrafficHistory;
            }

            public void setUseTrafficHistory(double useTrafficHistory) {
                this.useTrafficHistory = useTrafficHistory;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getIccid() {
                return iccid;
            }

            public void setIccid(String iccid) {
                this.iccid = iccid;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateUser() {
                return createUser;
            }

            public void setCreateUser(String createUser) {
                this.createUser = createUser;
            }

            public String getFlowId() {
                return flowId;
            }

            public void setFlowId(String flowId) {
                this.flowId = flowId;
            }

            public String getCardNumber() {
                return cardNumber;
            }

            public void setCardNumber(String cardNumber) {
                this.cardNumber = cardNumber;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getOrgId() {
                return orgId;
            }

            public void setOrgId(String orgId) {
                this.orgId = orgId;
            }
        }
    }
}
