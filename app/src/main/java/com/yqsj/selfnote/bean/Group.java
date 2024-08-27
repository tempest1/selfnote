package com.yqsj.selfnote.bean;


import java.sql.Timestamp;

/**
 * Created by Ryan on 2024/8/23.
 */

public class Group {
    private int id;
    private String text;
    private String time_update;
    private int sort;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime_update() {
        return time_update;
    }

    public void setTime_update(String time_update) {
        this.time_update = time_update;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", time_update=" + time_update +
                ", sort=" + sort +
                '}';
    }
}
