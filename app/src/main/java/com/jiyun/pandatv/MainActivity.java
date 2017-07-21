package com.jiyun.pandatv;


import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.module.china.ChinaFragment;
import com.jiyun.pandatv.module.china.Chinapresenter;
import com.jiyun.pandatv.module.home.HomeFragment;
import com.jiyun.pandatv.module.home.Homepresenter;
import com.jiyun.pandatv.module.live.LiveFragment;
import com.jiyun.pandatv.module.live.Livepresenter;
import com.jiyun.pandatv.module.livechina.LiveChinaFragment;
import com.jiyun.pandatv.module.livechina.LiveChinapresenter;
import com.jiyun.pandatv.module.paper.PaperFragment;
import com.jiyun.pandatv.module.paper.Paperpresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.rb_home)
    RadioButton rbHome;
    @BindView(R.id.rb_live)
    RadioButton rbLive;
    @BindView(R.id.rb_china)
    RadioButton rbChina;
    @BindView(R.id.rb_paper)
    RadioButton rbPaper;
    @BindView(R.id.rb_live_china)
    RadioButton rbLiveChina;
    @BindView(R.id.rg_group)
    RadioGroup rgGroup;

    private HomeFragment homeFragment = null;
    private LiveFragment liveFragment = null;
    private ChinaFragment chinaFragment = null;
    private PaperFragment paperFragment = null;
    private LiveChinaFragment liveChinaFragment = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        App.context = this;
        homeFragment = new HomeFragment();
        new Homepresenter(homeFragment);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.framelayout, homeFragment, "HomeFragment")
                .show(homeFragment)
                .commit();
    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.rb_home, R.id.rb_live, R.id.rb_china, R.id.rb_paper, R.id.rb_live_china})
    public void onViewClicked(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment();//首先隐藏所有fragment
        L.d("MainActivity", "全部fragment隐藏");
        switch (view.getId()) {
            case R.id.rb_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    new Homepresenter(homeFragment);
                }
                fragmentTransaction.show(homeFragment);
                break;
            case R.id.rb_live:
                if (liveFragment == null) {
                    liveFragment = new LiveFragment();
                    new Livepresenter(liveFragment);
                    fragmentTransaction.add(R.id.framelayout, liveFragment, "LiveFragment");
                }
                fragmentTransaction.show(liveFragment);
                break;
            case R.id.rb_china:
                L.d("MainActivity", "点击了第三个");
                if (chinaFragment == null) {
                    chinaFragment = new ChinaFragment();
                    new Chinapresenter(chinaFragment);
                    fragmentTransaction.add(R.id.framelayout, chinaFragment, "ChinaFragment");
                }
                fragmentTransaction.show(chinaFragment);
                break;
            case R.id.rb_paper:
                if (paperFragment == null) {
                    paperFragment = new PaperFragment();
                    new Paperpresenter(paperFragment);
                    fragmentTransaction.add(R.id.framelayout, paperFragment, "PaperFragment");
                }
                fragmentTransaction.show(paperFragment);
                break;
            case R.id.rb_live_china:
                if (liveChinaFragment == null) {
                    liveChinaFragment = new LiveChinaFragment();
                    new LiveChinapresenter(liveChinaFragment);
                    fragmentTransaction.add(R.id.framelayout, liveChinaFragment, "LiveChinaFragment");
                }
                fragmentTransaction.show(liveChinaFragment);
                break;
        }
        fragmentTransaction.commit();

    }

    private void hideAllFragment() {

        if (homeFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
        }
        if (liveFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(liveFragment).commit();
        }
        if (chinaFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(chinaFragment).commit();
        }
        if (paperFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(paperFragment).commit();
        }
        if (liveChinaFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(liveChinaFragment).commit();
        }
    }
}
