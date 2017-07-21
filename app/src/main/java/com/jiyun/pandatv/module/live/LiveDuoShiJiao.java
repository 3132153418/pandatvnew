package com.jiyun.pandatv.module.live;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.live.liveadapter.LiveDuoShiJiaoAdapter;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2017/7/13.
 */
public class LiveDuoShiJiao extends BaseFragment implements LiveContract.View {
    @BindView(R.id.live_duoshijiao_pull)
    RecyclerView liveDuoshijiaoPull;
    Unbinder unbinder;
    private LiveDuoShiJiaoAdapter liveDuoShiJiaoAdapter;
    private LiveContract.Presenter presenter;
    private List<Live_MoreViewBean.ListBean> mList = new ArrayList<>();

        @Override
        protected int getFragmentLayoutId() {
            return R.layout.live_duoshijiao_pull;
        }

        @Override
        protected void init(View view) {
            GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            liveDuoshijiaoPull.setLayoutManager(manager);
        }



        @Override
        protected void initData() {
            new Livepresenter(this);
        presenter.loadDuoshijiaoData();
    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }


    @Override
    public void setPresenter(LiveContract.Presenter livepresenter) {
        this.presenter = livepresenter;
    }


    @Override
    public void showLiveFragment(Live_MoreViewBean pandaLiveDuoshijiaoBean) {
        mList.addAll(pandaLiveDuoshijiaoBean.getList());
        liveDuoShiJiaoAdapter = new LiveDuoShiJiaoAdapter(getContext(),mList);
        L.d("多视角list",mList.toString());
        liveDuoshijiaoPull.setAdapter(liveDuoShiJiaoAdapter);
    }

    @Override
    public void jianjie(Live_JianJieBean live_jianJieBean) {

    }

    @Override
    public void biankanbianliao(Live_BianKanBianLiaoBean live_bianKanBianLiaoBean) {

    }



    @Override
    public void jiangcai(Live_JiangCaiBean paperJingCaiBean) {

    }

   
}
