package com.jiyun.pandatv.module.livechina;


import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudle;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudleIpl;
import com.jiyun.pandatv.moudle.entity.PopupBean;

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
        liveChinaMoudle.getLiveChinaTab(new MyHttpCallBack<PopupBean>() {
            @Override
            public void onSuccess(PopupBean popupBean) {
                livechinaview.getChinaLiveTab(popupBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }
}

