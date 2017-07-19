package com.jiyun.pandatv.module.paper;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.paper.paper.PaperDataAdaPter;
import com.jiyun.pandatv.module.paper.paper.PaperLunboAdaPter;
import com.jiyun.pandatv.moudle.entity.Paper_DataBean;
import com.jiyun.pandatv.moudle.entity.Paper_LunboBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PaperFragment extends BaseFragment implements PaperContract.View {
    @BindView(R.id.paper_pull)
    PullToRefreshRecyclerView paperPull;
    Unbinder unbinder;
    //持有P层对象
    private PaperContract.PaperPresenter presenter;
    private PaperLunboAdaPter paperLunboAdaPter;
    private PaperDataAdaPter paperDataAdaPter;
   private PullToRefreshRecyclerView paperdatapull;
  private List<Paper_LunboBean.DataBean.BigImgBean> listlunbo=new ArrayList<>();
  private List<Paper_DataBean.ListBean> listdata=new ArrayList<>();
    private List<Paper_DataBean.ListBean> list = new ArrayList<>();


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

        paperLunboAdaPter = new PaperLunboAdaPter(getContext(),listlunbo);
        paperPull.setAdapter(paperLunboAdaPter);

    }



    @Override
    public void shuju(Paper_DataBean paperDataBean) {
        listdata.addAll(paperDataBean.getList());
        list.addAll(listdata);
        paperDataAdaPter = new PaperDataAdaPter(getContext(),list);
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
}
