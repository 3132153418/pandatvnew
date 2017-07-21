package com.jiyun.pandatv.module.home.centre;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.SocializeUtils;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/17.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private ImageView loginBack,weibo_Login,qqLogin;
    private ProgressDialog dialog;
    private TextView register;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {
        dialog = new ProgressDialog(this);
        register = (TextView) findViewById(R.id.register_Text);
        register.setOnClickListener(this);

        loginBack = (ImageView) findViewById(R.id.loginBack);
        loginBack.setOnClickListener(this);
        qqLogin = (ImageView) findViewById(R.id.qqLogin);
        qqLogin.setOnClickListener(this);
        weibo_Login = (ImageView) findViewById(R.id.weibo_Login);
        weibo_Login.setOnClickListener(this);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBack:
                finish();
                break;
            case R.id.qqLogin:

                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.QQ, authListener);

                break;
            case R.id.weibo_Login:
                UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.SINA, authListener);
                break;
            case R.id.register_Text:
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
    UMAuthListener authListener = new UMAuthListener() {

        @Override
        public void onStart(SHARE_MEDIA platform) {
            SocializeUtils.safeShowDialog(dialog);
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            SocializeUtils.safeCloseDialog(dialog);
            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            SocializeUtils.safeCloseDialog(dialog);
            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            SocializeUtils.safeCloseDialog(dialog);
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };



}
