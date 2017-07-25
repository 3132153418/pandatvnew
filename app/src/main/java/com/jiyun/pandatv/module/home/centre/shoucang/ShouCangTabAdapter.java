package com.jiyun.pandatv.module.home.centre.shoucang;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;



public class ShouCangTabAdapter extends FragmentPagerAdapter{

    private ArrayList<Fragment> list;
    private String[] str={"直播","精彩看点"};

    public ShouCangTabAdapter(FragmentManager fm,ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
