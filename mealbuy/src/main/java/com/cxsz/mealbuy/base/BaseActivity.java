package com.cxsz.mealbuy.base;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.AppForegroundStateManager;
import com.cxsz.mealbuy.component.AppManager;
import com.cxsz.mealbuy.component.StatusBarUtils;
import com.cxsz.mealbuy.component.LoadingDialog;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * 基础的Activity
 */

public abstract class BaseActivity extends SupportActivity {
    protected Toast toast;
    protected Context context;
    private LoadingDialog loadingWindows;
    public View baseLeftIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        setContentView(getLayoutId());
        StatusBarUtils.with(this).init();
        context = getApplicationContext();
        toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        this.initView(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //当模式为singleTop和SingleInstance会回调到这里
    }

    @Override
    protected void onStart() {
        super.onStart();
        AppForegroundStateManager.getInstance().onActivityVisible(this);
    }

    @Override
    protected void onStop() {
        AppForegroundStateManager.getInstance().onActivityNotVisible(this);
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (loadingWindows != null) {
            loadingWindows.dismiss();
            loadingWindows = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    /**
     * 开启加载效果
     */
    public void startProgressDialog() {
        if (loadingWindows == null) {
            loadingWindows = new LoadingDialog(this);
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

    //获取布局
    protected abstract int getLayoutId();

    //初始化布局和监听
    protected abstract void initView(Bundle savedInstanceState);

    protected void initBaseTitle(String titleText) {
        baseLeftIv = findViewById(R.id.base_left_iv);
        View rightArea = findViewById(R.id.right_area);
        TextView tvTitle = findViewById(R.id.base_title_tv);
        ImageView baseRightIv = findViewById(R.id.base_right_iv);
        ImageView leftBack = findViewById(R.id.left_back);
        TextView rightInfo = findViewById(R.id.base_right_tv);
        if (baseLeftIv == null || tvTitle == null || baseRightIv == null) {
            return;
        }
        baseRightIv.setVisibility(View.GONE);
        rightInfo.setVisibility(View.GONE);
        tvTitle.setText(titleText);
        baseLeftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
