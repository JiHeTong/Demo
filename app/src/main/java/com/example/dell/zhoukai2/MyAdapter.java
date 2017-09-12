package com.example.dell.zhoukai2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static com.example.dell.zhoukai2.R.id.item_image;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Bean> list = new ArrayList<>();

    public MyAdapter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item, null);
            //找控件
            viewHolder.item_image = (ImageView) convertView.findViewById(item_image);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //赋值
        Glide.with(context).load(list.get(position).getImgs().get(0)).into(viewHolder.item_image);
        viewHolder.name.setText(list.get(position).getName());
        viewHolder.content.setText(list.get(position).getContent());
        return convertView;
    }


    static class ViewHolder {
        //控件对象
        View rootView;
        ImageView item_image;
        TextView name;
        TextView content;
    }


}
