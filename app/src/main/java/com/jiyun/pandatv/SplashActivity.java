package com.jiyun.pandatv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;


import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.module.yindaofragment.OneFragment;
import com.jiyun.pandatv.module.yindaofragment.ThreeFragment;
import com.jiyun.pandatv.module.yindaofragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/14.
 */

public class SplashActivity extends BaseActivity {
    ViewPager viewPager;
    private List<Fragment> list = new ArrayList<>();
    private FragmentAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        addViewPager();
        adapter = new FragmentAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void loadData() {

    }

    public void addViewPager(){
        OneFragment oneFragment=new OneFragment();
        TwoFragment twoFragment=new TwoFragment();
        ThreeFragment threeFragment=new ThreeFragment();

        list.add(oneFragment);
        list.add(twoFragment);
        list.add(threeFragment);

    }

}
