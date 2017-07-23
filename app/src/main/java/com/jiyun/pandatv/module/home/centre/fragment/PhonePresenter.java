package com.jiyun.pandatv.module.home.centre.fragment;

import android.graphics.drawable.Drawable;

import com.jiyun.pandatv.emileregutils.MyLogCallBack;
import com.jiyun.pandatv.emileregutils.MyLoginCallBack;
import com.jiyun.pandatv.moudle.biz.home.PhoneMoudle;
import com.jiyun.pandatv.moudle.biz.home.PhoneMoudleIpl;

/**
 * Created by Administrator on 2017/7/22.
 */

public class PhonePresenter implements PhoneContract.Presenter {
    private PhoneContract.View phoneView;
    private PhoneMoudle phoneMoudle;

    public PhonePresenter(PhoneContract.View phoneView) {
        phoneView.setPresenter(this);
        this.phoneView = phoneView;
        phoneMoudle = new PhoneMoudleIpl();

    }

    @Override
    public void start() {

        phoneMoudle.getPhone(new MyLoginCallBack() {
            @Override
            public void onSuccess(Drawable drawable) {
                phoneView.setPhoneReg(drawable);
            }

            @Override
            public void onErrorr(String msg) {

            }
        });
    }

    @Override
    public void getPhoneYz(String num, String yz) {
        phoneMoudle.setPhone(num, yz, new MyLogCallBack() {
            @Override
            public void onsusses(String string) {
                phoneView.setStrPhone(string);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Override
    public void getStrPhone(String num, String yz, String pwd) {
        phoneMoudle.phoneRegister(num, yz, pwd, new MyLogCallBack() {
            @Override
            public void onsusses(String string) {
                phoneView.setRegsPhone(string);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
