package com.jiyun.pandatv.module.home.centre;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.module.home.centre.shoucang.ShouCangActivity;

/**
 * Created by Administrator on 2017/7/15.
 */

public class CentreActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout click_Login_LinearLayout, gunakanLiShi, myShouCang, shezhi;
    private ImageView original_Back_Image;
    private TextView name_TextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_centre;
    }

    @Override
    protected void initView() {
        click_Login_LinearLayout = (LinearLayout) findViewById(R.id.click_Login_LinearLayout);
        click_Login_LinearLayout.setOnClickListener(this);
        gunakanLiShi = (LinearLayout) findViewById(R.id.gunakanLiShi);
        gunakanLiShi.setOnClickListener(this);
        myShouCang = (LinearLayout) findViewById(R.id.myShouCang);
        myShouCang.setOnClickListener(this);
        shezhi = (LinearLayout) findViewById(R.id.shezhi);
        shezhi.setOnClickListener(this);
        original_Back_Image = (ImageView) findViewById(R.id.original_Back_ImageOne);
        original_Back_Image.setOnClickListener(this);
        name_TextView = (TextView) findViewById(R.id.name_TextView);

    }

    @Override
    protected void loadData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click_Login_LinearLayout:
                if (name_TextView.getText().toString().equals("点击登录")) {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivityForResult(intent, 0);
                } else {
                    Intent intent1 = new Intent(CentreActivity.this, GeRenXinXiActivity.class);
                    intent1.putExtra("name", name_TextView.getText().toString());
                    startActivityForResult(intent1, 20);
                }
                break;

            case R.id.gunakanLiShi:

                break;
            case R.id.myShouCang:
                Intent intent = new Intent(CentreActivity.this, ShouCangActivity.class);
                startActivity(intent);
                break;
            case R.id.shezhi:
                Intent intent1 = new Intent(this, SettingActivity.class);
                startActivity(intent1);

                break;
           case R.id.original_Back_ImageOne:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (resultCode) {
                case 0:
                    name_TextView.setText(data.getStringExtra("name"));
                    break;
                case 20:
                    name_TextView.setText(data.getStringExtra("user"));
                    break;
                case 10:
                    name_TextView.setText(data.getStringExtra("names"));
                    break;
            }
        }
    }
}
