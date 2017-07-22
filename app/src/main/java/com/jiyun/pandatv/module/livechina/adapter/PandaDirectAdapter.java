package com.jiyun.pandatv.module.livechina.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.jiyun.pandatv.base.BaseFragment;

import java.util.List;

/**
 * Created by INS7566 on 2017/7/12.
 */

public class PandaDirectAdapter extends FragmentStatePagerAdapter{
    private List<String> ListName;
    private List<BaseFragment> mList;
    public PandaDirectAdapter(FragmentManager fm, List<String> ListName, List<BaseFragment> mList) {
        super(fm);
        this.ListName = ListName;
        this.mList = mList;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ListName.get(position);
    }
}
