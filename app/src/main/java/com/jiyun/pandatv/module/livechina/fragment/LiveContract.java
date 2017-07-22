package com.jiyun.pandatv.module.livechina.fragment;

import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.moudle.entity.ChangchengBean;

/**
 * Created by Administrator on 2017/7/22.
 */

public interface LiveContract {
    interface  View extends BaseView<Presenter> {
        void getManager(ChangchengBean changchengBean);
        void showMessage(String msg);



    }
    interface Presenter extends BasePresenter {
        void setUrl(String url);
    }
}
