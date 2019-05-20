package com.cxsz.mealbuy.model.modelImpl;

import android.content.Context;

import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelInterface.BusinessManagementModel;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.model.net.MealNetRequestModelImpl;
import com.cxsz.mealbuy.model.net.MealProgressSubscriber;
import com.cxsz.mealbuy.model.net.MealSubscriberOnNextListener;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

public class BusinessManagementModelImpl implements BusinessManagementModel {
    @Override
    public void RequestGetGoodsRelevance(Context context, String iccid, CallBack callBack) {
        ArrayList<MealGoodsBean.MealGoodsBodyBean> bodyBeans = new ArrayList<>();
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {
            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {
                    ArrayList dataBody = (ArrayList) codeData.getBody();
                    for (int i = 0; i < dataBody.size(); i++) {
                        LinkedTreeMap mapData = (LinkedTreeMap) dataBody.get(i);
                        MealGoodsBean.MealGoodsBodyBean bodyBean = new MealGoodsBean.MealGoodsBodyBean();
                        bodyBean.getMealInfo(mapData, bodyBean);
                        bodyBeans.add(bodyBean);
                    }
                } else {
                    callBack.onError(codeData.getMessage());
                }
                callBack.onSuccess(bodyBeans);

            }

            @Override
            public void onError(Throwable e) {
                callBack.onError(e.getMessage().toString());
                callBack.onSuccess(bodyBeans);
            }
        };
        MealNetRequestModelImpl.getInstance().getGoodsRelevance(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true), iccid);
    }
}
