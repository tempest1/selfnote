package com.yqsj.selfnote;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.yqsj.selfnote.adapter.MyGridAdapter;
import com.yqsj.selfnote.bean.Group;
import com.yqsj.selfnote.util.DatabaseHelper;
import com.yqsj.selfnote.util.DialogUtils;
import com.yqsj.selfnote.util.SelfData;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private GridView gridView;
    private MyGridAdapter adapter;

    private Button add;
    List<Group> groupList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        findViewById(R.id.add).setOnClickListener(this);
//        findViewById(R.id.delete).setOnClickListener(this);
//        findViewById(R.id.update).setOnClickListener(this);
//        findViewById(R.id.query).setOnClickListener(this);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        gridView = findViewById(R.id.grid_view);
        add = findViewById(R.id.add);


        add.setOnClickListener(this);
        // 初始化数据
        groupList =DatabaseHelper.getAllGroups();


        //添加一些默认的数据
//        Log.e("sys","   " +DatabaseHelper.getContentByTitle("xxss"));
//        DatabaseHelper.insertContent(SelfData.contents);

        // 创建ArrayAdapter并设置给GridView
        // 创建自定义的Adapter并设置给GridView
        adapter = new MyGridAdapter(this, groupList);
        gridView.setAdapter(adapter);

        // 设置下拉刷新监听器
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 模拟数据刷新
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        data.add("New Item " + (data.size() + 1));
                        groupList =DatabaseHelper.getAllGroups();
                        adapter.setData(groupList);
                        adapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000); // 2秒后停止刷新
            }
        });

        // 设置点击事件监听器
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 创建Intent并传递参数
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                intent.putExtra("groupId",  groupList.get(position).getId());
                Log.e("sys","groupId= " + groupList.get(position).getId());
                // 启动ContentActivity
                startActivity(intent);
            }
        });

        // 设置长按点击事件监听器
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                showCustomAlertDialog("删除此分组",position);

                return true; // 返回 true 表示事件已处理，不再传递
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add:

                showCustomDialog();
                break;
        }
    }

    private void showCustomDialog() {
        // 使用AlertDialog.Builder创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 加载自定义布局
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_edittext, null);
        builder.setView(dialogView);
        builder.setTitle(R.string.title_dialog);

        // 获取EditText和按钮
        final EditText editText = dialogView.findViewById(R.id.edit_text);
        builder.setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.e("sys",editText.getText().toString());
                if (editText.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this, "请输入分组名 " , Toast.LENGTH_SHORT).show();
                    return;
                }
                DatabaseHelper.insertGroup(editText.getText().toString(),1);
                groupList =DatabaseHelper.getAllGroups();
                adapter.setData(groupList);
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        builder.setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        // 创建并显示对话框
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showCustomAlertDialog(String title,final int position) {
        DialogUtils.showCustomAlertDialog(MainActivity.this, title, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper.deleteGroupData(groupList.get(position).getId());
                groupList =DatabaseHelper.getAllGroups();
                adapter.setData(groupList);
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, "删除成功 " , Toast.LENGTH_SHORT).show();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


    }
}
