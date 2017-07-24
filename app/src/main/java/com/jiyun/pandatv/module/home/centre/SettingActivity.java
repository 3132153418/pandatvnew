package com.jiyun.pandatv.module.home.centre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/17.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.isPush)
    CheckBox isPush;
    @BindView(R.id.isPlay)
    CheckBox isPlay;
    @BindView(R.id.personal_delete_img)
    ImageView personalDeleteImg;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.clean)
    RelativeLayout clean;
    @BindView(R.id.panda_setting_help)
    RelativeLayout pandaSettingHelp;
    @BindView(R.id.isShengji)
    ImageView isShengji;
    @BindView(R.id.panda_setting_shengji)
    RelativeLayout pandaSettingShengji;
    @BindView(R.id.isGood)
    ImageView isGood;
    @BindView(R.id.panda_setting_haoping)
    RelativeLayout pandaSettingHaoping;
    @BindView(R.id.isAbout)
    ImageView isAbout;
    @BindView(R.id.panda_setting_about)
    RelativeLayout pandaSettingAbout;
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
        switch (v.getId()) {
            case R.id.settingBack:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.panda_setting_help, R.id.panda_setting_shengji, R.id.panda_setting_haoping, R.id.panda_setting_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.panda_setting_help:
Intent intent = new Intent(SettingActivity.this, PersonhelpActivity.class);
startActivity(intent);
                break;
            case R.id.panda_setting_shengji:
                break;
            case R.id.panda_setting_haoping:
                break;
            case R.id.panda_setting_about:
                break;
        }
    }
}
