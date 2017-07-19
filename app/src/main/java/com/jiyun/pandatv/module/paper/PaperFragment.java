package com.jiyun.pandatv.module.paper;


import android.view.View;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;

public class PaperFragment extends BaseFragment implements PaperContract.View{
    //持有P层对象
    private PaperContract.Presenter presenter;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_paper;
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
    public void setPresenter(PaperContract.Presenter homePresenter) {
            this.presenter = homePresenter;
    }

}
