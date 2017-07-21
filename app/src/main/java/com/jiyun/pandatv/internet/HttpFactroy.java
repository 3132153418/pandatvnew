package com.jiyun.pandatv.internet;

import com.jiyun.pandatv.internet.HttpBase.BaseHttp;
import com.jiyun.pandatv.internet.utils.OkHttpUtils;
import com.jiyun.pandatv.internet.utils.RetrofitUtils;

/**
 * Created by xingge on 2017/7/11.
 */

public class HttpFactroy {
    public static BaseHttp createOkHttpUtils(){
        return OkHttpUtils.getInstance();
    }
    public static BaseHttp createRetrofitUtils(){
        return RetrofitUtils.getInstance();
    }
}
