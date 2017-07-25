package com.jiyun.pandatv.module.live;


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
    private ACache aCache = ACache.get(App.context);

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
        Live_MoreViewBean live_moreViewBean = (Live_MoreViewBean) aCache.getAsObject("Live_MoreViewBean");
        if (live_moreViewBean == null) {
            L.d("TAG", "没有缓存数据");
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
        } else {
            L.d("TAG", "拿到了缓存数据");
            liveview.showLiveFragment(live_moreViewBean);
        }
    }

    @Override
    public void biankanbianliaoData(String app, String itemid, String nature, String page) {
        Live_BianKanBianLiaoBean live_bianKanBianLiaoBean = (Live_BianKanBianLiaoBean) aCache.getAsObject("Live_BianKanBianLiaoBean");
        if (live_bianKanBianLiaoBean == null) {
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
        } else {
            liveview.biankanbianliao(live_bianKanBianLiaoBean);
        }

    }

    @Override
    public void jianjieData() {
        Live_JianJieBean live_jianjiebean = (Live_JianJieBean) aCache.getAsObject("Live_JianJieBean");
        if (live_jianjiebean == null) {
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
        } else {
            liveview.jianjie(live_jianjiebean);
        }
    }


    @Override
    public void dangxiongburang(String vsid, String n, String serviceId, String o, String of, String p) {
        Live_JiangCaiBean live_jiangcaibean = (Live_JiangCaiBean) aCache.getAsObject("Live_JiangCaiBeandangxiongburang");
        if (live_jiangcaibean == null) {
            liveMoudle.daxiongburang(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
                @Override
                public void onSuccess(final Live_JiangCaiBean live_jiangcaibean) {
                    aCache.put("Live_JiangCaiBeandangxiongburang", live_jiangcaibean);
                    //成功的回调
                    App.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            liveview.jiangcai(live_jiangcaibean);
                            L.d("当雄不让bean", live_jiangcaibean.getVideo().get(0).getVid().toString());
                        }
                    });
                }

                @Override
                public void onError(int errorCode, String errorMsg) {
                }
            });
        } else
            liveview.jiangcai(live_jiangcaibean);


    }

    @Override
    public void superxiu(String vsid, String n, String serviceId, String o, String of, String p) {
        Live_JiangCaiBean live_jiangcaibean = (Live_JiangCaiBean) aCache.getAsObject("Live_JiangCaiBeansuperxiu");
        if (live_jiangcaibean == null) {
            liveMoudle.superXiu(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
                @Override
                public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                    aCache.put("Live_JiangCaiBeansuperxiu", live_jiangCaiBean);
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
        } else
            liveview.jiangcai(live_jiangcaibean);
    }

    @Override
    public void pandatxt(String vsid, String n, String serviceId, String o, String of, String p) {
        Live_JiangCaiBean live_jiangcaibean = (Live_JiangCaiBean) aCache.getAsObject("Live_JiangCaiBeantxt");
        if (live_jiangcaibean == null) {
            liveMoudle.pandatxt(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
                @Override
                public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                    aCache.put("Live_JiangCaiBeantxt", live_jiangCaiBean);
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
        } else
            liveview.jiangcai(live_jiangcaibean);


    }

    @Override
    public void pandatop(String vsid, String n, String serviceId, String o, String of, String p) {
        Live_JiangCaiBean live_jiangcaibean = (Live_JiangCaiBean) aCache.getAsObject("Live_JiangCaiBeantop");
        if (live_jiangcaibean == null) {
            liveMoudle.pandaTOP(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
                @Override
                public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                    aCache.put("Live_JiangCaiBeantop", live_jiangCaiBean);
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
        } else
            liveview.jiangcai(live_jiangcaibean);


    }

    @Override
    public void pandaevent(String vsid, String n, String serviceId, String o, String of, String p) {
        Live_JiangCaiBean live_jiangcaibean = (Live_JiangCaiBean) aCache.getAsObject("Live_JiangCaiBeanevent");
        if (live_jiangcaibean == null) {
            liveMoudle.PandaEvent(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
                @Override
                public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                    aCache.put("Live_JiangCaiBeanevent", live_jiangCaiBean);
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
        } else
            liveview.jiangcai(live_jiangcaibean);


    }

    @Override
    public void tebiejiemu(String vsid, String n, String serviceId, String o, String of, String p) {
        Live_JiangCaiBean live_jiangcaibean = (Live_JiangCaiBean) aCache.getAsObject("Live_JiangCaiBeantebie");
        if (live_jiangcaibean == null) {
            liveMoudle.twbie(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
                @Override
                public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                    aCache.put("Live_JiangCaiBeantebie", live_jiangCaiBean);
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
        } else
            liveview.jiangcai(live_jiangcaibean);


    }

    @Override
    public void yuanchuang(String vsid, String n, String serviceId, String o, String of, String p) {
        Live_JiangCaiBean live_jiangcaibean = (Live_JiangCaiBean) aCache.getAsObject("Live_JiangCaiBeanyuanchuang");
        if (live_jiangcaibean == null) {
            liveMoudle.yuanchaung(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
                @Override
                public void onSuccess(final Live_JiangCaiBean live_jiangCaiBean) {
                    aCache.put("Live_JiangCaiBeanyuanchuang", live_jiangCaiBean);
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
        } else
            liveview.jiangcai(live_jiangcaibean);

    }

    @Override
    public void setjiangcai(String vsid, String n, String serviceId, String o, String of, String p) {
        Live_JiangCaiBean live_jiangcaibean = (Live_JiangCaiBean) aCache.getAsObject("Live_JiangCaiBeanjcyk");
        if (live_jiangcaibean == null) {
            liveMoudle.jingcai(vsid, n, serviceId, o, of, p, new MyHttpCallBack<Live_JiangCaiBean>() {
                @Override
                public void onSuccess(final Live_JiangCaiBean paper_jiangCaiBean) {
                    aCache.put("Live_JiangCaiBeanjcyk", paper_jiangCaiBean);
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
        } else
            liveview.jiangcai(live_jiangcaibean);

    }

    @Override
    public void video(String pid, MyHttpCallBack<VideoTwoBean> myHttpCallBack) {
        String head = "http://vdn.apps.cntv.cn/api/getVideoInfoForCBox.do?pid=";
        String s = head + pid;
        liveMoudle.video(s, myHttpCallBack);
    }
}
