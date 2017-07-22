package com.jiyun.pandatv.module.home.centre.fragment;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseFragment;

/**
 * Created by Administrator on 2017/7/18.
 */

public class EmileFragment extends BaseFragment implements EmileContract.View, View.OnClickListener {
    private ImageView register_youxiang_receivebut;
    private Button register_youxiang_button;
    private EmilePresenter presenter;
    private EditText register_youxiang_zhanghao, register_youxiang_pass, register_youxiang_querenpass, register_youxiang_yanzhengma;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_emile;
    }

    @Override
    protected void init(View view) {
        new EmilePresenter(this);
        register_youxiang_receivebut = (ImageView) view.findViewById(R.id.register_youxiang_receivebut);

        register_youxiang_receivebut.setOnClickListener(this);
        register_youxiang_button = (Button) view.findViewById(R.id.register_youxiang_button);
        register_youxiang_button.setOnClickListener(this);
        register_youxiang_zhanghao = (EditText) view.findViewById(R.id.register_youxiang_zhanghao);
        register_youxiang_pass = (EditText) view.findViewById(R.id.register_youxiang_pass);
        register_youxiang_querenpass = (EditText) view.findViewById(R.id.register_youxiang_querenpass);
        register_youxiang_yanzhengma = (EditText) view.findViewById(R.id.register_youxiang_yanzhengma);

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

    @Override
    public void setYanZheng(Drawable drawable) {
        register_youxiang_receivebut.setImageDrawable(drawable);

    }

    @Override
    public void setLog(String string) {

    }

    @Override
    public void setPresenter(EmileContract.Presenter presenter) {

        this.presenter = (EmilePresenter) presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_youxiang_receivebut:
                presenter.start();
                break;
            case R.id.register_youxiang_button:
                presenter.getRegis(register_youxiang_zhanghao.getText().toString()
                        , register_youxiang_pass.getText().toString()
                        , register_youxiang_yanzhengma.getText().toString());
                getActivity().finish();
                break;
        }
    }
}
