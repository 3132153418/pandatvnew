package com.jiyun.pandatv.module.live;


import android.util.Log;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.live.LiveMoudle;
import com.jiyun.pandatv.moudle.biz.live.LiveMoudleIpl;
import com.jiyun.pandatv.moudle.entity.Bean;

public class Livepresenter implements LiveContract.Presenter {
    //持有View层对象
    private LiveContract.View liveview;
    //持有Moudle层对象
    private LiveMoudle liveMoudle;
    //持有Moudle层对象
    public Livepresenter(LiveContract.View liveview) {
        this.liveview = liveview;
        liveview.setPresenter(this);
        liveMoudle = new LiveMoudleIpl();
    }


    //p层的网络请求
    @Override
    public void start() {
        Log.d("LiveChinapresenter", "start");


        liveMoudle.start(new MyHttpCallBack<Bean>() {
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
