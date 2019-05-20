package com.cxsz.mealbuy.presenter.presenterInterface;

import android.content.Context;

import com.cxsz.mealbuy.view.viewInterface.BaseView;

public interface BusinessManagementPresenter {
    void RequestGetGoodsRelevance(Context context, String iccid);
}
