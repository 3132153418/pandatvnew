package com.jiyun.pandatv.module.home.centre;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.pandatv.Application.App;
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
        personalDeleteImg = (ImageView) findViewById(R.id.personal_delete_img);
        personalDeleteImg.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        try {
            number.setText(CleanMessageUtil.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settingBack:
                finish();
                break;
            case R.id.personal_delete_img:
                onClickCleanCache();
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

    private void onClickCleanCache() {
        getConfirmDialog(this, "是否清空缓存?", new DialogInterface.OnClickListener
                () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CleanMessageUtil.clearAllCache(App.context);
                number.setText("0 k");
            }
        }).show();
    }

    public static AlertDialog.Builder getConfirmDialog(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("确定", onClickListener);
        builder.setNegativeButton("取消", null);
        return builder;
    }

    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }

}
