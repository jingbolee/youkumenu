package com.lijingbo.youkumenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rl_level3, rl_level2, rl_level1;
    private ImageView iv_home, iv_menu;
    private boolean isShowLevel2 = true;
    private boolean isShowLevel3 = true;

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
                if ( isShowLevel2 ) {
                    //关闭二级菜单
                    AnimUtils.closeMenu(rl_level2);
                } else {
                    //显示二级菜单
                    AnimUtils.startMenu(rl_level2);
                }
                isShowLevel2 = !isShowLevel2;
                break;

            case R.id.iv_menu:
                if ( isShowLevel3 ) {
                    //关闭三级次菜单
                    AnimUtils.closeMenu(rl_level3);
                } else {
                    //显示三级菜单
                    AnimUtils.startMenu(rl_level3);
                }
                isShowLevel3 = !isShowLevel3;

                break;
        }
    }
}
