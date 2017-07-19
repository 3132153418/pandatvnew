package com.jiyun.pandatv.module.livechina;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.live.ViewPagerAdapter;
import com.jiyun.pandatv.module.live.views.NoScrollViewPager;
import com.jiyun.pandatv.module.livechina.viewtwo.MyGridView;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View {


    @BindView(R.id.zh_tab)
    TabLayout zhTab;
    @BindView(R.id.zh_delete)
    Button zhDelete;
    @BindView(R.id.zh_lanmu)
    LinearLayout zhLanmu;
    @BindView(R.id.iv_ic_add)
    ImageView ivIcAdd;
    @BindView(R.id.zh_viewpager)
    NoScrollViewPager zhViewpager;
    Unbinder unbinder;
    private boolean mFlag = true;


    private List<BaseFragment> fragment_list;
    private ViewPagerAdapter adapter;
    private String[] titles = new String[]{"八达岭", "黄山", "凤凰古城", "峨眉山"};
    private int[] tags = new int[]{0, 1, 2, 3};
    private MyGridView myGridView1;
    private MyGridView myGridView2;
    //持有P层对象
    private LiveChinaContract.Presenter presenter;
    private LinearLayout my_grid_ll;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_livechina;
    }

    @Override
    protected void init(View view) {
    }

    @Override
    protected void initData() {
        fragment_list = new ArrayList<>();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("typetwo", FuYongFragment.BADALING);
        new FuYongFragment().setArguments(bundle1);
        for (int i = 0; i < titles.length; i++) {
            FuYongFragment fuyongfragment = new FuYongFragment();
            new LiveChinapresenter(fuyongfragment);

            Bundle bundle = new Bundle();
            bundle.putInt("typetwo", tags[i]);
            fuyongfragment.setArguments(bundle);
            fragment_list.add(fuyongfragment);
        }
        zhTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        zhViewpager.setOffscreenPageLimit(3);
        zhViewpager.setNoScroll(true);
        adapter = new ViewPagerAdapter(fragment_list, titles, getChildFragmentManager(), getContext());
        zhViewpager.setAdapter(adapter);
        zhTab.setupWithViewPager(zhViewpager);
    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    //BaseView的方法
    @Override
    public void setPresenter(LiveChinaContract.Presenter homePresenter) {
        this.presenter = homePresenter;
    }


    @Override
    public void badaling(LiveChina_BaDaBean liveChina_baDaBean) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}


