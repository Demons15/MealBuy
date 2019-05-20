package com.cxsz.mealbuy.view.viewInterface;

public interface MineMealView extends BaseView {
    <T> void ResponseSimCardMealInfo(T t);

    <T> void ResponseSimCardMealList(T t);
}
