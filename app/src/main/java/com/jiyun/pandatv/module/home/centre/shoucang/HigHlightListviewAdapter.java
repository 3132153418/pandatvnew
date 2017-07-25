package com.jiyun.pandatv.module.home.centre.shoucang;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.com.day07_greendao.VideoCollectBean;
import com.jiyun.pandatv.R;

import java.util.ArrayList;


public class HigHlightListviewAdapter extends BaseAdapter {
    ArrayList<VideoCollectBean> arr;
    Context context;

    public HigHlightListviewAdapter(ArrayList<VideoCollectBean> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
         if(viewHolder==null){
             viewHolder=new ViewHolder();
             view = View.inflate(context, R.layout.originalnewsrecycler_itemtwo, null);
             viewHolder.OriginalNewsItemTitle= (TextView) view.findViewById(R.id.OriginalNews_item_title);
             viewHolder.OriginalNewsItemImg= (ImageView) view.findViewById(R.id.OriginalNews_item_img);
             viewHolder.OriginalNewsItemTime= (TextView) view.findViewById(R.id.OriginalNews_item_time);
             viewHolder.checkBox= (RadioButton) view.findViewById(R.id.original_radio);
             view.setTag(viewHolder);
         }else{
             viewHolder = (ViewHolder) view.getTag();
         }
        viewHolder.OriginalNewsItemTitle.setText(arr.get(i).getTitle());
        viewHolder.OriginalNewsItemTime.setText(arr.get(i).getTime());
        Glide.with(context).load(arr.get(i).getImg()).into(viewHolder.OriginalNewsItemImg);
        viewHolder.checkBox.setEnabled(false);
        if(arr.get(i).getBb()) {
            viewHolder.checkBox.setVisibility(View.VISIBLE);

        }
        else {
            viewHolder.checkBox.setVisibility(View.GONE);
        }
        if(arr.get(i).getRb()) {
            viewHolder.checkBox.setChecked(true);
        }
        else {
            viewHolder.checkBox.setChecked(false);
        }

        return view;
    }

    static class ViewHolder {
        ImageView OriginalNewsItemImg;
        TextView OriginalNewsItemTitle;
        TextView OriginalNewsItemTime;
        RadioButton checkBox;
    }
}
