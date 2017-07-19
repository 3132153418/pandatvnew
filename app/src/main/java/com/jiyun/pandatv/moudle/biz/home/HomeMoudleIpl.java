package com.jiyun.pandatv.moudle.biz.home;


import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.FirstBean;

public class HomeMoudleIpl implements HomeMoudle {
    @Override
    public void start(MyHttpCallBack<Bean> callBack) {
//        okHttpUtils.get(Urls.PANDALIVE,null,callBack);
    }

    @Override
    public void getLunBo(MyHttpCallBack<FirstBean> callBack) {
        okHttpUtils.get(Urls.PANDALUNBO,null,callBack);
    }
}
