package com.cxsz.mealbuy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.bean.MealGoodsFilterBean;
import java.util.List;

/**
 * 套餐购买
 */
public class TagAreaRecycleAdapter extends RecyclerView.Adapter<TagAreaRecycleAdapter.ViewHolder> {
    private List<MealGoodsFilterBean> chatListBeanList;
    private Context context;
    private OnItemClickListener mItemClickListener;
    private int mSelectItem = -1;

    public TagAreaRecycleAdapter(Context context, List<MealGoodsFilterBean> chatListBeanList) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_area_item, parent, false);
        ViewHolder chatHolder = new ViewHolder(view);
        return chatHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final MealGoodsFilterBean mealGoodsBodyBean = chatListBeanList.get(position);
        String groupName = mealGoodsBodyBean.getGroupName();
        holder.tagDesInfo.setText(groupName);
        if (mSelectItem == position) {
            holder.tagDesInfo.setTextColor(Color.parseColor("#93CA05"));
        } else {
            holder.tagDesInfo.setTextColor(Color.parseColor("#4D4D4D"));
        }

        holder.tagDesInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(v, position);
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
        private TextView tagDesInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            tagDesInfo = itemView.findViewById(R.id.tag_des_info);
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void selectItemIndex(int selectItem) {
        this.mSelectItem = selectItem;
    }
}
