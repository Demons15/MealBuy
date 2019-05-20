package com.cxsz.mealbuy.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;


import com.cxsz.mealbuy.component.LoadingDialog;

import razerdp.basepopup.BasePopupWindow;

public abstract class BaseWindowView extends BasePopupWindow {
    private LoadingDialog loadingWindows;

    public BaseWindowView(Context context) {
        super(context);
        initView();
    }

    public BaseWindowView(Context context, int popupGravity) {
        super(context);
        setPopupGravity(popupGravity);
        initView();
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(getLayoutId());
    }

    //获取布局
    protected abstract int getLayoutId();

    //初始化布局和监听
    protected abstract void initView();

    /**
     * 开启加载效果
     */
    public void startProgressDialog() {
        if (loadingWindows == null) {
            loadingWindows = new LoadingDialog((Activity) getContext());
        }
        loadingWindows.show();
    }

    /**
     * 关闭加载
     */
    public void stopProgressDialog() {
        if (loadingWindows != null) {
            loadingWindows.dismiss();
            loadingWindows = null;
        }
    }
}
