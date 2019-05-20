package com.cxsz.mealbuy.presenter.presenterImpl;

import android.content.Context;

import com.cxsz.mealbuy.bean.ChooseNumberBean;
import com.cxsz.mealbuy.model.callback.CallBack;
import com.cxsz.mealbuy.model.modelImpl.ChoosePhoneNumberModelImpl;
import com.cxsz.mealbuy.model.modelInterface.ChoosePhoneNumberModel;
import com.cxsz.mealbuy.presenter.presenterInterface.ChoosePhoneNumberPresenter;
import com.cxsz.mealbuy.view.viewInterface.ChoosePhoneNumberView;

import java.util.List;

public class ChoosePhoneNumberPresenterImpl implements ChoosePhoneNumberPresenter {
    private ChoosePhoneNumberView mChoosePhoneNumberView;
    private final ChoosePhoneNumberModel choosePhoneNumberModel;

    public ChoosePhoneNumberPresenterImpl(ChoosePhoneNumberView choosePhoneNumberView) {
        this.mChoosePhoneNumberView = choosePhoneNumberView;
        choosePhoneNumberModel = new ChoosePhoneNumberModelImpl();
    }

    @Override
    public void RequestQueryChooseNumber(Context context, String tempIccid, String pageNumber, String number, String pageSize) {
        mChoosePhoneNumberView.showLoadingView();
        choosePhoneNumberModel.RequestQueryChooseNumber(context, tempIccid, pageNumber, number, pageSize, new CallBack() {
            @Override
            public void onSuccess(Object response) {
                List<ChooseNumberBean.BodyBean.ListBean> listBeans = (List<ChooseNumberBean.BodyBean.ListBean>) response;
                mChoosePhoneNumberView.ResponseQueryChooseNumber(listBeans);
                mChoosePhoneNumberView.closeLoadingView();
            }

            @Override
            public void onError(String error) {
                if (error != null) {
                    mChoosePhoneNumberView.showErrorInfo(error);
                }
                mChoosePhoneNumberView.closeLoadingView();
            }
        });
    }
}
