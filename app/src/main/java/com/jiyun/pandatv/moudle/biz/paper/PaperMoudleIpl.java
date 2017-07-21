package com.jiyun.pandatv.moudle.biz.paper;


import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.Paper_DataBean;
import com.jiyun.pandatv.moudle.entity.Paper_LunboBean;

public class PaperMoudleIpl implements PaperMoudle {
    @Override
    public void start(MyHttpCallBack<Bean> callBack) {
//        okHttpUtils.get(Urls.PANDALIVE,null,callBack);
    }
    @Override
    public void lunbobeancallback(MyHttpCallBack<Paper_LunboBean> callBack) {

        okHttpUtils.get(Urls.PAPERLUNBO,null,callBack);
    }

    @Override
    public void databeancallback(MyHttpCallBack<Paper_DataBean> callBack) {

        okHttpUtils.get(Urls.PAPERLDATA,null,callBack);
    }
}
