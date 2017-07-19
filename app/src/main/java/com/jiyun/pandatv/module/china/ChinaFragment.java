package com.jiyun.pandatv.module.china;


import android.view.View;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;

public class ChinaFragment extends BaseFragment implements ChinaContract.View{
    //持有P层对象
    private ChinaContract.Presenter presenter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_china;
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
    public void setPresenter(ChinaContract.Presenter homePresenter) {
            this.presenter = homePresenter;
    }

}
