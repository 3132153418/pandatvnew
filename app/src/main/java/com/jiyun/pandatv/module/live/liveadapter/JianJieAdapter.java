package com.jiyun.pandatv.module.live.liveadapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.Live_JianJieBean;

import java.util.List;

/**
 * Created by lenovo on 2017/7/14.
 */

public class JianJieAdapter extends BaseAdapter<Live_JianJieBean.LiveBean> {
    private CheckBox xialaxianshi;
    private TextView maioshuhaha;
    public JianJieAdapter(Context context, List<Live_JianJieBean.LiveBean> datas) {
        super(context, R.layout.live_jianjie_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, Live_JianJieBean.LiveBean liveBean) {
        holder.setText(R.id.jianjie_title, liveBean.getTitle());
        maioshuhaha = (TextView) holder.itemView.findViewById(R.id.brief);
        holder.setText(R.id.brief,liveBean.getBrief());
        xialaxianshi = (CheckBox) holder.itemView.findViewById(R.id.xiala_xianshi);
        xialaxianshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    maioshuhaha.setVisibility(View.VISIBLE);
                }else
                    maioshuhaha.setVisibility(View.GONE);
            }
        });
    }
}
