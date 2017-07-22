package com.jiyun.pandatv.module.paper.paper;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.module.paper.PaperActivity;
import com.jiyun.pandatv.moudle.entity.Paper_LunboBean;

import java.util.List;

/**
 * Created by lenovo on 2017/7/14.
 */
public class PaperLunboAdaPter extends BaseAdapter<Paper_LunboBean.DataBean.BigImgBean> {
    public PaperLunboAdaPter(Context context, List<Paper_LunboBean.DataBean.BigImgBean> datas) {
        super(context, R.layout.paper_lunbo_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final Paper_LunboBean.DataBean.BigImgBean bigImgBean) {
        holder.setText(R.id.impandabroadcast_r_itemb_tv1, bigImgBean.getTitle());
        ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.impandabroadcast_r_itemb_img);
        Glide.with(App.context.getApplication()).load(bigImgBean.getImage()).into(imageView);//名字
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.context.getApplication(),PaperActivity.class);
                intent.putExtra("url",bigImgBean.getUrl());
                App.context.startActivity(intent);
            }
        });
    }
}
