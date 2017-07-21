package com.jiyun.pandatv.moudle.biz.china;


import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.GGliveBean;

public class ChinaMoudleIpl implements ChinaMoudle {
    @Override
    public void start(MyHttpCallBack<Bean> callBack) {
//        okHttpUtils.get(Urls.PANDALIVE,null,callBack);
    }

    @Override
    public void setGGImage(MyHttpCallBack<GGliveBean> callBack) {
        okHttpUtils.get(Urls.GGLIVE,null,callBack);
    }
}
