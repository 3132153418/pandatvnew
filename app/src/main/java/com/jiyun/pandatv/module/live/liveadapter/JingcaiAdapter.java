package com.jiyun.pandatv.module.live.liveadapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.Live_JiangCaiBean;

import java.util.List;

/**
 * Created by lenovo on 2017/7/14.
 */
public class JingcaiAdapter extends BaseAdapter<Live_JiangCaiBean.VideoBean> {

    public JingcaiAdapter(Context context, List<Live_JiangCaiBean.VideoBean> datas) {
        super(context, R.layout.paper_after_item, datas);
    }
//    接口回调
    public void setJingcaiCallback(JingCaiCallback callback) {
        this.jingcaiCallback = callback;
    }

    private JingCaiCallback jingcaiCallback;

    public interface JingCaiCallback {
        void back(int layoutPosition);
    }

    @Override
    public void convert(ViewHolder holder, Live_JiangCaiBean.VideoBean videoBean) {
        holder.setText(R.id.paper_after_title, videoBean.getT());
        holder.setText(R.id.paper_after_time, videoBean.getPtime());
        holder.setText(R.id.paper_play_time, videoBean.getLen());
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.paper_after_image);
        Glide.with(App.context.getApplication()).load(videoBean.getImg()).into(imageView);//名字
        final int layoutPosition = holder.getLayoutPosition();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jingcaiCallback.back(layoutPosition);
            }
        });
    }
}
