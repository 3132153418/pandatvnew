package com.jiyun.pandatv.module.home.centre;

import android.view.View;
import android.widget.ImageView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

/**
 * Created by Administrator on 2017/7/17.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener{
    private ImageView settingBack;
    @Override
    protected int getLayoutId() {
        return R.layout.panda_person_setting;
    }

    @Override
    protected void initView() {

        settingBack = (ImageView) findViewById(R.id.settingBack);
        settingBack.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.settingBack:
                finish();
                break;
        }
    }
}
