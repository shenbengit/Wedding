package com.example.wedding.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * 封装Toast,避免重复显示
 *
 * @author

 */

public class ToastUtil {
    private static Toast toast;

    /**
     * 静态toast
     * @param context
     * @param text
     */
    @SuppressLint("ShowToast")
    public static void show(Context context, String text) {
        // 1. 创建前 2.消失后toast为null
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }
}
