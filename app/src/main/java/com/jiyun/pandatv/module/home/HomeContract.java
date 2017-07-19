package com.jiyun.pandatv.module.home;


import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.moudle.entity.FirstBean;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showProgressBar();

        void setConmit();

        void setResult(FirstBean firstBean);

        void onRefrash(int inDex,int inCount);

        void showMessage(String msg);

    }

    interface Presenter extends BasePresenter {

    }
}
