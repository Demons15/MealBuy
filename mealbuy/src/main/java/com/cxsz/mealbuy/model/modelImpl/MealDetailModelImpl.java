package com.cxsz.mealbuy.model.modelImpl;

import android.content.Context;

import com.cxsz.mealbuy.bean.ConfirmOrderResultBean;
import com.cxsz.mealbuy.bean.CreateOrderResultBean;
import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.callback.ResponseCallBack;
import com.cxsz.mealbuy.model.modelInterface.MealDetailModel;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.model.net.MealNetRequestModelImpl;
import com.cxsz.mealbuy.model.net.MealProgressSubscriber;
import com.cxsz.mealbuy.model.net.MealSubscriberOnNextListener;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;

public class MealDetailModelImpl implements MealDetailModel {

    @Override
    public void RequestConfirmOrder(Context context, MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {
                    String s = new Gson().toJson(codeData);
                    ConfirmOrderResultBean confirmOrderResultBean = new Gson().fromJson(s, ConfirmOrderResultBean.class);
                    callBack.onSuccess(confirmOrderResultBean);
                } else {
                    callBack.equals(codeData.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                callBack.equals(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().confirmOrder(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                mealGoodsBodyBean.getIccid(), mealGoodsBodyBean.getGoodsId());
    }

    @Override
    public void RequestCreateOrder(Context context, MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean, ConfirmOrderResultBean confirmOrderResultBean, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {
                    String s = new Gson().toJson(codeData);
                    CreateOrderResultBean createOrderResultBean = new Gson().fromJson(s, CreateOrderResultBean.class);
                    callBack.onSuccess(createOrderResultBean);
                } else {
                    callBack.onError(codeData.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().createNewOrder(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true),
                mealGoodsBodyBean.getCardNumber(), confirmOrderResultBean.getBody().getGoodsRelevance().get(0).getEffectiveMode().get(0).getDealMode(),
                confirmOrderResultBean.getBody().getGoodsRelevance().get(0).getEffectiveMode().get(0).getOldPackageEndTime(),
                confirmOrderResultBean.getBody().getGoodsRelevance().get(0).getEffectiveMode().get(0).getPackageEndTime(),
                mealGoodsBodyBean.getGoodsId(), mealGoodsBodyBean.getGoodsDescribe());
    }

    @Override
    public void RequestPayForOrder(IWXAPI api, String weChatAppId, CreateOrderResultBean createOrderResultBean, ResponseCallBack callBack) {
        PayReq req = new PayReq();
        req.appId = weChatAppId;
        req.partnerId = createOrderResultBean.getBody().getPartnerId();
        req.prepayId = createOrderResultBean.getBody().getPrepayId();
        req.nonceStr = createOrderResultBean.getBody().getNonceStr();
        req.timeStamp = createOrderResultBean.getBody().getTimeStamp();
        req.packageValue = createOrderResultBean.getBody().getPackageX();
        req.sign = createOrderResultBean.getBody().getSign();
        callBack.onResponse("正在跳转支付,请稍后...");
        // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
        api.sendReq(req);
    }
}
