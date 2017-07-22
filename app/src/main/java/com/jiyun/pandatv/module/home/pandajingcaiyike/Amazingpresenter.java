package com.jiyun.pandatv.module.home.pandajingcaiyike;

import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.home.AmazingMoudle;
import com.jiyun.pandatv.moudle.biz.home.AmazingMoudleIpl;
import com.jiyun.pandatv.moudle.entity.VadioBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/19.
 */

public class Amazingpresenter implements AmazingContract.Presenter{
    private AmazingContract.View amazingview;
    private AmazingMoudle amazingMoudle;
    public Amazingpresenter(AmazingContract.View view){
        this.amazingview = view;
        view.setPresenter(this);
        amazingMoudle = new AmazingMoudleIpl();
    }
    @Override
    public void setVadioPid(String pid) {
        Map<String,String> map = new HashMap<>();
        map.put("pid",pid);
        amazingMoudle.getAmazingCallBack(map, new MyHttpCallBack<VadioBean>() {
            @Override
            public void onSuccess(VadioBean vadioBean) {
                amazingview.showlivevedioFragment(vadioBean);
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
