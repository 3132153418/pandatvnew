package com.jiyun.pandatv.moudle.biz.china;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;

public interface ChinaMoudle extends BaseMoudle {
     void start(MyHttpCallBack<Bean> callBack);
}
