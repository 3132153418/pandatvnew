package com.jiyun.pandatv.module.china;


import android.util.Log;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.china.ChinaMoudle;
import com.jiyun.pandatv.moudle.biz.china.ChinaMoudleIpl;
import com.jiyun.pandatv.moudle.entity.Bean;

public class Chinapresenter implements ChinaContract.Presenter {
    //持有View层对象
    private ChinaContract.View chinaview;
    //持有Moudle层对象
    private ChinaMoudle chinaMoudle;
    //持有Moudle层对象
    public Chinapresenter(ChinaContract.View chinaview) {
        this.chinaview = chinaview;
        chinaview.setPresenter(this);
        chinaMoudle = new ChinaMoudleIpl();
    }


    //p层的网络请求
    @Override
    public void start() {
        Log.d("LiveChinapresenter", "start");


        chinaMoudle.start(new MyHttpCallBack<Bean>() {
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
