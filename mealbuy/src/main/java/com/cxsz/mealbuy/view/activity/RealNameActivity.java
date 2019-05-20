package com.cxsz.mealbuy.view.activity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.component.ToastUtil;
import com.cxsz.mealbuy.base.BaseActivity;
import com.cxsz.mealbuy.bean.MealInfoBean;
import com.cxsz.mealbuy.component.AndroidBugWorkRound;
import com.cxsz.mealbuy.presenter.presenterImpl.MineMealPresenterImpl;
import com.cxsz.mealbuy.presenter.presenterInterface.MineMealPresenter;
import com.cxsz.mealbuy.view.viewInterface.MineMealView;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;

public class RealNameActivity extends BaseActivity implements View.OnClickListener, MineMealView {
    TextView title;
    View rightIcon; //收起提示框
    View noticeArea;
    TextView cardNumber;
    TextView copyCardNumber;
    TextView iccidNumber;
    TextView copyIccid;  //复制后四位/复制ICCID
    LinearLayout realNameWebView;

    private boolean isHideNotice = false;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private String realnameUrl = "";
    protected AgentWeb mAgentWeb;
    private View leftIcon;
    private MineMealPresenter mineMealPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.real_name_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        AndroidBugWorkRound.assistActivity(this);
        title = findViewById(R.id.main_title_tv);
        leftIcon = findViewById(R.id.main_left_iv);
        rightIcon = findViewById(R.id.main_right_iv);
        noticeArea = findViewById(R.id.notice_area);
        cardNumber = findViewById(R.id.card_number);
        copyCardNumber = findViewById(R.id.copy_card_number);
        iccidNumber = findViewById(R.id.iccid_number);
        copyIccid = findViewById(R.id.copy_iccid);
        realNameWebView = findViewById(R.id.real_name_web_view);
        leftIcon.setOnClickListener(this);
        rightIcon.setOnClickListener(this);
        copyCardNumber.setOnClickListener(this);
        copyIccid.setOnClickListener(this);
        title.setText("实名认证");
        mineMealPresenter = new MineMealPresenterImpl(this);
        mineMealPresenter.RequestSimCardMealInfo(RealNameActivity.this, MealInfoHelper.getInstance().getNumber());
        myClipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }


    private com.just.agentweb.WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
            Log.i("Info", "BaseWebActivity onPageStarted");
            startProgressDialog();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            noticeArea.setVisibility(View.VISIBLE);
            rightIcon.setVisibility(View.VISIBLE);
            stopProgressDialog();
        }

        @SuppressLint("NewApi")
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            ToastUtil.show(RealNameActivity.this, error.getDescription().toString() + "");
            stopProgressDialog();
        }
    };
    private com.just.agentweb.WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
//            Log.i("Info","onProgress:"+newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onResume();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i("Info", "onResult:" + requestCode + " onResult:" + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
    }


    protected void onDestroy() {
        super.onDestroy();
        //mAgentWeb.destroy();
        if (mAgentWeb != null) {
            mAgentWeb.getWebLifeCycle().onDestroy();
        }
    }

    public void copySomeThing(String info, String tag) {
        myClip = ClipData.newPlainText("text", info);
        myClipboard.setPrimaryClip(myClip);
        ToastUtil.show(RealNameActivity.this, "已将" + tag + "复制");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.main_left_iv) {
            finish();
        } else if (view.getId() == R.id.main_right_iv) {
            if (isHideNotice == false) {
                noticeArea.setVisibility(View.GONE);
                isHideNotice = true;
            } else {
                noticeArea.setVisibility(View.VISIBLE);
                isHideNotice = false;
            }
        } else if (view.getId() == R.id.copy_card_number) {
            copySomeThing(cardNumber.getText().toString(), "物联网卡号");
        } else if (view.getId() == R.id.copy_iccid) {
            if (realnameUrl.contains("wap.fj.10086.cn")) {
                String iccid = iccidNumber.getText().toString();
                String substring = iccid.substring(iccid.length() - 4, iccid.length());
                copySomeThing(substring, "ICCID号后四位");
            } else {
                copySomeThing(iccidNumber.getText().toString(), "ICCID号");
            }
        }
    }

    @Override
    public <T> void ResponseSimCardMealInfo(T t) {
        MealInfoBean.BodyBean bodyBean = (MealInfoBean.BodyBean) t;
        MealInfoHelper.getInstance().setMealInfoBeans(bodyBean);
        MealInfoBean.BodyBean mealInfoBeans = MealInfoHelper.getInstance().getMealInfoBeans();
        cardNumber.setText(mealInfoBeans.getCardNumber() + "");
        iccidNumber.setText("ICCID：" + mealInfoBeans.getIccid() + "");
        if (mealInfoBeans.getRealnameUrl() != null) {
            realnameUrl = mealInfoBeans.getRealnameUrl();
        }
        if (realnameUrl.contains("wap.fj.10086.cn")) {
            copyIccid.setText("复制后四位");
        } else {
            copyIccid.setText("复制ICCID");
        }
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(realNameWebView, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
                .interceptUnkownUrl() //拦截找不到相关页面的Scheme
                .createAgentWeb()
                .ready()
                .go(realnameUrl);
    }

    @Override
    public <T> void ResponseSimCardMealList(T t) {

    }

    @Override
    public void showLoadingView() {
        startProgressDialog();
    }

    @Override
    public void closeLoadingView() {
        stopProgressDialog();
    }

    @Override
    public void showErrorInfo(String info) {
        ToastUtil.show(RealNameActivity.this, info);
    }
}
