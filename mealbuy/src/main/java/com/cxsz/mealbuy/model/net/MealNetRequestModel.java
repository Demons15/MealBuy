package com.cxsz.mealbuy.model.net;

import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.model.net.MealProgressSubscriber;

/**
 * Created by yangqian on 2017/7/26.
 */

public interface MealNetRequestModel {

    //卡信息查询.
    void getSimByParam(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber);

    //卡查询当前卡正使用以及未启用套餐接口
    void getSimPackage(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber);

    //获取卡可购买套餐列表.
    void getGoodsRelevance(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber);


    //选号查询
    void queryChooseNumber(MealProgressSubscriber<MealCodeData> subscriber, String tempIccid, String number, String pageNum, String pageSize);

    //选号确认
    void chooseNumber(MealProgressSubscriber<MealCodeData> subscriber, String tempIccid, String cardNumber);

    //购买套餐
    void confirmOrder(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber, String goodsRelevance);

    //创建订单
    void createNewOrder(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber,
                        String dealMode, String packageEndTime, String packageEndTimeNew, String goodsId, String goodsDescribe);

    //支付订单
    void payOrder(MealProgressSubscriber<MealCodeData> subscriber, String cardNumber);

}
