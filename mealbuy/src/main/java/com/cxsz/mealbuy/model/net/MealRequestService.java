package com.cxsz.mealbuy.model.net;
import com.cxsz.mealbuy.model.net.MealCodeData;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface MealRequestService {
    //套餐信息类
    //卡信息查询.
    //卡查询当前卡正使用以及未启用套餐接口
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/getSimByParam")
    Observable<MealCodeData> getSimByParam(@Body RequestBody cardInfo);

    //卡查询当前卡正使用以及未启用套餐接口
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/unactivePackage")
    Observable<MealCodeData> getSimPackage(@Body RequestBody cardInfo);

    //获取卡可购买套餐列表.
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/getGoodsRelevance")
    Observable<MealCodeData> getGoodsRelevance(@Body RequestBody body);


    //选号查询
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("queryChooseNumber")
    Observable<MealCodeData> queryChooseNumber(@Body RequestBody body);

    //选号确认
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("chooseNumber")
    Observable<MealCodeData> chooseNumber(@Body RequestBody body);

    //购买套餐
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/confirmOrder")
    Observable<MealCodeData> confirmOrder(@Body RequestBody body);

    //创建订单
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("third/createNewOrder")
    Observable<MealCodeData> createNewOrder(@Body RequestBody body);

    //支付订单
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST(" third/payOrder")
    Observable<MealCodeData> payOrder(@Body RequestBody body);
}
