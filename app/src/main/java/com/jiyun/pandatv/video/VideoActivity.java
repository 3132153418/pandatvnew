package com.jiyun.pandatv.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.androidkun.PullToRefreshRecyclerView;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by lenovo on 2017/7/20.
 */
public class VideoActivity extends BaseActivity {
    @BindView(R.id.video_pull)
    PullToRefreshRecyclerView videoPull;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        intent.getStringExtra("pid");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.video_pull;
    }

    //    JCFullScreenActivity.toActivity(getContext(),);
    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }
}
