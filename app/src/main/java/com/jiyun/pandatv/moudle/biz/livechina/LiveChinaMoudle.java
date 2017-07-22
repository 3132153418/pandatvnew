package com.jiyun.pandatv.moudle.biz.livechina;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.ChangchengBean;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;
import com.jiyun.pandatv.moudle.entity.LivechinaTabBean;
import com.jiyun.pandatv.moudle.entity.PopupBean;

public interface LiveChinaMoudle extends BaseMoudle {
     void getLiveChinaUrls(String url,MyHttpCallBack<LiveChina_BaDaBean> myNetCallBack);

     void getLiveChinas(MyHttpCallBack<LivechinaTabBean> myNetCallBack);

     void getChangcheng(MyHttpCallBack<ChangchengBean> callback);
     void getTaishan(MyHttpCallBack<ChangchengBean> callback);
     void getHuangshan(MyHttpCallBack<ChangchengBean> callback);
     void getfenghuanggucheng(MyHttpCallBack<ChangchengBean> callback);
     void getemeishan(MyHttpCallBack<ChangchengBean> callback);
     void getzhangjiajie(MyHttpCallBack<ChangchengBean> callback);
     void getLiveChinaUrl(String url,MyHttpCallBack<ChangchengBean> callback);
     void getLiveChinaTab(MyHttpCallBack<PopupBean> callback);

}
