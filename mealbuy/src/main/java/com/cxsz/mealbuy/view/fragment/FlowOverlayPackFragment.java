package com.cxsz.mealbuy.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cxsz.mealbuy.component.KeyConstants;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.adapter.FlowOverlayPacketRecycleAdapter;
import com.cxsz.mealbuy.base.BaseMainFragment;
import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.view.activity.MealDetailsActivity;

import java.util.List;

public class FlowOverlayPackFragment extends BaseMainFragment {
    RecyclerView flowOverlayPackList;

    @Override
    protected int getLayoutId() {
        return R.layout.flow_overlay_pack_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        flowOverlayPackList = rootView.findViewById(R.id.flow_overlay_pack_list);
        final List<MealGoodsBean.MealGoodsBodyBean> mealGoodsBodyBeanList = MealInfoHelper.getInstance().getFlowMealGoodsList();
        if (mealGoodsBodyBeanList != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);
            flowOverlayPackList.setLayoutManager(gridLayoutManager);
            FlowOverlayPacketRecycleAdapter flowOverlayPacketRecycleAdapter = new FlowOverlayPacketRecycleAdapter(getActivity(), mealGoodsBodyBeanList);
            flowOverlayPackList.setAdapter(flowOverlayPacketRecycleAdapter);
            flowOverlayPacketRecycleAdapter.setItemClickListener(new FlowOverlayPacketRecycleAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
//                    ToastUtil.show(getActivity(), "您点击的是流量叠加包:" + mealGoodsBodyBeanList.get(position).getGoodsName());
                    Intent intent = new Intent(getActivity(), MealDetailsActivity.class);
                    intent.putExtra(KeyConstants.PACKET_INFO, mealGoodsBodyBeanList.get(position));
                    startActivity(intent);
                    getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

    }

    @Override
    protected void lazyFetchData() {

    }

    public static FlowOverlayPackFragment getInstance() {
        FlowOverlayPackFragment childInfoFragment = new FlowOverlayPackFragment();
        return childInfoFragment;
    }

}
