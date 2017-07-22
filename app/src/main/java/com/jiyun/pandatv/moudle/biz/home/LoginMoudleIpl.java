package com.jiyun.pandatv.moudle.biz.home;

import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.LoginEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/21.
 */

public class LoginMoudleIpl implements LoginMoudle {
    @Override
    public void getLogin(String name, String pwd, MyHttpCallBack<LoginEntity> callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("username",name);
        map.put("password",pwd);
        map.put("from","https://reg.cntv.cn/login/login.action");
        map.put("service","client_transaction");

        loginUtils.get(Urls.LOGIN,map,callBack);
    }
}
