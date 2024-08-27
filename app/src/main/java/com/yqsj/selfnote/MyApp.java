package com.yqsj.selfnote;

import android.app.Application;

import com.yqsj.selfnote.util.DatabaseHelper;
import com.yqsj.selfnote.util.SelfData;

/**
 * Created by Ryan on 2024/8/23.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHelper.getInstance(this);
        SelfData.setContents();

    }
}
