package com.jiyun.pandatv.module.home.centre.fragment;

import android.graphics.drawable.Drawable;

import com.jiyun.pandatv.emileregutils.MyLogCallBack;
import com.jiyun.pandatv.emileregutils.MyLoginCallBack;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.home.EmileMoudle;
import com.jiyun.pandatv.moudle.biz.home.EmileMoudleIpl;

/**
 * Created by Administrator on 2017/7/21.
 */

public class EmilePresenter implements EmileContract.Presenter {
    private EmileContract.View emileView;
    private EmileMoudle emileMoudle;
    public EmilePresenter(EmileContract.View emileView){
        emileView.setPresenter(this);
        this.emileView = emileView;
        emileMoudle = new EmileMoudleIpl();

    }

    @Override
    public void start() {
        emileMoudle.setEmiRegs(new MyLoginCallBack() {
            @Override
            public void onSuccess(Drawable drawable) {
                emileView.setYanZheng(drawable);
            }

            @Override
            public void onErrorr(String msg) {

            }
        });
    }

    @Override
    public void getRegis(String emile, String pwd, String yzm) {
        emileMoudle.getEmileRegister(emile, pwd, yzm, new MyLogCallBack() {
            @Override
            public void onsusses(String string) {
                emileView.setLog(string);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
