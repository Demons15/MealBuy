package com.cxsz.mealbuy;

import android.app.Application;

import com.cxsz.mealbuy.component.MealInfoHelper;

public class App extends Application {
    public static final String APP_ID_WEI_XIN = "wxf4c31c80fc070ed9";//微信登录appid
    public static final String APP_ID = "CFBBFBD78EC2731A4208A4802E4A3DE9";
    public static final String MEAL_SECRET = "D9CF4912EA8C0ECB70B11592C9BD2900";
    public static final String NONCE_STR = "sanjitongchuanandchanxingshenzhou";

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化套餐购买相关信息
        MealInfoHelper.getInstance().init(this, APP_ID_WEI_XIN, APP_ID, MEAL_SECRET, NONCE_STR);
        //初始化主机环境
        MealInfoHelper.getInstance().setHostIsDebug(false);
    }
}
