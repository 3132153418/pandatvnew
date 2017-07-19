package com.jiyun.pandatv.module.home.centre.fragment;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;

/**
 * Created by Administrator on 2017/7/18.
 */

public class PhoneFragment extends BaseFragment {
    private ImageView phone_ImageView;
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_phone;
    }

    @Override
    protected void init(View view) {

        phone_ImageView = (ImageView) view.findViewById(R.id.phone_ImageView);

    }

    @Override
    protected void initData() {
        Glide.with(getActivity()).load("http://reg.cntv.cn/simple/verificationCode.action").into(phone_ImageView);

    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }
}
