package com.jiyun.pandatv.module.paper.paper;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.Paper_DataBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017/7/14.
 */
public class PaperDataAdaPter extends BaseAdapter<Paper_DataBean.ListBean> {
    private PaperCallBack paperCallBack;

    public void setPaperCallBack(PaperCallBack paperCallBack) {
        this.paperCallBack = paperCallBack;
    }

    public interface PaperCallBack {
        void back(int layoutPosition);
    }

    public PaperDataAdaPter(Context context, List<Paper_DataBean.ListBean> datas) {
        super(context, R.layout.paper_data_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final Paper_DataBean.ListBean listBean) {
        holder.setText(R.id.impandabroadcast_r_itema_tv1, listBean.getTitle());
//        时间
        holder.setText(R.id.paper_data_time, convert((listBean.getFocus_date())));
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.paper_data_image);
        Glide.with(context).load(listBean.getPicurl()).into(imageView);//名字
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paperCallBack.back(layoutId);
            }
        });
    }

    public String convert(long mill) {
        Date date = new Date(mill);
        String strs = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            strs = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }
}
