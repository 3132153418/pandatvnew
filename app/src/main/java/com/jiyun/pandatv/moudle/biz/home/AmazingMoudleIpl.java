package com.jiyun.pandatv.moudle.biz.home;

import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.VadioBean;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/19.
 */

public class AmazingMoudleIpl implements AmazingMoudle {
    @Override
    public void getAmazingCallBack(Map<String, String> parms, MyHttpCallBack<VadioBean> callBack) {
        okHttpUtils.get(Urls.PANDAVADIO,parms,callBack);
    }
}
