package com.jiyun.pandatv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;

import com.jiyun.pandatv.base.BaseActivity;

/**
 * Created by Administrator on 2017/6/14.
 */

public class LogoActivity extends BaseActivity {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private String have;
    @Override
    protected int getLayoutId() {
        return R.layout.logo;
    }

    @Override
    protected void initView() {
        preferences = getSharedPreferences("data",MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                have = preferences.getString("have","");
                if (have.isEmpty()){
                    Intent intent = new Intent(LogoActivity.this,SplashActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(LogoActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        },2000);

    }

    @Override
    protected void loadData() {

    }

}
