package com.jiyun.pandatv.Application;


import android.app.Application;

import com.jiyun.pandatv.base.BaseActivity;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import cn.smssdk.SMSSDK;

public class App extends Application {

    public static BaseActivity context = null;

    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad",         "http://sns.whalecloud.com");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        SMSSDK.initSDK(this, "1e506690017a4", "a627c68689e042e44ed4177f45e65638");
    }

}
