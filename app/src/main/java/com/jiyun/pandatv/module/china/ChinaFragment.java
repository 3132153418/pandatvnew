package com.jiyun.pandatv.module.china;


import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;

import fm.jiecao.jcvideoplayer_lib.JCFullScreenActivity;
import fm.jiecao.jcvideoplayer_lib.PandaVedioPlayer;


public class ChinaFragment extends BaseFragment implements ChinaContract.View {
    //持有P层对象
    private ChinaContract.Presenter presenter;
    private Button playvideo;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_china;
    }

    @Override
    protected void init(View view) {
        presenter.start();
        playvideo = (Button) view.findViewById(R.id.playvideo);
        playvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gaoqing = Environment.getExternalStorageDirectory() + "/Download/a.mp4";
                String liuchang = Environment.getExternalStorageDirectory() + "/Download/b.mp4";
                JCFullScreenActivity.toActivity(getActivity(), gaoqing,liuchang, null, PandaVedioPlayer.class, "嫂子真牛逼");
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    //BaseView的方法
    @Override
    public void setPresenter(ChinaContract.Presenter homePresenter) {
        this.presenter = homePresenter;
    }

}
