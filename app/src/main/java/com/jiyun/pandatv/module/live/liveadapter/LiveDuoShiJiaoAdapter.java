package com.jiyun.pandatv.module.live.liveadapter;

import android.content.Context;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.Live_MoreViewBean;

import java.util.List;

/**
 * Created by lenovo on 2017/7/13.
 */
public class LiveDuoShiJiaoAdapter extends BaseAdapter<Live_MoreViewBean.ListBean> {

    public LiveDuoShiJiaoAdapter(Context context,  List<Live_MoreViewBean.ListBean> datas) {
        super(context, R.layout.live_moreview_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, Live_MoreViewBean.ListBean listBean) {
        holder.setText(R.id.live_text, listBean.getTitle());
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.live_image);
        Glide.with(App.context.getApplication()).load(listBean.getImage()).into(imageView);//名字

    }
}
