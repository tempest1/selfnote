package com.yqsj.selfnote.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yqsj.selfnote.R;
import com.yqsj.selfnote.bean.Content;
import com.yqsj.selfnote.util.SPUtils;

import java.util.List;

/**
 * Created by Ryan on 2024/8/26.
 */

public class RandomAdapter extends PagerAdapter {

    private final Context context;
    private List<Content> dataList;
    private final LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public RandomAdapter(Context context, List<Content> dataList,RandomAdapter.OnItemClickListener onItemClickListener) {
        this.context = context;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
        this.onItemClickListener = onItemClickListener;
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
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = inflater.inflate(R.layout.page_item, container, false);

        TextView titleTextView = view.findViewById(R.id.title_text);
        TextView articleTextView = view.findViewById(R.id.article_text);
        TextView answerTextView = view.findViewById(R.id.answer);
        Button articleButton = view.findViewById(R.id.article_button);
        TextView pageTextView = view.findViewById(R.id.page_id);

        articleButton.setVisibility(View.GONE);
        Content itemData = dataList.get(position);
        titleTextView.setText(itemData.getTitle());

        pageTextView.setText("第" + (position+1) + "页/共"+ dataList.size() +"页");

        answerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onOnAnswerClick(position);
                }
            }
        });

        if (dataList.get(position).isShow()) {
            articleTextView.setText(itemData.getContent());
        }else{
            articleTextView.setText("内容已经隐藏");
            articleTextView.setTextColor(Color.parseColor("#FF0000"));
        }


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    // Define interface for item clicks
    public interface OnItemClickListener {
        void onOnAnswerClick(int position);
    }

}
