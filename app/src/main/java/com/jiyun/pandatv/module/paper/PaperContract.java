package com.jiyun.pandatv.module.paper;


import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Paper_DataBean;
import com.jiyun.pandatv.moudle.entity.Paper_LunboBean;
import com.jiyun.pandatv.moudle.entity.Video_PaperBean;

public interface PaperContract {

    interface View extends BaseView<PaperPresenter> {
        void lunbo(Paper_LunboBean paperLunboBean);
        void shuju(Paper_DataBean paperDataBean);


    }

    interface PaperPresenter extends BasePresenter {
        void lunboData();
        void shujuData();
        void papervideo(String pid, MyHttpCallBack<Video_PaperBean> myHttpCallBack);


    }
}
