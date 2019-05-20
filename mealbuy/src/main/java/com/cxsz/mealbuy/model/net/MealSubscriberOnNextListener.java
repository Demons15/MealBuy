package com.cxsz.mealbuy.model.net;

/**
 * Created by yangqian on 2017/2/26.
 */

public interface MealSubscriberOnNextListener<T> {
    void onNext(T t);

    void onError(Throwable e);

}
