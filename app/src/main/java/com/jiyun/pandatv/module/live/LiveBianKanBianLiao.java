package com.jiyun.pandatv.module.live;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.live.liveadapter.LiveBianKanBianLiaoAdapter;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2017/7/13.
 */
public class LiveBianKanBianLiao extends BaseFragment implements LiveContract.View {

    @BindView(R.id.live_biankanbianliao_pull)
    PullToRefreshRecyclerView liveBiankanbianliaoPull;
    Unbinder unbinder;
    private LiveBianKanBianLiaoAdapter livebiankanbianliaoadapter;
    private LiveContract.Presenter presenter;
    private List<Live_BianKanBianLiaoBean.DataBean.ContentBean> mListlook = new ArrayList<>();
    private int p = 1;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.live_biankanbianliao_pull;
    }

    @Override
    protected void init(View view) {

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        liveBiankanbianliaoPull.setLayoutManager(manager);
        liveBiankanbianliaoPull.setPullRefreshEnabled(true);
        liveBiankanbianliaoPull.setLoadingMoreEnabled(true);
        liveBiankanbianliaoPull.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                liveBiankanbianliaoPull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        liveBiankanbianliaoPull.setRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                liveBiankanbianliaoPull.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        p++;
                        presenter.biankanbianliaoData("ipandaApp", "zhiboye_chat", "nature", p + "");
                        liveBiankanbianliaoPull.setLoadMoreComplete();
                    }
                }, 2000);
            }
        });
    }

    @Override
    protected void initData() {
        new Livepresenter(this);
//        ?app=ipandaApp&itemid=zhiboye_chat&nature=1&page=1
        presenter.biankanbianliaoData("ipandaApp", "zhiboye_chat", "nature", p + "");
    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    @Override
    public void setPresenter(LiveContract.Presenter biankanpresenter) {
        this.presenter = biankanpresenter;
    }


    @Override
    public void showLiveFragment(Live_MoreViewBean pandaLiveDuoshijiaoBean) {

    }

    @Override
    public void jianjie(Live_JianJieBean live_jianJieBean) {

    }

    @Override
    public void biankanbianliao(Live_BianKanBianLiaoBean live_bianKanBianLiaoBean) {
        L.d("sgfdhgfdhfg",live_bianKanBianLiaoBean.toString());
        mListlook.addAll(live_bianKanBianLiaoBean.getData().getContent());
        livebiankanbianliaoadapter = new LiveBianKanBianLiaoAdapter(getContext(), mListlook);
        L.d("边看边聊", mListlook.toString());
        liveBiankanbianliaoPull.setAdapter(livebiankanbianliaoadapter);
    }

    @Override
    public void jiangcai(Live_JiangCaiBean paperJingCaiBean) {

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
