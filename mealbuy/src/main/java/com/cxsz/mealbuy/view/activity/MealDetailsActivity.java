package com.cxsz.mealbuy.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cxsz.mealbuy.component.KeyConstants;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.base.BaseActivity;
import com.cxsz.mealbuy.bean.ConfirmOrderResultBean;
import com.cxsz.mealbuy.bean.CreateOrderResultBean;
import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.component.ToastUtil;
import com.cxsz.mealbuy.presenter.presenterImpl.MealDetailPresenterImpl;
import com.cxsz.mealbuy.presenter.presenterInterface.MealDetailPresenter;
import com.cxsz.mealbuy.view.viewInterface.MealDetailView;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

public class MealDetailsActivity extends BaseActivity implements View.OnClickListener, MealDetailView {
    RadioGroup packageShowWay;
    RadioButton packageUpgrade;
    RadioButton packageBuy;
    RadioGroup payWayGroup;
    RadioButton weChatPay;
    RadioButton accountPay;
    LinearLayout payRightNow;
    TextView phoneNumber;
    TextView packageTitle;
    TextView packageUnitPrice;
    TextView monthlyAverageCost;
    TextView packageDetailInfo;
    TextView termOfValidity;
    TextView toBePaid;

    private MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean;
    private IWXAPI api;
    private View leftIcon;
    private MealDetailPresenter mealDetailPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.package_details_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        leftIcon = findViewById(R.id.base_left_iv);
        packageShowWay = findViewById(R.id.package_show_way);
        packageUpgrade = findViewById(R.id.package_upgrade);
        packageBuy = findViewById(R.id.package_buy);
        payWayGroup = findViewById(R.id.pay_way_group);
        weChatPay = findViewById(R.id.we_chat_pay);
        accountPay = findViewById(R.id.account_pay);
        payRightNow = findViewById(R.id.pay_right_now);
        phoneNumber = findViewById(R.id.phone_number);
        packageTitle = findViewById(R.id.package_title);
        packageUnitPrice = findViewById(R.id.package_unit_price);
        monthlyAverageCost = findViewById(R.id.monthly_average_cost);
        packageDetailInfo = findViewById(R.id.package_detail_info);
        termOfValidity = findViewById(R.id.term_of_validity);
        toBePaid = findViewById(R.id.to_be_paid);
        leftIcon.setOnClickListener(this);
        payRightNow.setOnClickListener(this);
        api = MealInfoHelper.getInstance().iwxapi;
        mealGoodsBodyBean = (MealGoodsBean.MealGoodsBodyBean) getIntent().getSerializableExtra(KeyConstants.PACKET_INFO);
        initPackageInfo(mealGoodsBodyBean);
        packageShowWay.setOnCheckedChangeListener(packageOnCheckedChangeListener);
        packageShowWay.check(R.id.package_buy);
        payWayGroup.setOnCheckedChangeListener(payOnCheckedChangeListener);
        payWayGroup.check(R.id.we_chat_pay);
        mealDetailPresenter = new MealDetailPresenterImpl(this);
    }

    /**
     * 初始化套餐信息
     *
     * @param mealGoodsBodyBean
     */
    private void initPackageInfo(MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean) {
        phoneNumber.setText(mealGoodsBodyBean.getCardNumber());
        packageTitle.setText(mealGoodsBodyBean.getShortName());
        packageUnitPrice.setText(mealGoodsBodyBean.getUnitPrice() + "元");
        monthlyAverageCost.setText("（月均¥" + (double) Math.round((mealGoodsBodyBean.getUnitPrice() / mealGoodsBodyBean.getValidityDuration()) * 100) / 100 + ")");
        if ((int) mealGoodsBodyBean.getPackageTraffic() == -1 && (int) mealGoodsBodyBean.getCallDuration() > 0) {
            packageDetailInfo.setText("套餐包含：无限流量+" + (int) mealGoodsBodyBean.getCallDuration() + "分钟语音/月");
        } else if ((int) mealGoodsBodyBean.getPackageTraffic() == 0 && (int) mealGoodsBodyBean.getCallDuration() > 0) {
            packageDetailInfo.setText("套餐包含：" + (int) mealGoodsBodyBean.getCallDuration() + "分钟语音/月");
        } else if ((int) mealGoodsBodyBean.getPackageTraffic() > 0 && (int) mealGoodsBodyBean.getCallDuration() > 0) {
            packageDetailInfo.setText("套餐包含：" + (int) mealGoodsBodyBean.getPackageTraffic() + "M流量+" + (int) mealGoodsBodyBean.getCallDuration() + "分钟语音/月");
        } else if ((int) mealGoodsBodyBean.getPackageTraffic() > 0 && (int) mealGoodsBodyBean.getCallDuration() == 0) {
            packageDetailInfo.setText("套餐包含：" + (int) mealGoodsBodyBean.getPackageTraffic() + "M流量/月");
        } else if ((int) mealGoodsBodyBean.getPackageTraffic() == -1 && (int) mealGoodsBodyBean.getCallDuration() == 0) {
            packageDetailInfo.setText("套餐包含：无限流量/月");
        }
        termOfValidity.setText("有效期：" + (int) mealGoodsBodyBean.getValidityDuration() + "个月");
        toBePaid.setText("需支付：" + mealGoodsBodyBean.getUnitPrice() + "元");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.base_left_iv) {
            finish();
        } else if (v.getId() == R.id.pay_right_now) {
            mealDetailPresenter.RequestConfirmOrder(MealDetailsActivity.this, mealGoodsBodyBean);
        }
    }

    RadioGroup.OnCheckedChangeListener payOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

        }
    };

    RadioGroup.OnCheckedChangeListener packageOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

        }
    };

    /**
     * 确认订单结果回调
     *
     * @param t
     * @param <T>
     */
    @Override
    public <T> void ResponseConfirmOrder(T t) {
        ConfirmOrderResultBean confirmOrderResultBean = (ConfirmOrderResultBean) t;
        mealDetailPresenter.RequestCreateOrder(MealDetailsActivity.this, mealGoodsBodyBean, confirmOrderResultBean);
    }

    /**
     * 创建订单结果回调
     *
     * @param t
     * @param <T>
     */
    @Override
    public <T> void ResponseCreateOrder(T t) {
        CreateOrderResultBean createOrderResultBean = (CreateOrderResultBean) t;
        mealDetailPresenter.RequestPayForOrder(api, MealInfoHelper.getInstance().getWeChatAppId(), createOrderResultBean);
//        EventBus.getDefault().post(createOrderResultBean);
    }

    /**
     * 支付接口回调
     *
     * @param t
     * @param <T>
     */
    @Override
    public <T> void ResponsePayForOrder(T t) {
        ToastUtil.show(MealDetailsActivity.this, (String) t);
        finish();
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
        if (info != null) {
            ToastUtil.show(this, info);
        }
    }
}
