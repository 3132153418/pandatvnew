package com.jiyun.pandatv.module.china;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.ShowPopuUtils;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.home.centre.CentreActivity;
import com.jiyun.pandatv.moudle.entity.GGliveBean;

import java.util.ArrayList;
import java.util.List;

public class ChinaFragment extends BaseFragment implements ChinaContract.View{
    private PullToRefreshRecyclerView ptr;
    private ImageView gg_ImageView;
    private List<GGliveBean.ListBean> list = new ArrayList<>();
    private GGAdapter adapter;
    private TextView china_Image_title;
    private View inflat;
    private ImageView mImage;

    //持有P层对象
    private ChinaContract.Presenter presenter;
    private Button playvideo;


    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_china;
    }

    @Override
    protected void init(View view) {
        ShowPopuUtils.getInsent().create(App.context);

        View viewById = view.findViewById(R.id.chinafragment_common);
        viewById.findViewById(R.id.iv_top_logo).setVisibility(View.INVISIBLE);
        ((TextView) viewById.findViewById(R.id.tv_top_title)).setText("滚滚视频");
        viewById.findViewById(R.id.iv_top_hudong).setVisibility(View.INVISIBLE);
        viewById.findViewById(R.id.iv_top_Image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CentreActivity.class);
                startActivity(intent);
            }
        });

        presenter.start();
        inflat = LayoutInflater.from(getContext()).inflate(R.layout.fragment_china_item, null);
        mImage = (ImageView) inflat.findViewById(R.id.gg_ImageView);
        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GGactivity.class);
                startActivity(intent);

            }
        });
        china_Image_title = (TextView) inflat.findViewById(R.id.china_Image_title);
        ptr = (PullToRefreshRecyclerView) view.findViewById(R.id.gg_PulltoRef);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        ptr.setLayoutManager(manager);
        ptr.addHeaderView(inflat);
        ptr.setPullRefreshEnabled(true);


    }



    @Override
    protected void initData() {
        presenter.start();
        onRefresh();
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
        ShowPopuUtils.getInsent().popuUtilsDismiss();
        Glide.with(getContext()).load(gGliveBean.getBigImg().get(0).getImage()).into(mImage);
        china_Image_title.setText(gGliveBean.getBigImg().get(0).getTitle());
        List<GGliveBean.ListBean> gGliveBeanList = gGliveBean.getList();
        adapter = new GGAdapter(getContext(), gGliveBeanList);
        ptr.setAdapter(adapter);

    }



    public void onRefresh() {
        ptr.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                ptr.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        ptr.setRefreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {

                ptr.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                },2000);
            }
        });
    }



}
