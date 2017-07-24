package com.jiyun.pandatv.module.home.centre;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.live.ViewPagerAdapter2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/22.
 */
public class PersonhelpActivity extends BaseActivity {


    @BindView(R.id.help_back)
    ImageView helpBack;
    @BindView(R.id.help_tab)
    TabLayout helpTab;
    @BindView(R.id.help_viewpager)
    ViewPager helpViewpager;
    private List<BaseFragment> fragment_list;
    private List<String> title_list;
    private ViewPagerAdapter2 adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.person_help;
    }

    @Override
    protected void initView() {
        fragment_list = new ArrayList<>();
        title_list = new ArrayList<>();
        fragment_list.add(new YuDaoPloblem());
        fragment_list.add(new ChangJianPloblem());
        title_list.add("遇到的问题");
        title_list.add("常见问题");

        helpTab.addTab(helpTab.newTab().setText(title_list.get(0)));
        helpTab.addTab(helpTab.newTab().setText(title_list.get(1)));
        adapter = new ViewPagerAdapter2(getSupportFragmentManager(), fragment_list, title_list);
        helpViewpager.setAdapter(adapter);
        helpTab.setupWithViewPager(helpViewpager);
    }

    @Override
    protected void loadData() {

    }

    @OnClick(R.id.help_back)
    public void onViewClicked() {
        finish();
    }


}
