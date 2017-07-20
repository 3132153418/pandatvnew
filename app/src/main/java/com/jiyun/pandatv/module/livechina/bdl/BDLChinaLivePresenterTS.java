package com.jiyun.pandatv.module.livechina.bdl;

import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudle;
import com.jiyun.pandatv.moudle.biz.livechina.LiveChinaMoudleIpl;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

/**
 * Created by lizhuofang on 2017/7/13.
 */

public class BDLChinaLivePresenterTS implements BDLChinaLiveContract.Presenter {
    private BDLChinaLiveContract.View view;
    private LiveChinaMoudle chinaLiveModel;
    public BDLChinaLivePresenterTS(BDLChinaLiveContract.View view){
        this.view=view;
        this.view.setPresenter(this);
        this.chinaLiveModel=new LiveChinaMoudleIpl();
    }
    @Override
    public void start() {

    }

    @Override
    public void setUrl(String url) {
        chinaLiveModel.getLiveChinaUrls(url, new MyHttpCallBack<LiveChina_BaDaBean>() {
            @Override
            public void onSuccess(LiveChina_BaDaBean liveBDLBean) {
                view.setResult(liveBDLBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
