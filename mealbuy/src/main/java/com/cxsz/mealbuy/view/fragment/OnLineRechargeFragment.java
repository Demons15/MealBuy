package com.cxsz.mealbuy.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.base.BaseMainFragment;

public class OnLineRechargeFragment extends BaseMainFragment {
    TextView name;

    @Override
    protected int getLayoutId() {
        return R.layout.business_management_info_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        initBaseTitle("业务办理", true);
        name = rootView.findViewById(R.id.name);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

    }

    @Override
    protected void lazyFetchData() {
        name.setText("OnLineRechargeFragment");
    }

    public static OnLineRechargeFragment getInstance() {
        OnLineRechargeFragment childInfoFragment = new OnLineRechargeFragment();
        return childInfoFragment;
    }

}
