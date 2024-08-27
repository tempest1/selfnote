package com.yqsj.selfnote.adapter;

/**
 * Created by Ryan on 2024/8/23.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yqsj.selfnote.R;
import com.yqsj.selfnote.bean.Group;

import java.util.List;

public class MyGridAdapter extends BaseAdapter {

    private Context context;
    private List<Group> data;
    private LayoutInflater inflater;

    public MyGridAdapter(Context context, List<Group> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }


    public void setData(List<Group> data){
        this.data = data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.center_text);
            holder.time = convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 设置TextView的内容
        holder.textView.setText(data.get(position).getText());
        holder.time.setText(data.get(position).getTime_update());

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
        TextView time;
    }
}