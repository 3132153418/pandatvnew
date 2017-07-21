package com.jiyun.pandatv.module.china;


import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.moudle.entity.GGliveBean;

public interface ChinaContract {

    interface View extends BaseView<Presenter> {

        void setResult(GGliveBean gGliveBean);


    }

    interface Presenter extends BasePresenter {

    }
}
