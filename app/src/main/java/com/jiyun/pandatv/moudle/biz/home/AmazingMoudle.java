package com.jiyun.pandatv.moudle.biz.home;

import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.VadioBean;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/17.
 */

public interface AmazingMoudle extends BaseMoudle{
    void getAmazingCallBack(Map<String,String> parms,MyHttpCallBack<VadioBean> callBack);

}
