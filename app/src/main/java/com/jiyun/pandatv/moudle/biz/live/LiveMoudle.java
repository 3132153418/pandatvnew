package com.jiyun.pandatv.moudle.biz.live;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;

public interface LiveMoudle extends BaseMoudle {
     void start(MyHttpCallBack<Bean> callBack);
}
