package com.jiyun.pandatv.module.home;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.MainActivity;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.module.home.adapter.Home_Adaoter;
import com.jiyun.pandatv.module.home.adapter.Home_viewpager_Adapter;
import com.jiyun.pandatv.module.home.centre.CentreActivity;
import com.jiyun.pandatv.module.home.original.OriginalActivity;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.Video_home_TuiJianBean;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCFullScreenActivity;
import fm.jiecao.jcvideoplayer_lib.PandaVedioPlayer;

public class HomeFragment extends BaseFragment implements HomeContract.View, View.OnClickListener, Home_Adaoter.ShouYeCallback {
    private ArrayList<FirstBean> list = new ArrayList<>();
    private Home_Adaoter home_adaoter;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private ViewPager homeViewPager;
    //持有P层对象
    private HomeContract.Presenter presenter;
    private List<Object> mlist;
    private List<View> viewList = new ArrayList<>();
    private View inflate;
    private int currentNum = 100000;
    private List<ImageView> DianDians;
    private ImageView home_Original_Image, home_MyLogin_Image;
    private LinearLayout linearLayout;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View view) {
        home_Original_Image = (ImageView) view.findViewById(R.id.home_Original_Image);
        home_MyLogin_Image = (ImageView) view.findViewById(R.id.home_MyLogin_Image);
        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.home_PullToRefreshRecyclerView);


        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        pullToRefreshRecyclerView.setLayoutManager(manager);
        pullToRefreshRecyclerView.setPullRefreshEnabled(true);
        pullToRefreshRecyclerView.setLoadingMoreEnabled(true);

        //添加轮播图布局
        inflate = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager, null);

        homeViewPager = (ViewPager) inflate.findViewById(R.id.home_viewpager);
        //添加轮播图头布局
        pullToRefreshRecyclerView.addHeaderView(inflate);
        home_Original_Image.setOnClickListener(this);
        home_MyLogin_Image.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        presenter.start();
        setListenre();

    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    //BaseView的方法
    @Override
    public void setPresenter(HomeContract.Presenter homePresenter) {
        this.presenter = homePresenter;
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void setConmit() {

    }

    @Override
    public void setResult(FirstBean firstBean) {
        //取出javaBean里面的所有集合   添加到list里面   放入适配器
        list.add(firstBean);
        FirstBean.DataBean data = firstBean.getData();
        mlist = new ArrayList<>();
        mlist.add(data.getPandaeye());
        mlist.add(data.getPandalive());
        mlist.add(data.getArea());
        mlist.add(data.getWalllive());
        mlist.add(data.getChinalive());

        home_adaoter = new Home_Adaoter(getContext(), mlist);
        home_adaoter.setBack(this);
        pullToRefreshRecyclerView.setAdapter(home_adaoter);


        //轮播图
        List<FirstBean.DataBean.BigImgBean> bigImg = firstBean.getData().getBigImg();
        View view = null;
        ImageView imageView = null;

        linearLayout = (LinearLayout) inflate.findViewById(R.id.home_viewpager_linearlayout);
        ImageView DianDian = null;


        //通过网络请求加载轮播图图片和文字  并且同时添加点
        DianDians = new ArrayList<>();
        for (int i = 0; i < bigImg.size(); i++) {
            DianDian = new ImageView(getContext());
            DianDian.setImageResource(R.drawable.point_off);
            linearLayout.addView(DianDian);
            DianDians.add(DianDian);
            view = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager_item, null);
            imageView = (ImageView) view.findViewById(R.id.home_ViewPager_Image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    List<FirstBean.DataBean.BigImgBean> bigImg = list.get(0).getData().getBigImg();
//                    String pid = bigImg.get(0).getPid();
//                    L.d("你大爷的奶奶的个腿", pid);
//                    presenter.homevideo(pid, new MyHttpCallBack<Video_home_TuiJianBean>() {
//                        @Override
//                        public void onSuccess(Video_home_TuiJianBean video_home_tuiJianBean) {
//                            L.d("轮播监听", video_home_tuiJianBean.getTitle().toString());
//                            List<Video_home_TuiJianBean.VideoBean.Chapters4Bean> chapters4 = video_home_tuiJianBean.getVideo().getChapters4();
//                            L.e("我擦", chapters4.get(0).getDuration().toString());
//                            String gaoqing = chapters4.get(0).getUrl();
//                            L.d("高清轮播", gaoqing.toString());
//                            String liuchang = video_home_tuiJianBean.getVideo().getChapters().get(0).getUrl();
//                            String title = video_home_tuiJianBean.getTitle();
//                            JCFullScreenActivity.toActivity(getContext(), gaoqing, liuchang, null, PandaVedioPlayer.class, title);
//                        }
//
//                        @Override
//                        public void onError(int errorCode, String errorMsg) {
//
//                        }
//                    });
                }
            });
            TextView title = (TextView) view.findViewById(R.id.home_viewpager_title);
            Glide.with(getContext()).load(bigImg.get(i).getImage()).into(imageView);
            title.setText(bigImg.get(i).getTitle());
            viewList.add(view);
        }


        Home_viewpager_Adapter adapter = new Home_viewpager_Adapter(viewList);
        homeViewPager.setAdapter(adapter);
        homeViewPager.setCurrentItem(currentNum);

        //添加轮播图的点
        ImageView imageView1 = DianDians.get(currentNum % DianDians.size());
        imageView1.setImageResource(R.drawable.point_on);
        handler.sendEmptyMessageDelayed(222, 2000);

    }

    //发送hanlder启动轮播
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 222) {
                currentNum++;
                homeViewPager.setCurrentItem(currentNum);
                int i1 = currentNum % DianDians.size();
                for (int i = 0; i < DianDians.size(); i++) {

                    if (i == i1) {
                        ImageView imageView = DianDians.get(i);
                        imageView.setImageResource(R.drawable.point_on);
                    } else {
                        ImageView imageView = DianDians.get(i);
                        imageView.setImageResource(R.drawable.point_off);
                    }
                }
                handler.sendEmptyMessageDelayed(222, 2000);
            }
        }
    };

    //设置轮播监听   设置选中和未选中时的状态
    public void setListenre() {

        homeViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentNum = position;
//
                int i1 = currentNum % DianDians.size();
                for (int i = 0; i < DianDians.size(); i++) {
                    if (i == i1) {
                        ImageView imageView = DianDians.get(i);
                        imageView.setImageResource(R.drawable.point_on);
                    } else {
                        ImageView imageView = DianDians.get(i);
                        imageView.setImageResource(R.drawable.point_off);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
        onRefresh();

    }

    @Override
    public void onRefrash(int inDex, int inCount) {

    }

    @Override
    public void showMessage(String msg) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.home_Original_Image:
                //获取跳转的第一个activity
                MainActivity activity = (MainActivity) getActivity();
                Intent intent = new Intent(activity, OriginalActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.home_MyLogin_Image:
                MainActivity activity1 = (MainActivity) getActivity();
                Intent intent1 = new Intent(activity1, CentreActivity.class);
                activity1.startActivity(intent1);
                break;

        }
    }

    public void onRefresh() {
        pullToRefreshRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                pullToRefreshRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        linearLayout.removeAllViews();
                        viewList.clear();
                        presenter.start();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {

                pullToRefreshRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 2000);
            }
        });
    }

    @Override
    public void jingcaituijianback(int position) {
        List<FirstBean.DataBean.AreaBean.ListscrollBean> listscroll = list.get(0).getData().getArea().getListscroll();
        String pid = listscroll.get(0).getPid();
        L.d("推荐", pid.toString());
        presenter.homevideo(pid, new MyHttpCallBack<Video_home_TuiJianBean>() {
            @Override
            public void onSuccess(Video_home_TuiJianBean video_home_tuiJianBean) {
                L.d("首页推荐一刻的bean值", video_home_tuiJianBean.getTitle().toString());
                final List<Video_home_TuiJianBean.VideoBean.Chapters4Bean> chapters4 = video_home_tuiJianBean.getVideo().getChapters4();
                String gaoqing = chapters4.get(0).getUrl();
                L.d("eeeee", gaoqing.toString());
                String liuchang = video_home_tuiJianBean.getVideo().getChapters().get(0).getUrl();
                String title = video_home_tuiJianBean.getTitle();
                JCFullScreenActivity.toActivity(getContext(), gaoqing, liuchang, null, PandaVedioPlayer.class, title);

            }


            @Override
            public void onError(int errorCode, String errorMsg) {
                L.d("首页精彩一刻", errorMsg);
            }
        });

    }

    @Override
    public void xiongmaoguanchaback(int position) {
        List<FirstBean.DataBean.PandaeyeBean.ItemsBean> items = list.get(0).getData().getPandaeye().getItems();
        String pid = items.get(0).getPid();
        presenter.homevideo(pid, new MyHttpCallBack<Video_home_TuiJianBean>() {
            @Override
            public void onSuccess(Video_home_TuiJianBean video_home_tuiJianBean) {
                final List<Video_home_TuiJianBean.VideoBean.Chapters4Bean> chapters4 = video_home_tuiJianBean.getVideo().getChapters4();
                String gaoqing = chapters4.get(0).getUrl();
                String liuchang = video_home_tuiJianBean.getVideo().getChapters().get(0).getUrl();
                String title = video_home_tuiJianBean.getTitle();
                JCFullScreenActivity.toActivity(getContext(), gaoqing, liuchang, null, PandaVedioPlayer.class, title);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void xiongmaoguanchaback2(int position) {
        List<FirstBean.DataBean.PandaeyeBean.ItemsBean> items = list.get(0).getData().getPandaeye().getItems();
        String pid = items.get(0).getPid();
        presenter.homevideo(pid, new MyHttpCallBack<Video_home_TuiJianBean>() {
            @Override
            public void onSuccess(Video_home_TuiJianBean video_home_tuiJianBean) {
                final List<Video_home_TuiJianBean.VideoBean.Chapters4Bean> chapters4 = video_home_tuiJianBean.getVideo().getChapters4();
                String gaoqing = chapters4.get(0).getUrl();
                String liuchang = video_home_tuiJianBean.getVideo().getChapters().get(0).getUrl();
                String title = video_home_tuiJianBean.getTitle();
                JCFullScreenActivity.toActivity(getContext(), gaoqing, liuchang, null, PandaVedioPlayer.class, title);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }


}