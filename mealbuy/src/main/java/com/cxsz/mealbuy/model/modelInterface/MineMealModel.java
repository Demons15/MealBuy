package com.cxsz.mealbuy.model.modelInterface;

import android.content.Context;

import com.cxsz.mealbuy.model.callback.CallBack;

public interface MineMealModel {
    void RequestSimCardMealInfo(Context context, String iccid, CallBack callBack);

    void RequestSimCardMealList(Context context, String iccid, CallBack callBack);
}
