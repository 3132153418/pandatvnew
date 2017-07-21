package com.jiyun.pandatv.moudle.biz.live;


import com.jiyun.pandatv.httpadress.Urls;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.entity.Bean;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;
import com.jiyun.pandatv.moudle.entity.VideoTwoBean;

import java.util.HashMap;
import java.util.Map;
/*
* 参数*/
public class LiveMoudleIpl implements LiveMoudle {
    @Override
    public void start(MyHttpCallBack<Bean> callBack) {
//        okHttpUtils.get(Urls.PANDALIVE,null,callBack);
    }


    //多视角直播
    @Override
    public void moreview(MyHttpCallBack<Live_MoreViewBean> callBack) {
        okHttpUtils.get(Urls.MOREVIEWLIVE, null, callBack);
    }

    //边看边聊
    @Override
    public void biankanbianliao(String app,String itemid,String nature,String page,MyHttpCallBack<Live_BianKanBianLiaoBean> callBack) {
        //    String app,=ipandaApp&itemid=zhiboye_chat&nature=1&page=1
        Map<String,String> map=new HashMap<>();
        map.put("app",app);
        map.put("itemid",itemid);
        map.put("nature",nature);
        map.put("page",page);

        okHttpUtils.get(Urls.BIANKANBIANLIAO, map, callBack);

    }

    //    简介
    @Override
    public void jianjie(MyHttpCallBack<Live_JianJieBean> callBack) {
        okHttpUtils.get(Urls.shangla, null, callBack);
    }

    //精彩一刻
    @Override
    public void jingcai(String vsid,String n,String serviceId,String o,String of,String p,MyHttpCallBack<Live_JiangCaiBean> callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("vsid",vsid);
        map.put("n",n);
        map.put("serviceId",serviceId);
        map.put("o",o);
        map.put("of",of);
        map.put("p",p);
        okHttpUtils.get(Urls.LIVE_BASEURL, map, callBack);
    }


    //当熊不让
    @Override
    public void daxiongburang(String vsid,String n,String serviceId,String o,String of,String p,MyHttpCallBack<Live_JiangCaiBean> callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("vsid",vsid);
        map.put("n",n);
        map.put("serviceId",serviceId);
        map.put("o",o);
        map.put("of",of);
        map.put("p",p);
        okHttpUtils.get(Urls.LIVE_BASEURL, map, callBack);
    }

    //熊猫文档
    @Override
    public void pandatxt(String vsid,String n,String serviceId,String o,String of,String p,MyHttpCallBack<Live_JiangCaiBean> callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("vsid",vsid);
        map.put("n",n);
        map.put("serviceId",serviceId);
        map.put("o",o);
        map.put("of",of);
        map.put("p",p);
        okHttpUtils.get(Urls.LIVE_BASEURL, map, callBack);
    }

    //熊猫TOP榜
    @Override
    public void pandaTOP(String vsid,String n,String serviceId,String o,String of,String p,MyHttpCallBack<Live_JiangCaiBean> callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("vsid",vsid);
        map.put("n",n);
        map.put("serviceId",serviceId);
        map.put("o",o);
        map.put("of",of);
        map.put("p",p);
        okHttpUtils.get(Urls.LIVE_BASEURL, map, callBack);
    }

    //超萌滚滚秀
    @Override
    public void superXiu(String vsid,String n,String serviceId,String o,String of,String p,MyHttpCallBack<Live_JiangCaiBean> callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("vsid",vsid);
        map.put("n",n);
        map.put("serviceId",serviceId);
        map.put("o",o);
        map.put("of",of);
        map.put("p",p);
        okHttpUtils.get(Urls.LIVE_BASEURL, map, callBack);
    }

    //熊猫那些事儿
    @Override
    public void PandaEvent(String vsid,String n,String serviceId,String o,String of,String p,MyHttpCallBack<Live_JiangCaiBean> callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("vsid",vsid);
        map.put("n",n);
        map.put("serviceId",serviceId);
        map.put("o",o);
        map.put("of",of);
        map.put("p",p);
        okHttpUtils.get(Urls.LIVE_BASEURL, map, callBack);
    }

    //特别节目
    @Override
    public void twbie(String vsid,String n,String serviceId,String o,String of,String p,MyHttpCallBack<Live_JiangCaiBean> callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("vsid",vsid);
        map.put("n",n);
        map.put("serviceId",serviceId);
        map.put("o",o);
        map.put("of",of);
        map.put("p",p);
        okHttpUtils.get(Urls.LIVE_BASEURL, map, callBack);
    }

    //原创
    @Override
    public void yuanchaung(String vsid,String n,String serviceId,String o,String of,String p,MyHttpCallBack<Live_JiangCaiBean> callBack) {
        Map<String,String> map=new HashMap<>();
        map.put("vsid",vsid);
        map.put("n",n);
        map.put("serviceId",serviceId);
        map.put("o",o);
        map.put("of",of);
        map.put("p",p);
        okHttpUtils.get(Urls.LIVE_BASEURL, map, callBack);
    }

    @Override
    public void video(String url,MyHttpCallBack<VideoTwoBean> callBack) {

        okHttpUtils.get(url,null, callBack);
    }



}
