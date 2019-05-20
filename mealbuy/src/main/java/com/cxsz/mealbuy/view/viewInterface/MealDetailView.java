package com.cxsz.mealbuy.view.viewInterface;

public interface MealDetailView extends BaseView {

    <T> void ResponseConfirmOrder(T t);

    <T> void ResponseCreateOrder(T t);

    <T> void ResponsePayForOrder(T t);
}
