package com.jiyun.pandatv.module.live.liveadapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.Live_BianKanBianLiaoBean;

import java.util.List;

/**
 * Created by lenovo on 2017/7/15.
 */
public class LiveBianKanBianLiaoAdapter extends BaseAdapter<Live_BianKanBianLiaoBean.DataBean.ContentBean> {

    public LiveBianKanBianLiaoAdapter(Context context,  List<Live_BianKanBianLiaoBean.DataBean.ContentBean> datas) {
        super(context, R.layout.live_biankanbianliao_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, Live_BianKanBianLiaoBean.DataBean.ContentBean contentBean) {
        holder.setText(R.id.panda_live_talk_author, contentBean.getAuthor());
        holder.setText(R.id.panda_live_talk_message, contentBean.getMessage());
    }
}
