package com.jiyun.pandatv.module.home.pandajingcaiyike;

import android.content.Intent;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.moudle.entity.VadioBean;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import fm.jiecao.jcvideoplayer_lib.PandaVedioPlayer;

/**
 * Created by Administrator on 2017/7/16.
 */

public class AmazingActivty extends BaseActivity implements AmazingContract.View{
    private PandaVedioPlayer pandaVedioPlayer;
    private String pid, title;
    AmazingContract.Presenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.video_avtivity;
    }

    @Override
    protected void initView() {

        Amazingpresenter amazingpresenter = new Amazingpresenter(this);
        Intent intent = getIntent();

        pid = intent.getStringExtra("pid");


        title = intent.getStringExtra("title");

        pandaVedioPlayer = (PandaVedioPlayer) findViewById(R.id.pandatv);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


    @Override
    protected void loadData() {

        presenter.setVadioPid(pid);
    }

    @Override
    public void showlivevedioFragment(VadioBean vadioBean) {

        List<VadioBean.VideoBean.Chapters2Bean> chapters2 = vadioBean.getVideo().getChapters2();
        String url = chapters2.get(0).getUrl();
        pandaVedioPlayer.setUrlAndObject(url, null,title);
        pandaVedioPlayer.setStateAndUi(PandaVedioPlayer.CURRENT_STATE_NORMAL);
    }

    @Override
    public void setPresenter(AmazingContract.Presenter presenter) {

        this.presenter = presenter;
    }
}
