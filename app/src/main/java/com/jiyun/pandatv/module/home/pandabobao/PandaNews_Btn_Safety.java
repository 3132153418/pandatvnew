package com.jiyun.pandatv.module.home.pandabobao;

import android.content.Intent;
import android.webkit.WebView;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

/**
 * Created by Administrator on 2017/7/15.
 */

public class PandaNews_Btn_Safety extends BaseActivity {
    private WebView webView;
    @Override
    protected int getLayoutId() {
        return R.layout.pandanews_btn_safety;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.panda_News_WebView);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.loadUrl(url);

    }

    @Override
    protected void loadData() {

    }
}
