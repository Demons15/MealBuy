package com.cxsz.mealbuy.model.modelInterface;

import android.content.Context;

import com.cxsz.mealbuy.model.callback.CallBack;

public interface BusinessManagementModel {
    void RequestGetGoodsRelevance(Context context,String iccid, CallBack callBack);
}
