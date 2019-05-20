package com.cxsz.mealbuy.model.modelImpl;

import android.content.Context;
import com.cxsz.mealbuy.bean.MealInfoBean;
import com.cxsz.mealbuy.bean.SimPackageBean;
import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelInterface.MineMealModel;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.model.net.MealNetRequestModelImpl;
import com.cxsz.mealbuy.model.net.MealProgressSubscriber;
import com.cxsz.mealbuy.model.net.MealSubscriberOnNextListener;
import com.google.gson.internal.LinkedTreeMap;
public class MineMealModelImpl implements MineMealModel {
    @Override
    public void RequestSimCardMealInfo(Context context, String iccid, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {
                    MealInfoBean.BodyBean bodyBean = new MealInfoBean.BodyBean();
                    LinkedTreeMap codeDataBody = (LinkedTreeMap) codeData.getBody();
                    bodyBean.getSimPackageInfo(codeDataBody, bodyBean);
                    callBack.onSuccess(bodyBean);
                } else {
                    callBack.onError(codeData.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage().toString());
            }
        };
        MealNetRequestModelImpl.getInstance().getSimByParam(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true), iccid);
    }

    @Override
    public void RequestSimCardMealList(Context context, String iccid, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> networkSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(MealCodeData codeData) {
                if (codeData.getCode() == 1) {
                    callBack.onSuccess(codeData.getBody());
                }
            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().getSimPackage(new MealProgressSubscriber<MealCodeData>(networkSubscriberOnNextListener, context), iccid);
    }
}
