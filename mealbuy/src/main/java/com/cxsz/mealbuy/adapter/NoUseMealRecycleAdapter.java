package com.cxsz.mealbuy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.bean.SimPackageBean;

import java.util.List;

/**
 * 当前使用的叠加包详情
 */
public class NoUseMealRecycleAdapter extends RecyclerView.Adapter<NoUseMealRecycleAdapter.ViewHolder> {
    private List<SimPackageBean.BodyBean> chatListBeanList;

    public NoUseMealRecycleAdapter(Context context, List<SimPackageBean.BodyBean> chatListBeanList) {
        this.chatListBeanList = chatListBeanList;
    }

    public void refreshStatus(List<SimPackageBean.BodyBean> requestMsgBean) {
        chatListBeanList = requestMsgBean;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_have_no_use_package_item, parent, false);
        ViewHolder chatHolder = new ViewHolder(view);
        return chatHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SimPackageBean.BodyBean mealGoodsBodyBean = chatListBeanList.get(position);
        holder.mealDetailInfo.setText(mealGoodsBodyBean.getGoodsName());
        if (mealGoodsBodyBean.getPackageTraffic() == -1) {
            holder.mealIncludeInfo.setText("无限流量+" + mealGoodsBodyBean.getCallDuration() + "分钟/月");
        } else {
            holder.mealIncludeInfo.setText("流量" + mealGoodsBodyBean.getPackageTraffic() + "M+" + mealGoodsBodyBean.getCallDuration() + "分钟/月");
        }
        holder.termOfValidityInfo.setText(mealGoodsBodyBean.getValidityDuration() + "个月");
        holder.effectiveTime.setText(mealGoodsBodyBean.getPackageActiveTime() + "生效");
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
        private TextView mealDetailInfo;
        private TextView mealIncludeInfo;
        private TextView termOfValidityInfo;
        private TextView effectiveTime;

        public ViewHolder(View itemView) {
            super(itemView);
            mealDetailInfo = itemView.findViewById(R.id.meal_detail_info);
            mealIncludeInfo = itemView.findViewById(R.id.meal_include_info);
            termOfValidityInfo = itemView.findViewById(R.id.term_of_validity_info);
            effectiveTime = itemView.findViewById(R.id.effective_time);

        }
    }
}
