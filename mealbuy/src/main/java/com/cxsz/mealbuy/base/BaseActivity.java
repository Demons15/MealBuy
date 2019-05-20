package com.cxsz.mealbuy.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.component.AppForegroundStateManager;
import com.cxsz.mealbuy.component.AppManager;
import com.cxsz.mealbuy.component.StatusBarUtils;
import com.cxsz.mealbuy.component.LoadingDialog;

import java.util.List;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by llf on 2017/3/1.
 * 基础的Activity
 */

public abstract class BaseActivity extends SupportActivity {
    protected static final String TAG = "BaseActivity";
    protected Toast toast;
    protected Context context;
    private LoadingDialog loadingWindows;
    public View baseLeftIv;
    private static final int REQUEST_PERMISSION = 0;
    private WifiManager mWifiManager;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            List<ScanResult> list = mWifiManager.getScanResults();
        }
    };
    public TextView rightTextView;

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

    protected void showToast(String message) {
        toast.setText(message);
        toast.show();
    }

    protected void showNoNetwork() {
        showToast(getString(R.string.network_unavailable));
    }

    protected void showNetworkFailed() {
        showToast(getString(R.string.network_connection_failed));
    }

    protected void showToast() {
        toast.show();
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
    protected void onResume() {
        super.onResume();
//        if (flag) {

//        } else {
//            Toast.makeText(this, "no permission", Toast.LENGTH_SHORT).show();
//        }
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
        //        unregisterReceiver(mBroadcastReceiver);
        AppManager.getInstance().removeActivity(this);
    }

    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }


    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    private void initGetWifiInfoOption() {
        mWifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        if (!mWifiManager.isWifiEnabled()) {
            mWifiManager.setWifiEnabled(true);
        }
        mWifiManager.startScan();
        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        registerReceiver(mBroadcastReceiver, filter);
    }

    /**
     * 5.0以上系统状态栏透明,国产手机默认透明
     */
    protected void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 读取状态栏的高度
     *
     * @param context
     * @return
     */

    protected int getStatusBarHeight(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            return resourceId > 0 ? context.getResources().getDimensionPixelSize(resourceId) : 0;
        } else {
            return 0;
        }
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

    protected void initBaseRightTitle(String titleText, String rightInfo, int rightInfoColor, View.OnClickListener listener) {
        View baseLeftIv = findViewById(R.id.base_left_iv);
        View rightArea = findViewById(R.id.right_area);
        TextView tvTitle = findViewById(R.id.base_title_tv);
        ImageView baseRightIv = findViewById(R.id.base_right_iv);
        ImageView leftBack = findViewById(R.id.left_back);
        rightTextView = findViewById(R.id.base_right_tv);
        if (baseLeftIv == null || tvTitle == null || baseRightIv == null) {
            return;
        }
        baseRightIv.setVisibility(View.GONE);
        rightTextView.setVisibility(View.VISIBLE);
        rightTextView.setText(rightInfo);
        rightTextView.setTextColor(rightInfoColor);
        rightArea.setOnClickListener(listener);
        tvTitle.setText(titleText);
        baseLeftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void initBaseTitle(String titleText, View.OnClickListener listener) {
        View baseLeftIv = findViewById(R.id.base_left_iv);
        View rightArea = findViewById(R.id.right_area);
        TextView tvTitle = findViewById(R.id.base_title_tv);
        ImageView baseRightIv = findViewById(R.id.base_right_iv);
        if (baseLeftIv == null || tvTitle == null || baseRightIv == null) {
            return;
        }
        tvTitle.setText(titleText);
        baseLeftIv.setOnClickListener(listener);
    }

    protected void initBaseTitle(String titleText, int resId, View.OnClickListener listener) {
        View baseLeftIv = findViewById(R.id.base_left_iv);
        View rightArea = findViewById(R.id.right_area);
        TextView tvTitle = findViewById(R.id.base_title_tv);
        TextView leftBackInfo = findViewById(R.id.left_back_title);
        ImageView leftBack = findViewById(R.id.left_back);
        TextView rightInfo = findViewById(R.id.base_right_tv);
        ImageView baseRightIv = findViewById(R.id.base_right_iv);
        if (baseLeftIv == null || tvTitle == null || baseRightIv == null) {
            return;
        }
        tvTitle.setText(titleText);
        leftBackInfo.setVisibility(View.VISIBLE);
        leftBack.setVisibility(View.GONE);
        rightInfo.setVisibility(View.GONE);
        baseRightIv.setVisibility(View.VISIBLE);
        baseLeftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        baseRightIv.setImageResource(resId);
        rightArea.setOnClickListener(listener);
    }

    protected void initBaseTitle(String titleText, int resId) {
        View baseLeftIv = findViewById(R.id.base_left_iv);
        View rightArea = findViewById(R.id.right_area);
        TextView tvTitle = findViewById(R.id.base_title_tv);
        ImageView baseRightIv = findViewById(R.id.base_right_iv);
        ImageView leftBack = findViewById(R.id.left_back);
        TextView rightInfo = findViewById(R.id.base_right_tv);
        if (baseLeftIv == null || tvTitle == null || baseRightIv == null) {
            return;
        }
        tvTitle.setText(titleText);
        Glide.with(context).load(resId).into(baseRightIv);
        baseLeftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 检测Sdcard是否存在
     *
     * @return
     */
    public boolean isExitsSdcard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    protected boolean isNetworkAvailable() {
        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = mgr.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

}
