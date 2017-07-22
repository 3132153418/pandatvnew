package com.jiyun.pandatv.moudle.biz.home;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.emileregutils.EmileRegUtils;
import com.jiyun.pandatv.emileregutils.MyLogCallBack;
import com.jiyun.pandatv.emileregutils.MyLoginCallBack;
import com.jiyun.pandatv.httpadress.Urls;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/22.
 */

public class PhoneMoudleIpl implements PhoneMoudle {
    @Override
    public void getPhone(MyLoginCallBack callBack) {
        EmileRegUtils.getInstance().loginPost(Urls.EMILEYANZHENG,null,null,callBack);
    }

    @Override
    public void setPhone(String number, String yanzm, MyLogCallBack callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("method","getRequestVerifiCodeM");
        map.put("mobile",number);
        map.put("verfiCodeType","1");
        map.put("verificationCode",yanzm);

        Map<String,String> map1 = new HashMap<>();
        try {
            map1.put("Referer", URLEncoder.encode( "http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            map1.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        map1.put("Cookie",getCookie());
        EmileRegUtils.getInstance().registerPost(Urls.PHONENUM,map,map1,callBack);
    }

    @Override
    public void phoneRegister(String number, String yanzm, String pwd, MyLogCallBack callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("method","saveMobileRegisterM");
        map.put("mobile",number);
        map.put("verfiCodeType","1");
        map.put("verfiCode",yanzm);
        map.put("passWd",pwd);
        try {
            map.put("addons",URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String,String> map1 = new HashMap<>();
        try {
            map1.put("Referer",URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            map1.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        EmileRegUtils.getInstance().registerPost(Urls.PHONEREGISTER,map,map1,callBack);
    }

    public String getCookie(){
        SharedPreferences cookie = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        String string = cookie.getString("Cookie", null);
        return string;
    }
}
