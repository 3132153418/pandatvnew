package com.jiyun.pandatv.base;


import com.jiyun.pandatv.internet.HttpBase.BaseHttp;
import com.jiyun.pandatv.internet.HttpFactroy;

public interface BaseMoudle {
    public static BaseHttp okHttpUtils = HttpFactroy.createOkHttpUtils();
    public static BaseHttp retrofitUtils = HttpFactroy.createRetrofitUtils();
    public static BaseHttp loginUtils = HttpFactroy.createLoginUtils();
    public static BaseHttp emileUtils = HttpFactroy.createEmileRegUtils();
}
