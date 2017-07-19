package com.jiyun.pandatv.module.livechina;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.live.ViewPagerAdapter;
import com.jiyun.pandatv.module.live.views.NoScrollViewPager;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View {
    @BindView(R.id.livechin_person)
    ImageView livechinPerson;
    @BindView(R.id.livechiana_tablayout)
    TabLayout livechianaTablayout;
    @BindView(R.id.livachiana_viewpager)
    NoScrollViewPager livachianaViewpager;
    Unbinder unbinder;


    private List<BaseFragment> fragment_list;
    private ViewPagerAdapter adapter;
    private String[] titles = new String[]{"八达岭", "黄山", "凤凰古城", "峨眉山"};
    private int[] tags = new int[]{0, 1, 2, 3};

    //持有P层对象
    private LiveChinaContract.Presenter presenter;

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
            bundle.putInt("typetwo",tags[i]);
            fuyongfragment.setArguments(bundle);
            fragment_list.add(fuyongfragment);
        }
        livechianaTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        livachianaViewpager.setNoScroll(true);
        adapter = new ViewPagerAdapter(fragment_list, titles,getChildFragmentManager(),getContext());
        livachianaViewpager.setAdapter(adapter);
        livechianaTablayout.setupWithViewPager(livachianaViewpager);
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

    @OnClick(R.id.livechin_person)
    public void onViewClicked() {
    }

    @Override
    public void badaling(LiveChina_BaDaBean liveChina_baDaBean) {

    }
}
