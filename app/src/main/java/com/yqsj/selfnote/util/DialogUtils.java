package com.yqsj.selfnote.util;

/**
 * Created by Ryan on 2024/8/23.
 */


import android.app.Activity;
import android.content.DialogInterface;
import android.widget.Toast;
import android.support.v7.app.AlertDialog; // 使用 android.support.v7.app.AlertDialog
import java.util.List;

public class DialogUtils {
    public static void showCustomAlertDialog(Activity activity, String title, DialogInterface.OnClickListener onclick1, DialogInterface.OnClickListener onclick2 ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setPositiveButton("确定", onclick1);

        builder.setNegativeButton("取消", onclick2);

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
