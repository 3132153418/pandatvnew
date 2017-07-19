package com.jiyun.pandatv.moudle.biz.home;

import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.OriginalBean;

import static com.jiyun.pandatv.base.BaseMoudle.okHttpUtils;

/**
 * Created by Administrator on 2017/7/15.
 */

public class OriginalMoudleipl implements OriginaMoudle {
    @Override
    public void getOriginaCallBack(MyHttpCallBack<OriginalBean> callBack) {
        okHttpUtils.get(Urls.PANDAORIGINAL,null,callBack);
    }
}
