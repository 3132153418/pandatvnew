package com.jiyun.pandatv.module.home.centre.shoucang;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jiyun.com.day07_greendao.DaoMaster;
import com.jiyun.com.day07_greendao.DaoSession;
import com.jiyun.com.day07_greendao.VideoCollectBean;
import com.jiyun.com.day07_greendao.VideoCollectBeanDao;
import com.jiyun.pandatv.JCFullScreenActivity;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.base.BaseFragment;
import com.jiyun.pandatv.jcvideoplayer_lib.PandaVedioPlayer;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;



public class Highlights_Tab_Fragment extends BaseFragment {

    @BindView(R.id.highlight_listview)
    ListView highlightListview;
    public  static TextView textView;
    @BindView(R.id.quanxuan)
    TextView quanxuan;
    @BindView(R.id.shanchu)
     TextView shanchu;
    @BindView(R.id.dilog)
    LinearLayout dilog;

    private int number = 0;
    public Highlights_Tab_Fragment(TextView textView) {
        this.textView = textView;
    }

    private ArrayList<VideoCollectBean> arr1;
    public static HigHlightListviewAdapter adapter;



    public void quer() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getContext(), "collect.db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        VideoCollectBeanDao videoCollectBeanDao = daoSession.getVideoCollectBeanDao();
        QueryBuilder<VideoCollectBean> videoCollectBeanQueryBuilder = videoCollectBeanDao.queryBuilder();
        List<VideoCollectBean> list = videoCollectBeanQueryBuilder.list();
        arr1.clear();
        for (VideoCollectBean bean : list) {
            arr1.add(bean);
        }
        adapter.notifyDataSetChanged();
        helper.close();
    }

    public void delect(VideoCollectBean videoCollectBean) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getContext(), "collect.db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        VideoCollectBeanDao videoCollectBeanDao = daoSession.getVideoCollectBeanDao();
        videoCollectBeanDao.delete(videoCollectBean);
        helper.close();
    }


    @Override
    protected int getFragmentLayoutId() {
        return R.layout.shoucang_highlights_tab_fragment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void initData() {
        arr1 = new ArrayList<>();
        adapter = new HigHlightListviewAdapter(arr1, getContext());
        highlightListview.setAdapter(adapter);
        quer();
        highlightListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (Highlights_Tab_Fragment.textView.getText().equals("完成")) {
                    if (arr1.get(i).getRb() == false) {
                        arr1.get(i).setRb(true);
                        number++;
                        shanchu.setText("删除" + number);
                    } else {
                        number--;
                        shanchu.setText("删除" + number);
                        arr1.get(i).setRb(false);
                    }
                    if (number == 0) {
                        shanchu.setText("删除");
                    }
                    adapter.notifyDataSetChanged();
                }else{
                    adapter.notifyDataSetChanged();
                    //跳转到视频播放
                    VideoCollectBean bean = arr1.get(i);
                    JCFullScreenActivity.toActivity(bean.getImg(), bean.getTime(), getActivity(), bean.getUrl(), bean.getUrltwo(), null, PandaVedioPlayer.class, bean.getTitle());
                }


            }
        });
        textView.setVisibility(View.VISIBLE);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("编辑")) {
                    for (int i = 0; i < arr1.size(); i++) {
                        arr1.get(i).setBb(true);
                    }
                    dilog.setVisibility(View.VISIBLE);
                    textView.setText("完成");
                    adapter.notifyDataSetChanged();
                } else {
                    for (int i = 0; i < arr1.size(); i++) {
                        arr1.get(i).setBb(false);
                    }
                    for (int i = 0; i < arr1.size(); i++) {
                        arr1.get(i).setRb(false);
                    }
                    dilog.setVisibility(View.GONE);
                    textView.setText("编辑");
                    adapter.notifyDataSetChanged();
                }
            }
        });



        quanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quanxuan.getText().equals("全选")) {
                    quanxuan.setText("取消全选");
                    if (textView.getText().equals("完成")) {
                        for (int i = 0; i < arr1.size(); i++) {
                            arr1.get(i).setRb(true);
                        }
                        number = arr1.size();
                        shanchu.setText("删除" + number);
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    for (int i = 0; i < arr1.size(); i++) {
                        arr1.get(i).setRb(false);
                    }
                    number = 0;
                    shanchu.setText("删除");
                    quanxuan.setText("全选");
                    adapter.notifyDataSetChanged();
                }
            }
        });
        shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals("完成")) {
                    L.e("tag===list.size", arr1.size() + "");
                    for (int i = arr1.size() - 1; i >= 0; i--) {
                        if (arr1.get(i).getRb()) {
                            delect(arr1.get(i));
                            arr1.remove(arr1.get(i));
                        }
                    }
                    number = 0;
                    adapter.notifyDataSetChanged();
                    shanchu.setText("删除");
                    if (arr1.size() == 0) {
                        textView.setVisibility(View.GONE);
                        //historyRelative.setVisibility(View.GONE);
                        //historyBackgroud.setVisibility(View.VISIBLE);
                        dilog.setVisibility(View.GONE);
                    }
                }
            }
        });

    }

    @Override
    protected void fragmentHidden() {

    }

    @Override
    protected void fragmentShowing() {

    }
}
