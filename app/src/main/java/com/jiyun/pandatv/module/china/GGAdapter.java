package com.jiyun.pandatv.module.china;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.pandatv.Application.App;
import com.jiyun.pandatv.R;
import com.jiyun.pandatv.moudle.entity.GGliveBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */

public class GGAdapter extends RecyclerView.Adapter {
    private List<GGliveBean.ListBean> mlist;
    private LayoutInflater inflater;
    private Context context;
   private String url;
    public GGAdapter(Context context,List<GGliveBean.ListBean> mlist) {
        this.mlist = mlist;
        this.inflater =LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context,R.layout.fragment_gglive_item,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        GGliveBean.ListBean listBean = mlist.get(position);

        url = listBean.getUrl();
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(mlist.get(position).getImage()).into(viewHolder.gg_item_image);
        viewHolder.gg_item_name.setText(mlist.get(position).getTitle());
        viewHolder.gg_item_title.setText(mlist.get(position).getBrief());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gg_item_image;
        TextView gg_item_name,gg_item_title;
        public ViewHolder(View itemView) {
            super(itemView);
            gg_item_image = (ImageView) itemView.findViewById(R.id.gg_item_image);
            gg_item_name = (TextView) itemView.findViewById(R.id.gg_item_name);
            gg_item_title = (TextView) itemView.findViewById(R.id.gg_item_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 Intent intent = new Intent(App.context.getApplication(), GGactivity.class);
                    intent.putExtra("url",url);
                 App.context.startActivity(intent);
                }
            });
        }

    }
}
