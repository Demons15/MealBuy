package com.cxsz.mealbuy.model.callback;

public interface CallBack<T> {
    void onSuccess(T response);

    void onError(String error);

}
