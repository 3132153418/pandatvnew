package com.jiyun.pandatv.moudle.biz.livechina;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;

public interface LiveChinaMoudle extends BaseMoudle {
     void start(MyHttpCallBack<Bean> callBack);
}
