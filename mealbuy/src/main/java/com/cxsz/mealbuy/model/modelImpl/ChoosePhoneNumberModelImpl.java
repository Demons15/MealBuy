package com.cxsz.mealbuy.model.modelImpl;

import android.content.Context;

import com.cxsz.mealbuy.bean.ChooseNumberBean;
import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelInterface.ChoosePhoneNumberModel;
import com.cxsz.mealbuy.model.net.MealCodeData;
import com.cxsz.mealbuy.model.net.MealNetRequestModelImpl;
import com.cxsz.mealbuy.model.net.MealProgressSubscriber;
import com.cxsz.mealbuy.model.net.MealSubscriberOnNextListener;
import com.google.gson.Gson;

import java.util.List;

public class ChoosePhoneNumberModelImpl implements ChoosePhoneNumberModel {

    @Override
    public void RequestQueryChooseNumber(Context context, String tempIccid, String pageNumber, String number, String pageSize, CallBack callBack) {
        MealSubscriberOnNextListener<MealCodeData> bindSubscriberOnNextListener = new MealSubscriberOnNextListener<MealCodeData>() {

            @Override
            public void onNext(final MealCodeData codeData) {
                if (codeData.getCode() == 1) {
                    String s = new Gson().toJson(codeData);
                    ChooseNumberBean chooseNumberBean = new Gson().fromJson(s, ChooseNumberBean.class);
                    List<ChooseNumberBean.BodyBean.ListBean> listBeans = chooseNumberBean.getBody().getList();
                    callBack.onSuccess(listBeans);
                } else {
                    callBack.onSuccess(codeData.getMessage());
                }
            }

            @Override
            public void onError(Throwable e) {
                callBack.onSuccess(e.getMessage());
            }
        };
        MealNetRequestModelImpl.getInstance().queryChooseNumber(new MealProgressSubscriber<MealCodeData>(bindSubscriberOnNextListener, context, true), tempIccid, number, pageNumber, pageSize);
    }
}
