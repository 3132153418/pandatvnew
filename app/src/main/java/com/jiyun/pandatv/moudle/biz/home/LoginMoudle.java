package com.jiyun.pandatv.moudle.biz.home;

import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.LoginEntity;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface LoginMoudle extends BaseMoudle{
    void getLogin(String name, String pwd, MyHttpCallBack<LoginEntity> callBack);
}
