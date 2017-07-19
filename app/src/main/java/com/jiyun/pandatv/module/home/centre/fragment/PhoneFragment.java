package com.jiyun.pandatv.module.home.centre.fragment;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by Administrator on 2017/7/18.
 */

public class PhoneFragment extends BaseFragment implements View.OnClickListener {
    private ImageView phone_ImageView;
    private EditText phone_Edit,image_Edit,yanzhengma_Edit,pwd_Edit;
    private CheckBox login_CheckBox;
    private Button yanzhengma_Btn,login_Button;
    private int a=60;
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

    }

    @Override
    protected void initData() {
        Glide.with(getActivity()).load("http://reg.cntv.cn/simple/verificationCode.action").into(phone_ImageView);

    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_CheckBox:
            break;
            case R.id.yanzhengma_Btn:
                if(phone_Edit != null) {
                    String phone = phone_Edit.getText().toString().trim();
                    SMSSDK.getVerificationCode("+86", phone, new OnSendMessageHandler() {
                        @Override
                        public boolean onSendMessage(String s, String s1) {
                            return false;
                        }
                    });
                    handler.post(runnable);
                    break;
                }
            case R.id.login_Button:
                initView();
                break;
        }
    }

    private void initView() {

        if (phone_Edit.getText().toString().equals("")){
            Toast.makeText(getContext(), "手机号不能为空", Toast.LENGTH_SHORT).show();
        }else if (image_Edit.getText().toString().equals("")){
            Toast.makeText(getContext(), "验证码不能为空", Toast.LENGTH_SHORT).show();
        }else if (yanzhengma_Edit.getText().toString().equals("")){
            Toast.makeText(getContext(), "验证码不能为空", Toast.LENGTH_SHORT).show();
        }else if (pwd_Edit.getText().toString().equals("")){
            Toast.makeText(getContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
        }else {

        }
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Toast.makeText(getContext(),"短信验证成功",Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(getContext(),"短信获取成功",Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if(a>0) {
                a--;
                handler.sendEmptyMessage(2);
                handler.postDelayed(runnable, 1000);
                yanzhengma_Btn.setText("正在发送验证码");
                yanzhengma_Btn.setClickable(false);
            }else {
                a=60;
                yanzhengma_Btn.setText("重新发送验证码");
                yanzhengma_Btn.setClickable(true);
            }

        }
    };
    private EventHandler eventHandler=new EventHandler(){

        @Override
        public void afterEvent(int event, int result, Object data) {

            if (result == SMSSDK.RESULT_COMPLETE) {
                //回调完成
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    HashMap<String,Object> map= (HashMap<String, Object>) data;
                    String shouji= (String) map.get("phone");
                    if(shouji.equals(phone_Edit)){
                        handler.sendEmptyMessage(0);
                    }
                    //提交验证码成功
                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    Boolean boo= (Boolean) data;
                    handler.sendEmptyMessage(1);
                    //获取验证码成功
                } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                    ArrayList<HashMap<String,Object>> list= (ArrayList<HashMap<String, Object>>) data;
                    Log.e("aaa",list+"");
                    //返回支持发送验证码的国家列表
                }
            } else {
                ((Throwable) data).printStackTrace();
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }
}
