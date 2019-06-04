package com.freebookqy.utilslib;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * 拨打电话对话框工具类
 * Created by chenyunjia on 2016/11/15.
 */

public class CallDialogUtils {


    public static void callPhone(Context context, String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri data = Uri.parse(number);
        intent.setData(data);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "无法拨打电话", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 拦截拨打电话
     *
     * @return
     */
    public static void callPhone(Context context, Uri uri) {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(uri.toString().replace("-", "")));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "无法拨打电话", Toast.LENGTH_SHORT).show();
        }
    }
}
