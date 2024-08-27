package com.yqsj.selfnote.adapter;

/**
 * Created by Ryan on 2024/8/23.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.view.PagerAdapter;

import com.yqsj.selfnote.R;
import com.yqsj.selfnote.bean.Content;
import com.yqsj.selfnote.util.SPUtils;

import java.util.List;

public class PageAdapter extends PagerAdapter {

    private final Context context;
    private List<Content> dataList;
    private final LayoutInflater inflater;
    private final OnItemClickListener onItemClickListener;
    private final OnButtonClickListener onButtonClickListener;

    public PageAdapter(Context context, List<Content> dataList,
                       OnItemClickListener onItemClickListener,
                       OnButtonClickListener onButtonClickListener) {
        this.context = context;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
        this.onItemClickListener = onItemClickListener;
        this.onButtonClickListener = onButtonClickListener;
    }

    public void setData(List<Content> dataList){
        this.dataList = dataList;
        for(int i =0;i<dataList.size();i++){
            Log.e("sys",dataList.get(i).toString());
        }
        this.notifyDataSetChanged();

    }

    //保证刷新有用
    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }


    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container,final int position) {
        View view = inflater.inflate(R.layout.page_item, container, false);

        TextView titleTextView = view.findViewById(R.id.title_text);
        TextView articleTextView = view.findViewById(R.id.article_text);
        Button articleButton = view.findViewById(R.id.article_button);
        TextView pageTextView = view.findViewById(R.id.page_id);

        Content itemData = dataList.get(position);
        titleTextView.setText(itemData.getTitle());

        pageTextView.setText("第" + (position+1) + "页/共"+ dataList.size() +"页");

        if (SPUtils.getString(context,"is_show","true").equals("true")) {
            articleTextView.setText(itemData.getContent());
        }else{
            articleTextView.setText("内容已经隐藏");
            articleTextView.setTextColor(Color.parseColor("#FF0000"));
        }



        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onTitleClick(position);
                }
            }
        });
        articleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onArticleClick(position);
                }
            }
        });

        articleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onButtonClickListener != null) {
                    onButtonClickListener.onButtonClick(position);
                }
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    // Define interface for item clicks
    public interface OnItemClickListener {
        void onTitleClick(int position);
        void onArticleClick(int position);
    }

    // Define interface for button clicks
    public interface OnButtonClickListener {
        void onButtonClick(int position);
    }
}
