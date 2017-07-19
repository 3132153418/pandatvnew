package com.jiyun.pandatv.moudle.biz.livechina;


import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

public class LiveChinaMoudleIpl implements LiveChinaMoudle {
    @Override
    public void start(MyHttpCallBack<Bean> callBack) {
//        okHttpUtils.get(Urls.PANDALIVE,null,callBack);
    }

    @Override
    public void daba(MyHttpCallBack<LiveChina_BaDaBean> callBack) {
        okHttpUtils.get(Urls.BADA,null,callBack);

    }

    @Override
    public void huangshan(MyHttpCallBack<LiveChina_BaDaBean> callBack) {
        okHttpUtils.get(Urls.HUANGSHAN,null,callBack);

    }

    @Override
    public void fenghaung(MyHttpCallBack<LiveChina_BaDaBean> callBack) {
        okHttpUtils.get(Urls.FENGHUANG,null,callBack);
    }

    @Override
    public void emeishan(MyHttpCallBack<LiveChina_BaDaBean> callBack) {
        okHttpUtils.get(Urls.EMEISHAN,null,callBack);

    }
}
