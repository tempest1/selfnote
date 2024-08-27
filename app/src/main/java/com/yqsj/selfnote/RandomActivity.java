package com.yqsj.selfnote;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yqsj.selfnote.adapter.RandomAdapter;
import com.yqsj.selfnote.bean.Content;
import com.yqsj.selfnote.util.DatabaseHelper;
import com.yqsj.selfnote.util.DialogUtils;
import com.yqsj.selfnote.util.SPUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ryan on 2024/8/26.
 */

public class RandomActivity extends Activity implements View.OnClickListener {
    private ViewPager viewPager;
    private RandomAdapter pageAdapter;
    private List<Content> dataList;
    int groupId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        // 获取Intent和传递的参数
        Intent intent = getIntent();
        groupId = intent.getIntExtra("groupId", -1);

        if(groupId == -1){
            RandomActivity.this.finish();
            Toast.makeText(RandomActivity.this, "数据发生错误 " , Toast.LENGTH_SHORT).show();
            return;
        }

        dataList = DatabaseHelper.getContentByGroupId(groupId);
        //随机列表
        Collections.shuffle(dataList);
        viewPager = findViewById(R.id.view_pager);
        Button addButton = findViewById(R.id.add);

        findViewById(R.id.back).setOnClickListener(this);

        // 设置适配器
        pageAdapter = new RandomAdapter(this, dataList, new RandomAdapter.OnItemClickListener() {
            @Override
            public void onOnAnswerClick(int position) {
                Log.e("sys","答案");
                if(dataList.get(position).isShow()) {
                    dataList.get(position).setShow(false);
                }else{
                    dataList.get(position).setShow(true);
                }
                pageAdapter.setData(dataList);
            }
        });
        viewPager.setAdapter(pageAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.change:
                Intent intent = new Intent(RandomActivity.this,ContentActivity.class);
                intent.putExtra("groupId",  groupId);
                Log.e("sys","groupId= " +groupId);
                RandomActivity.this.finish();
                // 启动Activity
                startActivity(intent);
                break;
            case R.id.back:
                RandomActivity.this.finish();
                break;
        }
    }

}
