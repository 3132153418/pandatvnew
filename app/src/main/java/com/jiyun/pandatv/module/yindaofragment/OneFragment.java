package com.jiyun.pandatv.module.yindaofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.pandatv.R;

/**
 * Created by Administrator on 2017/6/14.
 */

public class OneFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_one,container,false);
        ImageView line1_one= (ImageView) view.findViewById(R.id.line1_one);
        Glide.with(this).load("").error(R.drawable.guide_one).into(line1_one);
        return  view;
    }
}
