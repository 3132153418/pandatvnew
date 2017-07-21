package com.jiyun.pandatv.base;


import com.jiyun.pandatv.internet.HttpBase.BaseHttp;
import com.jiyun.pandatv.internet.HttpFactroy;

public interface BaseMoudle {
    public static BaseHttp okHttpUtils = HttpFactroy.createOkHttpUtils();
    public static BaseHttp retrofitUtils = HttpFactroy.createRetrofitUtils();
}
