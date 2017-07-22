package com.jiyun.pandatv.moudle.biz.home;

import android.graphics.drawable.Drawable;

import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.emileregutils.MyLogCallBack;
import com.jiyun.pandatv.emileregutils.MyLoginCallBack;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;

/**
 * Created by Administrator on 2017/7/21.
 */

public interface EmileMoudle extends BaseMoudle {
    void getEmileRegister(String emile, String pwd, String yanzhengma, MyLogCallBack callBack);
    void setEmiRegs(MyLoginCallBack callBack);
}
