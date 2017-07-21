package com.jiyun.pandatv.module.live;


import android.util.Log;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.apputils.ACache;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.moudle.biz.live.LiveMoudle;
import com.jiyun.pandatv.moudle.biz.live.LiveMoudleIpl;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;
import com.jiyun.pandatv.moudle.entity.VideoTwoBean;

public class Livepresenter implements LiveContract.Presenter {
    //持有View层对象
    private LiveContract.View liveview;
    //持有Moudle层对象
    private LiveMoudle liveMoudle;

    //持有Moudle层对象
    public Livepresenter(LiveContract.View liveview) {
        this.liveview = liveview;
        liveview.setPresenter(this);
        liveMoudle = new LiveMoudleIpl();
    }


    @Override
    public void start() {

    }

    @Override
    public void loadDuoshijiaoData() {

        ACache aCache = ACache.get(App.context);
        Live_MoreViewBean live_moreViewBean = (Live_MoreViewBean) aCache.getAsObject("Live_MoreViewBean");
        if (live_moreViewBean==null) {
            Log.d("TAG","没有缓存数据");
            liveMoudle.moreview(new MyHttpCallBack<Live_MoreViewBean>() {
                @Override
                public void onSuccess(final Live_MoreViewBean live_moreViewBean) {
                    //成功的回调
                    App.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            liveview.showLiveFragment(live_moreViewBean);
                            L.d("多視角", live_moreViewBean.toString());
                        }
                    });
                }

                @Override
                public void onError(int errorCode, String errorMsg) {
//                Log.d("Livepresenter", errorMsg);
                }
            });
        }else{
            Log.d("TAG","拿到了缓存数据");
            liveview.showLiveFragment(live_moreViewBean);
        }
    }

    @Override
    public void biankanbianliaoData(String app, String itemid, String nature, String page) {
        liveMoudle.biankanbianliao(app, itemid, nature, page, new MyHttpCallBack<Live_BianKanBianLiaoBean>() {
            @Override
            public void onSuccess(final Live_BianKanBianLiaoBean live_bianKanBianLiaoBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.biankanbianliao(live_bianKanBianLiaoBean);
                        L.d("边看边聊hqaha", live_bianKanBianLiaoBean.toString());
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
//                Log.d("Livepresenter", errorMsg);
            }
        });
    }

    @Override
    public void jianjieData() {
        liveMoudle.jianjie(new MyHttpCallBack<Live_JianJieBean>() {
            @Override
            public void onSuccess(final Live_JianJieBean live_jianJieBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.jianjie(live_jianJieBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            }
        });
    }


    @Override
    public void dangxiongburang(String vsid, String n, String serviceId, String o, String of, String p) {
        liveMoudle.daxiongburang(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
            @Override
            public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.jiangcai(live_jiangCaiBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            }
        });
    }

    @Override
    public void superxiu(String vsid, String n, String serviceId, String o, String of, String p) {
        liveMoudle.superXiu(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
            @Override
            public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.jiangcai(live_jiangCaiBean);
//                        Log.d("Livepresenter", "live_moreV超萌滚滚秀:" + paper_superXiuBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
//                Log.d("Livepresenter", errorMsg);
            }
        });
    }

    @Override
    public void pandatxt(String vsid, String n, String serviceId, String o, String of, String p) {
        liveMoudle.pandatxt(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
            @Override
            public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.jiangcai(live_jiangCaiBean);
//                        Log.d("Livepresenter", "熊猫档案:" + live_pandaTxtBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            }
        });
    }

    @Override
    public void pandatop(String vsid, String n, String serviceId, String o, String of, String p) {
        liveMoudle.pandaTOP(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
            @Override
            public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.jiangcai(live_jiangCaiBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            }
        });
    }

    @Override
    public void pandaevent(String vsid, String n, String serviceId, String o, String of, String p) {
        liveMoudle.PandaEvent(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
            @Override
            public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.jiangcai(live_jiangCaiBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            }
        });
    }

    @Override
    public void tebiejiemu(String vsid, String n, String serviceId, String o, String of, String p) {
        liveMoudle.twbie(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
            @Override
            public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.jiangcai(live_jiangCaiBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            }
        });
    }

    @Override
    public void yuanchuang(String vsid, String n, String serviceId, String o, String of, String p) {
        liveMoudle.yuanchaung(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
            @Override
            public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.jiangcai(live_jiangCaiBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
            }
        });
    }

    @Override
    public void setjiangcai(String vsid, String n, String serviceId, String o, String of, String p) {
        liveMoudle.jingcai(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
            @Override
            public void onSuccess(final Live_JiangCaiBean paper_jiangCaiBean) {
                //成功的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        liveview.jiangcai(paper_jiangCaiBean);
//                        Log.d("Livepresenter", "live_moreV精彩一刻:" + paper_jiangCaiBean);
                    }
                });
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
//                Log.d("Livepresenter", errorMsg);
            }
        });
    }

    @Override
    public void video(String pid,MyHttpCallBack<VideoTwoBean> myHttpCallBack) {
        String head =  "http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do?pid=";
        String s = head + pid;
        liveMoudle.video(s,myHttpCallBack);
    };
    }
