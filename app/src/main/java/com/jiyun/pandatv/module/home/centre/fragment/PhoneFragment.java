package com.jiyun.pandatv.module.home.centre.fragment;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/18.
 */

public class PhoneFragment extends BaseFragment implements View.OnClickListener,PhoneContract.View {
    private ImageView phone_ImageView;
    private EditText phone_Edit, image_Edit, yanzhengma_Edit, pwd_Edit;
    private CheckBox login_CheckBox;
    private Button yanzhengma_Btn, login_Button;
    private TextView textView, yanzhnegma_Text;
    private int a = 60;
    byte[] bytes;
    private OkHttpClient client = new OkHttpClient();
    private String jsonId;
    private PhonePresenter presenter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_phone;
    }

    @Override
    protected void init(View view) {
        new PhonePresenter(this);
        phone_Edit = (EditText) view.findViewById(R.id.phone_Edit);
        image_Edit = (EditText) view.findViewById(R.id.image_Edit);
        yanzhengma_Edit = (EditText) view.findViewById(R.id.yanzhengma_Edit);
        pwd_Edit = (EditText) view.findViewById(R.id.pwd_Edit);
        login_Button = (Button) view.findViewById(R.id.login_Button);
        login_Button.setOnClickListener(this);
        login_CheckBox = (CheckBox) view.findViewById(R.id.login_CheckBox);
        yanzhengma_Btn = (Button) view.findViewById(R.id.yanzhengma_Btn);
        yanzhengma_Btn.setOnClickListener(this);
        phone_ImageView = (ImageView) view.findViewById(R.id.phone_ImageView);
        phone_ImageView.setOnClickListener(this);
        textView = (TextView) view.findViewById(R.id.phone_TextView);
        yanzhnegma_Text = (TextView) view.findViewById(R.id.yanzheng_TextView);

    }

    @Override
    protected void initData() {
        presenter.start();
    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phone_Edit:
                if (phone_Edit.getText().toString().equals("")) {
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("手机号码不能为空");
                } else {
                    textView.setVisibility(View.GONE);
                }
                break;
            case R.id.image_Edit:
                break;
            case R.id.phone_ImageView:
               presenter.start();
                break;
            case R.id.login_CheckBox:
                break;
            case R.id.yanzhengma_Btn:
                presenter.getPhoneYz(phone_Edit.getText().toString(),image_Edit.getText().toString());
                break;
            case R.id.login_Button:
                presenter.getStrPhone(phone_Edit.getText().toString(),yanzhengma_Edit.getText().toString(),pwd_Edit.getText().toString());
                if (phone_Edit.getText().toString().equals("")
                        || yanzhengma_Edit.getText().toString().equals("")
                        || pwd_Edit.getText().toString().equals("")){
                    Toast.makeText(getContext(), "注册失败，手机号和验证码和密码不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    getActivity().finish();
                }

                break;
        }
    }

    @Override
    public void setPhoneReg(Drawable drawable) {
        phone_ImageView.setImageDrawable(drawable);

    }

    @Override
    public void setStrPhone(String strPhone) {

    }

    @Override
    public void setRegsPhone(String string) {

    }

    @Override
    public void setPresenter(PhoneContract.Presenter presenter) {

        this.presenter = (PhonePresenter) presenter;
    }
}
