package com.cxsz.mealbuy.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.LoadingDialog;


public abstract class BaseDialogView implements DialogInterface.OnDismissListener {
    public Activity mContext;
    public Dialog mDialog;
    public ViewGroup dialogView;//附加Dialog 的 根View
    protected ViewGroup contentContainer;
    private ShowType mType;
    private LoadingDialog loadingWindows;

    public BaseDialogView(Activity activity, ShowType type) {
        this.mContext = activity;
        this.mType = type;
        initViews();
        initViewInfo();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {

    }

    public enum ShowType {
        RIGHT, LEFT, CENTER, BOTTOM, TOP
    }

    protected void initViews() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        //如果是对话框模式
        dialogView = (ViewGroup) layoutInflater.inflate(R.layout.base_pop_layout, null, true);
        //设置界面的背景为透明
        dialogView.setBackgroundColor(Color.TRANSPARENT);
        //这个是真正要加载选择器的父布局
        contentContainer = (ViewGroup) dialogView.findViewById(R.id.content_container);
        //设置对话框 默认左右间距屏幕30
//        params.leftMargin = 30;
//        params.rightMargin = 30;
        contentContainer.setLayoutParams(params);
        //创建对话框
        createDialog();
    }

    public abstract void initViewInfo();

    public void createDialog() {
        if (dialogView != null) {
            mDialog = new Dialog(mContext, R.style.custom_dialog);
            mDialog.setCancelable(true);//不能点外面取消,也不能点back取消
            mDialog.setContentView(dialogView);
            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(R.style.loading_scale_anim);
                if (mType == ShowType.CENTER) {
                    dialogWindow.setGravity(Gravity.CENTER);//可以改成Bottom
                } else if (mType == ShowType.BOTTOM) {
                    dialogWindow.setGravity(Gravity.BOTTOM);//可以改成Bottom
                } else if (mType == ShowType.LEFT) {
                    dialogWindow.setGravity(Gravity.LEFT);//可以改成Bottom
                } else if (mType == ShowType.RIGHT) {
                    dialogWindow.setGravity(Gravity.RIGHT);//可以改成Bottom
                } else if (mType == ShowType.TOP) {
                    dialogWindow.setGravity(Gravity.TOP);//可以改成Bottom
                }

            }
            mDialog.setOnDismissListener(this);
        }
    }

    public boolean isShow() {
        return mDialog.isShowing();
    }

    /**
     * 添加View到根视图
     */
    public void show() {
        showDialog();
    }

    private void showDialog() {
        if (mDialog != null) {
            mDialog.show();
        }
    }

    private void dismissDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    /**
     * 开启加载效果
     */
    public void startProgressDialog() {
        if (loadingWindows == null) {
            loadingWindows = new LoadingDialog(mContext);
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

    public void dismiss() {
        dismissDialog();
    }
}
