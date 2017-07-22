package com.jiyun.pandatv.module.livechina;


import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.moudle.entity.PopupBean;

public interface LiveChinaContract {

    interface View extends BaseView<Presenter> {

        void showProgressDialog();
        void dismissDialog();
        void getChinaLiveTab(PopupBean popupBean);
        void showMessage(String msg);


    }

    interface Presenter extends BasePresenter {

    }
}
