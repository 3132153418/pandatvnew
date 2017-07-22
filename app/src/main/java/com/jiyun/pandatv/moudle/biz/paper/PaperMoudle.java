package com.jiyun.pandatv.moudle.biz.paper;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.Paper_DataBean;
import com.jiyun.pandatv.moudle.entity.Paper_LunboBean;
import com.jiyun.pandatv.moudle.entity.Video_PaperBean;

public interface PaperMoudle extends BaseMoudle {
     void start(MyHttpCallBack<Bean> callBack);
     void lunbobeancallback(MyHttpCallBack<Paper_LunboBean> callBack);
     void databeancallback(MyHttpCallBack<Paper_DataBean> callBack);
     void papervideo(String url,MyHttpCallBack<Video_PaperBean> callBack);
}
