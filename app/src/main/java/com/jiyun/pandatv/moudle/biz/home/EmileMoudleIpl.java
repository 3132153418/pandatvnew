package com.jiyun.pandatv.moudle.biz.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.emileregutils.EmileRegUtils;
import com.jiyun.pandatv.emileregutils.MyLogCallBack;
import com.jiyun.pandatv.emileregutils.MyLoginCallBack;
import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/21.
 */

public class EmileMoudleIpl implements EmileMoudle {

    @Override
    public void getEmileRegister(String emile, String pwd, String yanzhengma, MyLogCallBack callBack) {

        Map<String,String> map = new HashMap<>();
        map.put("mailAdd",emile);
        map.put("passWd",pwd);
        map.put("verificationCode",yanzhengma);

        Map<String,String> map1 = new HashMap<>();
        try {
            map1.put("Referer", URLEncoder.encode("iPanda.Android", "UTF-8"));

            map1.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8"));
            map1.put("Cookie",getCookie());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        EmileRegUtils.getInstance().registerPost(Urls.EMILEREGIS,map,map1,callBack);
    }

    @Override
    public void setEmiRegs(MyLoginCallBack callBack) {
        EmileRegUtils.getInstance().loginPost(Urls.EMILEYANZHENG,null,null,callBack);
    }

    public String getCookie(){
        SharedPreferences cookie = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        String string = cookie.getString("Cookie", null);
        return string;
    }
}
