package com.cxsz.mealbuy.presenter.presenterInterface;

import android.content.Context;

public interface ChoosePhoneNumberPresenter {
    void RequestQueryChooseNumber(Context context, String tempIccid, String pageNumber, String number, String pageSize);
}
