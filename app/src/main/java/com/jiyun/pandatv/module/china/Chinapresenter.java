package com.jiyun.pandatv.module.china;


import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.china.ChinaMoudle;
import com.jiyun.pandatv.moudle.biz.china.ChinaMoudleIpl;
import com.jiyun.pandatv.moudle.entity.GGliveBean;

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
        L.d("LiveChinapresenter", "start");


        chinaMoudle.setGGImage(new MyHttpCallBack<GGliveBean>() {
            @Override
            public void onSuccess(final GGliveBean bean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        L.d("LiveChinapresenter", "bean:" + bean.toString());
                        chinaview.setResult(bean);

                    }
                });

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            //失败的回调
                L.d("LiveChinapresenter", errorMsg);
            }
        });


    }
}
