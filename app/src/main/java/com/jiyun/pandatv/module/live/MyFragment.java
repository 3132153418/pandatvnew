package com.jiyun.pandatv.module.live;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.JCFullScreenActivity;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.apputils.ShowPopuUtils;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.jcvideoplayer_lib.PandaVedioPlayer;
import com.jiyun.pandatv.module.live.liveadapter.JianJieAdapter;
import com.jiyun.pandatv.module.live.liveadapter.JingcaiAdapter;
import com.jiyun.pandatv.module.live.views.NoScrollViewPager;
import com.jiyun.pandatv.moudle.db.HistoryUtils;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;
import com.jiyun.pandatv.moudle.entity.VideoTwoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lt on 2015/12/14.直播
 */
public class MyFragment extends BaseFragment implements LiveContract.View, JingcaiAdapter.JingCaiCallback {

    public static final int live = 0;//直播
    public static final int Wonderful_moment = 1;//精彩一刻
    public static final int When_the_bear_oes_not_let = 2;//当熊不让
    public static final int supercute = 3;//超萌滚滚秀
    public static final int The_panda_archives = 4;//熊猫档案
    public static final int The_pand_on_the_TOP_list = 5;//熊猫TOP榜
    public static final int What_happened_to_the_panda = 6;//熊猫那些事儿
    public static final int Special_programs = 7;//特别节目
    public static final int Original_news = 8;//原创新闻
    private int type;
   private String img;
    private  String len;
    //    多视角直播 边看边聊
    private TabLayout livetabLayout;
    private NoScrollViewPager liveviewPager;
    private List<BaseFragment> fragment_list;
    private List<String> title_list;
    private ViewPagerAdapter2 adapter;
    private RecyclerView jianjiepull;
    private PullToRefreshRecyclerView jingcaipull;
    private JianJieAdapter jianJieAdapter;
    private JingcaiAdapter jingcaiAdapter;
    private LiveContract.Presenter presenter;
    private List<Live_JianJieBean.LiveBean> jianjieBeanlist = new ArrayList<>();
    private List<Live_JiangCaiBean.VideoBean> jinagcaiBeanlist = new ArrayList<>();

    private static int p = 1;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            ShowPopuUtils.getInsent().create(App.context);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    ShowPopuUtils.getInsent().popuUtilsDismiss();
                }
            }, 300);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.type = getArguments().getInt("type");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        switch (type) {
            case live:
                L.d("TAG", "重新创建了直播Fragment");
                jianjieBeanlist.clear();
                View inflate = inflater.inflate(R.layout.live_live_pull, null);

                jianjiepull = (RecyclerView) inflate.findViewById(R.id.jianjie);
                presenter.jianjieData();
                jianjieManager();
                livetabLayout = (TabLayout) inflate.findViewById(R.id.livetablayout);
                liveviewPager = (NoScrollViewPager) inflate.findViewById(R.id.liveviewpager);
                fragment_list = new ArrayList<>();
                title_list = new ArrayList<>();
                fragment_list.add(new LiveDuoShiJiao());
                fragment_list.add(new LiveBianKanBianLiao());
                title_list.add("多视角直播");
                title_list.add("边看边聊");
                liveviewPager.setNoScroll(true);
                livetabLayout.addTab(livetabLayout.newTab().setText(title_list.get(0)));
                livetabLayout.addTab(livetabLayout.newTab().setText(title_list.get(1)));
                adapter = new ViewPagerAdapter2(getChildFragmentManager(), fragment_list, title_list);
                liveviewPager.setAdapter(adapter);
                livetabLayout.setupWithViewPager(liveviewPager);
                return inflate;
            case Wonderful_moment:
                View inflatejiangcai = View.inflate(getActivity(), R.layout.live_jingcaiyike_pull, null);
                jingcaipull = (PullToRefreshRecyclerView) inflatejiangcai.findViewById(R.id.live_jiangcai_pull);
                jiangcaimangger();
                presenter.setjiangcai("VSET100167216881", "7", "panda", "desc", "time", p + "");
                return inflatejiangcai;
            case When_the_bear_oes_not_let:
                View inflateq = View.inflate(getActivity(), R.layout.live_jingcaiyike_pull, null);
                jingcaipull = (PullToRefreshRecyclerView) inflateq.findViewById(R.id.live_jiangcai_pull);
                jiangcaimangger();
                presenter.dangxiongburang("VSET100332640004", "7", "panda", "desc", "time", p + "");
                return inflateq;
            case supercute:
                View inflatee = inflater.inflate(R.layout.live_jingcaiyike_pull, null);
                jingcaipull = (PullToRefreshRecyclerView) inflatee.findViewById(R.id.live_jiangcai_pull);
                presenter.superxiu("VSET100272959126", "7", "panda", "desc", "time", p + "");
                jiangcaimangger();
                return inflatee;
            case The_panda_archives:
                View inflated = inflater.inflate(R.layout.live_jingcaiyike_pull, null);
                jingcaipull = (PullToRefreshRecyclerView) inflated.findViewById(R.id.live_jiangcai_pull);
                presenter.pandatxt("VSET100340574858", "7", "panda", "desc", "time", p + "");
                jiangcaimangger();
                return inflated;

            case The_pand_on_the_TOP_list:
                View inflatetop = inflater.inflate(R.layout.live_jingcaiyike_pull, null);
                jingcaipull = (PullToRefreshRecyclerView) inflatetop.findViewById(R.id.live_jiangcai_pull);
                presenter.pandatop("VSET100284428835", "7", "panda", "desc", "time", p + "");
                jiangcaimangger();
                return inflatetop;

            case What_happened_to_the_panda:
                View inflateevent = inflater.inflate(R.layout.live_jingcaiyike_pull, null);
                jingcaipull = (PullToRefreshRecyclerView) inflateevent.findViewById(R.id.live_jiangcai_pull);
                presenter.pandaevent("VSET100237714751", "7", "panda", "desc", "time", p + "");
                jiangcaimangger();
                return inflateevent;

            case Special_programs:
                View inflatetebie = inflater.inflate(R.layout.live_jingcaiyike_pull, null);
                jingcaipull = (PullToRefreshRecyclerView) inflatetebie.findViewById(R.id.live_jiangcai_pull);
                presenter.tebiejiemu("VSET100167308855", "7", "panda", "desc", "time", p + "");
                jiangcaimangger();
                return inflatetebie;

            case Original_news:
                View inflateyuanchuang = inflater.inflate(R.layout.live_jingcaiyike_pull, null);
                jingcaipull = (PullToRefreshRecyclerView) inflateyuanchuang.findViewById(R.id.live_jiangcai_pull);
                presenter.yuanchuang("VSET100219009515", "7", "panda", "desc", "time", p + "");
                jiangcaimangger();
                return inflateyuanchuang;
        }


        return null;
    }

    private void jiangcaimangger() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        jingcaipull.setLayoutManager(manager);
        jingcaipull.setPullRefreshEnabled(true);
        jingcaipull.setLoadingMoreEnabled(true);
        jingcaipull.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                jingcaipull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        jingcaipull.setRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                jingcaipull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        p++;
                        presenter.setjiangcai("VSET100167216881", "7", "panda", "desc", "time", p + "");
                        presenter.superxiu("VSET100272959126", "7", "panda", "desc", "time", p + "");
                        presenter.dangxiongburang("VSET100332640004", "7", "panda", "desc", "time", p + "");
                        presenter.pandatxt("VSET100340574858", "7", "panda", "desc", "time", p + "");
                        presenter.pandatop("VSET100284428835", "7", "panda", "desc", "time", p + "");
                        presenter.pandaevent("VSET100237714751", "7", "panda", "desc", "time", p + "");
                        presenter.tebiejiemu("VSET100167308855", "7", "panda", "desc", "time", p + "");
                        presenter.yuanchuang("VSET100219009515", "7", "panda", "desc", "time", p + "");


                        jingcaipull.setLoadMoreComplete();
                    }
                }, 2000);
            }
        });
    }

    private void jianjieManager() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        jianjiepull.setLayoutManager(manager);
    }

    @Override
    protected int getFragmentLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {


    }


    @Override
    protected void initData() {
        new Livepresenter(this);


    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    @Override
    public void setPresenter(LiveContract.Presenter jianjiepresenter) {
        this.presenter = jianjiepresenter;
    }


    @Override
    public void showLiveFragment(Live_MoreViewBean pandaLiveDuoshijiaoBean) {

    }

    @Override
    public void jianjie(Live_JianJieBean live_jianJieBean) {
        L.d("TAG", "走了简介回调");
        jianjieBeanlist.addAll(live_jianJieBean.getLive());
        L.d("TAG","简介的长度="+jianjieBeanlist.size()+"简介的实体"+jianjieBeanlist.toString());
        jianJieAdapter = new JianJieAdapter(App.context, jianjieBeanlist);
        jianjiepull.setAdapter(jianJieAdapter);
        jianJieAdapter.notifyDataSetChanged();

    }

    @Override
    public void biankanbianliao(Live_BianKanBianLiaoBean live_bianKanBianLiaoBean) {

    }


    @Override
    public void jiangcai(Live_JiangCaiBean paperJingCaiBean) {
        jinagcaiBeanlist.addAll(paperJingCaiBean.getVideo());

        len = paperJingCaiBean.getVideo().get(0).getLen();

        img = paperJingCaiBean.getVideo().get(0).getImg();
        jingcaiAdapter = new JingcaiAdapter(getContext(), jinagcaiBeanlist);
        jingcaiAdapter.setJingcaiCallback(this);
        jingcaipull.setAdapter(jingcaiAdapter);
    }


    @Override
    public void back(int layoutPosition) {
        final Live_JiangCaiBean.VideoBean videoBean = jinagcaiBeanlist.get(layoutPosition);
        presenter.video(videoBean.getVid(), new MyHttpCallBack<VideoTwoBean>() {
            @Override
            public void onSuccess(VideoTwoBean videoTwoBean) {
                L.d("精彩一课视频", videoBean.getLen().toString());
                String img = videoBean.getImg();
                String time = videoTwoBean.getF_pgmtime();
                List<VideoTwoBean.VideoBean.ChaptersBean> chapters = videoTwoBean.getVideo().getChapters();//流畅
                String liuchangurl = chapters.get(0).getUrl();
                List<VideoTwoBean.VideoBean.Chapters4Bean> chapters4 = videoTwoBean.getVideo().getChapters4();//高清
                String gaoqingurl = chapters4.get(0).getUrl();
                String title = videoTwoBean.getTitle();
                HistoryUtils.getInstance(getActivity()).instert(title,img,len);
                JCFullScreenActivity.toActivity(img,time,getContext(), gaoqingurl, liuchangurl, null, PandaVedioPlayer.class, title);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}