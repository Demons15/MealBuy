package com.cxsz.mealbuy.presenter.presenterImpl;

import android.content.Context;

import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelImpl.BusinessManagementModelImpl;
import com.cxsz.mealbuy.model.modelInterface.BusinessManagementModel;
import com.cxsz.mealbuy.presenter.presenterInterface.BusinessManagementPresenter;
import com.cxsz.mealbuy.view.viewInterface.BusinessManagementView;

import java.util.ArrayList;
import java.util.List;

public class BusinessManagementPresenterImpl implements BusinessManagementPresenter {
    private BusinessManagementView mBusinessManagementView;
    private BusinessManagementModel businessManagementModel;
    private List<MealGoodsBean.MealGoodsBodyBean> mainMealGoodsList = new ArrayList();//主套餐列表
    private List<MealGoodsBean.MealGoodsBodyBean> voiceMealGoodsList = new ArrayList();//语音叠加包列表
    private List<MealGoodsBean.MealGoodsBodyBean> flowMealGoodsList = new ArrayList();//流量叠加包列表

    public BusinessManagementPresenterImpl(BusinessManagementView businessManagementView) {
        this.mBusinessManagementView = businessManagementView;
        businessManagementModel = new BusinessManagementModelImpl();
    }

    @Override
    public void RequestGetGoodsRelevance(Context context, String iccid) {
        if (iccid != null) {
            mBusinessManagementView.showLoadingView();
            businessManagementModel.RequestGetGoodsRelevance(context, iccid, new CallBack() {
                @Override
                public void onSuccess(Object response) {
                    ArrayList<MealGoodsBean.MealGoodsBodyBean> body = (ArrayList<MealGoodsBean.MealGoodsBodyBean>) response;
                    if (!mainMealGoodsList.isEmpty()) {
                        mainMealGoodsList.clear();
                    }
                    if (!voiceMealGoodsList.isEmpty()) {
                        voiceMealGoodsList.clear();
                    }
                    if (!flowMealGoodsList.isEmpty()) {
                        flowMealGoodsList.clear();
                    }
                    for (int i = 0; i < body.size(); i++) {
                        MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean = body.get(i);
                        if (mealGoodsBodyBean.getCustomType().equals("1")) {
                            mainMealGoodsList.add(mealGoodsBodyBean);
                        } else if (mealGoodsBodyBean.getCustomType().equals("3")) {
                            if (mealGoodsBodyBean.getGoodsType().equals("O2")) {
                                voiceMealGoodsList.add(mealGoodsBodyBean);
                            } else if (mealGoodsBodyBean.getGoodsType().equals("O1")) {
                                flowMealGoodsList.add(mealGoodsBodyBean);
                            }
                        }
                    }
                    MealInfoHelper.getInstance().setMainMealGoodsList(mainMealGoodsList);
                    MealInfoHelper.getInstance().setFlowMealGoodsList(flowMealGoodsList);
                    MealInfoHelper.getInstance().setVoiceMealGoodsList(voiceMealGoodsList);
                    mBusinessManagementView.ResponseGetGoodsRelevance(response);
                    mBusinessManagementView.closeLoadingView();
                }

                @Override
                public void onError(String error) {
                    if (error != null) {
                        mBusinessManagementView.showErrorInfo(error);
                    }
                    mBusinessManagementView.closeLoadingView();
                }
            });
        } else {
            mBusinessManagementView.showErrorInfo("iccid不能为空！");
        }
    }
}
