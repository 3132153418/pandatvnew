package com.jiyun.pandatv.module.yindaofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.pandatv.R;

/**
 * Created by Administrator on 2017/6/14.
 */

public class TwoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.guide_page3,container,false);
        return inflate;
    }
}
