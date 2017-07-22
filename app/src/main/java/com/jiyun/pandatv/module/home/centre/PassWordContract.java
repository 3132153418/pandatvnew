package com.jiyun.pandatv.module.home.centre;

import android.graphics.drawable.Drawable;

import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;

/**
 * Created by Administrator on 2017/7/22.
 */

public interface PassWordContract {
    interface View extends BaseView<Presenter>{
        void setPwdYz(Drawable drawable);

        void setStrPwd(String strPhone);

        void setRegsPwd(String string);

    }
    interface Presenter extends BasePresenter{
        void getPwdYz(String num,String yz);

        void getStrPwd(String num,String yz,String pwd);

    }
}
