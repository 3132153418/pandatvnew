package com.jiyun.pandatv.emileregutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.internet.HttpBase.BaseHttp;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;

import com.umeng.qq.handler.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.umeng.qq.handler.a.s;

/**
 * Created by Administrator on 2017/7/21.
 */

public class EmileRegUtils implements BaseHttp {
    private String jsonId;
    byte[] bytes;
    private OkHttpClient okHttpClient;

    //构造函数私有化
    private EmileRegUtils() {
        this.okHttpClient = new OkHttpClient.Builder().build();
    }


    private static EmileRegUtils okHttpUtils;

    public static EmileRegUtils getInstance() {
        //加锁判断如果为空就创建对象
        if (okHttpUtils == null) {
            synchronized (EmileRegUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new EmileRegUtils();
                }
            }
        }
        //判断完成后返回工具类单例对象
        return okHttpUtils;
    }
    //打一个斜杠两个*加回车s

    /**
     * 发送get请求
     *
     * @param url      请求地址
     * @param parmers  请求参数
     * @param callBack 回调
     * @param <T>      请求回来的数据对应的JavaBean
     */

    @Override
    public <T> void get(String url, Map<String, String> parmers, final MyHttpCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, Map<String, String> parmers, MyHttpCallBack<T> callBack) {

    }

    public void loginPost(String url, Map<String, String> parmers, Map<String, String> heards, final MyLoginCallBack callBack) {
        StringBuffer sb = new StringBuffer(url);
        if (parmers != null && parmers.size() > 0) {
            sb.append("?");
            Set<String> strings = parmers.keySet();
            for (String string : strings) {
                String s = parmers.get(string);
                sb.append(string).append("=").append(s).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        Request.Builder builder = new Request.Builder();

        if (heards != null && heards.size() > 0) {
            Set<String> strings = heards.keySet();
            for (String string : strings) {
                String s = heards.get(string);
                builder.addHeader(string, s);
            }
        }
       Request request = builder.url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //okhttp请求失败的回调
                Log.d("OkHttpUtils", "网络请求异常" + e.toString());
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onErrorr("执行了网络请求异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers = response.headers();
                jsonId = headers.get("Set-Cookie");
                bytes = response.body().bytes();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        saveCookie(jsonId);
                        Drawable drawable = byteToDrawable(bytes);

                        callBack.onSuccess(drawable);
                    }
                });

            }
        });
    }

    public void registerPost(String url, Map<String, String> parmers, Map<String, String> heards, final MyLogCallBack callBack) {
        StringBuffer sb = new StringBuffer(url);
        if (parmers != null && parmers.size() > 0) {
            sb.append("?");
            Set<String> strings = parmers.keySet();
            for (String string : strings) {
                String s = parmers.get(string);
                sb.append(string).append("=").append(s).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        Request.Builder builder = new Request.Builder();

        if (heards != null && heards.size() > 0) {
            Set<String> strings = heards.keySet();
            for (String string : strings) {
                String s = heards.get(string);
                builder.addHeader(string, s);
            }
        }
        final Request request = builder.url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //okhttp请求失败的回调
                Log.d("OkHttpUtils", "网络请求异常" + e.toString());
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onError("执行了网络请求异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        callBack.onsusses(string);
                    }
                });

            }
        });
    }
    public void saveCookie(String value){
        SharedPreferences cookie = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = cookie.edit();
        edit.putString("Cookie",value);
        edit.commit();
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

}
