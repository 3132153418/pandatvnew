package com.jiyun.pandatv.module.live.liveadapter;

import android.content.Context;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.Live_PandaTopBean;

import java.util.List;

/**
 * Created by lenovo on 2017/7/15.
 */
public class PandaTOPAdapter extends BaseAdapter<Live_PandaTopBean.VideoBean> {
    public PandaTOPAdapter(Context context,List<Live_PandaTopBean.VideoBean> datas) {
        super(context, R.layout.paper_after_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, Live_PandaTopBean.VideoBean videoBean) {
        holder.setText(R.id.paper_after_title, videoBean.getT());
        holder.setText(R.id.paper_after_time, videoBean.getPtime());
        holder.setText(R.id.paper_play_time, videoBean.getLen());
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.paper_after_image);
        Glide.with(App.context.getApplication()).load(videoBean.getImg()).into(imageView);//名字
    }
}
