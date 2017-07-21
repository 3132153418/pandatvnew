package com.jiyun.pandatv.module.home;


import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.Video_home_TuiJianBean;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        /*
        * view层和presenter层连接*/
        void showProgressBar();

        void setConmit();

        void setResult(FirstBean firstBean);

        void onRefrash(int inDex, int inCount);

        void showMessage(String msg);

    }

    interface Presenter extends BasePresenter {
        /*
        * 网络请求接口*/
        void homevideo(String pid, MyHttpCallBack<Video_home_TuiJianBean> myHttpCallBack);
    }
}
