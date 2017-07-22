package com.jiyun.pandatv.module.home.centre.fragment;

import android.graphics.drawable.Drawable;

import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface EmileContract {
    interface View extends BaseView<Presenter>{

        void setYanZheng(Drawable drawable);
        void setLog(String string);
    }
    interface Presenter extends BasePresenter{
        void getRegis(String emile,String pwd,String yzm);

    }
}
