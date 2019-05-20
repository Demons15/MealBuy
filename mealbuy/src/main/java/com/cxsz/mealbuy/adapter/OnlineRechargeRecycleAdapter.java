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
import com.cxsz.mealbuy.bean.MealGoodsBodyBean;

import java.util.List;

/**
 * 在线充值适配器
 */
public class OnlineRechargeRecycleAdapter extends RecyclerView.Adapter<OnlineRechargeRecycleAdapter.ChatHolder> {
    private List<MealGoodsBodyBean> chatListBeanList;
    private Context context;
    private OnItemClickListener mItemClickListener;

    public OnlineRechargeRecycleAdapter(Context context, List<MealGoodsBodyBean> chatListBeanList) {
        this.context = context;
        this.chatListBeanList = chatListBeanList;
    }

    public void refreshStatus(List<MealGoodsBodyBean> requestMsgBean) {
        chatListBeanList = requestMsgBean;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.online_recharge_item, parent, false);
        ChatHolder chatHolder = new ChatHolder(view);
        return chatHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder holder, final int position) {
        MealGoodsBodyBean childData = chatListBeanList.get(position);
        holder.itemPrice.setText("");
        holder.itemPriceInfoOne.setText("");
        holder.itemPriceInfoTwo.setText("");
        holder.itemPriceArea.setOnClickListener(new View.OnClickListener() {
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
        return chatListBeanList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class ChatHolder extends RecyclerView.ViewHolder {
        private RelativeLayout itemPriceArea;
        private TextView itemPrice;
        private TextView itemPriceInfoOne;
        private TextView itemPriceInfoTwo;

        public ChatHolder(View itemView) {
            super(itemView);

            itemPriceArea = itemView.findViewById(R.id.online_recharge_item_area);
            itemPrice = itemView.findViewById(R.id.online_recharge_item_price);
            itemPriceInfoOne = itemView.findViewById(R.id.online_recharge_item_price_info_one);
            itemPriceInfoTwo = itemView.findViewById(R.id.online_recharge_item_price_info_two);
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
