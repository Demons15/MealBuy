package com.cxsz.mealbuy.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cxsz.mealbuy.component.MealCommonUtils;
import com.cxsz.mealbuy.component.KeyConstants;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.adapter.NoUseMealRecycleAdapter;
import com.cxsz.mealbuy.base.BaseActivity;
import com.cxsz.mealbuy.bean.MealInfoBean;
import com.cxsz.mealbuy.bean.SimPackageBean;
import com.cxsz.mealbuy.component.ToastUtil;
import com.cxsz.mealbuy.presenter.presenterImpl.MineMealPresenterImpl;
import com.cxsz.mealbuy.presenter.presenterInterface.MineMealPresenter;
import com.cxsz.mealbuy.view.viewInterface.MineMealView;

import java.util.ArrayList;

public class MineMealActivity extends BaseActivity implements View.OnClickListener, MineMealView {
    TextView cardNumber;//卡号
    TextView iccidNumber;//iccid号
    TextView cardStateInfo;//卡状态
    TextView realNameState;//实名状态
    TextView networkTypeInfo;//网络状态
    TextView updateTime;//更新套餐的时间
    TextView mealDataInfo;//套餐详情
    TextView flowUnit;
    TextView remainFlowSize;
    TextView allFlowSize;
    TextView haveUserFlowSize;
    ProgressBar flowDetailProgress;
    TextView haveUseFlowPercentSize;
    TextView remainFlowPercentSize;
    TextView buyFlowPackage;


    TextView remainVoiceSize;
    TextView allVoiceSize;
    TextView voiceHaveUserSize;
    ProgressBar voiceDetailProgress;
    TextView haveUseVoicePercentSize;
    TextView remainVoicePercentSize;
    TextView buyVoicePackage;


    TextView endTime;//到期时间
    RecyclerView noUseList;//暂未使用的套餐列表
    private View noUseArea;
    private MineMealPresenter mineMealPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.mine_package_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        View leftIcon = findViewById(R.id.base_left_iv);
        cardNumber = findViewById(R.id.card_number);
        iccidNumber = findViewById(R.id.iccid_number);
        cardStateInfo = findViewById(R.id.card_state_info);
        realNameState = findViewById(R.id.real_name_state);
        networkTypeInfo = findViewById(R.id.network_type_info);
        updateTime = findViewById(R.id.update_time);
        mealDataInfo = findViewById(R.id.meal_data_info);
        flowUnit = findViewById(R.id.flow_unit);
        remainFlowSize = findViewById(R.id.remain_flow_size);
        allFlowSize = findViewById(R.id.all_flow_size);
        haveUserFlowSize = findViewById(R.id.have_user_flow_size);
        flowDetailProgress = findViewById(R.id.flow_detail_progress);
        haveUseFlowPercentSize = findViewById(R.id.have_use_flow_percent_size);
        remainFlowPercentSize = findViewById(R.id.remain__flow_percent_size);
        buyFlowPackage = findViewById(R.id.buy_flow_package);
        remainVoiceSize = findViewById(R.id.remain_voice_size);
        allVoiceSize = findViewById(R.id.all_voice_size);
        voiceHaveUserSize = findViewById(R.id.voice_have_user_size);
        voiceDetailProgress = findViewById(R.id.voice_detail_progress);
        haveUseVoicePercentSize = findViewById(R.id.have_use_voice_percent_size);
        remainVoicePercentSize = findViewById(R.id.remain_voice_percent_size);
        buyVoicePackage = findViewById(R.id.buy_voice_package);
        noUseArea = findViewById(R.id.no_user_area);
        endTime = findViewById(R.id.end_time);
        noUseList = findViewById(R.id.no_use_list);
        leftIcon.setOnClickListener(this);
        buyFlowPackage.setOnClickListener(this);
        buyVoicePackage.setOnClickListener(this);
        mineMealPresenter = new MineMealPresenterImpl(this);
        if (MealInfoHelper.getInstance().getNumber() != null) {
            //查询卡的基本信息
            mineMealPresenter.RequestSimCardMealInfo(MineMealActivity.this, MealInfoHelper.getInstance().getNumber());
            //卡查询当前卡正使用以及未启用套餐
            mineMealPresenter.RequestSimCardMealList(MineMealActivity.this, MealInfoHelper.getInstance().getNumber());
        }
    }

    //语音流量详情
    private void initMealDetail(MealInfoBean.BodyBean mealInfoBean) {
        if (mealInfoBean.getSimFlow() != null) {
            double packageTraffic = mealInfoBean.getSimFlow().getPackageTraffic();//所有流量
            double useTraffic = mealInfoBean.getSimFlow().getUseTraffic();//已使用的流量
            double packageCallDuration = mealInfoBean.getSimFlow().getPackageCallDuration();//所有语音时长
            double useCallDuration = mealInfoBean.getSimFlow().getUseCallDuration();//已使用的语音时长
            if (packageCallDuration > 0 && packageTraffic > 0) {//流量语音都是固定的值
                flowDetailProgress.setProgress((int) (useTraffic / packageTraffic * 100));
//                remainFlowSize.setText((packageTraffic - useTraffic) + "");
                MealCommonUtils.formatFlowSize((packageTraffic - useTraffic), remainFlowSize);
//                allFlowSize.setText(packageTraffic + "");
                MealCommonUtils.formatFlowSize(packageTraffic, allFlowSize);
                if (packageTraffic < 1024) {
                    flowUnit.setText("流量(MB)");

                } else if (packageTraffic > 1024) {
                    flowUnit.setText("流量(G)");
                }
//                haveUserFlowSize.setText(useTraffic + "");
                MealCommonUtils.formatFlowSize(useTraffic, haveUserFlowSize);
                remainFlowPercentSize.setText(MealCommonUtils.remain2(useTraffic / packageTraffic) * 100 + "%");
                double size = (packageTraffic - useTraffic) / packageTraffic;
                haveUseFlowPercentSize.setText(MealCommonUtils.remain2(size) * 100 + "%");
                if (size <= 0.1) {
                    buyFlowPackage.setVisibility(View.VISIBLE);
                } else {
                    buyFlowPackage.setVisibility(View.GONE);
                }
                voiceDetailProgress.setProgress((int) (useCallDuration / packageCallDuration * 100));
                remainVoiceSize.setText((int) (packageCallDuration - useCallDuration) + "");
                allVoiceSize.setText((int) packageCallDuration + "");
                voiceHaveUserSize.setText((int) useCallDuration + "");
                remainVoicePercentSize.setText(MealCommonUtils.remain2(useCallDuration / packageCallDuration) * 100 + "%");
                double voiceSize = (packageCallDuration - useCallDuration) / packageCallDuration;
                haveUseVoicePercentSize.setText(MealCommonUtils.remain2(voiceSize) * 100 + "%");
                if (voiceSize <= 0.1) {
                    buyVoicePackage.setVisibility(View.VISIBLE);
                } else {
                    buyVoicePackage.setVisibility(View.GONE);
                }

            } else if (packageTraffic == -1 && packageCallDuration > 0) {//无限流量,语音有数值
                flowDetailProgress.setProgress(0);
                remainFlowSize.setText("无限");
                allFlowSize.setText("无限");
                haveUserFlowSize.setText("无限");
                haveUseFlowPercentSize.setText("无限");
                remainFlowPercentSize.setText("无限");
                buyFlowPackage.setVisibility(View.GONE);
                voiceDetailProgress.setProgress((int) (useCallDuration / packageCallDuration * 100));
                remainVoiceSize.setText((int) (packageCallDuration - useCallDuration) + "");
                allVoiceSize.setText((int) packageCallDuration + "");
                voiceHaveUserSize.setText((int) useCallDuration + "");
                remainVoicePercentSize.setText(MealCommonUtils.remain2(useCallDuration / packageCallDuration) * 100 + "%");
                double voiceSize = (packageCallDuration - useCallDuration) / packageCallDuration;
                haveUseVoicePercentSize.setText(MealCommonUtils.remain2(voiceSize) * 100 + "%");
                if (voiceSize <= 0.1) {
                    buyVoicePackage.setVisibility(View.VISIBLE);
                } else {
                    buyVoicePackage.setVisibility(View.GONE);
                }
            }
        }
    }

    private void initRealNameState(MealInfoBean.BodyBean mealInfoBean) {
        int realName = mealInfoBean.getRealname();
        if (realName == 0) {
            realNameState.setText("已实名");
        } else if (realName == 1) {
            realNameState.setText("未实名");
        } else if (realName == 2) {
            realNameState.setText("无需实名");
        }
    }

    private void initCardState(MealInfoBean.BodyBean mealInfoBean) {
        String simState = mealInfoBean.getSimState();
        if (simState != null) {
            if (simState.equals("1")) {
                cardStateInfo.setText("未激活");
            } else if (simState.equals("2")) {
                cardStateInfo.setText("正使用");
            } else if (simState.equals("3")) {
                cardStateInfo.setText("停机");
            } else if (simState.equals("4")) {
                cardStateInfo.setText("欠费");
            } else if (simState.equals("5")) {
                cardStateInfo.setText("解除集团代付");
            } else if (simState.equals("6")) {
                cardStateInfo.setText("销号");
            } else if (simState.equals("7")) {
                cardStateInfo.setText("测试期");
            } else if (simState.equals("8")) {
                cardStateInfo.setText("沉默期");
            } else if (simState.equals("9")) {
                cardStateInfo.setText("库存");
            } else if (simState.equals("10")) {
                cardStateInfo.setText("出库停机");
            } else if (simState.equals("11")) {
                cardStateInfo.setText("审核停机");
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.base_left_iv) {
            finish();
        } else if (id == R.id.buy_flow_package) {
            Intent flIntent = new Intent(this, BusinessManagementActivity.class);
            flIntent.putExtra(KeyConstants.BUSINESS_TYPE, KeyConstants.FLOW_OVERLAY_PACK);
            startActivity(flIntent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        } else if (id == R.id.buy_voice_package) {
            Intent voIntent = new Intent(this, BusinessManagementActivity.class);
            voIntent.putExtra(KeyConstants.BUSINESS_TYPE, KeyConstants.VOICE_OVERLAY_PACKET);
            startActivity(voIntent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    @Override
    public <T> void ResponseSimCardMealInfo(T t) {
        MealInfoBean.BodyBean bodyBean = (MealInfoBean.BodyBean) t;
        cardNumber.setText(bodyBean.getCardNumber() + "");
        iccidNumber.setText("ICCID : " + bodyBean.getIccid() + "");
        initCardState(bodyBean);
        initRealNameState(bodyBean);
        networkTypeInfo.setText(bodyBean.getNetworkStandard() + "网络");
        if (bodyBean.getSimFlow() != null) {
            updateTime.setText("更新时间" + bodyBean.getSimFlow().getUpdateTime());
        }
        mealDataInfo.setText(bodyBean.getGoodsName());
        initMealDetail(bodyBean);
        endTime.setText("将于" + bodyBean.getPackageEndTime() + "到期");
    }

    @Override
    public <T> void ResponseSimCardMealList(T t) {
        ArrayList<SimPackageBean.BodyBean> bodyBeans = (ArrayList<SimPackageBean.BodyBean>) t;
        if (bodyBeans.size() > 0) {
            LinearLayoutManager packagePurchaseLayoutManager = new LinearLayoutManager(MineMealActivity.this);
            packagePurchaseLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            noUseList.setLayoutManager(packagePurchaseLayoutManager);
            NoUseMealRecycleAdapter packagePurchaseRecycleAdapter = new NoUseMealRecycleAdapter(MineMealActivity.this, bodyBeans);
            noUseList.setAdapter(packagePurchaseRecycleAdapter);
            noUseArea.setVisibility(View.VISIBLE);
        } else {
            noUseArea.setVisibility(View.GONE);
        }
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
        ToastUtil.show(MineMealActivity.this, info);
    }
}
