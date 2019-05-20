package com.cxsz.mealbuy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.base.BaseAdapter;
import com.cxsz.mealbuy.bean.BusinessManagementBean;

import java.util.List;

public class BusinessManagementListAdapter extends BaseAdapter<BusinessManagementBean> {
    private int mSelectItem = -1;

    public BusinessManagementListAdapter(Context context, List<BusinessManagementBean> list) {
        super(context, list);
    }

    @Override
    public int getContentView() {
        return R.layout.business_management_list_item;
    }

    @Override
    public void onInitView(View view, int position) {
        RelativeLayout selectArea = get(view, R.id.select_area);
        TextView selectInfo = get(view, R.id.select_info);
        View chooseIcon = get(view, R.id.choose_icon);
        BusinessManagementBean item = getItem(position);
        selectInfo.setText(item.getInfo());
        if (mSelectItem == position) {
            chooseIcon.setVisibility(View.VISIBLE);
            selectArea.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            chooseIcon.setVisibility(View.GONE);
            selectArea.setBackgroundColor(Color.parseColor("#F7F7F7"));
        }
    }

    public void selectItemIndex(int selectItem) {
        this.mSelectItem = selectItem;
        notifyDataSetChanged();
    }
}
