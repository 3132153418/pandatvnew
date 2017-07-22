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
    public LiveBianKanBianLiaoAdapter(Context context, List<Live_BianKanBianLiaoBean.DataBean.ContentBean> datas) {
        super(context, R.layout.live_biankanbianliao_item, datas);
    }
    @Override
    public void convert(ViewHolder holder, Live_BianKanBianLiaoBean.DataBean.ContentBean contentBean) {
            holder.setText(R.id.panda_live_talk_author, contentBean.getAuthor());
            holder.setText(R.id.panda_live_talk_message, contentBean.getMessage());
            holder.setText(R.id.panda_live_talk_data, TimeStamp2Date(contentBean.getDateline(), "MM-dd-yyyy"));
//时间
    }

    /**
     * unix时间戳 转换成时间格式
     * wrp
     *
     * @return
     */
    public String TimeStamp2Date(String timestampString, String formats) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new java.text.SimpleDateFormat(formats).format(new java.util.Date(timestamp));
        return date;
    }
}
