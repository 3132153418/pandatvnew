package com.jiyun.pandatv.moudle.biz.livechina;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;
import com.jiyun.pandatv.moudle.entity.LivechinaTabBean;

public interface LiveChinaMoudle extends BaseMoudle {
     void getLiveChinaUrls(String url,MyHttpCallBack<LiveChina_BaDaBean> myNetCallBack);

     void getLiveChinas(MyHttpCallBack<LivechinaTabBean> myNetCallBack);

}
