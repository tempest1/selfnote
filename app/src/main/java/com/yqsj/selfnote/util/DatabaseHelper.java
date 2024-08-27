package com.yqsj.selfnote.util;

/**
 * Created by Ryan on 2024/8/23.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.yqsj.selfnote.bean.Content;
import com.yqsj.selfnote.bean.Group;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {

    // 数据库名称
    private static final String DATABASE_NAME = "MyDatabase.db";
    // 数据库版本
    private static final int DATABASE_VERSION = 1;

    // 私有静态变量，持有类的唯一实例
    private static DatabaseHelper sInstance;

    // 私有构造方法，防止外部通过new创建实例
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 公有静态方法，返回类的唯一实例
    public static synchronized DatabaseHelper getInstance(Context context) {
        // 如果实例不存在，则创建
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }
    // 创建数据库时调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建tb_group表
        String CREATE_GROUP_TABLE = "CREATE TABLE " + "tb_group" + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "text TEXT NOT NULL,"
                + "time_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "sort INTEGER NOT NULL" + ")";
        db.execSQL(CREATE_GROUP_TABLE);

        // 创建tb_content表
        String CREATE_CONTENT_TABLE = "CREATE TABLE " + "tb_content" + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "title TEXT NOT NULL,"
                + "content TEXT NOT NULL,"
                + "time_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "sort INTEGER NOT NULL,"
                + "id_group INTEGER"
                 + ")";
        db.execSQL(CREATE_CONTENT_TABLE);
    }

    // 数据库版本升级时调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 在这里处理数据库版本升级的逻辑
        // 例如，删除旧表，然后调用onCreate重新创建表
        db.execSQL("DROP TABLE IF EXISTS " + "tb_group");
        db.execSQL("DROP TABLE IF EXISTS " + "tb_content");
        onCreate(db);
    }

    // 插入分组数据
    public static long insertGroup(String text, int sort) {
        SQLiteDatabase db = sInstance.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("text", text);
        values.put("sort", sort);

        long id = db.insert("tb_group", null, values);
        db.close();
        return id;
    }


    // 插入内容数据
    public static void insertContent(List<Content> contents) {
        SQLiteDatabase db = sInstance.getWritableDatabase();

        for (int i=0;i<contents.size();i++) {
            String[] selectionArgs = new String[]{contents.get(i).getTitle()};
            Cursor cursor = db.rawQuery("SELECT * FROM tb_content WHERE title = ?", selectionArgs);
            if  (cursor != null && cursor.moveToFirst()) {
                Log.e("sys","存在title");
            }else{
                ContentValues values = new ContentValues();
                values.put("title", contents.get(i).getTitle());
                values.put("content", contents.get(i).getContent());
                values.put("sort", contents.get(i).getSort());
                values.put("id_group", contents.get(i).getId_group());
                long id = db.insert("tb_content", null, values);
                Log.e("sys","成功添加");
            }


        }
        db.close();
    }

    // 插入内容数据
    public static long insertContent(String title, String content, int sort, int groupId) {
        SQLiteDatabase db = sInstance.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("content", content);
        values.put("sort", sort);
        values.put("id_group", groupId);

        long id = db.insert("tb_content", null, values);
        db.close();
        return id;
    }

    // 更多的数据操作方法...（如查询、更新、删除）

    // 示例：查询所有分组
    public static List<Group> getAllGroups() {
        SQLiteDatabase db = sInstance.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_group", null);
        List<Group> groupList = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String time_update = cursor.getString(cursor.getColumnIndexOrThrow("time_update"));
                String text = cursor.getString(cursor.getColumnIndexOrThrow("text"));
                int sort = cursor.getInt(cursor.getColumnIndexOrThrow("sort"));
                Group group = new Group();
                group.setId(id);
                group.setText(text);
                group.setTime_update(time_update);
                group.setSort(sort);
                groupList.add(group);
            } while (cursor.moveToNext());
        }
        return groupList;
    }

    // 示例：根据分组ID查询内容
    public static List<Content> getContentByGroupId(int groupId) {
        SQLiteDatabase db = sInstance.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_content WHERE id_group = "+ String.valueOf(groupId),null);
        List<Content> contentList = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String time_update = cursor.getString(cursor.getColumnIndexOrThrow("time_update"));
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                int sort = cursor.getInt(cursor.getColumnIndexOrThrow("sort"));
                String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                int id_group = cursor.getInt(cursor.getColumnIndexOrThrow("id_group"));
                Content contents = new Content();
                contents.setId(id);
                contents.setTitle(title);
                contents.setContent(content);
                contents.setTime_update(time_update);
                contents.setSort(sort);
                contents.setId_group(id_group);
                contentList.add(contents);
            } while (cursor.moveToNext());
        }
        return contentList;
    }

    // 示例：根据ID查询内容
    public static Content getContentById(int id) {
        SQLiteDatabase db = sInstance.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_content WHERE id = "+ String.valueOf(id),null);
        Content contents = null;
        if (cursor != null && cursor.moveToFirst()) {
            String time_update = cursor.getString(cursor.getColumnIndexOrThrow("time_update"));
            String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            int sort = cursor.getInt(cursor.getColumnIndexOrThrow("sort"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
            int id_group = cursor.getInt(cursor.getColumnIndexOrThrow("id_group"));
            contents = new Content();
            contents.setId(id);
            contents.setTitle(title);
            contents.setContent(content);
            contents.setTime_update(time_update);
            contents.setSort(sort);
            contents.setId_group(id_group);
        }
        return contents;
    }

    // 示例：根据title查询内容
    public static Content getContentByTitle(String title) {
        SQLiteDatabase db = sInstance.getReadableDatabase();
        String[] selectionArgs = new String[]{title};
        Cursor cursor = db.rawQuery("SELECT * FROM tb_content WHERE title = ?", selectionArgs);

        Content contents = null;
        if (cursor != null && cursor.moveToFirst()) {
            String time_update = cursor.getString(cursor.getColumnIndexOrThrow("time_update"));
            int sort = cursor.getInt(cursor.getColumnIndexOrThrow("sort"));
            String content = cursor.getString(cursor.getColumnIndexOrThrow("content"));
            int id_group = cursor.getInt(cursor.getColumnIndexOrThrow("id_group"));
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            contents = new Content();
            contents.setId(id);
            contents.setTitle(title);
            contents.setContent(content);
            contents.setTime_update(time_update);
            contents.setSort(sort);
            contents.setId_group(id_group);
        }
        return contents;
    }


    // 更新分组数据
    public static void updateGroupData(int id, String text, int sort) {
        SQLiteDatabase db = sInstance.getWritableDatabase();
        ContentValues values = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        values.put("text", text);
        values.put("sort", sort);
        values.put("time_update", currentTime);
        db.update("tb_group", values, "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // 删除分组数据
    public static void deleteGroupData(int id) {
        SQLiteDatabase db = sInstance.getWritableDatabase();
        db.delete("tb_content", "id_group = ?", new String[]{String.valueOf(id)});
        db.delete("tb_group", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // 更新内容数据
    public static void updateContentData(int id, String title,String content, int sort) {
        SQLiteDatabase db = sInstance.getWritableDatabase();
        ContentValues values = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        values.put("title", title);
        values.put("content", content);
        values.put("sort", sort);
        values.put("time_update", currentTime);
        db.update("tb_content", values, "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    // 删除内容数据
    public static void deleteContentData(int id) {
        SQLiteDatabase db = sInstance.getWritableDatabase();
        db.delete("tb_content", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }


    // 关闭数据库连接（通常不需要在工具类中提供，因为SQLite会自动管理连接）
    // 但如果需要，可以提供一个静态方法来关闭已打开的数据库连接（如果有的话）
    // 注意：在大多数情况下，Android的SQLiteOpenHelper会自动管理数据库的打开和关闭
}