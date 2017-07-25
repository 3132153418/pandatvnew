package com.jiyun.pandatv.module.china;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.pandatv.R;
import com.jiyun.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/24.
 */
public class GGactivity extends BaseActivity {
    @BindView(R.id.gg_web_back)
    ImageView ggWebBack;
    @BindView(R.id.gg_web)
    WebView ggWeb;
    private ImageView webview_collect_gg;
    private boolean isCollect = false;
    @Override
    protected int getLayoutId() {
        return R.layout.gg_webview;
    }

    @Override
    protected void initView() {
        webview_collect_gg = (ImageView) findViewById(R.id.webview_collect_gg);
        webview_collect_gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollect) {
                    webview_collect_gg.setBackgroundResource(R.drawable.collect_no);
                    isCollect = false;
                    Toast toast = Toast.makeText(GGactivity.this, "恭喜您收藏成功啦", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    View inflate = View.inflate(GGactivity.this, com.jiyun.pandatv.jcvideoplayer_lib.R.layout.item_toast, null);
                    ((TextView) inflate.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.tv_toast)).setText("已取消收藏");
                    toast.setView(inflate);
                    toast.show();
                }else {
                    webview_collect_gg.setBackgroundResource(R.drawable.collect_yes);
                    isCollect = true;
                    Toast toast = Toast.makeText(GGactivity.this, "恭喜您收藏成功啦", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    View inflate = View.inflate(GGactivity.this, com.jiyun.pandatv.jcvideoplayer_lib.R.layout.item_toast, null);
                    ((TextView) inflate.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.tv_toast)).setText("已添加，请到[我的收藏]中查看");
                    toast.setView(inflate);
                    toast.show();
                }

            }
        });
    }

    @Override
    protected void loadData() {
        String url = getIntent().getStringExtra("url");
        ggWeb.loadUrl(url);
        WebSettings settings = ggWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
//        webview.addJavascriptInterface(this, "test");
        ggWeb.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }




        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.gg_web_back)
    public void onViewClicked() {
        finish();
    }
}
