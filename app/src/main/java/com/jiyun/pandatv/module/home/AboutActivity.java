package com.jiyun.pandatv.module.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/24.
 */
public class AboutActivity extends BaseActivity {
    @BindView(R.id.about_web_back)
    ImageView aboutWebBack;
    @BindView(R.id.about_version)
    TextView aboutVersion;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_about;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.about_web_back)
    public void onViewClicked() {
        finish();
    }
}
