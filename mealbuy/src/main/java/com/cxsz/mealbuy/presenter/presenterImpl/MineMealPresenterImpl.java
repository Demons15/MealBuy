package com.cxsz.mealbuy.presenter.presenterImpl;

import android.content.Context;

import com.cxsz.mealbuy.bean.MealInfoBean;
import com.cxsz.mealbuy.bean.SimPackageBean;
import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelImpl.MineMealModelImpl;
import com.cxsz.mealbuy.model.modelInterface.MineMealModel;
import com.cxsz.mealbuy.presenter.presenterInterface.MineMealPresenter;
import com.cxsz.mealbuy.view.viewInterface.MineMealView;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;

public class MineMealPresenterImpl implements MineMealPresenter {
    private MineMealView mMineMealView;
    private MineMealModel mineMealModel;
    private ArrayList<SimPackageBean.BodyBean> simPackageList = new ArrayList<SimPackageBean.BodyBean>();

    public MineMealPresenterImpl(MineMealView mineMealView) {
        mineMealModel = new MineMealModelImpl();
        this.mMineMealView = mineMealView;
    }

    @Override
    public void RequestSimCardMealInfo(Context context, String iccid) {
        mMineMealView.showLoadingView();
        mineMealModel.RequestSimCardMealInfo(context, iccid, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                MealInfoBean.BodyBean bodyBean = (MealInfoBean.BodyBean) response;
                mMineMealView.ResponseSimCardMealInfo(bodyBean);
                mMineMealView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    mMineMealView.showErrorInfo(error);
                }
                mMineMealView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestSimCardMealList(Context context, String iccid) {
        mMineMealView.showLoadingView();
        mineMealModel.RequestSimCardMealList(context, iccid, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                ArrayList dataBody = (ArrayList) response;
                if (!simPackageList.isEmpty()) {
                    simPackageList.clear();
                }
                for (int i = 0; i < dataBody.size(); i++) {
                    LinkedTreeMap mapData = (LinkedTreeMap) dataBody.get(i);
                    SimPackageBean.BodyBean bodyBean = new SimPackageBean.BodyBean();
                    bodyBean.getSimPackageInfo(mapData, bodyBean);
                    simPackageList.add(bodyBean);
                }
                mMineMealView.ResponseSimCardMealList(simPackageList);
                mMineMealView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    mMineMealView.showErrorInfo(error);
                }
                mMineMealView.closeLoadingView();
            }
        });
    }
}
