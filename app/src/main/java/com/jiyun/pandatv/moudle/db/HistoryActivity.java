package com.jiyun.pandatv.moudle.db;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jiyun.com.day07_greendao.DaoMaster;
import com.jiyun.com.day07_greendao.DaoSession;
import com.jiyun.com.day07_greendao.HistoryDao;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.base.BaseActivity;
import com.jiyun.pandatv.moudle.entity.HistoryBean;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivity extends BaseActivity {


    @BindView(R.id.history_backImage)
    ImageView historyBackImage;
    @BindView(R.id.history_editBtn)
    Button historyEditBtn;
    @BindView(R.id.history_listview)
    RecyclerView historyListview;
    @BindView(R.id.history_item_chooseBtn)
    Button historyItemChooseBtn;
    @BindView(R.id.history_item_deleteBtn)
    Button historyItemDeleteBtn;
    @BindView(R.id.liner_chooseAnddelete)
    LinearLayout linerChooseAnddelete;
    @BindView(R.id.activity_history)
    LinearLayout activityHistory;
    private LinkedList<History> mList = new LinkedList<History>();
    private static ArrayList<HistoryBean> hList = new ArrayList<>();
    //    private HistoryAdapter adapter;
    private boolean flag = false;
    private int number = 0;

    private HistoryAdapterRecy adapterRecy;

    @Override
    public int getLayoutId() {
        return R.layout.activity_history;
    }

    @Override
    public void initView() {
        select();
        adapterRecy.setOnHistory(new HistoryAdapterRecy.OnHistory() {
            @Override
            public void onHistoryListener(int position) {
                if (historyEditBtn.getText().toString().equals("取消")) {
                    if (hList.get(position).isFlag() == false) {
                        hList.get(position).setFlag(true);
                        number++;
                        historyItemDeleteBtn.setText("删除" + number);
                    } else {
                        hList.get(position).setFlag(false);
                        number--;
                        historyItemDeleteBtn.setText("删除" + number);
                    }
                    if (number == 0) {
                        historyItemDeleteBtn.setText("删除");
                    }
                    if (number == hList.size()) {
                        historyItemChooseBtn.setText("取消全选");
                    } else {
                        historyItemChooseBtn.setText("全选");
                    }

                }
                adapterRecy.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.history_backImage, R.id.history_editBtn, R.id.history_item_chooseBtn, R.id.history_item_deleteBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.history_backImage:
                finish();
                break;
            case R.id.history_editBtn:

                if (historyEditBtn.getText().equals("编辑")) {
                    for (int i = 0; i < hList.size(); i++) {
                        hList.get(i).setVisibility(true);
                    }
                    linerChooseAnddelete.setVisibility(View.VISIBLE);
                    historyEditBtn.setText("取消");
                    adapterRecy.notifyDataSetChanged();
                } else {
                    for (int i = 0; i < hList.size(); i++) {
                        hList.get(i).setVisibility(false);
                    }
                    for (int i = 0; i < hList.size(); i++) {
                        hList.get(i).setFlag(false);
                    }
                    linerChooseAnddelete.setVisibility(View.GONE);
                    historyEditBtn.setText("编辑");
                    historyItemChooseBtn.setText("全选");
                    historyItemDeleteBtn.setText("删除");
                    number = 0;
                    adapterRecy.notifyDataSetChanged();
                }

                break;
            case R.id.history_item_chooseBtn:
                if (historyItemChooseBtn.getText().equals("全选")) {
                    historyItemChooseBtn.setText("取消全选");
                    if (historyEditBtn.getText().equals("取消")) {
                        for (int i = 0; i < hList.size(); i++) {
                            hList.get(i).setFlag(true);
                        }
                        number = hList.size();
                        historyItemDeleteBtn.setText("删除" + number);
                        adapterRecy.notifyDataSetChanged();
                    }
                } else {
                    for (int i = 0; i < hList.size(); i++) {
                        hList.get(i).setFlag(false);
                    }
                    number = 0;
                    historyItemDeleteBtn.setText("删除");
                    historyItemChooseBtn.setText("全选");
                    adapterRecy.notifyDataSetChanged();
                }

                break;
            case R.id.history_item_deleteBtn:
                if (historyEditBtn.getText().equals("取消")) {
                    for (int i = hList.size() - 1; i >= 0; i--) {
                        if (hList.get(i).isFlag()) {
                            deleteAll();
                            hList.remove(hList.get(i));
                        }
                    }
                    number = 0;
                    adapterRecy.notifyDataSetChanged();
                    historyItemDeleteBtn.setText("删除");
                    if (hList.size() == 0) {
                        historyEditBtn.setVisibility(View.GONE);
                        linerChooseAnddelete.setVisibility(View.GONE);
                    }
                }

                break;
        }
    }

    //查询数据库同时给listview加载数据。。
    public void select() {
//        hList.clear();
        DaoMaster master = new DaoMaster(MyHistoryHelper.gethelper(HistoryActivity.this).getR());

        DaoSession session = master.newSession();

        HistoryDao historyDao = session.getHistoryDao();

        QueryBuilder<History> builder = historyDao.queryBuilder();

        List<History> list = builder.list();
        L.d("TAG","每次查询时集合长度"+list.size());
        for (int i = 0; i < list.size(); i++) {
            hList.add(new HistoryBean(list.get(i).getTitle(), list.get(i).getImageUrl(), list.get(i).getVoideLength(), list.get(i).getDayTime(), false, false));
        }

        adapterRecy = new HistoryAdapterRecy(this, hList);
        historyListview.setLayoutManager(new LinearLayoutManager(this));
        historyListview.setAdapter(adapterRecy);
    }

    public void deleteAll() {

        DaoMaster master = new DaoMaster(MyHistoryHelper.gethelper(HistoryActivity.this).getW());

        DaoSession session = master.newSession();

        HistoryDao historyDao = session.getHistoryDao();

        historyDao.deleteAll();
    }


    public void updata(History history) {

        DaoMaster master = new DaoMaster(MyHistoryHelper.gethelper(this).getW());

        DaoSession session = master.newSession();

        HistoryDao historyDao = session.getHistoryDao();

        historyDao.update(history);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
