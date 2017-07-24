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

public class TwoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.activity_two, null);

        ImageView line1_two= (ImageView) inflate.findViewById(R.id.line1_two);
        Glide.with(this).load("").error(R.drawable.guide_two).into(line1_two);


        return inflate;
    }
}
