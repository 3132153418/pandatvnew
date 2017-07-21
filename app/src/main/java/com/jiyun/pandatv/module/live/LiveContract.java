package com.jiyun.pandatv.module.live;


import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;
import com.jiyun.pandatv.moudle.entity.VideoTwoBean;

public interface LiveContract {

    interface View extends BaseView<Presenter> {
/*
* 网络请求接口*/
        /**
         * 多视角直播
         */
        void showLiveFragment(Live_MoreViewBean pandaLiveDuoshijiaoBean);

        //        簡介
        void jianjie(Live_JianJieBean live_jianJieBean);

        //边看边聊
        void biankanbianliao(Live_BianKanBianLiaoBean live_bianKanBianLiaoBean);
        void jiangcai(Live_JiangCaiBean paperJingCaiBean);//精彩一刻


    }

    interface Presenter extends BasePresenter {
/*
* 开启网络请求*/
        void loadDuoshijiaoData();
        void biankanbianliaoData(String app, String itemid, String nature, String page);
        void jianjieData();
        void dangxiongburang(String vsid, String n, String serviceId, String o, String of, String p);
        void superxiu(String vsid, String n, String serviceId, String o, String of, String p);
        void pandatxt(String vsid, String n, String serviceId, String o, String of, String p);
        void pandatop(String vsid, String n, String serviceId, String o, String of, String p);
        void pandaevent(String vsid, String n, String serviceId, String o, String of, String p);
        void tebiejiemu(String vsid, String n, String serviceId, String o, String of, String p);
        void yuanchuang(String vsid, String n, String serviceId, String o, String of, String p);
        void setjiangcai(String vsid, String n, String serviceId, String o, String of, String p);
        void video(String pid, MyHttpCallBack<VideoTwoBean> myHttpCallBack);
    }


}
