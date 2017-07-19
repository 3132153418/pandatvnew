package com.jiyun.pandatv.module.home.original;

import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.home.OriginaMoudle;
import com.jiyun.pandatv.moudle.biz.home.OriginalMoudleipl;
import com.jiyun.pandatv.moudle.entity.OriginalBean;

/**
 * Created by Administrator on 2017/7/15.
 */

public class OriginalPresenter implements OriginalContract.Presenter {
    OriginalContract.View view;

    OriginaMoudle originaMoudle;
    public OriginalPresenter(OriginalContract.View view){
        this.view=view;
        view.setPresenter(this);
        originaMoudle=new OriginalMoudleipl();
    }
    @Override
    public void start() {
        originaMoudle.getOriginaCallBack(new MyHttpCallBack<OriginalBean>() {
            @Override
            public void onSuccess(OriginalBean originalBean) {
                view.setResoust(originalBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
