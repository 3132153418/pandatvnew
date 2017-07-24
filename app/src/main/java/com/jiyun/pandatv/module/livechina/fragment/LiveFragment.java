package com.jiyun.pandatv.module.livechina.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.ACache;
import com.jiyun.pandatv.apputils.ShowPopuUtils;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.livechina.adapter.ZhiBochenaAdapter;
import com.jiyun.pandatv.moudle.entity.ChangchengBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/22.
 */

public class LiveFragment extends BaseFragment implements LiveContract.View{
    private LivePresenter presenter;
    private ListView mListView;
    private ZhiBochenaAdapter mAdapter;
    private List<ChangchengBean.LiveBean> mList = new ArrayList<>();
    private Bundle bundle;
    private ACache cache;
    Unbinder unbinder;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.zhibochena_listview;
    }

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
            },300);
        }
    }

    @Override
    protected void init(View view) {
        new LivePresenter(this);
        mListView = (ListView) view.findViewById(R.id.ZhiboChena_ListView);

        mAdapter = new ZhiBochenaAdapter(getContext(),mList);
        mListView.setAdapter(mAdapter);

    }

    @Override
    protected void initData() {
        String url = bundle.getString("url");
        if(url!=null) {
            presenter.setUrl(url);
        }
    }

    @Override
    protected void fragmentHidden() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void fragmentShowing() {

    }

    @Override
    public void setParams(Bundle bundle) {
        this.bundle=bundle;
    }

    @Override
    public void getManager(ChangchengBean changchengBean) {

        mList.addAll(changchengBean.getLive());
        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void showMessage(String msg) {

        cache=ACache.get(getContext());
        ChangchengBean list = (ChangchengBean)cache.getAsObject("ChangchengBean");
        mList.addAll(list.getLive());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(LiveContract.Presenter presenter) {

        this.presenter = (LivePresenter) presenter;
    }
}
