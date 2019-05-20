package com.cxsz.mealbuy.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxsz.mealbuy.component.LogUtil;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.MealInfoHelper;
import com.cxsz.mealbuy.adapter.PackagePurchaseRecycleGroupAdapter;
import com.cxsz.mealbuy.adapter.TagAreaRecycleAdapter;
import com.cxsz.mealbuy.base.BaseMainFragment;
import com.cxsz.mealbuy.bean.MealGoodsBean;
import com.cxsz.mealbuy.bean.MealGoodsFilterBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PackagePurchaseFragment extends BaseMainFragment {
    RecyclerView packagePurchaseList;
    private RecyclerView tagRecyclerView;
    private ImageView openTagArea;
    private View tagArea;
    private TagFlowLayout tagAreaList;
    private LayoutInflater mInflater;
    private boolean isOpen = false;
    private TagAreaRecycleAdapter tagAreaRecycleAdapter;
    private TextView goodDesInfo;
    private PackagePurchaseRecycleGroupAdapter packagePurchaseRecycleGroupAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.package_purchase_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        tagArea = rootView.findViewById(R.id.tag_area);
        mInflater = LayoutInflater.from(getContext());
        tagAreaList = rootView.findViewById(R.id.tag_area_list);
        //标签集合
        tagRecyclerView = rootView.findViewById(R.id.tag_recycler_view);
        //打开
        openTagArea = rootView.findViewById(R.id.open_tag_area);

        goodDesInfo = rootView.findViewById(R.id.good_des_info);

        packagePurchaseList = rootView.findViewById(R.id.package_purchase_list);
        final List<MealGoodsFilterBean> mealGoodsFilterBeans = getMealGoodsFilterBeans();
        LinearLayoutManager tagLinearLayoutManager = new LinearLayoutManager(getActivity());
        tagLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        tagRecyclerView.setLayoutManager(tagLinearLayoutManager);
        tagAreaRecycleAdapter = new TagAreaRecycleAdapter(getActivity(), mealGoodsFilterBeans);
        tagRecyclerView.setAdapter(tagAreaRecycleAdapter);
        tagAreaRecycleAdapter.setItemClickListener(new TagAreaRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                tagAreaRecycleAdapter.selectItemIndex(position);
                tagAreaRecycleAdapter.notifyDataSetChanged();
                if (position != -1) {
                    smoothMoveToPosition(packagePurchaseList, position);
                } else {
                    smoothMoveToPosition(packagePurchaseList, position + 1);
                }
                tagArea.setVisibility(View.GONE);
            }
        });
        openTagArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                tagAreaListWindow.setMealGoodsFilterInfo(mealGoodsFilterBeans);
//                tagAreaListWindow.showPopupWindow(tagArea);
                if (!isOpen) {
                    setMealGoodsFilterInfo(mealGoodsFilterBeans);
                    tagArea.setVisibility(View.VISIBLE);
                    isOpen = true;
                } else {
                    tagArea.setVisibility(View.GONE);
                    isOpen = false;
                }
            }
        });
        tagArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagArea.setVisibility(View.GONE);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        packagePurchaseList.setLayoutManager(linearLayoutManager);
        packagePurchaseRecycleGroupAdapter = new PackagePurchaseRecycleGroupAdapter(getActivity(), mealGoodsFilterBeans);
        packagePurchaseList.setAdapter(packagePurchaseRecycleGroupAdapter);

        packagePurchaseList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mShouldScroll) {
                    mShouldScroll = false;
                    smoothMoveToPosition(recyclerView, mToPosition);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View stickView = recyclerView.findChildViewUnder(0, 0);
                if (stickView != null && stickView.getContentDescription() != null) {
                    if (!TextUtils.equals(goodDesInfo.getText(), stickView.getContentDescription())) {
                        goodDesInfo.setText(stickView.getContentDescription());
                    }
                }
                View transInfoView = recyclerView.findChildViewUnder(
                        0, goodDesInfo.getHeight() + 1);
                if (transInfoView.getTag() != null) {
                    int transViewStatus = (int) transInfoView.getTag();
                    int top = transInfoView.getTop();
                    if (transViewStatus == packagePurchaseRecycleGroupAdapter.HAS_STICKY_VIEW) {
                        if (top > 0) {
                            int dealtY = top - goodDesInfo.getMeasuredHeight();
                            LogUtil.setTagE("dealtY", "dealtY的值为:" + dealtY + "- - - - -  top的值为:" + top);
                            goodDesInfo.setTranslationY(0);
                        } else {
                            goodDesInfo.setTranslationY(0);
                        }
                    } else if (transViewStatus == packagePurchaseRecycleGroupAdapter.NONE_STICKY_VIEW) {
                        goodDesInfo.setTranslationY(0);
                    }
                }
            }
        });
    }

    private List<MealGoodsFilterBean> getMealGoodsFilterBeans() {
        final List<MealGoodsBean.MealGoodsBodyBean> mealGoodsBodyBeanList = MealInfoHelper.getInstance().getMainMealGoodsList();
        //构建存储分组的数据结构，Map, name（分组类）-value(数组)
        LinkedHashMap<String, ArrayList<MealGoodsBean.MealGoodsBodyBean>> mealGoodsBodyBeans = new LinkedHashMap<String, ArrayList<MealGoodsBean.MealGoodsBodyBean>>();
        for (MealGoodsBean.MealGoodsBodyBean mealGoodsBodyBean : mealGoodsBodyBeanList) {
            ArrayList<MealGoodsBean.MealGoodsBodyBean> childList = new ArrayList<MealGoodsBean.MealGoodsBodyBean>();
            if (mealGoodsBodyBean.getGroupName() == null) {
                mealGoodsBodyBeans.put("其他", childList);
            } else {
                mealGoodsBodyBeans.put(mealGoodsBodyBean.getGroupName(), childList);
            }
        }
        //根据不同分组，把数据放进不同的数组
        for (MealGoodsBean.MealGoodsBodyBean s : mealGoodsBodyBeanList) {
            String groupName = s.getGroupName();
            if (groupName == null) {
                mealGoodsBodyBeans.get("其他").add(s);
            }
            //简化书写。
            for (String infoName : mealGoodsBodyBeans.keySet()) {
                if (groupName != null && s.getGroupName().equals(infoName)) {
                    mealGoodsBodyBeans.get(infoName).add(s);
                }
            }
        }
        final List<MealGoodsFilterBean> mealGoodsFilterBeans = new ArrayList<>();
        Iterator<Map.Entry<String, ArrayList<MealGoodsBean.MealGoodsBodyBean>>> iterator = mealGoodsBodyBeans.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<MealGoodsBean.MealGoodsBodyBean>> next = iterator.next();
            ArrayList<MealGoodsBean.MealGoodsBodyBean> value = next.getValue();
            String key = next.getKey();
            mealGoodsFilterBeans.add(new MealGoodsFilterBean(key, value));
        }
        LinkedList<MealGoodsFilterBean> mealGoodsFilterBeanLinkedList1 = new LinkedList<>();
        LinkedList<MealGoodsFilterBean> mealGoodsFilterBeanLinkedList = new LinkedList<>(mealGoodsFilterBeans);

        MealGoodsFilterBean firstMealGoodsFilterBean = new MealGoodsFilterBean();
        MealGoodsFilterBean lastMealGoodsFilterBean = new MealGoodsFilterBean();
        for (int i = 0; i < mealGoodsFilterBeanLinkedList.size(); i++) {
            String groupName = mealGoodsFilterBeanLinkedList.get(i).getGroupName();
            if (groupName.equals("推荐套餐")) {
                firstMealGoodsFilterBean = mealGoodsFilterBeanLinkedList.get(i);
            } else if (!groupName.equals("其他") && !groupName.equals("推荐套餐")) {
                mealGoodsFilterBeanLinkedList1.add(mealGoodsFilterBeanLinkedList.get(i));
            } else if (groupName.equals("其他")) {
                lastMealGoodsFilterBean = mealGoodsFilterBeanLinkedList.get(i);
            }
        }
        mealGoodsFilterBeanLinkedList1.addFirst(firstMealGoodsFilterBean);
        mealGoodsFilterBeanLinkedList1.addLast(lastMealGoodsFilterBean);
        return new ArrayList<>(mealGoodsFilterBeanLinkedList1);
    }

    public void setMealGoodsFilterInfo(List<MealGoodsFilterBean> mealGoodsFilterBeans) {
        tagAreaList.setAdapter(new TagAdapter(mealGoodsFilterBeans) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView tagInfo = (TextView) mInflater.inflate(R.layout.tag_item,
                        tagAreaList, false);
                MealGoodsFilterBean mealGoodsFilterBean = (MealGoodsFilterBean) o;
                tagInfo.setText(mealGoodsFilterBean.getGroupName());
                return tagInfo;
            }
        });

        tagAreaList.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                if (position != -1) {
                    smoothMoveToPosition(packagePurchaseList, position);
                } else {
                    smoothMoveToPosition(packagePurchaseList, position + 1);
                }
                tagArea.setVisibility(View.GONE);
                return true;
            }
        });
    }

    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;

    /**
     * 滑动到指定位置
     */
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        // 第一个可见位置
        int firstItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        int lastItem = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));
        if (position < firstItem) {
            // 第一种可能:跳转位置在第一个可见位置之前，使用smoothScrollToPosition
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            // 第二种可能:跳转位置在第一个可见位置之后，最后一个可见项之前
            int movePosition = position - firstItem;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                // smoothScrollToPosition 不会有效果，此时调用smoothScrollBy来滑动到指定位置
                mRecyclerView.smoothScrollBy(0, top);
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用smoothMoveToPosition，执行上一个判断中的方法
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }


    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

    }

    @Override
    protected void lazyFetchData() {

    }

    public static PackagePurchaseFragment getInstance() {
        PackagePurchaseFragment childInfoFragment = new PackagePurchaseFragment();
        return childInfoFragment;
    }

}
