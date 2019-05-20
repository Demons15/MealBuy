package com.cxsz.mealbuy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.bean.MealGoodsBean;

import java.util.List;

/**
 * 套餐购买
 */
public class FlowOverlayPacketRecycleAdapter extends RecyclerView.Adapter<FlowOverlayPacketRecycleAdapter.ViewHolder> {
    private List<MealGoodsBean.MealGoodsBodyBean> chatListBeanList;
    private Context context;
    private OnItemClickListener mItemClickListener;

    public FlowOverlayPacketRecycleAdapter(Context context, List<MealGoodsBean.MealGoodsBodyBean> chatListBeanList) {
        this.context = context;
        this.chatListBeanList = chatListBeanList;
    }

    public void refreshStatus(List<MealGoodsBean.MealGoodsBodyBean> requestMsgBean) {
        chatListBeanList = requestMsgBean;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flow_overlay_pack_item, parent, false);
        ViewHolder chatHolder = new ViewHolder(view);
        return chatHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean = chatListBeanList.get(position);
        holder.flowOverlayPackCapacity.setText((int)mealGoodsBodyBean.getPackageTraffic() + "M");
        holder.flowOverlayPackDesInfo.setText("有效期" + (int)mealGoodsBodyBean.getValidityDuration() + "个月");
        holder.flowOverlayPackPrice.setText(mealGoodsBodyBean.getUnitPrice() + "");
        holder.flowOverlayPackItemArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(v, position);
                }
            }
        });
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
        private RelativeLayout flowOverlayPackItemArea;
        private TextView flowOverlayPackTitleInfo;
        private TextView flowOverlayPackCapacity;
        private TextView flowOverlayPackDesInfo;
        private TextView flowOverlayPackPrice;

        public ViewHolder(View itemView) {
            super(itemView);

            flowOverlayPackItemArea = itemView.findViewById(R.id.flow_overlay_pack_item_area);
            flowOverlayPackTitleInfo = itemView.findViewById(R.id.flow_overlay_pack_title_info);

            flowOverlayPackCapacity = itemView.findViewById(R.id.flow_overlay_pack_capacity);
            flowOverlayPackDesInfo = itemView.findViewById(R.id.flow_overlay_pack_des_info);
            flowOverlayPackPrice = itemView.findViewById(R.id.flow_overlay_pack_price);
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
