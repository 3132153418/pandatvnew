package com.jiyun.pandatv.module.home.original;

import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.moudle.entity.OriginalBean;

/**
 * Created by Administrator on 2017/7/15.
 */

public interface OriginalContract {
    interface View extends BaseView<Presenter>{
        void setResoust(OriginalBean originalBean);
    }
    interface Presenter extends BasePresenter{

    }
}
