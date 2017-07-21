package com.jiyun.pandatv.module.china;


import android.os.Environment;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.androidkun.PullToRefreshRecyclerView;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.home.centre.CentreActivity;
import com.jiyun.pandatv.moudle.entity.GGliveBean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ChinaFragment extends BaseFragment implements ChinaContract.View,View.OnClickListener{
    private PullToRefreshRecyclerView ptr;
    private ImageView gg_ImageView;
    private List<GGliveBean.ListBean> list = new ArrayList<>();
    private GGAdapter adapter;
    private TextView china_Image_title;
    private View inflat;
    private ImageView mImage;
    private ImageView gg_MyLogin_Image;
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
        inflat = LayoutInflater.from(getContext()).inflate(R.layout.fragment_china_item, null);
        mImage = (ImageView) inflat.findViewById(R.id.gg_ImageView);
        china_Image_title = (TextView) inflat.findViewById(R.id.china_Image_title);
        ptr = (PullToRefreshRecyclerView) view.findViewById(R.id.gg_PulltoRef);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        ptr.setLayoutManager(manager);
        ptr.addHeaderView(inflat);
        gg_MyLogin_Image = (ImageView) view.findViewById(R.id.gg_MyLogin_Image);
        gg_MyLogin_Image.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        presenter.start();
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

    @Override
    public void setResult(GGliveBean gGliveBean) {
        Glide.with(getContext()).load(gGliveBean.getBigImg().get(0).getImage()).into(mImage);
        china_Image_title.setText(gGliveBean.getBigImg().get(0).getTitle());
        List<GGliveBean.ListBean> gGliveBeanList = gGliveBean.getList();
        adapter = new GGAdapter(getContext(), gGliveBeanList);
        ptr.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gg_MyLogin_Image:
                Intent intent = new Intent(getActivity(),CentreActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }
}
