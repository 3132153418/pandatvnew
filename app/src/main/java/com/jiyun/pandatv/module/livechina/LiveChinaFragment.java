package com.jiyun.pandatv.module.livechina;


import android.view.View;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View{
    //持有P层对象
    private LiveChinaContract.Presenter presenter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_livechina;
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
    public void setPresenter(LiveChinaContract.Presenter homePresenter) {
            this.presenter = homePresenter;
    }
}
