package com.jiyun.pandatv;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiyun.pandatv.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class SplashActivity extends BaseActivity {
    ViewPager viewPager;
    private List<ImageView> list = new ArrayList<>();
    private FragmentAdapter adapter;
    private int[] imgs = {R.drawable.guide_one,R.drawable.guide_two,R.drawable.guide_three};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        addViewPager();
        adapter = new FragmentAdapter(list);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void loadData() {

    }

    public void addViewPager(){
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        for (int i = 0; i < 3; i++){
            ImageView img = new ImageView(this);
            img.setLayoutParams(params);
            img.setImageResource(imgs[i]);
            list.add(img);
            if(i == 2){
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    }
                });
            }
        }

    }

}
