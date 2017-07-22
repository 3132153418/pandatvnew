package com.jiyun.pandatv.moudle.biz.home;

import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.emileregutils.MyLogCallBack;
import com.jiyun.pandatv.emileregutils.MyLoginCallBack;

/**
 * Created by Administrator on 2017/7/22.
 */

public interface PassWordMoudle extends BaseMoudle{
    void setPwd(MyLoginCallBack callBack);

    void setPwdYz(String number, String yanzm, MyLogCallBack callBack);

    void findPwdBtn(String number,String yanzm,String pwd,MyLogCallBack callBack);
}
