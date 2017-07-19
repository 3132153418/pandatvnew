package com.jiyun.pandatv.internet.callback;


public interface MyHttpCallBack<T> {

    void onSuccess(T t);
    void onError(int errorCode,String errorMsg);

}
