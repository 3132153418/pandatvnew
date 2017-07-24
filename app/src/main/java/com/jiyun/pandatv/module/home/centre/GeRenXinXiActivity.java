package com.jiyun.pandatv.module.home.centre;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

/**
 * Created by Administrator on 2017/7/24.
 */

public class GeRenXinXiActivity extends BaseActivity implements View.OnClickListener{
    private LinearLayout name_TiaoZhuan;
    private ImageView geRenXinXi_Back_Image;
    private TextView gerenXinXi_name;
    private Button tuichu_Login;
    @Override
    protected int getLayoutId() {
        return R.layout.login_tiaozhuan_geren;
    }

    @Override
    protected void initView() {

        name_TiaoZhuan = (LinearLayout) findViewById(R.id.name_TiaoZhuan);
        name_TiaoZhuan.setOnClickListener(this);
        geRenXinXi_Back_Image = (ImageView) findViewById(R.id.geRenXinXi_Back_Image);
        geRenXinXi_Back_Image.setOnClickListener(this);
        gerenXinXi_name = (TextView) findViewById(R.id.gerenXinXi_name);
        tuichu_Login = (Button) findViewById(R.id.tuichu_Login);
        tuichu_Login.setOnClickListener(this);
        Intent intent = getIntent();
        String uesrname = intent.getStringExtra("names");
        gerenXinXi_name.setText(uesrname);

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.name_TiaoZhuan:
                Intent intent = new Intent(GeRenXinXiActivity.this,XiuGaiNameActivity.class);
                intent.putExtra("user",gerenXinXi_name.getText().toString());
                startActivity(intent);
                break;
            case R.id.geRenXinXi_Back_Image:
                finish();
                break;
            case R.id.tuichu_Login:

                Intent intent1 = getIntent();
                intent1.putExtra("user","点击登录");
                setResult(20,intent1);
                finish();
                break;
        }
    }
}
