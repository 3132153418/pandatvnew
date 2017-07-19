package com.jiyun.pandatv.module.home.centre;

import android.view.View;
import android.widget.ImageView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

/**
 * Created by Administrator on 2017/7/17.
 */

public class LookActivity extends BaseActivity implements View.OnClickListener{
    private ImageView lookBack;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_look;
    }

    @Override
    protected void initView() {

        lookBack = (ImageView) findViewById(R.id.lookBack);
        lookBack.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lookBack:
                finish();
                break;
        }
    }
}
