package com.jiyun.pandatv.internet.HttpBase;


import com.jiyun.pandatv.internet.callback.MyHttpCallBack;

import java.util.Map;

public interface BaseHttp {


    <T> void get(String url, Map<String,String> parmers, MyHttpCallBack<T> callBack);
    <T> void post(String url, Map<String,String> parmers, MyHttpCallBack<T> callBack);
    void upload();
    void download();
    void loadImage();

}
