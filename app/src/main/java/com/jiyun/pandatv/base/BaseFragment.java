package com.jiyun.pandatv.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentview = inflater.inflate(getFragmentLayoutId(), null);
        bind = ButterKnife.bind(this, fragmentview);
        return fragmentview;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);//初始化组件
        initData();//初始化数据
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (hidden) {
            fragmentHidden();
        }else{
            fragmentShowing();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }


    protected abstract int getFragmentLayoutId();
    protected abstract void init(View view);
    protected abstract void initData();
    protected abstract void fragmentHidden();
    protected abstract void fragmentShowing();

    public void setParams(Bundle bundle){

    }
}


