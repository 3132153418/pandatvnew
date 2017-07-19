package com.jiyun.pandatv.module.livechina;


import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

public interface LiveChinaContract {

    interface View extends BaseView<Presenter> {
        /**
      八达岭
         */
        void badaling(LiveChina_BaDaBean liveChina_baDaBean);


    }

    interface Presenter extends BasePresenter {
        void bada();
        void huangshan();
        void fenghaung();
        void emeishan();
    }
}
