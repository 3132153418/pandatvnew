package com.jiyun.pandatv.module.home.original;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.FirstBean;
import com.jiyun.pandatv.moudle.entity.OriginalBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */

public class Original_Adapter extends BaseAdapter {
    private List<OriginalBean.InteractiveBean> mlist;
    private Context context;
    private LayoutInflater inflater;

    public Original_Adapter(Context context,List<OriginalBean.InteractiveBean> mlist) {
        this.mlist = mlist;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.original_item,null);
            viewHolder.original_ImageView = (ImageView) convertView.findViewById(R.id.original_ImageView);
            viewHolder.original_Title = (TextView) convertView.findViewById(R.id.original_Title);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        OriginalBean.InteractiveBean interactiveoneBean = mlist.get(position);
        Glide.with(context).load(interactiveoneBean.getImage()).into(viewHolder.original_ImageView);
        viewHolder.original_ImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.original_Title.setText(interactiveoneBean.getTitle());
        return convertView;
    }
    class ViewHolder{
        ImageView original_ImageView;
        TextView original_Title;
    }
}
