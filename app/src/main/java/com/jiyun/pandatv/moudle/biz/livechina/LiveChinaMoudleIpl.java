package com.jiyun.pandatv.moudle.biz.livechina;


import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;
import com.jiyun.pandatv.moudle.entity.LivechinaTabBean;

public class LiveChinaMoudleIpl implements LiveChinaMoudle {

    @Override
    public void getLiveChinaUrls(String url,MyHttpCallBack<LiveChina_BaDaBean> myNetCallBack) {
       okHttpUtils.get(url,null,myNetCallBack);
    }

    @Override
    public void getLiveChinas(MyHttpCallBack<LivechinaTabBean> myNetCallBack) {
        okHttpUtils.get(Urls.LIVECHINAS,null,myNetCallBack);
    }
}
