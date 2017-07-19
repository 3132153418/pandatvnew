package com.jiyun.pandatv.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.pandatv.Application.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());//设置Activity加载的布局

        bind = ButterKnife.bind(this);

        initView();//初始化组件

        loadData();
    }

    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void loadData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
