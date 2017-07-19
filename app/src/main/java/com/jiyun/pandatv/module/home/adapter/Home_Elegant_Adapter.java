package com.jiyun.pandatv.module.home.adapter;

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

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */

public class Home_Elegant_Adapter extends BaseAdapter {
    private List<FirstBean.DataBean.PandaliveBean.ListBean> mlist;
    private LayoutInflater inflater;
    private Context context;

    public Home_Elegant_Adapter(Context context,List<FirstBean.DataBean.PandaliveBean.ListBean> mlist) {
        this.mlist = mlist;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
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
            convertView = inflater.inflate(R.layout.home_elegant_adapter_item,null);
            viewHolder.elegant_Adapter_Image = (ImageView) convertView.findViewById(R.id.elegant_Adapter_Image);
            viewHolder.elegant_Adapter_Title = (TextView) convertView.findViewById(R.id.elegant_Adapter_Title);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        FirstBean.DataBean.PandaliveBean.ListBean bean = mlist.get(position);
        viewHolder.elegant_Adapter_Title.setText(bean.getTitle());
        viewHolder.elegant_Adapter_Image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).load(bean.getImage()).into(viewHolder.elegant_Adapter_Image);
        return convertView;
    }
    class ViewHolder{
        TextView elegant_Adapter_Title;
        ImageView elegant_Adapter_Image;
    }
}
