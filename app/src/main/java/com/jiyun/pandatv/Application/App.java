package com.jiyun.pandatv.Application;


import android.app.Application;
import android.app.Notification;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

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
        JPushInterface.setDebugMode(true);//开启极光推送的debug模式
        JPushInterface.init(this);//初始化极光推送
        Set<Integer> days = new HashSet<Integer>();
        days.add(1);
        days.add(2);
        days.add(3);
        days.add(4);
        days.add(5);
        JPushInterface.setPushTime(this,days,8,22);//设置极光推送的接收时间
        JPushInterface.setSilenceTime(getApplicationContext(), 22, 30, 8, 30);//设置静音时间
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(this);
        builder.statusBarDrawable = R.drawable.logo_ipnda;
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
                | Notification.FLAG_SHOW_LIGHTS;  //设置为自动消失和呼吸灯闪烁
        builder.notificationDefaults = Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE
                | Notification.DEFAULT_LIGHTS;  // 设置为铃声、震动、呼吸灯闪烁都要
        JPushInterface.setPushNotificationBuilder(1, builder);//设置消息样式
    }

}
