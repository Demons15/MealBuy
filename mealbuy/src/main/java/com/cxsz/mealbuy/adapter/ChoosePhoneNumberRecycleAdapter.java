package com.cxsz.mealbuy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.bean.ChooseNumberBean;

import java.util.List;

public class ChoosePhoneNumberRecycleAdapter extends RecyclerView.Adapter<ChoosePhoneNumberRecycleAdapter.ChildListHolder> {
    private int mSelectItem = -1;

    private List<ChooseNumberBean.BodyBean.ListBean> numberChooseBeanList;
    private Context context;
    private OnItemClickListener mItemClickListener;

    public ChoosePhoneNumberRecycleAdapter(Context context, List<ChooseNumberBean.BodyBean.ListBean> numberChooseBeans) {
        this.context = context;
        this.numberChooseBeanList = numberChooseBeans;
    }

    @NonNull
    @Override
    public ChoosePhoneNumberRecycleAdapter.ChildListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_phone_number_item, parent, false);
        ChoosePhoneNumberRecycleAdapter.ChildListHolder chatHolder = new ChildListHolder(view);
        return chatHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChoosePhoneNumberRecycleAdapter.ChildListHolder holder, final int position) {
        final ChooseNumberBean.BodyBean.ListBean item = numberChooseBeanList.get(position);
        holder.numberInfo.setText(item.getCardNumber() + "");
        if (mSelectItem == position) {
            holder.numberInfoArea.setBackgroundResource(R.drawable.choose_phone_button_shape);
            holder.numberInfo.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            holder.numberInfoArea.setBackgroundResource(R.drawable.choose_phone_number_normal_shape);
            holder.numberInfo.setTextColor(context.getResources().getColor(R.color.color_333333));
        }
        holder.numberInfo.setOnClickListener(new View.OnClickListener() {
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
        return numberChooseBeanList.size();
    }

    class ChildListHolder extends RecyclerView.ViewHolder {
        private LinearLayout numberInfoArea;
        private TextView numberInfo;

        public ChildListHolder(View itemView) {
            super(itemView);
            numberInfo = itemView.findViewById(R.id.number_info);
            numberInfoArea = itemView.findViewById(R.id.number_info_area);
        }
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void refreshStatus(List<ChooseNumberBean.BodyBean.ListBean> requestMsgBean) {
        numberChooseBeanList = requestMsgBean;
        notifyDataSetChanged();
    }

    public void selectItemIndex(int selectItem) {
        this.mSelectItem = selectItem;
    }
}
