package com.jiyun.pandatv.module.home.pandajingcaiyike;

import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.moudle.entity.VadioBean;

/**
 * Created by Administrator on 2017/7/19.
 */

public interface AmazingContract {
    interface View extends BaseView<Presenter>{

        void showlivevedioFragment(VadioBean vadioBean);
    }
    interface Presenter extends BasePresenter{

        void setVadioPid(String pid);
    }
}
