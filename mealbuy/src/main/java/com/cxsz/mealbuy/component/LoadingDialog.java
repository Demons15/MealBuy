package com.cxsz.mealbuy.component;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.cxsz.mealbuy.R;
import com.cxsz.mealbuy.base.BaseDialogView;


public class LoadingDialog extends BaseDialogView {

    private ImageView rotateView;

    public LoadingDialog(Activity activity) {
        super(activity, ShowType.CENTER);
    }

    @Override
    public void initViewInfo() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.loading_layout, contentContainer);
        rotateView = view.findViewById(R.id.rotate_view);

    }

    @Override
    public void show() {
        super.show();
        rotate(rotateView);
    }

    private void rotate(ImageView imageView) {
        RotateAnimation rotate = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lin = new LinearInterpolator();
        rotate.setInterpolator(lin);
        rotate.setDuration(2000);//设置动画持续周期
        rotate.setRepeatCount(-1);//设置重复次数
        rotate.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        rotate.setStartOffset(10);//执行前的等待时间
        imageView.setAnimation(rotate);
    }
}
