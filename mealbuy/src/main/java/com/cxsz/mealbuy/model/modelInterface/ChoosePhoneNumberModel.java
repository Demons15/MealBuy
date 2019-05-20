package com.cxsz.mealbuy.model.modelInterface;

import android.content.Context;

import com.cxsz.mealbuy.model.callback.CallBack;

public interface ChoosePhoneNumberModel {
    void RequestQueryChooseNumber(Context context, String tempIccid, String pageNumber, String number, String pageSize, CallBack callBack);
}
