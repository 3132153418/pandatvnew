package com.jiyun.pandatv.moudle.biz.home;


import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.Video_home_TuiJianBean;

public class HomeMoudleIpl implements HomeMoudle {
    @Override
    public void start(MyHttpCallBack<Bean> callBack) {
//        okHttpUtils.get(Urls.PANDALIVE,null,callBack);
    }

    @Override
    public void getLunBo(MyHttpCallBack<FirstBean> callBack) {
        okHttpUtils.get(Urls.PANDALUNBO,null,callBack);
    }

    @Override
    public void video_home_tuijian(String url,MyHttpCallBack<Video_home_TuiJianBean> callBack) {
        okHttpUtils.get(url,null,callBack);
    }

}
