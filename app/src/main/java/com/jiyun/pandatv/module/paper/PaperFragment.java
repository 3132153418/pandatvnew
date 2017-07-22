package com.jiyun.pandatv.module.paper;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.ACache;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.module.home.centre.CentreActivity;
import com.jiyun.pandatv.module.paper.paper.PaperDataAdaPter;
import com.jiyun.pandatv.module.paper.paper.PaperLunboAdaPter;
import com.jiyun.pandatv.moudle.entity.Paper_DataBean;
import com.jiyun.pandatv.moudle.entity.Paper_LunboBean;
import com.jiyun.pandatv.moudle.entity.Video_PaperBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCFullScreenActivity;
import fm.jiecao.jcvideoplayer_lib.PandaVedioPlayer;

public class PaperFragment extends BaseFragment implements PaperContract.View, PaperDataAdaPter.PaperCallBack {
    @BindView(R.id.paper_pull)
    PullToRefreshRecyclerView paperPull;
    Unbinder unbinder;
    @BindView(R.id.paper_person)
    ImageView paperPerson;
    //持有P层对象
    private PaperContract.PaperPresenter presenter;
    private PaperLunboAdaPter paperLunboAdaPter;
    private PaperDataAdaPter paperDataAdaPter;
    private PullToRefreshRecyclerView paperdatapull;
    private List<Paper_LunboBean.DataBean.BigImgBean> listlunbo = new ArrayList<>();
    private List<Paper_DataBean.ListBean> listdata = new ArrayList<>();
    private List<Paper_DataBean.ListBean> list = new ArrayList<>();
//缓存
    private ACache aCache = ACache.get(App.context);
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_paper;
    }

    @Override
    protected void init(View view) {
        lunbomanger();
        shujumamger();
    }

    private void shujumamger() {

    }

    private void lunbomanger() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        paperPull.setLayoutManager(manager);
        paperPull.setPullRefreshEnabled(true);
        paperPull.setLoadingMoreEnabled(true);
        paperPull.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                paperPull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        paperPull.setRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                paperPull.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        paperPull.setLoadMoreComplete();
                    }
                }, 2000);
            }
        });
        View inflate = LayoutInflater.from(App.context.getApplicationContext()).inflate(R.layout.paper_data, null);
        paperdatapull = (PullToRefreshRecyclerView) inflate.findViewById(R.id.paper_data_pull);
        papermanger();
        paperPull.addFooterView(inflate);
    }

    private void papermanger() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        paperdatapull.setLayoutManager(manager);
        paperdatapull.setPullRefreshEnabled(true);
        paperdatapull.setLoadingMoreEnabled(true);
        paperdatapull.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                paperdatapull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        paperdatapull.setRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                paperdatapull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        paperdatapull.setLoadMoreComplete();
                        list.addAll(listdata);
                        paperDataAdaPter.notifyDataSetChanged();
                    }
                }, 2000);
            }
        });
    }

    @Override
    protected void initData() {
        new Paperpresenter(this);
        presenter.lunboData();
        presenter.shujuData();
    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    //BaseView的方法
    @Override
    public void setPresenter(PaperContract.PaperPresenter homePresenter) {
        this.presenter = homePresenter;
    }


    @Override
    public void lunbo(Paper_LunboBean paperLunboBean) {
        listlunbo.addAll(paperLunboBean.getData().getBigImg());

        paperLunboAdaPter = new PaperLunboAdaPter(getContext(), listlunbo);
        paperPull.setAdapter(paperLunboAdaPter);

    }


    @Override
    public void shuju(Paper_DataBean paperDataBean) {
        listdata.addAll(paperDataBean.getList());
        list.addAll(listdata);
        paperDataAdaPter = new PaperDataAdaPter(getContext(), list);
        paperDataAdaPter.setPaperCallBack(this);
        paperdatapull.setAdapter(paperDataAdaPter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void back(int layoutPosition) {
    String pid = list.get(0).getGuid();
    presenter.papervideo(pid, new MyHttpCallBack<Video_PaperBean>() {
        @Override
        public void onSuccess(Video_PaperBean paper_videoBean) {
            String gaoqing = paper_videoBean.getVideo().getChapters4().get(0).getUrl();
            String liuchang = paper_videoBean.getVideo().getChapters().get(0).getUrl();
            String title = paper_videoBean.getTitle();
            JCFullScreenActivity.toActivity(getContext(), gaoqing, liuchang, null, PandaVedioPlayer.class, title);
        }
        @Override
        public void onError(int errorCode, String errorMsg) {
        }
    });
}

    @OnClick(R.id.paper_person)
    public void onViewClicked() {
    Intent intent = new Intent(getContext(),CentreActivity.class);
    startActivity(intent);
    }

}
