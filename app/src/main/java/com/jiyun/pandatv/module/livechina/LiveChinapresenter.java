package com.jiyun.pandatv.module.livechina;


import android.util.Log;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudle;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudleIpl;
import com.jiyun.pandatv.moudle.entity.Bean;

public class LiveChinapresenter implements LiveChinaContract.Presenter {
    //持有View层对象
    private LiveChinaContract.View livechinaview;
    //持有Moudle层对象
    private LiveChinaMoudle liveChinaMoudle;
    //持有Moudle层对象
    public LiveChinapresenter(LiveChinaContract.View livechinaview) {
        this.livechinaview = livechinaview;
        livechinaview.setPresenter(this);
        liveChinaMoudle = new LiveChinaMoudleIpl();
    }


    //p层的网络请求
    @Override
    public void start() {
        Log.d("LiveChinapresenter", "start");


        liveChinaMoudle.start(new MyHttpCallBack<Bean>() {
            @Override
            public void onSuccess(final Bean bean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("LiveChinapresenter", "bean:" + bean.toString());

                    }
                });

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            //失败的回调
                Log.d("LiveChinapresenter", errorMsg);
            }
        });


    }
}
