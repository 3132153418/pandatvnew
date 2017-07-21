package com.jiyun.pandatv.module.home;


import android.util.Log;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.home.HomeMoudle;
import com.jiyun.pandatv.moudle.biz.home.HomeMoudleIpl;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.Video_home_TuiJianBean;

public class Homepresenter implements HomeContract.Presenter {
    //持有View层对象
    private HomeContract.View homeView;
    //持有Moudle层对象
    private HomeMoudle homeMoudle;
    //持有Moudle层对象
    public Homepresenter(HomeContract.View homeView) {
        this.homeView = homeView;
        homeView.setPresenter(this);
        homeMoudle = new HomeMoudleIpl();
    }


    //p层的网络请求
    @Override
    public void start() {
        Log.d("LiveChinapresenter", "start");
        homeMoudle.getLunBo(new MyHttpCallBack<FirstBean>() {
            @Override
            public void onSuccess(final FirstBean firstBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      homeView.setResult(firstBean);

                    }
                });

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            //失败的回调
                Log.d("LiveChinapresenter", errorMsg);
                homeView.showMessage(errorMsg);
            }
        });


    }

    @Override
    public void homevideo(String pid, MyHttpCallBack<Video_home_TuiJianBean> myHttpCallBack) {
        String head =  "http://202.108.8.115/api/getVideoInfoForCBox.do?pid=";
        String s = head + pid;
        homeMoudle.video_home_tuijian(s,myHttpCallBack);
    }
}
