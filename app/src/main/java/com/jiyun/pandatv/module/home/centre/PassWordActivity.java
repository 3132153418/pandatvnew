package com.jiyun.pandatv.module.home.centre;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

/**
 * Created by Administrator on 2017/7/22.
 */

public class PassWordActivity extends BaseActivity implements PassWordContract.View,View.OnClickListener{
    private ImageView pwd_ImageView;
    private PassWordPresenter presenter;
    private Button pwd_yanzhengma_Btn,find_pwd_Button;
    private EditText pwd_Edit,pwd_yanzhengma_Edit,pwd_pwd_Edit,pwd_image_Edit;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_password;
    }

    @Override
    protected void initView() {
        new PassWordPresenter(this);
        pwd_ImageView = (ImageView) findViewById(R.id.pwd_ImageView);
        pwd_ImageView.setOnClickListener(this);
        pwd_yanzhengma_Btn = (Button) findViewById(R.id.pwd_yanzhengma_Btn);
        pwd_yanzhengma_Btn.setOnClickListener(this);
        find_pwd_Button = (Button) findViewById(R.id.find_pwd_Button);
        find_pwd_Button.setOnClickListener(this);
        pwd_Edit = (EditText) findViewById(R.id.pwd_Edit);
        pwd_yanzhengma_Edit = (EditText) findViewById(R.id.pwd_yanzhengma_Edit);
        pwd_pwd_Edit = (EditText) findViewById(R.id.pwd_pwd_Edit);
        pwd_image_Edit = (EditText) findViewById(R.id.pwd_image_Edit);

    }

    @Override
    protected void loadData() {

        presenter.start();
    }

    @Override
    public void setPwdYz(Drawable drawable) {
        pwd_ImageView.setImageDrawable(drawable);
    }

    @Override
    public void setStrPwd(String strPhone) {

    }

    @Override
    public void setRegsPwd(String string) {

    }

    @Override
    public void setPresenter(PassWordContract.Presenter presenter) {

        this.presenter = (PassWordPresenter) presenter;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.pwd_ImageView:
                presenter.start();
                break;
            case R.id.pwd_yanzhengma_Btn:
                presenter.getPwdYz(pwd_Edit.getText().toString()
                ,pwd_yanzhengma_Edit.getText().toString());
                break;
            case R.id.find_pwd_Button:
                presenter.getStrPwd(pwd_Edit.getText().toString()
                        ,pwd_yanzhengma_Edit.getText().toString()
                        ,pwd_pwd_Edit.getText().toString());
                finish();
                break;
        }
    }
}
