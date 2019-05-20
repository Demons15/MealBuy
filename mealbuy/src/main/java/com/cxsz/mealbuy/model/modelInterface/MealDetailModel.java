package com.cxsz.mealbuy.model.modelInterface;

import android.content.Context;

import com.cxsz.mealbuy.bean.ConfirmOrderResultBean;
import com.cxsz.mealbuy.bean.CreateOrderResultBean;
import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.callback.ResponseCallBack;
import com.tencent.mm.opensdk.openapi.IWXAPI;

public interface MealDetailModel {

    void RequestConfirmOrder(Context context, MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean, CallBack callBack);

    void RequestCreateOrder(Context context, MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean,ConfirmOrderResultBean confirmOrderResultBean, CallBack callBack);

    void RequestPayForOrder(IWXAPI api, String weChatAppId, CreateOrderResultBean createOrderResultBean, ResponseCallBack callBack);

}
