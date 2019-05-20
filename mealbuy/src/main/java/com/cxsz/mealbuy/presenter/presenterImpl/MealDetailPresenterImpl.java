package com.cxsz.mealbuy.presenter.presenterImpl;

import android.content.Context;

import com.cxsz.mealbuy.bean.ConfirmOrderResultBean;
import com.cxsz.mealbuy.bean.CreateOrderResultBean;
import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.callback.ResponseCallBack;
import com.cxsz.mealbuy.model.modelImpl.MealDetailModelImpl;
import com.cxsz.mealbuy.model.modelInterface.MealDetailModel;
import com.cxsz.mealbuy.presenter.presenterInterface.MealDetailPresenter;
import com.cxsz.mealbuy.view.viewInterface.MealDetailView;
import com.tencent.mm.opensdk.openapi.IWXAPI;

public class MealDetailPresenterImpl implements MealDetailPresenter {
    private MealDetailView mMealDetailView;
    private final MealDetailModel mealDetailModel;

    public MealDetailPresenterImpl(MealDetailView mealDetailView) {
        this.mMealDetailView = mealDetailView;
        mealDetailModel = new MealDetailModelImpl();
    }

    @Override
    public void RequestConfirmOrder(Context context, MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean) {
        mMealDetailView.showLoadingView();
        mealDetailModel.RequestConfirmOrder(context, mealGoodsBodyBean, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                mMealDetailView.ResponseConfirmOrder(response);
                mMealDetailView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    mMealDetailView.showErrorInfo(error);
                }
                mMealDetailView.closeLoadingView();
            }
        });
    }

    @Override
    public void RequestCreateOrder(Context context, MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean, ConfirmOrderResultBean confirmOrderResultBean) {
        mMealDetailView.showLoadingView();
        mealDetailModel.RequestCreateOrder(context, mealGoodsBodyBean, confirmOrderResultBean, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                mMealDetailView.ResponseCreateOrder(response);
                mMealDetailView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    mMealDetailView.showErrorInfo(error);
                }
                mMealDetailView.closeLoadingView();
            }

        });
    }

    @Override
    public void RequestPayForOrder(IWXAPI api, String weChatAppId, CreateOrderResultBean createOrderResultBean) {
        mealDetailModel.RequestPayForOrder(api, weChatAppId, createOrderResultBean, new ResponseCallBack() {

            @Override
            public void onResponse(String info) {
                mMealDetailView.ResponsePayForOrder(info);
            }
        });
    }
}
