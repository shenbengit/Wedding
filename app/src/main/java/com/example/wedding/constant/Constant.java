package com.example.wedding.constant;

import android.os.Environment;

import java.io.File;

/**
 * @author

 */
public class Constant {
    public static final String TAG = "Wedding";
    /**
     * 文件路径,基础路径
     */
    public static final String FILE_SAVE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + TAG + File.separator;
    /**
     * 压缩图片存储路径
     */
    public static final String COMPRESS_PICTURE = FILE_SAVE_PATH + "CompressPicture" + File.separator;
    /**
     * 缓存图片存储路径，拍照等
     */
    public static final String CACHE_PICTURE = FILE_SAVE_PATH + "CachePicture" + File.separator;
    /**
     * 照相机拍照返回图片的文件名称
     */
    public static final String CAMERA_HEAD_NAME = "camera_head.jpeg";
    /**
     * UCROP 截图文件名称
     */
    public static final String UCROP_HEAD_NAME = "uCrop_head.jpeg";


    /**
     * 是否需要登录
     */
    public static final String IS_NEED_LOGIN = "isNeedLogin";


    /**
     * Bmob云 控制台上 Application ID
     */
    public static final String BMOB_APP_KEY = "bbb82cc6991985c5e2b43030d529d613";
    /**
     * 自定义短息模板
     */
    public static final String SMS_TEMPLATE = "Wedding";


    /**
     * 时间模板
     */
    public static final String DATA_FORMAT_PATTERN = "yyyy-MM-dd";

}
