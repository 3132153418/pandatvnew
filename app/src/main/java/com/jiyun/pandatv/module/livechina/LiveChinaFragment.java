package com.jiyun.pandatv.module.livechina;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
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
import com.jiyun.pandatv.module.livechina.adapter.PandaDirectAdapter;
import com.jiyun.pandatv.module.livechina.fragment.LiveFragment;
import com.jiyun.pandatv.moudle.entity.PopupBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View, View.OnClickListener {

    private List<String> mListName;
    private List<BaseFragment> mList;
    private List<String> mListNameUrl;
    private Map<String, String> mMapAllUrl;
    private ViewPager liveChenaViewPager;
    private ImageButton liveChenaIBtn;
    private TabLayout liveChenaTabLayout;
    private ImageView personal_Cente;
    private PandaDirectAdapter adapter;
    private LiveChinapresenter presenter;
    private ImageButton live_chena_IBtn;
  /*  private DragGridView gridView;
    private DragGridView gridView_other;
    private DragAdapter dragAdapter;
    private DragAdapter other_adapter;
    private CheckBox button;
    private ACache aCache;
    private PopupWindow popupWindow;
    private ArrayList<BaseFragment> fragmentList = new ArrayList<BaseFragment>(); //碎片链表
    private ArrayList<String> channels = new ArrayList<>();
    private ArrayList<String> channels_other = new ArrayList<>();
    private ZHPagerAdapter title_adapter;*/


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
        live_chena_IBtn = (ImageButton) view.findViewById(R.id.live_chena_IBtn);
        live_chena_IBtn.setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.personal_Cente:
                Intent intent = new Intent(getActivity(), CentreActivity.class);
                startActivity(intent);
                break;
            case R.id.live_chena_IBtn:

                break;
        }
    }


 /*   public void upPopupWindow(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.activity_popup_columns, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);
    }

    public void popupView(View v) {
        ImageView imageView = (ImageView) v.findViewById(R.id.Fanhui);
        gridView = (DragGridView) v.findViewById(R.id.gridView_channel);
        gridView_other = (DragGridView) v.findViewById(R.id.gridView_channel_other);
        button = (CheckBox) v.findViewById(R.id.licechina_add_button);
        gridView.setNumColumns(3);
        dragAdapter = new DragAdapter(App.activity, channels);
        gridView.setAdapter(dragAdapter);

        other_adapter = new DragAdapter(App.activity, channels_other);
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
                            if(channels.size()>4) {
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
*/
}


