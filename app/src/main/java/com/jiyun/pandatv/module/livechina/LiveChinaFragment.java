package com.jiyun.pandatv.module.livechina;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.ACache;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.home.centre.CentreActivity;
import com.jiyun.pandatv.module.livechina.adapter.DragAdapter;
import com.jiyun.pandatv.module.livechina.adapter.PandaDirectAdapter;
import com.jiyun.pandatv.module.livechina.adapter.ZHPagerAdapter;
import com.jiyun.pandatv.module.livechina.fragment.LiveFragment;
import com.jiyun.pandatv.moudle.entity.PopupBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View, View.OnClickListener {

    private List<String> mListName;
    private List<BaseFragment> mList;
    private List<String> mListNameUrl;
    private Map<String, String> mMapAllUrl;
    private ViewPager liveChenaViewPager;
    private TabLayout liveChenaTabLayout;
    private ImageView personal_Cente,imageView;
    private PandaDirectAdapter adapter;
    private LiveChinapresenter presenter;
    private ImageButton live_chena_IBtn;
    private DragGridView gridView;
    private DragGridView gridView_other;
    private DragAdapter dragAdapter;
    private DragAdapter other_adapter;
    private CheckBox button;
    private ACache aCache;
    private PopupWindow popupWindow;
    private ArrayList<BaseFragment> fragmentList = new ArrayList<BaseFragment>(); //碎片链表
    private ArrayList<String> channels = new ArrayList<>();
    private ArrayList<String> channels_other = new ArrayList<>();
    private ZHPagerAdapter title_adapter;


    @Override
    protected int getFragmentLayoutId() {

        return R.layout.livechina_fragment;
    }

    @Override
    protected void init(View view) {
        new LiveChinapresenter(this);

        liveChenaViewPager = (ViewPager) view.findViewById(R.id.live_chena_viewPager);
        liveChenaTabLayout = (TabLayout) view.findViewById(R.id.live_chena_TabLayout);
        personal_Cente = (ImageView) view.findViewById(R.id.personal_Cente);
        personal_Cente.setOnClickListener(this);
        live_chena_IBtn = (ImageButton) view.findViewById(R.id.live_chena_IBtn);
        live_chena_IBtn.setOnClickListener(this);
        title_adapter = new ZHPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, channels);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        }

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

    private void initDataOther(List<PopupBean.AlllistBean> alllistBeanList) {
        for (PopupBean.AlllistBean alllistBean : alllistBeanList) {
            channels_other.add(alllistBean.getTitle());
        }

    }

    private void initDatatitle(List<PopupBean.TablistBean> tablistBeanList) {
        for (PopupBean.TablistBean alllistBean : tablistBeanList) {
            channels.add(alllistBean.getTitle());
        }

    }


    @Override
    public void getChinaLiveTab(PopupBean popupBean) {


        add_Fragment(popupBean);
        List<PopupBean.TablistBean> tablist = popupBean.getTablist();
        initDatatitle(tablist);

        List<PopupBean.AlllistBean> alllist = popupBean.getAlllist();
        initDataOther(alllist);
    }

    @Override
    public void showMessage(String msg) {

        ACache aCache = ACache.get(getContext());
        PopupBean asObject = (PopupBean) aCache.getAsObject("PopupBean");


        add_Fragment(asObject);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personal_Cente:
                Intent intent = new Intent(getActivity(), CentreActivity.class);
                startActivity(intent);
                break;
            case R.id.live_chena_IBtn:

                View view = LayoutInflater.from(getActivity()).inflate(R.layout.livechina_fragment, null);
                upPopupWindow(view);
                break;
            case R.id.Fanhui:
                popupWindow.dismiss();
                break;
        }
    }

  public void upPopupWindow(View view) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.activity_popup_columns, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);
    }

    public void popupView(View v) {
        imageView  = (ImageView) v.findViewById(R.id.Fanhui);
        imageView.setOnClickListener(this);
        gridView = (DragGridView) v.findViewById(R.id.gridView_channel);
        gridView_other = (DragGridView) v.findViewById(R.id.gridView_channel_other);
        button = (CheckBox) v.findViewById(R.id.licechina_add_button);
        gridView.setNumColumns(3);
        dragAdapter = new DragAdapter(getActivity(), channels);
        gridView.setAdapter(dragAdapter);

        other_adapter = new DragAdapter(getActivity(), channels_other);
        gridView_other.setAdapter(other_adapter);
        gridView_other.setNumColumns(3);

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    button.setText("完成");
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String channel = channels.get(position);
                            if (channels.size() > 4) {
                                channels.remove(position);
                                channels_other.add(channel);
                                dragAdapter.notifyDataSetChanged();
                                other_adapter.notifyDataSetChanged();
                            }

                        }
                    });
                    gridView_other.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String channel = channels_other.get(position);
                            channels_other.remove(position);
                            channels.add(channel);
                            dragAdapter.notifyDataSetChanged();
                            other_adapter.notifyDataSetChanged();
                        }
                    });
                } else {
                    button.setText("编辑");
                    setRefresh();


                }
            }
        });

    }

        public void setRefresh() {
            mListName.clear();
            mList.clear();
            mListName.addAll(channels) ;
            Set<String> strings = mMapAllUrl.keySet();

            LiveFragment badaLingFragment = null;
            Bundle bundle = null;
            String url=null;
            for (String nameTab : mListName) {
                url = mMapAllUrl.get(nameTab);
                badaLingFragment = new LiveFragment();
                bundle = new Bundle();
                bundle.putString("url", url);
                badaLingFragment.setParams(bundle);
                mList.add(badaLingFragment);
            }
            adapter = new PandaDirectAdapter(getChildFragmentManager(), mListName, mList);
            liveChenaViewPager.setAdapter(adapter);
            liveChenaTabLayout.setupWithViewPager(liveChenaViewPager);

        }

    }


