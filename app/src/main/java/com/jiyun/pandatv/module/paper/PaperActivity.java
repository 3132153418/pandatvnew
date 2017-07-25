package com.jiyun.pandatv.module.paper;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.pandatv.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/21.
 */
public class PaperActivity extends AppCompatActivity {
    @BindView(R.id.paper_web_back)
    ImageView paperWebBack;
    private WebView paperWeb;
    private ProgressDialog dialog;
    private ImageView webview_collect_paper;
    private boolean isCollect = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paper_webview);
        ButterKnife.bind(this);
        webview_collect_paper = (ImageView) findViewById(R.id.webview_collect_paper);
        webview_collect_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollect) {
                    webview_collect_paper.setBackgroundResource(R.drawable.collect_no);
                    isCollect = false;
                    Toast toast = Toast.makeText(PaperActivity.this, "恭喜您收藏成功啦", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    View inflate = View.inflate(PaperActivity.this, com.jiyun.pandatv.jcvideoplayer_lib.R.layout.item_toast, null);
                    ((TextView) inflate.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.tv_toast)).setText("已取消收藏");
                    toast.setView(inflate);
                    toast.show();
                }else {
                    webview_collect_paper.setBackgroundResource(R.drawable.collect_yes);
                    isCollect = true;
                    Toast toast = Toast.makeText(PaperActivity.this, "恭喜您收藏成功啦", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    View inflate = View.inflate(PaperActivity.this, com.jiyun.pandatv.jcvideoplayer_lib.R.layout.item_toast, null);
                    ((TextView) inflate.findViewById(com.jiyun.pandatv.jcvideoplayer_lib.R.id.tv_toast)).setText("已添加，请到[我的收藏]中查看");
                    toast.setView(inflate);
                    toast.show();
                }

            }
        });
        paperWeb = (WebView) findViewById(R.id.paper_web);
        String url = getIntent().getStringExtra("url");

        paperWeb.loadUrl(url);
        WebSettings settings = paperWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
//        webview.addJavascriptInterface(this, "test");
        paperWeb.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            //开始加载时
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                dialog = new ProgressDialog(PaperActivity.this);
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


    @OnClick(R.id.paper_web_back)
    public void onViewClicked() {
finish();
    }
}
