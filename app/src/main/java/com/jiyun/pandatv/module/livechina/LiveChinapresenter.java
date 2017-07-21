package com.jiyun.pandatv.module.livechina;


import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudle;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudleIpl;

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
}

