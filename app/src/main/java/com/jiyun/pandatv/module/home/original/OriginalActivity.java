package com.jiyun.pandatv.module.home.original;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.moudle.entity.OriginalBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */

public class OriginalActivity extends BaseActivity implements OriginalContract.View ,View.OnClickListener{
    private List<OriginalBean.InteractiveBean> list = new ArrayList<>();
    private ListView listView;
    private Original_Adapter adapter;
    private OriginalContract.Presenter presenter;
    private ImageView original_Back_Image;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_original;
    }

    @Override
    protected void initView() {
        new OriginalPresenter(this);
        listView = (ListView) findViewById(R.id.activity_original_ListView);
        presenter.start();
        original_Back_Image = (ImageView) findViewById(R.id.original_Back_Imagetwo);
        original_Back_Image.setOnClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(OriginalActivity.this, OriginalWebViewAcTivity.class);
                intent.putExtra("url",list.get(0).getUrl());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setPresenter(OriginalContract.Presenter presenter) {

        this.presenter = presenter;

    }

    @Override
    public void setResoust(OriginalBean originalBean) {

        List<OriginalBean.InteractiveBean> interactive = originalBean.getInteractive();

        list.addAll(interactive);

        adapter = new Original_Adapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.original_Back_Image:
                finish();
                break;
        }
    }
}
