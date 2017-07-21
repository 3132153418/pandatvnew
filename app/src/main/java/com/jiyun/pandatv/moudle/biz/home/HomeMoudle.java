package com.jiyun.pandatv.moudle.biz.home;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.Video_home_TuiJianBean;

public interface HomeMoudle extends BaseMoudle {
     void start(MyHttpCallBack<Bean> callBack);
     void getLunBo(MyHttpCallBack<FirstBean> callBack);
     void video_home_tuijian(String pid,MyHttpCallBack<Video_home_TuiJianBean> callBack);
}
