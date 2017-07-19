package com.jiyun.pandatv.module.paper;


import android.util.Log;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.paper.PaperMoudle;
import com.jiyun.pandatv.moudle.biz.paper.PaperMoudleIpl;
import com.jiyun.pandatv.moudle.entity.Paper_DataBean;
import com.jiyun.pandatv.moudle.entity.Paper_LunboBean;

public class Paperpresenter implements PaperContract.PaperPresenter {
    //持有View层对象
    private PaperContract.View paperview;
    //持有Moudle层对象
    private PaperMoudle paperMoudle;

    //持有Moudle层对象
    public Paperpresenter(PaperContract.View paperview) {
        this.paperview = paperview;
        paperview.setPresenter(this);
        paperMoudle = new PaperMoudleIpl();
    }


    //p层的网络请求
    @Override
    public void start() {

    }

    @Override
    public void lunboData() {
        paperMoudle.lunbobeancallback(new MyHttpCallBack<Paper_LunboBean>() {
            @Override
            public void onSuccess(final Paper_LunboBean paperLunboBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        paperview.lunbo(paperLunboBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                //失败的回调
                Log.d("LiveChinapresenter", errorMsg);
            }
        });

    }

    @Override
    public void shujuData() {
        paperMoudle.databeancallback(new MyHttpCallBack<Paper_DataBean>() {
            @Override
            public void onSuccess(final Paper_DataBean paperDataBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        paperview.shuju(paperDataBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                //失败的回调
                Log.d("LiveChinapresenter", errorMsg);
            }
        });


    }


}
