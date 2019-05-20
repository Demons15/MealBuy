package com.cxsz.mealbuy.presenter.presenterInterface;

import android.content.Context;

public interface MineMealPresenter {
    void RequestSimCardMealInfo(Context context, String iccid);

    void RequestSimCardMealList(Context context, String iccid);
}
