package com.jiyun.pandatv.internet.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.apputils.ACache;
import com.jiyun.pandatv.internet.HttpBase.BaseHttp;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils implements BaseHttp {

    private OkHttpClient okHttpClient;
    //构造函数私有化
    private OkHttpUtils() {
        this.okHttpClient = new OkHttpClient.Builder().build();
    }


    private static OkHttpUtils okHttpUtils;
    public static OkHttpUtils getInstance(){
        //加锁判断如果为空就创建对象
        if (okHttpUtils==null) {
            synchronized (OkHttpUtils.class){
                if (okHttpUtils==null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        //判断完成后返回工具类单例对象
        return okHttpUtils;
    }
    //打一个斜杠两个*加回车s
    /**
     * 发送get请求
     * @param url 请求地址
     * @param parmers 请求参数
     * @param callBack 回调
     * @param <T> 请求回来的数据对应的JavaBean
     */

    @Override
    public <T> void get(String url, Map<String, String> parmers,final MyHttpCallBack<T> callBack) {
        StringBuffer sb = new StringBuffer(url);
        if (parmers!=null&&parmers.size()>0) {
            sb.append("?");
            Set<String> strings = parmers.keySet();
            for (String string : strings) {
                String s = parmers.get(string);
                sb.append(string).append("=").append(s).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }

        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //okhttp请求失败的回调
                Log.d("OkHttpUtils", "网络请求异常"+e.toString());
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                       callBack.onError(404,"执行了网络请求异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //okhttp请求成功的回调
                Log.d("OkHttpUtils", "执行了网络请求成功");
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        T generic = getGeneric(jsonData, callBack);
                        ACache aCache = ACache.get(App.context);
                        aCache.put(generic.getClass().getSimpleName(), (Serializable) generic,5*ACache.TIME_HOUR);
                        //回调泛型对象
                        callBack.onSuccess(generic);
                    }
                });

            }
        });
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

    private <T> T getGeneric(String jsonData,MyHttpCallBack<T> callBack){
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData,type);
        return t;
    }
}
