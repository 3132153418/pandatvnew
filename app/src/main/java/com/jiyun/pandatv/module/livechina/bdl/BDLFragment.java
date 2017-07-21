package com.jiyun.pandatv.module.livechina.bdl;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.androidkun.PullToRefreshRecyclerView;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.livechina.liveadapter.LiveChinaAdapter;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhuofang on 2017/7/13.
 */
public class BDLFragment extends BaseFragment implements BDLChinaLiveContract.View {
    BDLChinaLiveContract.Presenter presenter;
    PullToRefreshRecyclerView bdlframent;
    private LiveChinaAdapter bdlAdapter;
    private List<LiveChina_BaDaBean.LiveBean> mList;
    private Bundle bundle;
    @Override
    public void onShowDialog() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void setResult(LiveChina_BaDaBean tablistBean) {
        List<LiveChina_BaDaBean.LiveBean> live = tablistBean.getLive();
        Log.e("bdffragment", "请求，，，" + live);
        mList.addAll(live);
        bdlAdapter = new LiveChinaAdapter(getContext(), mList);
        bdlframent.setAdapter(bdlAdapter);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.bdlfragment;
    }

    @Override
    protected void init(View view) {
        bdlframent = (PullToRefreshRecyclerView) view.findViewById(R.id.bdlframent);

    }

    @Override
    protected void initData() {
        mList = new ArrayList<>();
        bdlframent.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        bdlframent.setLoadingMoreEnabled(true);
        bdlframent.setPullRefreshEnabled(true);
        new BDLChinaLivePresenterTS(this);
        if(bundle!=null) {
            String url = bundle.getString("url");
            presenter.setUrl(url);
        }
    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    @Override
    public void setParams(Bundle bundle) {
        this.bundle=bundle;
    }

    //presenter报空的话，是一个fragment对应一个presenter
    @Override
    public void setPresenter(BDLChinaLiveContract.Presenter presenter) {
        this.presenter = presenter;
    }

}
