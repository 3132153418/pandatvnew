package com.jiyun.pandatv.module.livechina.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.ChangchengBean;

import java.util.List;

/**
 * Created by Lenovo on 2017/7/14.
 */
public class ZhiBochenaAdapter extends BaseAdapter{

    private Context mContext;
    private List<ChangchengBean.LiveBean> mList;
    private boolean isBocke = false;

    public ZhiBochenaAdapter(Context mContext, List<ChangchengBean.LiveBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    class Holder{
        private ImageView jcVideoPlayer;
        private TextView mtitle,mJianjie;
        private ImageButton chebox;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if(convertView == null) {
            holder = new Holder();
            convertView = View.inflate(mContext, R.layout.zhibochena_item,null);
            holder.jcVideoPlayer = (ImageView) convertView.findViewById(R.id.custom_videoplayer_standard_with_share_button);
            holder.mtitle = (TextView) convertView.findViewById(R.id.ZhiboChena_title);
            holder.mJianjie = (TextView) convertView.findViewById(R.id.ZhiboChena_Jianjie);
            holder.chebox = (ImageButton) convertView.findViewById(R.id.ZhiboChena_chebox);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        ChangchengBean.LiveBean bean = mList.get(position);
            holder.mtitle.setText(bean.getTitle());
            holder.mJianjie.setText(bean.getBrief());

//        holder.jcVideoPlayer.setUp(
//                "http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4",
//                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,bean.getTitle());
//        holder.jcVideoPlayer.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(mContext).load(bean.getImage()).into(holder.jcVideoPlayer);



        holder.chebox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isBocke == false) {
                    holder.mJianjie.setVisibility(View.VISIBLE);
                    isBocke =true;
                }else{
                    isBocke=false;
                    holder.mJianjie.setVisibility(View.GONE);
                }
            }
        });

        return convertView;
    }



}
