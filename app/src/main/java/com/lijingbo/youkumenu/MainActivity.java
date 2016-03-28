package com.lijingbo.youkumenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rl_level3, rl_level2, rl_level1;
    private ImageView iv_home, iv_menu;
    private boolean isShowLevel2 = true;
    private boolean isShowLevel3 = true;
    private boolean isShowLevel1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();

    }

    private void initView() {
        setContentView(R.layout.activity_main);
        rl_level2 = (RelativeLayout) findViewById(R.id.rl_level2);
        rl_level3 = (RelativeLayout) findViewById(R.id.rl_level3);
        rl_level1 = (RelativeLayout) findViewById(R.id.rl_level1);
        iv_home = (ImageView) findViewById(R.id.iv_home);
        iv_menu = (ImageView) findViewById(R.id.iv_menu);
    }

    private void initListener() {
        iv_home.setOnClickListener(this);
        iv_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ) {
            case R.id.iv_home:
                //判断是否有动画在执行
                if ( AnimUtils.animCount != 0 ) {
                    break;
                }
                if ( isShowLevel2 ) {
                    int startOffset = 0;
                    if ( isShowLevel3 ) {
                        AnimUtils.closeMenu(rl_level3, startOffset);
                        isShowLevel3 = false;
                        startOffset += 200;
                    }
                    //关闭二级菜单
                    AnimUtils.closeMenu(rl_level2, startOffset);
                } else {
                    //显示二级菜单
                    AnimUtils.startMenu(rl_level2, 0);
                }
                isShowLevel2 = !isShowLevel2;
                break;

            case R.id.iv_menu:
                //判断是否有动画在执行
                if ( AnimUtils.animCount != 0 ) {
                    break;
                }
                if ( isShowLevel3 ) {
                    //关闭三级次菜单
                    AnimUtils.closeMenu(rl_level3, 0);
                } else {
                    //显示三级菜单
                    AnimUtils.startMenu(rl_level3, 0);
                }
                isShowLevel3 = !isShowLevel3;

                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch ( keyCode ) {
            //监听menu键
            case KeyEvent.KEYCODE_MENU:
                //判断是否有动画在执行
                if ( AnimUtils.animCount != 0 ) {
                    break;
                }
                if ( isShowLevel1 ) {
                    int startOffset = 0;
                    if ( isShowLevel2 ) {
                        if ( isShowLevel3 ) {
                            AnimUtils.closeMenu(rl_level3, startOffset);
                            startOffset += 200;
                            isShowLevel3 = false;
                        }
                        AnimUtils.closeMenu(rl_level2, startOffset);
                        startOffset += 200;
                        isShowLevel2 = false;
                    }
                    AnimUtils.closeMenu(rl_level1, startOffset);
                    isShowLevel1 = false;
                } else {
                    AnimUtils.startMenu(rl_level1, 0);
                    AnimUtils.startMenu(rl_level2, 200);
                    AnimUtils.startMenu(rl_level3, 400);
                    isShowLevel1 = true;
                    isShowLevel2 = true;
                    isShowLevel3 = true;
                }
                break;
        }

        return super.onKeyDown(keyCode, event);
    }
}
