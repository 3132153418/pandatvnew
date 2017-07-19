package com.jiyun.pandatv.moudle.biz.home;

import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.OriginalBean;

/**
 * Created by Administrator on 2017/7/15.
 */

public interface OriginaMoudle {
    void getOriginaCallBack(MyHttpCallBack<OriginalBean> callBack);
}
