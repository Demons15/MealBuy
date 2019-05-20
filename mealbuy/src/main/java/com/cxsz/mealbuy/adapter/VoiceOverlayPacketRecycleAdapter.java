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
public class VoiceOverlayPacketRecycleAdapter extends RecyclerView.Adapter<VoiceOverlayPacketRecycleAdapter.ViewHolder> {
    private List<MealGoodsBean.MealGoodsBodyBean> chatListBeanList;
    private Context context;
    private OnItemClickListener mItemClickListener;

    public VoiceOverlayPacketRecycleAdapter(Context context, List<MealGoodsBean.MealGoodsBodyBean> chatListBeanList) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voice_overlay_packet_item, parent, false);
        ViewHolder chatHolder = new ViewHolder(view);
        return chatHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean = chatListBeanList.get(position);
        holder.voiceOverlayPacketCapacity.setText((int)mealGoodsBodyBean.getCallDuration() + "分钟");
        holder.voiceOverlayPacketDesInfo.setText("有效期" + (int)mealGoodsBodyBean.getValidityDuration() + "个月");
        holder.voiceOverlayPacketPrice.setText(mealGoodsBodyBean.getUnitPrice() + "");
        holder.voiceOverlayPacketItemArea.setOnClickListener(new View.OnClickListener() {
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
        private RelativeLayout voiceOverlayPacketItemArea;
        private TextView voiceOverlayPacketTitleInfo;
        private TextView voiceOverlayPacketCapacity;
        private TextView voiceOverlayPacketDesInfo;
        private TextView voiceOverlayPacketPrice;
        public ViewHolder(View itemView) {
            super(itemView);

            voiceOverlayPacketItemArea = itemView.findViewById(R.id.voice_overlay_packet_item_area);
            voiceOverlayPacketTitleInfo = itemView.findViewById(R.id.voice_overlay_packet_title_info);

            voiceOverlayPacketCapacity = itemView.findViewById(R.id.voice_overlay_packet_capacity);
            voiceOverlayPacketDesInfo = itemView.findViewById(R.id.voice_overlay_packet_des_info);
            voiceOverlayPacketPrice = itemView.findViewById(R.id.voice_overlay_packet_price);
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
