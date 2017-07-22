package com.jiyun.pandatv.module.livechina.fragment;

import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudle;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudleIpl;
import com.jiyun.pandatv.moudle.entity.ChangchengBean;

/**
 * Created by Administrator on 2017/7/22.
 */

public class LivePresenter implements LiveContract.Presenter {

    private LiveChinaMoudle liveChinaMoudle;

    private LiveContract.View view;
    public LivePresenter(LiveContract.View view){

        this.view=view;
        this.view.setPresenter(this);
        liveChinaMoudle = new LiveChinaMoudleIpl();

    }
    @Override
    public void setUrl(String url) {

        liveChinaMoudle.getLiveChinaUrl(url, new MyHttpCallBack<ChangchengBean>() {
            @Override
            public void onSuccess(ChangchengBean changchengBean) {

                view.getManager(changchengBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void start() {

    }
}
