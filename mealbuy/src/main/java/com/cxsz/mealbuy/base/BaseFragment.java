package com.cxsz.mealbuy.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.LoadingDialog;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 基础的Fragment
 */
public abstract class BaseFragment extends SupportFragment {
    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasFetchData; // 标识已经触发过懒加载数据
    private Bundle bundle;
    public View rootView;
    public ImageView baseRightIv;
    private LoadingDialog loadingWindows;
    public ImageView baseRightIv1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() == null) return;
        initReg();
    }

    public void initReg() {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        this.initView(savedInstanceState);
        isViewPrepared = true;
        return rootView;
    }

    protected void initBaseTitle(String titleText, int resId, View.OnClickListener listener) {
        View baseLeftIv = rootView.findViewById(R.id.base_left_iv);
        View rightArea = rootView.findViewById(R.id.right_area);
        TextView tvTitle = (TextView) rootView.findViewById(R.id.base_title_tv);
        TextView leftBackInfo = (TextView) rootView.findViewById(R.id.left_back_title);
        ImageView leftBack = (ImageView) rootView.findViewById(R.id.left_back);
        TextView rightInfo = (TextView) rootView.findViewById(R.id.base_right_tv);
        baseRightIv1 = (ImageView) rootView.findViewById(R.id.base_right_iv);
        if (baseLeftIv == null || tvTitle == null || baseRightIv1 == null) {
            return;
        }
        tvTitle.setText(titleText);
        leftBackInfo.setVisibility(View.VISIBLE);
        leftBack.setVisibility(View.GONE);
        rightInfo.setVisibility(View.GONE);
        baseRightIv1.setVisibility(View.VISIBLE);
        baseLeftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        baseRightIv1.setImageResource(resId);
        rightArea.setOnClickListener(listener);
    }

    protected void initBaseTitle(String titleText, boolean isShowLeftInfo) {
        View baseLeftIv = rootView.findViewById(R.id.base_left_iv);
        TextView tvTitle = (TextView) rootView.findViewById(R.id.base_title_tv);
        baseRightIv = (ImageView) rootView.findViewById(R.id.base_right_iv);
        if (baseLeftIv == null || tvTitle == null || baseRightIv == null) {
            return;
        }
        if (isShowLeftInfo) {
            baseLeftIv.setVisibility(View.GONE);
        } else {
            baseLeftIv.setVisibility(View.VISIBLE);
        }
        tvTitle.setText(titleText);
        baseLeftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyFetchDataIfPrepared();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        lazyFetchDataIfPrepared();
    }

    private void lazyFetchDataIfPrepared() {
        if (isViewPrepared && getUserVisibleHint() && !hasFetchData) {
            lazyFetchData();
            hasFetchData = true;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (loadingWindows != null) {
            loadingWindows.dismiss();
            loadingWindows = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hasFetchData = false;
        isViewPrepared = false;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * 开启加载效果
     */
    public void startProgressDialog() {
        if (loadingWindows == null) {
            loadingWindows = new LoadingDialog(getActivity());
        }
        loadingWindows.show();
    }

    /**
     * 关闭加载
     */
    public void stopProgressDialog() {
        if (loadingWindows != null) {
            loadingWindows.dismiss();
            loadingWindows = null;
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void lazyFetchData();

    public void showToast(final String text) {
        final Activity activity = getActivity();
        if (activity != null) {
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
        }
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

}
