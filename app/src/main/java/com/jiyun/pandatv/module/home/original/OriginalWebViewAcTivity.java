package com.jiyun.pandatv.module.home.original;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.jiyun.pandatv.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/21.
 */
public class OriginalWebViewAcTivity extends AppCompatActivity {
    @BindView(R.id.original_web_back)
    ImageView originalWebBack;
    @BindView(R.id.original_web)
    WebView originalWeb;
    @BindView(R.id.original_shoucang)
    ImageView originalShoucang;
    @BindView(R.id.original_share)
    ImageView originalShare;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.original_webview);
        ButterKnife.bind(this);
        String url = getIntent().getStringExtra("url");
        originalWeb.loadUrl(url);
        WebSettings settings = originalWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
//        webview.addJavascriptInterface(this, "test");
        originalWeb.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //开始加载时
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                dialog = new ProgressDialog(OriginalWebViewAcTivity.this);
                dialog.setMessage("请稍等......");
                dialog.show();
            }

            //加载结束时
            @Override
            public void onPageFinished(WebView view, String url) {
                dialog.cancel();
                super.onPageFinished(view, url);
            }
        });
    }

    @OnClick({R.id.original_web_back, R.id.original_shoucang, R.id.original_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.original_web_back:
                finish();
                break;
            case R.id.original_shoucang:
                break;
            case R.id.original_share:
                break;
        }
    }
}
