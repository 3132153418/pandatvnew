package com.jiyun.pandatv.moudle.biz.livechina;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

public interface LiveChinaMoudle extends BaseMoudle {
     void start(MyHttpCallBack<Bean> callBack);
     void daba(MyHttpCallBack<LiveChina_BaDaBean> callBack);
     void huangshan(MyHttpCallBack<LiveChina_BaDaBean> callBack);
     void fenghaung(MyHttpCallBack<LiveChina_BaDaBean> callBack);
     void emeishan(MyHttpCallBack<LiveChina_BaDaBean> callBack);
}
