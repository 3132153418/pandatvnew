package com.jiyun.pandatv.module.home.centre;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.module.home.centre.fragment.EmileFragment;
import com.jiyun.pandatv.module.home.centre.fragment.PhoneFragment;

/**
 * Created by Administrator on 2017/7/18.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private Button phone, emile;
    private PhoneFragment phoneFragment = null;
    private EmileFragment emileFragment = null;
    private FrameLayout  frameLayout;
    private ImageView registerBack;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        App.context = this;
        phoneFragment = new PhoneFragment();
        frameLayout = (FrameLayout) findViewById(R.id.register_FrameLayout);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.register_FrameLayout, phoneFragment, "PhoneFragment")
                .show(phoneFragment)
                .commit();

        phone = (Button) findViewById(R.id.phone_Button);
        phone.setOnClickListener(this);
        emile = (Button) findViewById(R.id.emile_Button);
        emile.setOnClickListener(this);
        registerBack = (ImageView) findViewById(R.id.registerBack);
        registerBack.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment();//首先隐藏所有fragment
        switch (v.getId()) {
            case R.id.phone_Button:

                if (phoneFragment == null) {
                    phoneFragment = new PhoneFragment();

                }
                fragmentTransaction.show(phoneFragment);

                break;
            case R.id.emile_Button:
                if (emileFragment == null) {
                    emileFragment = new EmileFragment();
                    fragmentTransaction.add(R.id.register_FrameLayout, emileFragment, "LiveFragment");
                }
                fragmentTransaction.show(emileFragment);
                break;
            case R.id.registerBack:
                finish();
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideAllFragment() {

        if (phoneFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(phoneFragment).commit();
        }
        if (emileFragment != null) {
            getSupportFragmentManager().beginTransaction().hide(emileFragment).commit();
        }
    }
}
