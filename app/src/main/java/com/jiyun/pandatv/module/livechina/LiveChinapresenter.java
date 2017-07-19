package com.jiyun.pandatv.module.livechina;


import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudle;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudleIpl;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

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


    }

    @Override
    public void bada() {
        liveChinaMoudle.daba(new MyHttpCallBack<LiveChina_BaDaBean>() {
            @Override
            public void onSuccess(final LiveChina_BaDaBean liveChina_baDaBean) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                  livechinaview.badaling(liveChina_baDaBean);
                        L.d("八达岭",liveChina_baDaBean.toString());
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void huangshan() {

        liveChinaMoudle.huangshan(new MyHttpCallBack<LiveChina_BaDaBean>() {
            @Override
            public void onSuccess(final LiveChina_BaDaBean liveChina_baDaBean) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        livechinaview.badaling(liveChina_baDaBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void fenghaung() {
        liveChinaMoudle.fenghaung(new MyHttpCallBack<LiveChina_BaDaBean>() {
            @Override
            public void onSuccess(final LiveChina_BaDaBean liveChina_baDaBean) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        livechinaview.badaling(liveChina_baDaBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void emeishan() {
        liveChinaMoudle.emeishan(new MyHttpCallBack<LiveChina_BaDaBean>() {
            @Override
            public void onSuccess(final LiveChina_BaDaBean liveChina_baDaBean) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        livechinaview.badaling(liveChina_baDaBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
