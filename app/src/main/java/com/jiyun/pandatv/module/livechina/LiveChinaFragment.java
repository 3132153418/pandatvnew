package com.jiyun.pandatv.module.livechina;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;


import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.ACache;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.home.centre.CentreActivity;
import com.jiyun.pandatv.module.livechina.adapter.PandaDirectAdapter;
import com.jiyun.pandatv.module.livechina.fragment.LiveFragment;
import com.jiyun.pandatv.moudle.entity.PopupBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View,View.OnClickListener{

    private List<String> mListName;
    private List<BaseFragment> mList;
    private List<String> mListNameUrl;
    private Map<String,String> mMapAllUrl;
    private ViewPager liveChenaViewPager;
    private ImageButton liveChenaIBtn;
    private TabLayout liveChenaTabLayout;
    private ImageView personal_Cente;
    private PandaDirectAdapter adapter;
    private LiveChinapresenter presenter;

    @Override
    protected int getFragmentLayoutId() {

        return R.layout.livechina_fragment;
    }

    @Override
    protected void init(View view) {
        new LiveChinapresenter(this);

        liveChenaViewPager = (ViewPager) view.findViewById(R.id.live_chena_viewPager);
        liveChenaIBtn = (ImageButton) view.findViewById(R.id.live_chena_IBtn);
        liveChenaTabLayout = (TabLayout) view.findViewById(R.id.live_chena_TabLayout);
        personal_Cente = (ImageView) view.findViewById(R.id.personal_Cente);
        personal_Cente.setOnClickListener(this);
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

    public void add_Fragment(PopupBean popupBean) {
        mListName = new ArrayList<>();
        mList = new ArrayList<>();
        mListNameUrl = new ArrayList<>();
        mMapAllUrl = new HashMap<>();
        List<PopupBean.TablistBean> tablist = popupBean.getTablist();
        List<PopupBean.AlllistBean> alllist = popupBean.getAlllist();
        LiveFragment badaLingFragment = null;
        Bundle bundle = null;
        for (PopupBean.TablistBean tablistBean : tablist) {
            mListName.add(tablistBean.getTitle());
            badaLingFragment = new LiveFragment();
            bundle = new Bundle();
            bundle.putString("url", tablistBean.getUrl());
            badaLingFragment.setParams(bundle);
            mList.add(badaLingFragment);
            mListNameUrl.add(tablistBean.getUrl());
            mMapAllUrl.put(tablistBean.getTitle(), tablistBean.getUrl());
        }
        for (PopupBean.AlllistBean alllistBean : alllist) {
            mMapAllUrl.put(alllistBean.getTitle(), alllistBean.getUrl());
        }

        adapter = new PandaDirectAdapter(getChildFragmentManager(), mListName, mList);
        liveChenaViewPager.setAdapter(adapter);
        liveChenaTabLayout.setupWithViewPager(liveChenaViewPager);
    }


    @Override
    public void setPresenter(LiveChinaContract.Presenter presenter) {

        this.presenter = (LiveChinapresenter) presenter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void getChinaLiveTab(PopupBean popupBean) {

        add_Fragment(popupBean);
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.personal_Cente:
                Intent intent = new Intent(getActivity(), CentreActivity.class);
                startActivity(intent);
                break;
        }
    }
}


