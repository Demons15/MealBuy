package com.cxsz.mealbuy.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cxsz.mealbuy.component.KeyConstants;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.bean.MealGoodsFilterBean;
import com.cxsz.mealbuy.view.activity.MealDetailsActivity;
import java.util.List;

/**
 * 套餐购买
 */
public class PackagePurchaseRecycleGroupAdapter extends RecyclerView.Adapter<PackagePurchaseRecycleGroupAdapter.ViewHolder> {
    private List<MealGoodsFilterBean> chatListBeanList;
    private Activity context;
    private OnItemClickListener mItemClickListener;
    public static final int FIRST_STICKY_VIEW = 1;
    public static final int HAS_STICKY_VIEW = 2;
    public static final int NONE_STICKY_VIEW = 3;

    public PackagePurchaseRecycleGroupAdapter(Activity context, List<MealGoodsFilterBean> chatListBeanList) {
        this.context = context;
        this.chatListBeanList = chatListBeanList;
    }

    public void refreshStatus(List<MealGoodsFilterBean> requestMsgBean) {
        chatListBeanList = requestMsgBean;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.package_purchase_group_item, parent, false);
        ViewHolder chatHolder = new ViewHolder(view);
        return chatHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final MealGoodsFilterBean mealGoodsBodyBean = chatListBeanList.get(position);
        if (position == 0) {
            holder.packagePurchaseName.setVisibility(View.VISIBLE);
            holder.packagePurchaseName.setText(mealGoodsBodyBean.getGroupName());
            holder.itemView.setTag(FIRST_STICKY_VIEW);
        } else {
            if (!TextUtils.equals(mealGoodsBodyBean.getGroupName(), chatListBeanList.get(position - 1).getGroupName())) {
                holder.packagePurchaseName.setVisibility(View.VISIBLE);
                holder.packagePurchaseName.setText(mealGoodsBodyBean.getGroupName());
                holder.itemView.setTag(HAS_STICKY_VIEW);
            } else {
                holder.packagePurchaseName.setVisibility(View.GONE);
                holder.itemView.setTag(NONE_STICKY_VIEW);
            }
        }
        holder.itemView.setContentDescription(mealGoodsBodyBean.getGroupName());
        if (mealGoodsBodyBean.getBody() != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
            holder.packagePurchaseGroupList.setLayoutManager(gridLayoutManager);
            PackagePurchaseRecycleAdapter packagePurchaseRecycleAdapter = new PackagePurchaseRecycleAdapter(context, mealGoodsBodyBean.getBody());
            holder.packagePurchaseGroupList.setAdapter(packagePurchaseRecycleAdapter);
            packagePurchaseRecycleAdapter.setItemClickListener(new PackagePurchaseRecycleAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Intent intent = new Intent(context, MealDetailsActivity.class);
                    intent.putExtra(KeyConstants.PACKET_INFO, mealGoodsBodyBean.getBody().get(position));
                    context.startActivity(intent);
                    context.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return chatListBeanList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView packagePurchaseName;
        private RecyclerView packagePurchaseGroupList;

        public ViewHolder(View itemView) {
            super(itemView);
            packagePurchaseName = itemView.findViewById(R.id.good_des_info);
            packagePurchaseGroupList = itemView.findViewById(R.id.package_purchase_group_list);
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
