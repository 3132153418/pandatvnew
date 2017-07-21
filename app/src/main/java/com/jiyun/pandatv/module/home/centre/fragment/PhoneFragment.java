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

public class PhoneFragment extends BaseFragment implements View.OnClickListener {
    private ImageView phone_ImageView;
    private EditText phone_Edit, image_Edit, yanzhengma_Edit, pwd_Edit;
    private CheckBox login_CheckBox;
    private Button yanzhengma_Btn, login_Button;
    private TextView textView, yanzhnegma_Text;
    private int a = 60;
    byte[] bytes;
    private OkHttpClient client = new OkHttpClient();
    private String jsonId;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_phone;
    }

    @Override
    protected void init(View view) {
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
        // Glide.with(getActivity()).load("http://reg.cntv.cn/simple/verificationCode.action").into(phone_ImageView);
        getPersonalRegImgCheck();
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
                getPersonalRegImgCheck();
                break;
            case R.id.login_CheckBox:
                break;
            case R.id.yanzhengma_Btn:
                getPhoneCode();
                break;
            case R.id.login_Button:

                if (phone_Edit.getText().toString().equals("") || image_Edit.getText().toString().equals("") || yanzhengma_Edit.getText().toString().equals("") || pwd_Edit.getText().toString().equals("")){
                    Toast.makeText(getContext(), "注册失败", Toast.LENGTH_SHORT).show();
                }else {
                    register();
                    getActivity().finish();
                }
                break;
        }
    }

    //获取图片验证码
    public void getPersonalRegImgCheck() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request build = new Request.Builder().url("http://reg.cntv.cn/simple/verificationCode.action").build();
                client.newCall(build).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Headers headers = response.headers();
                        jsonId = headers.get("Set-Cookie");
                        bytes = response.body().bytes();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Drawable captchaImage = byteToDrawable(bytes);
                                phone_ImageView.setImageDrawable(captchaImage);
                            }
                        });
                    }
                });
            }
        }).start();
    }

    public static Drawable byteToDrawable(byte[] byteArray) {
        try {
            String string = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
        return Drawable.createFromStream(ins, null);
    }
    //获取手机验证码
    public void getPhoneCode() {
        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
        String from = "http://cbox_mobile.regclientuser.cntv.cn";
//                    手机号
        String tPhoneNumber = phone_Edit.getText().toString().trim();
//                    验证码
        String imgyanzhengma = image_Edit.getText().toString().trim();

        RequestBody body = new FormBody.Builder()
                .add("method", "getRequestVerifiCodeM")
                .add("mobile", tPhoneNumber)
                .add("verfiCodeType", "1")
                .add("verificationCode", imgyanzhengma)
                .build();

        try {
            Request request = new Request.Builder().url(url)
                    .addHeader("Referer", URLEncoder.encode(from, "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .addHeader("Cookie", jsonId)
                    .post(body).build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.i("TAG", "失败");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    Log.i("TAG", "手机验证码打印：" + string);
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    //注册
    public void register() {
        String url = "https://reg.cntv.cn/regist/mobileRegist.do";
//                    手机号
        String tPhoneNumber = phone_Edit.getText().toString().trim();
//                    验证码
        String imgyanzhengma = image_Edit.getText().toString().trim();

        String tCheckPhone = yanzhengma_Edit.getText().toString().trim();
        String tPassWord = pwd_Edit.getText().toString();

        RequestBody body = null;
        try {
            body = new FormBody.Builder()
                    .add("method", "saveMobileRegisterM")
                    .add("mobile", tPhoneNumber)
                    .add("verfiCodeType", "1")
                    .add("verfiCode", tCheckPhone)
                    .add("passWd", URLEncoder.encode(tPassWord, "UTF-8"))
                    .add("addons",URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                    .build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            Request request = new Request.Builder().url(url)
                    .addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
                    .post(body).build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.i("TAG", "失败");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    Log.i("TAG", "注册：" + string);
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


}
