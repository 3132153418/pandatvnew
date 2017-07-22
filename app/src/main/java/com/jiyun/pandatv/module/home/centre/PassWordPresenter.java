package com.jiyun.pandatv.module.home.centre;

import android.graphics.drawable.Drawable;

import com.jiyun.pandatv.emileregutils.MyLogCallBack;
import com.jiyun.pandatv.emileregutils.MyLoginCallBack;
import com.jiyun.pandatv.module.home.centre.PassWordContract;
import com.jiyun.pandatv.moudle.biz.home.PassWordMoudle;
import com.jiyun.pandatv.moudle.biz.home.PassWordMoudleIpl;

/**
 * Created by Administrator on 2017/7/22.
 */

public class PassWordPresenter implements PassWordContract.Presenter {
    private PassWordContract.View pwdView;
    private PassWordMoudle passWordMoudle;
    public PassWordPresenter(PassWordContract.View pwdView){
        pwdView.setPresenter(this);
        this.pwdView = pwdView;
        passWordMoudle = new PassWordMoudleIpl();


    }
    @Override
    public void start() {

        passWordMoudle.setPwd(new MyLoginCallBack() {
            @Override
            public void onSuccess(Drawable drawable) {
                pwdView.setPwdYz(drawable);
            }

            @Override
            public void onErrorr(String msg) {

            }
        });
    }

    @Override
    public void getPwdYz(String num, String yz) {

        passWordMoudle.setPwdYz(num, yz, new MyLogCallBack() {
            @Override
            public void onsusses(String string) {
                pwdView.setStrPwd(string);
            }

            @Override
            public void onError(String msg) {

            }
        });

    }

    @Override
    public void getStrPwd(String num, String yz, String pwd) {

        passWordMoudle.findPwdBtn(num, yz, pwd, new MyLogCallBack() {
            @Override
            public void onsusses(String string) {
                pwdView.setRegsPwd(string);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
