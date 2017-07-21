package com.jiyun.pandatv.module.live.liveadapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.Live_LiveBean;

import java.util.List;

/**
 * Created by lenovo on 2017/7/13.
 */
public class LiveAdapter extends BaseAdapter<Live_LiveBean> {
    public LiveAdapter(Context context, List<Live_LiveBean> datas) {
        super(context, R.layout.live_live_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, Live_LiveBean listBean) {
//        ImageView you = holder.getView(R.id.you);
//        holder.setText(R.id.title, listBean.getTitle());
//        holder.setText(R.id.introduction, listBean.getIntroduction());
//        ImageView publicHeadImage2 = (ImageView) holder.itemView.findViewById(R.id.tou);//图片
//        Glide.with(App.activity.getApplication()).load(listBean.getPublicHeadImage()).into(publicHeadImage2);


    }
}
