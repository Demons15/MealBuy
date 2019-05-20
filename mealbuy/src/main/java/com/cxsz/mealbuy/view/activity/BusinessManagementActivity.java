package com.cxsz.mealbuy.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cxsz.mealbuy.component.KeyConstants;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.adapter.BusinessManagementListAdapter;
import com.cxsz.mealbuy.base.BaseActivity;
import com.cxsz.mealbuy.bean.BusinessManagementBean;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.component.ThreadPoolManager;
import com.cxsz.mealbuy.component.ToastUtil;
import com.cxsz.mealbuy.presenter.presenterImpl.BusinessManagementPresenterImpl;
import com.cxsz.mealbuy.presenter.presenterInterface.BusinessManagementPresenter;
import com.cxsz.mealbuy.view.fragment.FlowOverlayPackFragment;
import com.cxsz.mealbuy.view.fragment.PackagePurchaseFragment;
import com.cxsz.mealbuy.view.fragment.VoiceOverlayPacketFragment;
import com.cxsz.mealbuy.view.viewInterface.BusinessManagementView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

public class BusinessManagementActivity extends BaseActivity implements AdapterView.OnItemClickListener, BusinessManagementView {
    private static final int REFRESH_VIEW = 0x1;
    ListView businessManagementList;
    private SupportFragment[] mFragments = new SupportFragment[3];
    private BusinessManagementListAdapter businessManagementListAdapter;
    private int businessType;
    public static final int FIRST = 0;
    public static final int SECOND = 0;
    public static final int THIRD = 1;
    public static final int FOURTH = 2;
    private MyHandler handler = new MyHandler(this);
    private BusinessManagementPresenter businessManagementPresenter;

    private static class MyHandler extends Handler {
        WeakReference<BusinessManagementActivity> businessManagementActivityWeakReference;

        public MyHandler(BusinessManagementActivity activity) {
            this.businessManagementActivityWeakReference = new WeakReference<BusinessManagementActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            BusinessManagementActivity businessManagementActivity = businessManagementActivityWeakReference.get();
            if (businessManagementActivity != null) {
                switch (msg.arg1) {
                    case REFRESH_VIEW:
                        businessManagementActivity.stopProgressDialog();
                        businessManagementActivity.businessManagementListAdapter.selectItemIndex(msg.arg2);
                        businessManagementActivity.loadRootFragment(R.id.business_management_area, businessManagementActivity.mFragments[msg.arg2]);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.business_management_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initBaseTitle("业务办理");
        businessManagementList = findViewById(R.id.business_management_list);
        businessManagementPresenter = new BusinessManagementPresenterImpl(this);
        businessManagementPresenter.RequestGetGoodsRelevance(BusinessManagementActivity.this, MealInfoHelper.getInstance().getNumber());
        businessType = getIntent().getIntExtra(KeyConstants.BUSINESS_TYPE, KeyConstants.PACKAGE_PURCHASE);
    }

    private void initSelectInfo() {
        startProgressDialog();
//        mFragments[FIRST] = OnLineRechargeFragment.getInstance();
        mFragments[SECOND] = PackagePurchaseFragment.getInstance();
        mFragments[THIRD] = FlowOverlayPackFragment.getInstance();
        mFragments[FOURTH] = VoiceOverlayPacketFragment.getInstance();
        final List<BusinessManagementBean> businessManagementBeans = new ArrayList<>();
//        businessManagementBeans.add(new BusinessManagementBean("在线充值", KeyConstants.ONLINE_RECHARGE));
        businessManagementBeans.add(new BusinessManagementBean("套餐购买", KeyConstants.PACKAGE_PURCHASE));
        businessManagementBeans.add(new BusinessManagementBean("流量叠加", KeyConstants.FLOW_OVERLAY_PACK));
        businessManagementBeans.add(new BusinessManagementBean("语音叠加", KeyConstants.VOICE_OVERLAY_PACKET));
        businessManagementListAdapter = new BusinessManagementListAdapter(BusinessManagementActivity.this, businessManagementBeans);
        businessManagementList.setAdapter(businessManagementListAdapter);
        businessManagementList.setOnItemClickListener(this);
        ThreadPoolManager.getThreadPollProxy().execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < businessManagementBeans.size(); i++) {
                    if (businessType == businessManagementBeans.get(i).getTag()) {
                        Message message = Message.obtain();
                        message.arg1 = REFRESH_VIEW;
                        message.arg2 = i;
                        handler.sendMessage(message);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        businessManagementListAdapter.selectItemIndex(position);
        switch (businessManagementListAdapter.getItem(position).getTag()) {
//            case KeyConstants.ONLINE_RECHARGE:
//                loadRootFragment(R.id.business_management_area, OnLineRechargeFragment.getInstance());
//                break;
            case KeyConstants.PACKAGE_PURCHASE:
                loadRootFragment(R.id.business_management_area, PackagePurchaseFragment.getInstance());
                break;
            case KeyConstants.FLOW_OVERLAY_PACK:
                loadRootFragment(R.id.business_management_area, FlowOverlayPackFragment.getInstance());
                break;
            case KeyConstants.VOICE_OVERLAY_PACKET:
                loadRootFragment(R.id.business_management_area, VoiceOverlayPacketFragment.getInstance());
                break;
            default:
                break;
        }

    }

    @Override
    public <T> void ResponseGetGoodsRelevance(T t) {
        initSelectInfo();
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
        ToastUtil.show(BusinessManagementActivity.this, info);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return true;
    }
}
