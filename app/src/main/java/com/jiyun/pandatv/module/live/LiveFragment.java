package com.jiyun.pandatv.module.live;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.module.home.centre.CentreActivity;
import com.jiyun.pandatv.module.live.views.NoScrollViewPager;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LiveFragment extends BaseFragment implements LiveContract.View {


    @BindView(R.id.iv_top_logo)
    ImageView ivTopLogo;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.iv_top_hudong)
    ImageView ivTopHudong;
    @BindView(R.id.iv_top_Image)
    ImageView ivTopImage;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    NoScrollViewPager viewpager;
    Unbinder unbinder;
    private List<BaseFragment> fragment_list;
    private ViewPagerAdapter adapter;
    //持有P层对象
    private LiveContract.Presenter presenter;
    private String[] titles = new String[]{"直播", "精彩一刻", "当熊不让", "超萌滚滚秀", "熊猫档案", "熊猫TOP榜", "熊猫那些事儿", "特别节目", "原创新闻"};
    private int[] tags = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void init(View view) {
        View viewById = view.findViewById(R.id.livefragment_common);
        viewById.findViewById(R.id.iv_top_logo).setVisibility(View.INVISIBLE);
        ((TextView) viewById.findViewById(R.id.tv_top_title)).setText("熊猫直播");
        viewById.findViewById(R.id.iv_top_hudong).setVisibility(View.INVISIBLE);
        viewById.findViewById(R.id.iv_top_Image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CentreActivity.class);
                startActivity(intent);
            }
        });

        presenter.start();
    }

    @Override
    protected void initData() {
        fragment_list = new ArrayList<>();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("type", MyFragment.live);
        new MyFragment().setArguments(bundle1);
        for (int i = 0; i < titles.length; i++) {
            MyFragment fragment = new MyFragment();
            new Livepresenter(fragment);//把P层对象和View层对象关联起来
            Bundle bundle = new Bundle();
            bundle.putInt("type", tags[i]);
            fragment.setArguments(bundle);
            fragment_list.add(fragment);
        }

        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewpager.setNoScroll(true);
        adapter = new ViewPagerAdapter(fragment_list, titles, getChildFragmentManager(), getContext());
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    //BaseView的方法
    @Override
    public void setPresenter(LiveContract.Presenter livePresenter) {
        this.presenter = livePresenter;
    }


    @Override
    public void showLiveFragment(Live_MoreViewBean pandaLiveDuoshijiaoBean) {

    }

    @Override
    public void jianjie(Live_JianJieBean live_jianJieBean) {

    }

    @Override
    public void biankanbianliao(Live_BianKanBianLiaoBean live_bianKanBianLiaoBean) {

    }


    @Override
    public void jiangcai(Live_JiangCaiBean paperJingCaiBean) {

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
