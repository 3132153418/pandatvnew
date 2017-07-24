package com.jiyun.pandatv;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class FragmentAdapter extends PagerAdapter {
    private List<ImageView> mlist;

    public FragmentAdapter(List<ImageView> mlist){
        this.mlist = mlist;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mlist.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mlist.get(position);
        container.addView(imageView);
        return imageView;
    }
}
