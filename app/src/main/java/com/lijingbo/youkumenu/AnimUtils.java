package com.lijingbo.youkumenu;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;


public class AnimUtils {
    private static final String TAG = "AnimUtils";
    public static int animCount = 0;

    //关闭动画效果
    public static void closeMenu(RelativeLayout view, long startOffset) {
        //view关闭动画以后，所有的子view的enable为true
        for ( int i = 0; i < view.getChildCount(); i++ ) {
            view.getChildAt(i).setEnabled(false);
        }

        RotateAnimation animation = new RotateAnimation(0, -180, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 1f);
        animation.setDuration(400);
        animation.setStartOffset(startOffset);
        animation.setFillAfter(true);
        view.startAnimation(animation);
        animation.setAnimationListener(new AnimListener());
    }

    //开始动画效果
    public static void startMenu(RelativeLayout view, long startOffset) {
        //view显示动画以后，所有的子view的enable为true
        for ( int i = 0; i < view.getChildCount(); i++ ) {
            view.getChildAt(i).setEnabled(true);
        }
        RotateAnimation animation = new RotateAnimation(-180, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 1f);
        animation.setFillAfter(true);
        animation.setDuration(400);
        animation.setStartOffset(startOffset);
        view.startAnimation(animation);
        animation.setAnimationListener(new AnimListener());
    }

    static class AnimListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
            //有动画执行，++
            animCount++;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //没有动画执行，--
            animCount--;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
