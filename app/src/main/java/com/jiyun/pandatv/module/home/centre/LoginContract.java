package com.jiyun.pandatv.module.home.centre;

import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.moudle.entity.LoginEntity;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter>{
        void setLogin(LoginEntity login);
    }
    interface Presenter extends BasePresenter{
        void loge(String name,String pwd);
    }
}
