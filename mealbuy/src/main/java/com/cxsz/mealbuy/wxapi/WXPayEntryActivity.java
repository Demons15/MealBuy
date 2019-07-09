package com.cxsz.mealbuy.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private static final String TAG = "WXPayEntryActivity";
    private IWXAPI api;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechat_pay_result);
        api = MealInfoHelper.getInstance().iwxapi;
        api.handleIntent(getIntent(), this);
    }


    @Override
    public void onReq(BaseReq req) {

    }

    @Override
    public void onResp(BaseResp resp) {
        Log.d(TAG, "onPayFinish, errCode = " + resp.errCode);
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            int code = resp.errCode;
            switch (code) {
                case 0:
                    Log.d(TAG, "onPayFinish, errCode = " + "支付成功");
                    //微信支付成功后去调后台，以后台返回的支付结果为准
                    //这里是微信支付完成后的回调，在这里请求后台，让他来告诉我们到底支付成功没。
                    MealInfoHelper.doStartApplicationWithPackageName(WXPayEntryActivity.this,"com.concat.mineMeal");
                    finish();
                    break;
                case -1:
                    Toast.makeText(this, "支付失败1", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onPayFinish, errCode = " + "支付失败1");
                    finish();
                    break;
                case -2:
                    Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onPayFinish, errCode = " + "支付取消");
                    finish();
                    break;
                default:
//                    Toast.makeText(this, "支付失败2", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onPayFinish, errCode = " + "支付失败2");
                    setResult(RESULT_OK);
                    finish();
                    break;
            }

        }
    }
}