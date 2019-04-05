package com.example.wedding.constant;

import android.os.Environment;

import java.io.File;

/**
 * @author Ben
 * @date 2018/9/12
 * Email: 714081644@qq.com
 */
public class Constant {
    public static final String TAG = "Wedding";
    /**
     * 文件路径,基础路径
     */
    public static final String FILE_SAVE_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator + TAG + File.separator;
    /**
     * Bmob云 控制台上 Application ID
     */
    public static final String BMOB_APP_KEY = "bbb82cc6991985c5e2b43030d529d613";
}
