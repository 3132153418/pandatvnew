package com.jiyun.pandatv.module.live;


import android.view.View;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;

public class LiveFragment extends BaseFragment implements LiveContract.View{
    //持有P层对象
    private LiveContract.Presenter presenter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void init(View view) {
        presenter.start();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    //BaseView的方法
    @Override
    public void setPresenter(LiveContract.Presenter homePresenter) {
            this.presenter = homePresenter;
    }

}
