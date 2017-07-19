package com.jiyun.pandatv.internet.utils;

import com.jiyun.pandatv.internet.HttpBase.BaseHttp;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;

import java.util.Map;

/**
 * Created by xingge on 2017/7/11.
 */

public class RetrofitUtils implements BaseHttp {
    private static RetrofitUtils retrofitUtils;
    public static RetrofitUtils getInstance(){
        //加锁判断如果为空就创建对象
        if (retrofitUtils==null) {
            synchronized (OkHttpUtils.class){
                if (retrofitUtils==null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        //判断完成后返回工具类单例对象
        return retrofitUtils;
    }
    @Override
    public <T> void get(String url, Map<String, String> parmers, MyHttpCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, Map<String, String> parmers, MyHttpCallBack<T> callBack) {

    }

    @Override
    public void upload() {

    }

    @Override
    public void download() {

    }

    @Override
    public void loadImage() {

    }
}
