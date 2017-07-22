package com.jiyun.pandatv.module.home.centre;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.jiyun.pandatv.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/22.
 */
public class PersonhelpActivity extends Activity {
    @BindView(R.id.help_back)
    ImageView helpBack;
    @BindView(R.id.feedback_rb_left)
    RadioButton feedbackRbLeft;
    @BindView(R.id.feedback_rb_right)
    RadioButton feedbackRbRight;
    @BindView(R.id.feedback_content_viewpager)
    ViewPager feedbackContentViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_help);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.help_back)
    public void onViewClicked() {
        finish();
    }
}
