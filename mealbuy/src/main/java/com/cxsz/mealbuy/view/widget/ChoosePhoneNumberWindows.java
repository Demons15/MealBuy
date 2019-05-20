package com.cxsz.mealbuy.view.widget;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.adapter.ChoosePhoneNumberRecycleAdapter;
import com.cxsz.mealbuy.base.BaseWindowView;
import com.cxsz.mealbuy.bean.ChooseNumberBean;
import com.cxsz.mealbuy.component.MealCommonUtils;
import com.cxsz.mealbuy.component.ToastUtil;
import com.cxsz.mealbuy.presenter.presenterImpl.ChoosePhoneNumberPresenterImpl;
import com.cxsz.mealbuy.presenter.presenterInterface.ChoosePhoneNumberPresenter;
import com.cxsz.mealbuy.view.viewInterface.ChoosePhoneNumberView;
import java.util.ArrayList;
import java.util.List;

public class ChoosePhoneNumberWindows extends BaseWindowView implements ChoosePhoneNumberView {
    private ChoosePhoneNumberRecycleAdapter choosePhoneNumberRecycleAdapter;
    private List<ChooseNumberBean.BodyBean.ListBean> numberChooseBeanList;
    private LinearLayout noNumberArea;
    private RecyclerView numberRecycleList;
    private ChooseNumberBean.BodyBean.ListBean listBean;
    private ChoosePhoneNumberPresenter choosePhoneNumberPresenter;

    public ChoosePhoneNumberWindows(Activity mContext) {
        super(mContext, Gravity.BOTTOM);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.choose_phone_number_windows_layout;
    }

    @Override
    protected void initView() {
        choosePhoneNumberPresenter = new ChoosePhoneNumberPresenterImpl(this);
        noNumberArea = findViewById(R.id.no_number_area);
        ImageView cancel = findViewById(R.id.cancel);
        final EditText inputLuckMumber = findViewById(R.id.input_luck_number);
        ImageView searchLuckNumber = findViewById(R.id.search_luck_number);
        numberRecycleList = findViewById(R.id.number_recycle_list);
        numberChooseBeanList = new ArrayList<ChooseNumberBean.BodyBean.ListBean>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        numberRecycleList.setLayoutManager(gridLayoutManager);
        choosePhoneNumberRecycleAdapter = new ChoosePhoneNumberRecycleAdapter(getContext(), numberChooseBeanList);
        numberRecycleList.setAdapter(choosePhoneNumberRecycleAdapter);
        choosePhoneNumberRecycleAdapter.setItemClickListener(new ChoosePhoneNumberRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                choosePhoneNumberRecycleAdapter.selectItemIndex(position);
                listBean = numberChooseBeanList.get(position);
                choosePhoneNumberRecycleAdapter.notifyDataSetChanged();
            }
        });
        RelativeLayout refreshNumber = findViewById(R.id.refresh_number);
        Button confirm = findViewById(R.id.confirm);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        searchLuckNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //选号查询
                choosePhoneNumberPresenter.RequestQueryChooseNumber(getContext(), "898602D99818C0270001", MealCommonUtils.getRandom(0, 9), inputLuckMumber.getText().toString().trim(), "10");
                MealCommonUtils.hideSoft((Activity) getContext());
            }
        });
        refreshNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //选号查询
                choosePhoneNumberPresenter.RequestQueryChooseNumber(getContext(), "898602D99818C0270001", MealCommonUtils.getRandom(0, 9), inputLuckMumber.getText().toString().trim(), "10");

                MealCommonUtils.hideSoft((Activity) getContext());
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listBean != null) {

                } else {
                    ToastUtil.show(getContext(), "请先选择号码！");
                }
            }
        });
    }

    @Override
    public <T> void ResponseQueryChooseNumber(T t) {
        List<ChooseNumberBean.BodyBean.ListBean> listBeans = (List<ChooseNumberBean.BodyBean.ListBean>) t;
        if (listBeans.size() > 0) {
            if (!numberChooseBeanList.isEmpty()) {
                numberChooseBeanList.clear();
            }
            numberChooseBeanList.addAll(listBeans);
            choosePhoneNumberRecycleAdapter.refreshStatus(numberChooseBeanList);

            numberRecycleList.setVisibility(View.VISIBLE);
            noNumberArea.setVisibility(View.GONE);
        } else {
            numberRecycleList.setVisibility(View.GONE);
            noNumberArea.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showLoadingView() {
        startProgressDialog();
    }

    @Override
    public void closeLoadingView() {
        stopProgressDialog();
    }

    @Override
    public void showErrorInfo(String info) {
        ToastUtil.show(getContext(), info);
    }
}
