package com.jiyun.pandatv.moudle.biz.home;

import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.emileregutils.MyLogCallBack;
import com.jiyun.pandatv.emileregutils.MyLoginCallBack;

/**
 * Created by Administrator on 2017/7/22.
 */

public interface PhoneMoudle extends BaseMoudle{
    void getPhone(MyLoginCallBack callBack);
    void setPhone(String number, String yanzm, MyLogCallBack callBack);

    void phoneRegister(String number,String yanzm,String pwd,MyLogCallBack callBack);
}
