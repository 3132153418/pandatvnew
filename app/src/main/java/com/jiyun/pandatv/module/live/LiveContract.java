package com.jiyun.pandatv.module.live;


import com.jiyun.pandatv.base.BasePresenter;
import com.jiyun.pandatv.base.BaseView;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;
import com.jiyun.pandatv.moudle.entity.Live_DangXiongBuRangBean;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;
import com.jiyun.pandatv.moudle.entity.Live_PandaEventBean;
import com.jiyun.pandatv.moudle.entity.Live_PandaTopBean;
import com.jiyun.pandatv.moudle.entity.Live_PandaTxtBean;
import com.jiyun.pandatv.moudle.entity.Live_SuperXiuBean;
import com.jiyun.pandatv.moudle.entity.Live_TeBieJieMuBean;
import com.jiyun.pandatv.moudle.entity.Live_YuanChuangBean;
import com.jiyun.pandatv.moudle.entity.VideoTwoBean;

public interface LiveContract {

    interface View extends BaseView<Presenter> {
        /**
         * 多视角直播
         */
        void showLiveFragment(Live_MoreViewBean pandaLiveDuoshijiaoBean);

        //        簡介
        void jianjie(Live_JianJieBean live_jianJieBean);

        //边看边聊
        void biankanbianliao(Live_BianKanBianLiaoBean live_bianKanBianLiaoBean);
        void jiangcai(Live_JiangCaiBean paperJingCaiBean);//精彩一刻
        void dangxiongburang(Live_DangXiongBuRangBean paperDangXiongBuRangBean);//当熊不让
        void superxiu(Live_SuperXiuBean paperSuperXiuBean);//超萌滚滚秀
        void pandatxt(Live_PandaTxtBean paperPandaTxtBean);//熊猫文档
        void pandatop(Live_PandaTopBean paperPandaTopBean);//熊猫TOP榜
        void pandaevent(Live_PandaEventBean paperPandaEventBean);//熊猫那些事儿
        void tebiejiemu(Live_TeBieJieMuBean paperTeBieJieMuBean);//特别节目
        void yuanchuang(Live_YuanChuangBean paperYuanChuangBean);//原创

    }

    interface Presenter extends BasePresenter {
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
