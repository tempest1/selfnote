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
import android.widget.TextView;
import android.widget.Toast;

import com.yqsj.selfnote.adapter.PageAdapter;
import com.yqsj.selfnote.bean.Content;
import com.yqsj.selfnote.util.DatabaseHelper;
import com.yqsj.selfnote.util.DialogUtils;
import com.yqsj.selfnote.util.SPUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2024/8/23.
 */

public class ContentActivity extends Activity implements View.OnClickListener {

    private ViewPager viewPager;
    private PageAdapter pageAdapter;
    private List<Content> dataList;

    private Button add,jump;

    private Button hide;
    private Button change;
    int groupId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        add = findViewById(R.id.add);
        jump = findViewById(R.id.jump);
        change = findViewById(R.id.change);
        add.setOnClickListener(this);
        jump.setOnClickListener(this);



        hide = findViewById(R.id.hide);
        hide.setOnClickListener(this);
        change.setOnClickListener(this);
        if (SPUtils.getString(this,"is_show","true").equals("true")) {
            hide.setBackground(ContextCompat.getDrawable(this, R.mipmap.show));

        }else{
            hide.setBackground(ContextCompat.getDrawable(this, R.mipmap.hide));
        }

        // 获取Intent和传递的参数
        Intent intent = getIntent();
        groupId = intent.getIntExtra("groupId", -1);



        if(groupId == -1){
            ContentActivity.this.finish();
            Toast.makeText(ContentActivity.this, "数据发生错误 " , Toast.LENGTH_SHORT).show();
            return;
        }

        dataList = DatabaseHelper.getContentByGroupId(groupId);

        for (int i =0;i<dataList.size();i++){

        }
        viewPager = findViewById(R.id.view_pager);
        Button addButton = findViewById(R.id.add);

        findViewById(R.id.back).setOnClickListener(this);

        // 设置适配器
        pageAdapter = new PageAdapter(this, dataList,
                new PageAdapter.OnItemClickListener() {
                    @Override
                    public void onTitleClick(final int position) {
                        // Handle title click
                        String title = dataList.get(position).getTitle();
                        // Implement your logic here
                        Log.e("sys",title);
                        // 回到主线程更新UI
                        ContentActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showCustomEditDialog(position,1);
                            }
                        });

                    }
                    @Override
                    public void onArticleClick(final int position) {
                        // Handle article click
                        String article = dataList.get(position).getContent();
                        // Implement your logic here
                        Log.e("sys",article);
                        ContentActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showCustomEditDialog(position,2);
                            }
                        });
                    }
                },
                new PageAdapter.OnButtonClickListener() {
                    @Override
                    public void onButtonClick(final int position) {
                        Log.e("sys","按钮  " + position);
                        DialogUtils.showCustomAlertDialog(ContentActivity.this, "删除此内容", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (position >= 0 && position < dataList.size()) {
                                    DatabaseHelper.deleteContentData(dataList.get(position).getId());
                                    dataList = DatabaseHelper.getContentByGroupId(groupId);
                                    ContentActivity.this.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            pageAdapter.setData(dataList);
                                            viewPager.setCurrentItem(viewPager.getCurrentItem(), false);
                                            if (dataList.size()==0){
                                                ContentActivity.this.finish();
                                            }
                                        }
                                    });
                                }
                            }
                        }, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                    }
                });
        viewPager.setAdapter(pageAdapter);
        //设置页数
        viewPager.setCurrentItem(Integer.parseInt(SPUtils.getString(this,"groupId"+groupId,"0")), false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.change:
                // 创建Intent并传递参数
                Intent intent = new Intent(ContentActivity.this,RandomActivity.class);
                intent.putExtra("groupId",  groupId);
                Log.e("sys","groupId= " +groupId);
                ContentActivity.this.finish();
                // 启动Activity
                startActivity(intent);
                break;
            case R.id.add:
                showCustomDialog();

                break;
            case R.id.back:
                ContentActivity.this.finish();

                break;
            case R.id.hide:
                Log.e("sys","hide");
                if (SPUtils.getString(this,"is_show","true").equals("true")) {
                    SPUtils.putString(this, "is_show", "false");
                    hide.setBackground(ContextCompat.getDrawable(this, R.mipmap.hide));
                }else{
                    SPUtils.putString(this, "is_show", "true");
                    hide.setBackground(ContextCompat.getDrawable(this, R.mipmap.show));
                }
                pageAdapter.setData(dataList);
                break;
            case R.id.jump:
                showListDialog();
                break;
        }
    }

    private void showCustomDialog() {
        // Inflate the dialog layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_two_edittext, null);

        // Find EditText elements
        final EditText editText1 = dialogView.findViewById(R.id.edit_title);
        final EditText editText2 = dialogView.findViewById(R.id.edit_cotnent);

        // Create and show the dialog
        new AlertDialog.Builder(this)
                .setTitle("Custom Dialog")
                .setView(dialogView)
                .setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String title = editText1.getText().toString();
                        String content = editText2.getText().toString();
                        DatabaseHelper.insertContent(title,content,1,groupId);
                        dataList = DatabaseHelper.getContentByGroupId(groupId);
                        ContentActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pageAdapter.setData(dataList);
                            }
                        });
                    }
                })
                .setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    private void showCustomEditDialog(final int position, final int type) {
        Log.e("sys","showCustomEditDialog");
        // 使用AlertDialog.Builder创建对话框
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 加载自定义布局
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_edittext, null);
        builder.setView(dialogView);



        // 获取EditText和按钮
        final EditText editText = dialogView.findViewById(R.id.edit_text);
        if (type == 1) {
            builder.setTitle(R.string.title_dialog);
            editText.setHint(R.string.title_dialog);
            editText.setText(dataList.get(position).getTitle());
        } else {
            builder.setTitle(R.string.title_content);
            editText.setHint(R.string.title_content);
            editText.setText(dataList.get(position).getContent());
        }
        int textLength = editText.getText().length();
        if (textLength>0){
            editText.setSelection(textLength);

        }


        builder.setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.e("sys", editText.getText().toString());
                if (editText.getText().toString().length() == 0) {
                    Toast.makeText(ContentActivity.this, "请输入内容", Toast.LENGTH_SHORT).show();
                    return;
                }
                String data = editText.getText().toString();
                Content content = DatabaseHelper.getContentById(dataList.get(position).getId());
                if (type == 1) {
                    DatabaseHelper.updateContentData(dataList.get(position).getId(), data, content.getContent(), 1);
                } else {
                    DatabaseHelper.updateContentData(dataList.get(position).getId(), content.getTitle(), data, 1);
                }
                dataList = DatabaseHelper.getContentByGroupId(groupId);
                ContentActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pageAdapter.setData(dataList);
                        pageAdapter.notifyDataSetChanged();

                    }
                });

            }
        });

        builder.setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        // 创建并显示对话框
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showListDialog() {
        // 数据列表

        ArrayList<String> itemList = new ArrayList<>();

        for(int i =0;i<dataList.size();i++){
            itemList.add(String.valueOf(i+1));
        }

        final String[] items = itemList.toArray(new String[0]);


        // 创建AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择页数");
        // 设置列表项
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 点击某一项后的处理逻辑
                int postion = Integer.parseInt(items[which]) - 1;
                viewPager.setCurrentItem(postion, false);
            }
        });
        // 添加取消按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // 显示对话框
        builder.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        int currentPage1 = viewPager.getCurrentItem();
        SPUtils.putString(this,"groupId"+groupId,String.valueOf(currentPage1));
    }
}
