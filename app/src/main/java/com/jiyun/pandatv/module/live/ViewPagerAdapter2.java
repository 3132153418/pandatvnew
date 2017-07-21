package com.jiyun.pandatv.module.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.jiyun.pandatv.base.BaseFragment;

import java.util.List;

/**
 * Created by lenovo on 2017/7/13.
 */
public class ViewPagerAdapter2 extends FragmentPagerAdapter {
    private List<BaseFragment> fragment_list;
    private List<String> title_list;

    public ViewPagerAdapter2(FragmentManager fm, List<BaseFragment> fragment_list, List<String> title_list) {
        super(fm);
        this.fragment_list = fragment_list;
        this.title_list = title_list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title_list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
