package com.jiyun.pandatv.module.livechina.liveadapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.apputils.L;
import com.jiyun.pandatv.moudle.entity.LiveChina_BaDaBean;

import java.util.List;

/**
 * Created by lenovo on 2017/7/18.
 */
public class LiveChinaAdapter extends BaseAdapter<LiveChina_BaDaBean.LiveBean> {
    private CheckBox xianshi;
    private TextView maioshuhaha;
    public LiveChinaAdapter(Context context, List<LiveChina_BaDaBean.LiveBean> datas) {
        super(context, R.layout.livechina_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, LiveChina_BaDaBean.LiveBean liveBean) {
        holder.setText(R.id.livechina_text, "[正在直播]"+liveBean.getTitle());
        maioshuhaha = (TextView) holder.itemView.findViewById(R.id.ewew);
        maioshuhaha.setText(liveBean.getBrief());
        L.d("八达岭隐藏",liveBean.getBrief().toString());
//        holder.setText(R.id.ewew,);
        xianshi = (CheckBox) holder.itemView.findViewById(R.id.haha_xianshi);
        xianshi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    maioshuhaha.setVisibility(View.VISIBLE);
                }else{
                    maioshuhaha.setVisibility(View.GONE);
                }
            }
        });
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.livaching_image);
        Glide.with(App.context.getApplication()).load(liveBean.getImage()).into(imageView);//名字

    }
}
