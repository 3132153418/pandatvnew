package com.jiyun.pandatv.moudle.biz.live;


import com.jiyun.pandatv.base.BaseMoudle;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;
import com.jiyun.pandatv.moudle.entity.VideoTwoBean;

public interface LiveMoudle extends BaseMoudle {
    void start(MyHttpCallBack<Bean> callBack);


    //    熊猫直播
//    1. 多视角直播
    void moreview(MyHttpCallBack<Live_MoreViewBean> callBack);

    //边看边聊
    void biankanbianliao(String app, String itemid, String nature, String page, MyHttpCallBack<Live_BianKanBianLiaoBean> callBack);
    //    String app,=ipandaApp&itemid=zhiboye_chat&nature=1&page=1

    //    2.簡介
    void jianjie(MyHttpCallBack<Live_JianJieBean> callBack);

    //精彩一刻
    void jingcai(String vsid, String n, String serviceId, String o, String of, String p, MyHttpCallBack<Live_JiangCaiBean> callBack);

    ///当熊不让
    void daxiongburang(String vsid, String n, String serviceId, String o, String of, String p, MyHttpCallBack<Live_JiangCaiBean> callBack);

    //熊猫文档
    void pandatxt(String vsid, String n, String serviceId, String o, String of, String p, MyHttpCallBack<Live_JiangCaiBean> callBack);

    //熊猫TOP榜
    void pandaTOP(String vsid, String n, String serviceId, String o, String of, String p, MyHttpCallBack<Live_JiangCaiBean> callBack);

    //超萌滚滚秀
    void superXiu(String vsid, String n, String serviceId, String o, String of, String p, MyHttpCallBack<Live_JiangCaiBean> callBack);

    //熊猫那些事儿
    void PandaEvent(String vsid, String n, String serviceId, String o, String of, String p, MyHttpCallBack<Live_JiangCaiBean> callBack);

    //特别节目
    void twbie(String vsid, String n, String serviceId, String o, String of, String p, MyHttpCallBack<Live_JiangCaiBean> callBack);

    //原创
    void yuanchaung(String vsid, String n, String serviceId, String o, String of, String p, MyHttpCallBack<Live_JiangCaiBean> callBack);

    void video(String pid,MyHttpCallBack<VideoTwoBean> callBack);
}
