package com.jiyun.pandatv.module.home.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/13 0013.
 */

public class Home_viewpager_Adapter extends PagerAdapter{
    private List<View> mlist;

    public Home_viewpager_Adapter(List<View> mlist) {
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        if (mlist.size() == 0){
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View image = mlist.get(position % mlist.size());
        if (image.getParent() != null){
            ((ViewGroup) image.getParent()).removeView(image);

        }
        container.addView(image);
        return image;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }
}
