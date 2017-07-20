package com.jiyun.pandatv.module.live;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jiyun.pandatv.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final String[] titles;
    private Context context;
    private List<BaseFragment> fragments;

    public ViewPagerAdapter(List<BaseFragment> fragments, String[] titles, FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
        this.titles = titles;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
