package com.jiyun.pandatv.moudle.biz.livechina;


import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.ChangchengBean;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;
import com.jiyun.pandatv.moudle.entity.LivechinaTabBean;
import com.jiyun.pandatv.moudle.entity.PopupBean;

public class LiveChinaMoudleIpl implements LiveChinaMoudle {

    @Override
    public void getLiveChinaUrls(String url,MyHttpCallBack<LiveChina_BaDaBean> myNetCallBack) {
       okHttpUtils.get(url,null,myNetCallBack);
    }

    @Override
    public void getLiveChinas(MyHttpCallBack<LivechinaTabBean> myNetCallBack) {
        okHttpUtils.get(Urls.LIVECHINAS,null,myNetCallBack);
    }

    @Override
    public void getChangcheng(MyHttpCallBack<ChangchengBean> callback) {

    }

    @Override
    public void getTaishan(MyHttpCallBack<ChangchengBean> callback) {

    }

    @Override
    public void getHuangshan(MyHttpCallBack<ChangchengBean> callback) {

    }

    @Override
    public void getfenghuanggucheng(MyHttpCallBack<ChangchengBean> callback) {

    }

    @Override
    public void getemeishan(MyHttpCallBack<ChangchengBean> callback) {

    }

    @Override
    public void getzhangjiajie(MyHttpCallBack<ChangchengBean> callback) {

    }

    @Override
    public void getLiveChinaUrl(String url, MyHttpCallBack<ChangchengBean> callback) {

        okHttpUtils.get(url,null,callback);
    }

    @Override
    public void getLiveChinaTab(MyHttpCallBack<PopupBean> callback) {
        okHttpUtils.get(Urls.PANDA_LIVE_CHINA_TAB,null,callback);

    }
}
