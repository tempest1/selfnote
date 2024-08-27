package com.yqsj.selfnote.bean;

/**
 * Created by Ryan on 2024/8/23.
 */

public class Content {
    private int id;
    private String title;
    private String content;
    private String time_update;
    private int sort;
    private int id_group;

    private boolean isShow;
    public Content(){
        this.isShow = false;
    }
    public Content(String title,String content,int id_group){
        this.title = title;
        this.content = content;
        this.sort = 1;
        this.id_group = id_group;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }



    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time_update='" + time_update + '\'' +
                ", sort=" + sort +
                ", id_group=" + id_group +
                '}';
    }
}
