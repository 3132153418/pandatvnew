package com.jiyun.pandatv.module.home;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.JCFullScreenActivity;
import com.jiyun.pandatv.MainActivity;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.apputils.ShowPopuUtils;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.internet.callback.MyHttpCallBack;
import com.jiyun.pandatv.jcvideoplayer_lib.PandaVedioPlayer;
import com.jiyun.pandatv.module.home.adapter.Home_Adaoter;
import com.jiyun.pandatv.module.home.adapter.Home_viewpager_Adapter;
import com.jiyun.pandatv.module.home.centre.CentreActivity;
import com.jiyun.pandatv.module.home.original.OriginalActivity;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.UpdateBean;
import com.jiyun.pandatv.moudle.entity.Video_home_TuiJianBean;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment implements HomeContract.View, View.OnClickListener, Home_Adaoter.ShouYeCallback {
    private ArrayList<FirstBean> list = new ArrayList<>();
    private Home_Adaoter home_adaoter;
    private PullToRefreshRecyclerView pullToRefreshRecyclerView;
    private ViewPager homeViewPager;
    //持有P层对象
    private HomeContract.Presenter presenter;
    private List<Object> mlist;
    private List<View> viewList = new ArrayList<>();
    private View inflate;
    private int currentNum = 100000;
    private List<ImageView> DianDians;
    private ImageView home_Original_Image, home_MyLogin_Image;
    private LinearLayout linearLayout;

    //版本更新
    private static int versionCode;
    private String versionsUrl;
    private AlertDialog alertDialog;
    int total = 0;
    private int versionsInt;

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View view) {
        ShowPopuUtils.getInsent().create(App.context);
        View viewById = view.findViewById(R.id.homefragment_common);
        home_Original_Image = (ImageView) viewById.findViewById(R.id.iv_top_hudong);
        home_MyLogin_Image = (ImageView) viewById.findViewById(R.id.iv_top_Image);


        pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.home_PullToRefreshRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        pullToRefreshRecyclerView.setLayoutManager(manager);
        pullToRefreshRecyclerView.setPullRefreshEnabled(true);

        //添加轮播图布局
        inflate = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager, null);

        homeViewPager = (ViewPager) inflate.findViewById(R.id.home_viewpager);
        //添加轮播图头布局
        pullToRefreshRecyclerView.addHeaderView(inflate);
        home_Original_Image.setOnClickListener(this);
        home_MyLogin_Image.setOnClickListener(this);
    }

    @Override
    protected void initData() {

        setListenre();
        //获取当前版本
        getAppVersionName(getActivity());
        getVersion();
        presenter.start();
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

    //发送网络请求获取最新版本号
    public void getVersion() {
        presenter.version();
    }

    @Override
    public void getVersion(UpdateBean updateBean) {
        String versionsNum = updateBean.getData().getVersionsNum();
        versionsUrl = updateBean.getData().getVersionsUrl();
        versionsInt = Integer.parseInt(versionsNum);
        if (versionCode < versionsInt) {
            L.d("当前版本", versionCode + "");
            L.d("最新版本", versionsInt + "");
            getShowDialog();
        } else {
            Toast.makeText(getActivity(), "已经是最新版本", Toast.LENGTH_LONG).show();
        }
    }

    public void getShowDialog() {
        new AlertDialog.Builder(getActivity()).setTitle("版本升级")//设置对话框标题
                .setMessage("检测到最新版本，新版本对系统做了更好的优化")//设置显示的内容
                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {//添加确定按钮

                    @Override
                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                        // TODO Auto-generated method stub
//                        try {
//                            PackageManager pm = getActivity().getPackageManager();
//                            PackageInfo pi = pm.getPackageInfo(getActivity().getPackageName(), 0);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
        pd = new ProgressDialog(getActivity());
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
//                    Toast.makeText(getActivity(), "下载新版本失败", Toast.LENGTH_LONG).show();
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
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }

    //BaseView的方法
    @Override
    public void setPresenter(HomeContract.Presenter homePresenter) {
        this.presenter = homePresenter;
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void setConmit() {

    }

    @Override
    public void setResult(FirstBean firstBean) {
        ShowPopuUtils.getInsent().popuUtilsDismiss();
        //取出javaBean里面的所有集合   添加到list里面   放入适配器
        list.add(firstBean);
        FirstBean.DataBean data = firstBean.getData();
        mlist = new ArrayList<>();
        mlist.add(data.getPandaeye());
        mlist.add(data.getPandalive());
        mlist.add(data.getArea());
        mlist.add(data.getWalllive());
        mlist.add(data.getChinalive());

        home_adaoter = new Home_Adaoter(getContext(), mlist);
        home_adaoter.setBack(this);
        pullToRefreshRecyclerView.setAdapter(home_adaoter);


        //轮播图
        List<FirstBean.DataBean.BigImgBean> bigImg = firstBean.getData().getBigImg();
        View view = null;
        ImageView imageView = null;

        linearLayout = (LinearLayout) inflate.findViewById(R.id.home_viewpager_linearlayout);
        ImageView DianDian = null;


        //通过网络请求加载轮播图图片和文字  并且同时添加点
        DianDians = new ArrayList<>();
        for (int i = 0; i < bigImg.size(); i++) {
            DianDian = new ImageView(getContext());
            DianDian.setImageResource(R.drawable.point_off);
            linearLayout.addView(DianDian);
            DianDians.add(DianDian);
            view = LayoutInflater.from(getContext()).inflate(R.layout.home_viewpager_item, null);
            imageView = (ImageView) view.findViewById(R.id.home_ViewPager_Image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    List<FirstBean.DataBean.BigImgBean> bigImg = list.get(0).getData().getBigImg();
//                    String pid = bigImg.get(0).getPid();
//                    L.d("你大爷的奶奶的个腿", pid);
//                    presenter.homevideo(pid, new MyHttpCallBack<Video_home_TuiJianBean>() {
//                        @Override
//                        public void onSuccess(Video_home_TuiJianBean video_home_tuiJianBean) {
//                            L.d("轮播监听", video_home_tuiJianBean.getTitle().toString());
//                            List<Video_home_TuiJianBean.VideoBean.Chapters4Bean> chapters4 = video_home_tuiJianBean.getVideo().getChapters4();
//                            L.e("我擦", chapters4.get(0).getDuration().toString());
//                            String gaoqing = chapters4.get(0).getUrl();
//                            L.d("高清轮播", gaoqing.toString());
//                            String liuchang = video_home_tuiJianBean.getVideo().getChapters().get(0).getUrl();
//                            String title = video_home_tuiJianBean.getTitle();
//                            JCFullScreenActivity.toActivity(getContext(), gaoqing, liuchang, null, PandaVedioPlayer.class, title);
//                        }
//
//                        @Override
//                        public void onError(int errorCode, String errorMsg) {
//
//                        }
//                    });
                }
            });
            TextView title = (TextView) view.findViewById(R.id.home_viewpager_title);
            Glide.with(getContext()).load(bigImg.get(i).getImage()).into(imageView);
            title.setText(bigImg.get(i).getTitle());
            viewList.add(view);
        }


        Home_viewpager_Adapter adapter = new Home_viewpager_Adapter(viewList);
        homeViewPager.setAdapter(adapter);
        homeViewPager.setCurrentItem(currentNum);

        //添加轮播图的点
        ImageView imageView1 = DianDians.get(currentNum % DianDians.size());
        imageView1.setImageResource(R.drawable.point_on);
        handler.sendEmptyMessageDelayed(222, 2000);

    }

    //发送hanlder启动轮播
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 222) {
                currentNum++;
                homeViewPager.setCurrentItem(currentNum);
                int i1 = currentNum % DianDians.size();
                for (int i = 0; i < DianDians.size(); i++) {

                    if (i == i1) {
                        ImageView imageView = DianDians.get(i);
                        imageView.setImageResource(R.drawable.point_on);
                    } else {
                        ImageView imageView = DianDians.get(i);
                        imageView.setImageResource(R.drawable.point_off);
                    }
                }
                handler.sendEmptyMessageDelayed(222, 2000);
            }
        }
    };

    //设置轮播监听   设置选中和未选中时的状态
    public void setListenre() {

        homeViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentNum = position;
//
                int i1 = currentNum % DianDians.size();
                for (int i = 0; i < DianDians.size(); i++) {
                    if (i == i1) {
                        ImageView imageView = DianDians.get(i);
                        imageView.setImageResource(R.drawable.point_on);
                    } else {
                        ImageView imageView = DianDians.get(i);
                        imageView.setImageResource(R.drawable.point_off);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
        onRefresh();

    }

    @Override
    public void onRefrash(int inDex, int inCount) {

    }

    @Override
    public void showMessage(String msg) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.iv_top_hudong:
                //获取跳转的第一个activity
                MainActivity activity = (MainActivity) getActivity();
                Intent intent = new Intent(activity, OriginalActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.iv_top_Image:
                MainActivity activity1 = (MainActivity) getActivity();
                Intent intent1 = new Intent(activity1, CentreActivity.class);
                activity1.startActivity(intent1);
                break;

        }
    }

    public void onRefresh() {
        pullToRefreshRecyclerView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                pullToRefreshRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        linearLayout.removeAllViews();
                        viewList.clear();
                        presenter.start();
                        pullToRefreshRecyclerView.setRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {

                pullToRefreshRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        pullToRefreshRecyclerView.setLoadMoreComplete();
                    }
                }, 0);
            }
        });
    }

    @Override
    public void jingcaituijianback(int position) {
        List<FirstBean.DataBean.AreaBean.ListscrollBean> listscroll = list.get(0).getData().getArea().getListscroll();
        final FirstBean.DataBean.AreaBean.ListscrollBean listscrollBean = listscroll.get(0);
        String pid = listscrollBean.getPid();
        L.d("推荐", pid.toString());
        presenter.homevideo(pid, new MyHttpCallBack<Video_home_TuiJianBean>() {
            @Override
            public void onSuccess(Video_home_TuiJianBean video_home_tuiJianBean) {
                L.d("首页推荐一刻的bean值", video_home_tuiJianBean.getTitle().toString());
                String image = listscrollBean.getImage();
                String time = video_home_tuiJianBean.getF_pgmtime();
                final List<Video_home_TuiJianBean.VideoBean.Chapters4Bean> chapters4 = video_home_tuiJianBean.getVideo().getChapters4();
                String gaoqing = chapters4.get(0).getUrl();
                L.d("eeeee", gaoqing.toString());
                String liuchang = video_home_tuiJianBean.getVideo().getChapters().get(0).getUrl();
                String title = video_home_tuiJianBean.getTitle();
                JCFullScreenActivity.toActivity(image,time,getContext(), gaoqing, liuchang, null, PandaVedioPlayer.class, title);

            }


            @Override
            public void onError(int errorCode, String errorMsg) {
                L.d("首页精彩一刻", errorMsg);
            }
        });

    }

    @Override
    public void xiongmaoguanchaback(int position) {
        List<FirstBean.DataBean.PandaeyeBean.ItemsBean> items = list.get(0).getData().getPandaeye().getItems();
        FirstBean.DataBean.PandaeyeBean.ItemsBean itemsBean = items.get(0);
        String pid = itemsBean.getPid();
        presenter.homevideo(pid, new MyHttpCallBack<Video_home_TuiJianBean>() {
            @Override
            public void onSuccess(Video_home_TuiJianBean video_home_tuiJianBean) {
                String time = video_home_tuiJianBean.getF_pgmtime();
                FirstBean.DataBean.PandaliveBean.ListBean listBean = list.get(0).getData().getPandalive().getList().get(0);
                String image = listBean.getImage();
                final List<Video_home_TuiJianBean.VideoBean.Chapters4Bean> chapters4 = video_home_tuiJianBean.getVideo().getChapters4();
                String gaoqing = chapters4.get(0).getUrl();
                String liuchang = video_home_tuiJianBean.getVideo().getChapters().get(0).getUrl();
                String title = video_home_tuiJianBean.getTitle();
                JCFullScreenActivity.toActivity(image,time,getContext(), gaoqing, liuchang, null, PandaVedioPlayer.class, title);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

    }

    @Override
    public void xiongmaoguanchaback2(int position) {
        List<FirstBean.DataBean.PandaeyeBean.ItemsBean> items = list.get(0).getData().getPandaeye().getItems();
        FirstBean.DataBean.PandaeyeBean.ItemsBean itemsBean = items.get(0);
        String pid = itemsBean.getPid();
        presenter.homevideo(pid, new MyHttpCallBack<Video_home_TuiJianBean>() {
            @Override
            public void onSuccess(Video_home_TuiJianBean video_home_tuiJianBean) {
                String image = list.get(0).getData().getPandalive().getList().get(0).getImage();
                String time = video_home_tuiJianBean.getF_pgmtime();
                final List<Video_home_TuiJianBean.VideoBean.Chapters4Bean> chapters4 = video_home_tuiJianBean.getVideo().getChapters4();
                String gaoqing = chapters4.get(0).getUrl();
                String liuchang = video_home_tuiJianBean.getVideo().getChapters().get(0).getUrl();
                String title = video_home_tuiJianBean.getTitle();
                JCFullScreenActivity.toActivity(image,time,getContext(), gaoqing, liuchang, null, PandaVedioPlayer.class, title);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }


}