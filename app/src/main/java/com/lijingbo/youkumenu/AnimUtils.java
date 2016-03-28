package com.lijingbo.youkumenu;

import android.view.View;
import android.view.animation.RotateAnimation;

/**
 * @FileName: com.lijingbo.youkumenu.AnimUtils.java
 * @Author: Li Jingbo
 * @Date: 2016-03-28 11:27
 * @Version V1.0 <描述当前版本功能>
 */
public class AnimUtils {
    private static final String TAG = "AnimUtils";

    //关闭动画效果
    public static void closeMenu(View view) {
        RotateAnimation animation = new RotateAnimation(0, -180, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 1f);
        animation.setDuration(200);
        animation.setFillAfter(true);
        view.startAnimation(animation);
    }

    //开始动画效果
    public static void startMenu(View view) {
        RotateAnimation animation = new RotateAnimation(-180, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 1f);
        animation.setFillAfter(true);
        animation.setDuration(200);
        view.startAnimation(animation);
    }
}
