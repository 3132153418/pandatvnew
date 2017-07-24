package com.jiyun.pandatv.module.home.centre;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.module.home.AboutActivity;
import com.jiyun.pandatv.module.home.HomeContract;
import com.jiyun.pandatv.module.home.Homepresenter;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.UpdateBean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/17.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener, HomeContract.View {

    @BindView(R.id.isPush)
    CheckBox isPush;
    @BindView(R.id.isPlay)
    CheckBox isPlay;
    @BindView(R.id.personal_delete_img)
    ImageView personalDeleteImg;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.clean)
    RelativeLayout clean;
    @BindView(R.id.panda_setting_help)
    RelativeLayout pandaSettingHelp;
    @BindView(R.id.isShengji)
    ImageView isShengji;
    @BindView(R.id.panda_setting_shengji)
    RelativeLayout pandaSettingShengji;
    @BindView(R.id.isGood)
    ImageView isGood;
    @BindView(R.id.panda_setting_haoping)
    RelativeLayout pandaSettingHaoping;
    @BindView(R.id.isAbout)
    ImageView isAbout;
    @BindView(R.id.panda_setting_about)
    RelativeLayout pandaSettingAbout;
    private ImageView settingBack;
    //版本更新
    private static int versionCode;
    private String versionsUrl;
    private AlertDialog alertDialog;
    int total = 0;
    private int versionsInt;
    //持有P层对象
    private HomeContract.Presenter presenter;
    private Context context;

    @Override
    protected int getLayoutId() {
        return R.layout.panda_person_setting;
    }

    @Override
    protected void initView() {
        context = SettingActivity.this;
        new Homepresenter(this);
        settingBack = (ImageView) findViewById(R.id.settingBack);
        settingBack.setOnClickListener(this);
        personalDeleteImg = (ImageView) findViewById(R.id.personal_delete_img);
        personalDeleteImg.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        try {
            number.setText(CleanMessageUtil.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }

        presenter.version();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settingBack:
                finish();
                break;
            case R.id.personal_delete_img:
                onClickCleanCache();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }






    @OnClick({R.id.panda_setting_help, R.id.panda_setting_shengji, R.id.panda_setting_haoping, R.id.panda_setting_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.panda_setting_help:
Intent intent = new Intent(SettingActivity.this, PersonhelpActivity.class);
startActivity(intent);
                break;
            case R.id.panda_setting_shengji:
                //获取当前版本

                getAppVersionName(SettingActivity.this);
                getShowDialog();

                break;
            case R.id.panda_setting_haoping:
                Uri uri = Uri.parse("market://details?id=cn.cntv.app.ipanda");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(goToMarket);
                } catch (Exception e) {
                    Toast.makeText(SettingActivity.this,R.string.no_find_store,
                            Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.panda_setting_about:
                Intent intent2 = new Intent(SettingActivity.this, AboutActivity.class);
                startActivity(intent2);
                break;
        }
    }

    private void onClickCleanCache() {
        getConfirmDialog(this, "是否清空缓存?", new DialogInterface.OnClickListener
                () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CleanMessageUtil.clearAllCache(App.context);
                number.setText("0 k");
            }
        }).show();
    }

    public static AlertDialog.Builder getConfirmDialog(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("确定", onClickListener);
        builder.setNegativeButton("取消", null);
        return builder;
    }

    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }



    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }


    public static String getAppVersionName(Context context) {
        String versionName = "";

        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            //versioncode = pi.versionCode;
            versionCode = pi.versionCode;
            Log.i("aaa", versionCode + "");
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.i("aaa", versionName);
        }
        return versionName;

    }


    @Override
    public void getVersion(UpdateBean updateBean) {
        String versionsNum = updateBean.getData().getVersionsNum();
        versionsUrl = updateBean.getData().getVersionsUrl();
        versionsInt = Integer.parseInt(versionsNum);
        if (versionCode < versionsInt) {
            L.d("当前版本", versionCode + "");
            L.d("最新版本", versionsInt + "");
        } else {
            Toast.makeText(SettingActivity.this, "已经是最新版本", Toast.LENGTH_LONG).show();
        }
    }

    public void getShowDialog() {
        new AlertDialog.Builder(SettingActivity.this).setTitle("版本升级")//设置对话框标题
                .setMessage("检测到最新版本，新版本对系统做了更好的优化")//设置显示的内容
                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {//添加确定按钮

                    @Override
                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                        // TODO Auto-generated method stub
//                        try {
//                            PackageManager pm = SettingActivity.this.getPackageManager();
//                            PackageInfo pi = pm.getPackageInfo(SettingActivity.this.getPackageName(), 0);
//                            pi.versionCode = versionsInt;
//                        } catch (PackageManager.NameNotFoundException e) {
//                            e.printStackTrace();
//                        }
                        dialog.dismiss();
                        showDialogUpdate();
                        dialog.dismiss();
                    }
                }).setNegativeButton("稍后再说", new DialogInterface.OnClickListener() {//添加返回按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {//响应事件
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        }).show();//在按键响应事件中显示此对话框
    }

    /**
     * 提示版本更新的对话框
     */
    private void showDialogUpdate() {
// 这里的属性可以一直设置，因为每次设置后返回的是一个builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
        // 设置提示框的标题
        builder.setTitle("版本升级").
                // 设置提示框的图标
                        setIcon(R.drawable.logo_ipnda).
                // 设置要显示的信息
                        setMessage("发现新版本！请及时更新").
                // 设置确定按钮
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "选择确定哦", 0).show();
                        dialog.dismiss();
                        loadNewVersionProgress();//下载最新的版本程序
                    }
                }).

                // 设置取消按钮,null是什么都不做，并关闭对话框
                        setNegativeButton("取消", null);

        // 生产对话框
        alertDialog = builder.create();
        // 显示对话框
        alertDialog.show();
    }

    /**
     * 下载新版本程序，需要子线程
     */
    private void loadNewVersionProgress() {
        final String uri = versionsUrl;
        final ProgressDialog pd;    //进度条对话框
        pd = new ProgressDialog(SettingActivity.this);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
        pd.show();
        //启动子线程下载任务
        new Thread() {
            @Override
            public void run() {
                try {
                    File file = getFileFromServer(uri, pd);
                    sleep(3000);
                    installApk(file);
                    pd.dismiss(); //结束掉进度条对话框
                } catch (Exception e) {
                    //下载apk失败
                    Log.i("abc", "下载失败");
//                    Toast.makeText(SettingActivity.this, "下载新版本失败", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 从服务器获取apk文件的代码
     * 传入网址uri，进度条对象即可获得一个File文件
     * （要在子线程中执行哦）
     */
    public File getFileFromServer(String uri, final ProgressDialog pd) throws Exception {
        //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //获取到文件的大小
            pd.setMax(conn.getContentLength());
            InputStream is = conn.getInputStream();
            long time = System.currentTimeMillis();//当前时间的毫秒数
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), time + "updata.apk");
            if (!file.exists())
                file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                total += len;
                //获取当前下载量
                pd.setProgress(total);
            }
            fos.close();
            bis.close();
            is.close();
            return file;
        } else {
            return null;
        }
    }

    /**
     * 安装apk
     */
    protected void installApk(File file) {
        Intent intent = new Intent();
        //执行动作
        intent.setAction(Intent.ACTION_VIEW);
        //执行的数据类型
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
    }


    @Override
    public void showProgressBar() {

    }

    @Override
    public void setConmit() {

    }

    @Override
    public void setResult(FirstBean firstBean) {

    }

    @Override
    public void onRefrash(int inDex, int inCount) {

    }

    @Override
    public void showMessage(String msg) {

    }


}
