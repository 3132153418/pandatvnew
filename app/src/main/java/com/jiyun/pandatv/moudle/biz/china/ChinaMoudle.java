package com.jiyun.pandatv.moudle.biz.china;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.GGliveBean;

public interface ChinaMoudle extends BaseMoudle {
     void start(MyHttpCallBack<Bean> callBack);
     void setGGImage(MyHttpCallBack<GGliveBean> callBack);
}
