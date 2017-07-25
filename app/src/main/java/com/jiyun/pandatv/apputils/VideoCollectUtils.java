package com.jiyun.pandatv.apputils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jiyun.com.day07_greendao.DaoMaster;
import com.jiyun.com.day07_greendao.DaoSession;
import com.jiyun.com.day07_greendao.VideoCollectBean;
import com.jiyun.com.day07_greendao.VideoCollectBeanDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by lenovo on 2017/7/24.
 */

public class VideoCollectUtils {
   private Context context;

    public VideoCollectUtils(Context context) {
        this.context = context;
    }

    public  void add(VideoCollectBean videoCollectBean){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "collect.db", null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        VideoCollectBeanDao videoCollectBeanDao = daoSession.getVideoCollectBeanDao();
        videoCollectBeanDao.insert(videoCollectBean);


    }
    public  void remove(VideoCollectBean videoCollectBean){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "collect.db", null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        VideoCollectBeanDao videoCollectBeanDao = daoSession.getVideoCollectBeanDao();
        videoCollectBeanDao.delete(videoCollectBean);
    }

    public  List<VideoCollectBean> selector(){

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "collect.db", null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(writableDatabase);
        DaoSession daoSession = daoMaster.newSession();
        VideoCollectBeanDao videoCollectBeanDao = daoSession.getVideoCollectBeanDao();
        QueryBuilder<VideoCollectBean> videoCollectBeanQueryBuilder = videoCollectBeanDao.queryBuilder();
        List<VideoCollectBean> list = videoCollectBeanQueryBuilder.list();
        return list;
    }
}
