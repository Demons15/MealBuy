package com.cxsz.mealbuy.base;

/**
 * Created by yangqian on 2017/2/10.
 */

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    protected Context context;

    private List<T> mDatas = new ArrayList<>();

    public BaseAdapter(Context context) {
        init(context, new ArrayList<T>());
    }

    public BaseAdapter(Context context, List<T> list) {
        init(context, list);
    }

    private void init(Context context, List<T> list) {
        this.context = context;
        this.mDatas.addAll(list);
    }

    public List<T> getList() {
        return mDatas;
    }

    public void setList(List<T> list) {
        this.mDatas = list;
    }

    public void replaceList(List<T> list) {
        this.mDatas.clear();
        mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mDatas.clear();
        notifyDataSetChanged();
    }
    public void add(T list) {
        this.mDatas.add(list);
        notifyDataSetChanged();
    }

    public void addAll(List<T> list) {
        this.mDatas.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflate(getContentView(), parent);
        }
        onInitView(convertView, position);
        return convertView;
    }

    /**
     * 加载布局
     */
    private View inflate(int layoutResID, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layoutResID, parent, false);
        return view;
    }

    public abstract int getContentView();

    public abstract void onInitView(View view, int position);

    /**
     * @param view converView
     * @param id   控件的id
     * @return 返回<T extends View>
     */
    @SuppressWarnings("unchecked")
    protected <E extends View> E get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (null == viewHolder) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (null == childView) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);

        }
        return (E) childView;
    }
}
