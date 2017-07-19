package com.jiyun.pandatv.module.livechina;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.live.ViewPagerAdapter2;
import com.jiyun.pandatv.module.live.views.NoScrollViewPager;
import com.jiyun.pandatv.module.livechina.liveadapter.LiveChinaAdapter;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/18.
 */

public class FuYongFragment extends BaseFragment implements LiveChinaContract.View {
    public static final int BADALING = 0;//八达岭
    public static final int HUANGSHAN = 1;//黄山
    public static final int FENGHUANG = 2;//凤凰古城
    public static final int EMEISHAN = 3;//峨眉山
    private TabLayout livetabLayout;
    private NoScrollViewPager liveviewPager;
    private List<BaseFragment> fragment_list;
    private List<String> title_list;
    private ViewPagerAdapter2 adapter;
    private int type;

    private PullToRefreshRecyclerView livachina_pull;


    private LiveChinaContract.Presenter presenter;
    private List<LiveChina_BaDaBean.LiveBean> mlist = new ArrayList<>();
    private LiveChinaAdapter liveChinaAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.type = getArguments().getInt("typetwo");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        switch (type) {
            case BADALING:
                View inflateyuanchuang = inflater.inflate(R.layout.livechina_pull, null);
                livachina_pull = (PullToRefreshRecyclerView) inflateyuanchuang.findViewById(R.id.livechina_pull);
                presenter.bada();
                livachinamangger();
                return inflateyuanchuang;
            case HUANGSHAN:

                View inflate2 = inflater.inflate(R.layout.livechina_pull, null);
                livachina_pull = (PullToRefreshRecyclerView) inflate2.findViewById(R.id.livechina_pull);
                presenter.huangshan();
                livachinamangger();
                return inflate2;
            case FENGHUANG:

                View inflate3 = inflater.inflate(R.layout.livechina_pull, null);
                livachina_pull = (PullToRefreshRecyclerView) inflate3.findViewById(R.id.livechina_pull);
                presenter.fenghaung();
                livachinamangger();
                return inflate3;

            case EMEISHAN:

                View inflate4 = inflater.inflate(R.layout.livechina_pull, null);
                livachina_pull = (PullToRefreshRecyclerView) inflate4.findViewById(R.id.livechina_pull);
                presenter.emeishan();
                livachinamangger();
                return inflate4;
        }
        return null;
    }

    private void livachinamangger() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        livachina_pull.setLayoutManager(manager);
        livachina_pull.setPullRefreshEnabled(true);
        livachina_pull.setLoadingMoreEnabled(true);
        livachina_pull.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                livachina_pull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        livachina_pull.setRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                livachina_pull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        livachina_pull.setLoadMoreComplete();
                    }
                }, 2000);
            }
        });
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
        new LiveChinapresenter(this);
    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    @Override
    public void setPresenter(LiveChinaContract.Presenter livechinapresenter) {
        this.presenter = livechinapresenter;
    }



    @Override
    public void badaling(LiveChina_BaDaBean liveChina_baDaBean) {
        mlist.addAll(liveChina_baDaBean.getLive());
        liveChinaAdapter = new LiveChinaAdapter(App.context, mlist);
        livachina_pull.setAdapter(liveChinaAdapter);
        liveChinaAdapter.notifyDataSetChanged();
    }
}
