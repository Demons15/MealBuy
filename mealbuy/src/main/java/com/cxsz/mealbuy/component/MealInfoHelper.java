package com.cxsz.mealbuy.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.bean.MealInfoBean;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化相关参数
 */
public class MealInfoHelper {

    private String weChatAppId;
    private String mealAppId;
    private String mealSecret;
    private String mealNonceStr;
    private String number;
    private MealInfoBean.BodyBean mealInfoBeans;
    private List<MealGoodsBean.MealGoodsBodyBean> mainMealGoodsList;//主套餐列表
    private List<MealGoodsBean.MealGoodsBodyBean> voiceMealGoodsList;//语音叠加包列表
    private List<MealGoodsBean.MealGoodsBodyBean> flowMealGoodsList;//流量叠加包列表
    private boolean isDebugHost;
    public IWXAPI iwxapi;

    private MealInfoHelper() {
    }

    public void init(Context context, String weChatAppId, String mealAppId, String mealSecret, String mealNonceStr) {
        this.weChatAppId = weChatAppId;
        this.mealAppId = mealAppId;
        this.mealSecret = mealSecret;
        this.mealNonceStr = mealNonceStr;
        iwxapi = WXAPIFactory.createWXAPI(context, weChatAppId);
        // 将该app注册到微信
        iwxapi.registerApp(weChatAppId);
    }

    private static class Holder {
        private static MealInfoHelper instance = new MealInfoHelper();
    }

    public static MealInfoHelper getInstance() {
        return MealInfoHelper.Holder.instance;
    }

    public String getWeChatAppId() {
        return weChatAppId;
    }

    public void setWeChatAppId(String weChatAppId) {
        this.weChatAppId = weChatAppId;
    }

    public String getMealAppId() {
        return mealAppId;
    }

    public void setMealAppId(String mealAppId) {
        this.mealAppId = mealAppId;
    }

    public String getMealSecret() {
        return mealSecret;
    }

    public void setMealSecret(String mealSecret) {
        this.mealSecret = mealSecret;
    }

    public String getMealNonceStr() {
        return mealNonceStr;
    }

    public void setMealNonceStr(String mealNonceStr) {
        this.mealNonceStr = mealNonceStr;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<MealGoodsBean.MealGoodsBodyBean> getMainMealGoodsList() {
        return mainMealGoodsList;
    }

    public void setMainMealGoodsList(List<MealGoodsBean.MealGoodsBodyBean> mainMealGoodsList) {
        this.mainMealGoodsList = mainMealGoodsList;
    }

    public List<MealGoodsBean.MealGoodsBodyBean> getVoiceMealGoodsList() {
        return voiceMealGoodsList;
    }

    public void setVoiceMealGoodsList(List<MealGoodsBean.MealGoodsBodyBean> voiceMealGoodsList) {
        this.voiceMealGoodsList = voiceMealGoodsList;
    }

    public List<MealGoodsBean.MealGoodsBodyBean> getFlowMealGoodsList() {
        return flowMealGoodsList;
    }

    public void setFlowMealGoodsList(List<MealGoodsBean.MealGoodsBodyBean> flowMealGoodsList) {
        this.flowMealGoodsList = flowMealGoodsList;
    }

    public MealInfoBean.BodyBean getMealInfoBeans() {
        return mealInfoBeans;
    }

    public void setMealInfoBeans(MealInfoBean.BodyBean mealInfoBeans) {
        this.mealInfoBeans = mealInfoBeans;
    }

    public static void doStartApplicationWithPackageName(Activity activity, String action) {
        Intent intent = new Intent();
        intent.setAction(action);    // 通过intent隐式跳转进行跳转
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        activity.startActivity(intent);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void setHostIsDebug(boolean isDebug) {
        isDebugHost = isDebug;
    }

    public String getHostUrl() {
        if (!isDebugHost) {
            //App内接口回调的生产环境主机名
            return "http://iapi.ai-boss.net/api/v2/";
        }
        //App内接口回调的测试环境主机名
        return "http://testiapi.cwucloud.com/api/v2/";
    }
}
