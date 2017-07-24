package com.jiyun.pandatv.module.home.centre;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.moudle.entity.LoginEntity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.SocializeUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/17.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener,LoginContract.View{
    private ImageView loginBack,weibo_Login,qqLogin;
    private ProgressDialog dialog;
    private TextView register;
    private EditText editUserName,editUserPassword;
    private Button loginBtn;
    private LoginPresenter presenter;
    private Boolean isLogin = true;
    private  String user_seq_id;
    private TextView forget_password;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView() {
        dialog = new ProgressDialog(this);
        new LoginPresenter(this);
        register = (TextView) findViewById(R.id.register_Text);
        register.setOnClickListener(this);

        loginBack = (ImageView) findViewById(R.id.loginBack);
        loginBack.setOnClickListener(this);
        qqLogin = (ImageView) findViewById(R.id.qqLogin);
        qqLogin.setOnClickListener(this);
        weibo_Login = (ImageView) findViewById(R.id.weibo_Login);
        weibo_Login.setOnClickListener(this);
        editUserName = (EditText) findViewById(R.id.editUserName);
        editUserPassword = (EditText) findViewById(R.id.editUserPassword);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
        forget_password = (TextView) findViewById(R.id.forget_password);
        forget_password.setOnClickListener(this);

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
            case R.id.loginBtn:
                presenter.loge(editUserName.getText().toString(),editUserPassword.getText().toString());
                if (isLogin){
                    Intent intent1 = new Intent(LoginActivity.this,CentreActivity.class);
                    intent1.putExtra("id","央视网友"+user_seq_id);
                    startActivity(intent1);
                    finish();
                }else {
                    Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.forget_password:

                Intent intent1 = new Intent(LoginActivity.this,PassWordActivity.class);
                startActivity(intent1);
                finish();
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

    @Override
    public void setLogin(LoginEntity login) {
        String errMsg = login.getErrMsg();
        user_seq_id = login.getUser_seq_id();
        Log.i("susses",errMsg);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

            this.presenter= (LoginPresenter) presenter;
    }
}
