package com.jiyun.pandatv.module.livechina;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.live.ViewPagerAdapter2;
import com.jiyun.pandatv.module.livechina.bdl.BDLFragment;
import com.jiyun.pandatv.module.livechina.liveadapter.DragAdapter;
import com.jiyun.pandatv.module.livechina.viewtwo.DragGridView;
import com.jiyun.pandatv.moudle.entity.LivechinaTabBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    ImageView livechinaFragmentAdd;
    ViewPager myLiveviewpager;
    TabLayout myLivetablayout;
    private ViewPagerAdapter2 myLivechinaAdapter;
    private List<String> mTabListName;
    private List<BaseFragment> mList;
    private LiveChinaContract.Presenter presenter;

    private PopupWindow popupWindow;
    private DragGridView gridView;
    private DragGridView gridView_other;
    private DragAdapter dragAdapter;
    private DragAdapter other_adapter;
    private CheckBox checkBox;
    private List<String> channels = new ArrayList<>();
    private List<String> channels_other = new ArrayList<>();
    private Map<String, String> tagUrlMap;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_open;
    }

    @Override
    protected void init(View view) {
        myLivetablayout = (TabLayout) view.findViewById(R.id.livechina_fragment_tablayout);
        myLiveviewpager = (ViewPager) view.findViewById(R.id.livechina_fragment_viewpager);
        livechinaFragmentAdd = (ImageView) view.findViewById(R.id.livechina_fragment_add);

        upWopwindowo();
    }

    private void upWopwindowo() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_popup_columns, null);

        popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setOutsideTouchable(true);
        ImageView imageView = (ImageView) view.findViewById(R.id.fanhui);
        gridView = (DragGridView) view.findViewById(R.id.gridView_channel);
        gridView_other = (DragGridView) view.findViewById(R.id.gridView_channel_other);
        checkBox = (CheckBox) view.findViewById(R.id.licechina_add_button);
        checkBox.setOnCheckedChangeListener(this);

        gridView.setNumColumns(3);
        dragAdapter = new DragAdapter(getActivity(), channels);
        gridView.setAdapter(dragAdapter);

        other_adapter = new DragAdapter(getActivity(), channels_other);
        gridView_other.setAdapter(other_adapter);
        gridView_other.setNumColumns(3);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

    private void initDataOther(List<LivechinaTabBean.AlllistBean> alllistBeanList) {
        for (LivechinaTabBean.AlllistBean alllistBean : alllistBeanList) {
            channels_other.add(alllistBean.getTitle());
        }

    }

    private void initDatatitle(List<LivechinaTabBean.TablistBean> tablistBeanList) {
        for (LivechinaTabBean.TablistBean alllistBean : tablistBeanList) {
            channels.add(alllistBean.getTitle());
        }

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


    public void add_Fragment(LivechinaTabBean popupBean) {//添加fragment
        mTabListName = new ArrayList<>();
        mList = new ArrayList<>();
        tagUrlMap = new HashMap<>();
        List<LivechinaTabBean.TablistBean> tablist = popupBean.getTablist();
        List<LivechinaTabBean.AlllistBean> alllist = popupBean.getAlllist();
        BDLFragment badaLingFragment = null;
        Bundle bundle = null;
        for (LivechinaTabBean.TablistBean tablistBean : tablist) {
            mTabListName.add(tablistBean.getTitle());
            badaLingFragment = new BDLFragment();
            bundle = new Bundle();
            bundle.putString("url", tablistBean.getUrl());
            badaLingFragment.setParams(bundle);
            tagUrlMap.put(tablistBean.getTitle(), tablistBean.getUrl());
            mList.add(badaLingFragment);
        }
        for (LivechinaTabBean.AlllistBean alllistBean : alllist) {
            tagUrlMap.put(alllistBean.getTitle(), alllistBean.getUrl());
        }
        myLivetablayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        myLivechinaAdapter = new ViewPagerAdapter2(getChildFragmentManager(), mList, mTabListName);
        myLiveviewpager.setAdapter(myLivechinaAdapter);
        myLivetablayout.setupWithViewPager(myLiveviewpager);

    }

    @Override
    public void setPresenter(LiveChinaContract.Presenter presenter) {

    }

    @Override
    public void onClick(View v) {

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
        if (isChecked) {
            checkBox.setText("完成");
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (isChecked && channels != null && channels.size() > 4) {
                        String channel = channels.get(position);
                        channels.remove(position);
                        channels_other.add(channel);
                        dragAdapter.notifyDataSetChanged();
                        other_adapter.notifyDataSetChanged();

                    } else {
                        Toast.makeText(getContext(), "总数不能小于4", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            gridView_other.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (isChecked) {
                        String channel = channels_other.get(position);
                        channels_other.remove(position);
                        channels.add(channel);
                        dragAdapter.notifyDataSetChanged();
                        other_adapter.notifyDataSetChanged();
                    }

                }
            });
        } else {
            setRefresh();
            checkBox.setText("编辑");
        }
    }

    public void setRefresh() {
        mTabListName = new ArrayList<>();
        mList = new ArrayList<>();
        BDLFragment badaLingFragment = null;
        Bundle bundle = null;
        for (String title : channels) {
            String url = tagUrlMap.get(title);
            mTabListName.add(title);
            badaLingFragment = new BDLFragment();
            bundle = new Bundle();
            bundle.putString("url", url);
            badaLingFragment.setParams(bundle);
            mList.add(badaLingFragment);
        }
        myLivechinaAdapter = new ViewPagerAdapter2(getChildFragmentManager(), mList, mTabListName);
        myLiveviewpager.setAdapter(myLivechinaAdapter);
        myLivetablayout.setupWithViewPager(myLiveviewpager);
    }

    public void setSave() {
        LivechinaTabBean.TablistBean tablistBean;
        List<LivechinaTabBean.TablistBean> tablistBeanList = new ArrayList<>();
        List<LivechinaTabBean.AlllistBean> alllistBeanList = new ArrayList<>();
        LivechinaTabBean.AlllistBean alllistBean;

        LivechinaTabBean livechinaTabbean = new LivechinaTabBean();
        for (String title : channels) {
            tablistBean = new LivechinaTabBean.TablistBean();
            tablistBean.setTitle(title);
            tablistBean.setUrl(tagUrlMap.get(title));
            tablistBeanList.add(tablistBean);
        }
        for (String title : channels_other) {
            alllistBean = new LivechinaTabBean.AlllistBean();
            alllistBean.setUrl(tagUrlMap.get(title));
            alllistBean.setTitle(title);
            alllistBeanList.add(alllistBean);
        }
        livechinaTabbean.setAlllist(alllistBeanList);
        livechinaTabbean.setTablist(tablistBeanList);


    }


}


