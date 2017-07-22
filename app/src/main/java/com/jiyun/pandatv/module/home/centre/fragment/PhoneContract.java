package com.jiyun.pandatv.module.home.centre.fragment;

import android.graphics.drawable.Drawable;

import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;

/**
 * Created by Administrator on 2017/7/22.
 */

public interface PhoneContract {
    interface View extends BaseView<Presenter>{
        void setPhoneReg(Drawable drawable);

        void setStrPhone(String strPhone);

        void setRegsPhone(String string);
    }
    interface Presenter extends BasePresenter{
        void getPhoneYz(String num,String yz);

        void getStrPhone(String num,String yz,String pwd);
    }
}
