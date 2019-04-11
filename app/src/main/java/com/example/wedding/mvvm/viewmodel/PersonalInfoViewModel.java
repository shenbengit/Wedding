package com.example.wedding.mvvm.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.databinding.ObservableField;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;

import com.example.wedding.R;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.constant.Constant;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.ToastUtil;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;

import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * @author ShenBen
 * @date 2019/4/11 15:21
 * @email 714081644@qq.com
 */
public class PersonalInfoViewModel extends BaseViewModel {
    /**
     * 从相册选取照片
     */
    public static final int SELECT_PICTURE_FROM_ALBUM = 1;
    /**
     * 拍照方式选取照片
     */
    public static final int SELECT_PICTURE_FROM_CAMERA = 2;
    /**
     * 跳转至剪裁界面
     */
    public MutableLiveData<UCrop> toUCrop;

    public ObservableField<Uri> compressPictureUri;

    public PersonalInfoViewModel(@NonNull Application application) {
        super(application);
        toUCrop = new MutableLiveData<>();
        compressPictureUri = new ObservableField<>();
    }

    /**
     * Activity onActivityResult 返回
     *
     * @param requestCode 请求码
     * @param resultCode  结果码
     * @param data        数据
     */
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case SELECT_PICTURE_FROM_ALBUM: {//相册选取图片
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null && data.getData() != null) {
                        //剪裁图片
                        inToUCrop(data.getData());
                    }
                }
            }
            break;
            case SELECT_PICTURE_FROM_CAMERA: {//拍照选取图片
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        LogUtil.e("相册返回数据: " + data.getData());
                    }
                }
            }
            break;
            case UCrop.REQUEST_CROP://图片剪裁
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        Uri resultUri = UCrop.getOutput(data);
                        compressPictureUri.set(resultUri);
                        compressPicture(resultUri);
                    }
                }
                break;
            case UCrop.RESULT_ERROR://
                if (data != null) {
                    final Throwable cropError = UCrop.getError(data);
                    if (cropError != null) {
                        ToastUtil.show(getApplication(), "图片剪裁失败: " + cropError.getMessage());
                    }
                }
                break;
        }
    }

    /**
     * 剪裁图片
     *
     * @param source 被剪裁的图片资源
     */
    private void inToUCrop(Uri source) {
        String imageName = String.valueOf(System.currentTimeMillis());
        Uri destinationUri = Uri.fromFile(new File(getApplication().getCacheDir(), imageName + ".jpeg"));

        UCrop.Options options = new UCrop.Options();
        //设置裁剪图片可操作的手势
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        //设置隐藏底部容器，默认显示
        options.setHideBottomControls(true);
        //设置toolbar颜色
        options.setToolbarColor(ActivityCompat.getColor(getApplication(), R.color.colorPrimary));
        //设置状态栏颜色
        options.setStatusBarColor(ActivityCompat.getColor(getApplication(), R.color.colorPrimaryDark));
        //开始设置
        //设置最大缩放比例
        options.setMaxScaleMultiplier(5);
        //设置图片在切换比例时的动画
        options.setImageToCropBoundsAnimDuration(666);
        //设置裁剪窗口是否为椭圆
        options.setCircleDimmedLayer(true);
        //设置是否展示矩形裁剪框
        options.setShowCropFrame(false);
        //设置竖线的数量
        options.setCropGridColumnCount(0);
        //设置横线的数量
        options.setCropGridRowCount(0);

        UCrop uCrop = UCrop.of(source, destinationUri)
                .withAspectRatio(1, 1)
                .withMaxResultSize(1000, 1000)
                .withOptions(options);
        toUCrop.postValue(uCrop);
    }

    /**
     * 压缩图片
     *
     * @param uri 图片uri
     */
    private void compressPicture(Uri uri) {
        File file = new File(Constant.COMPRESS_PICTURE);
        if (!file.exists()) {
            file.mkdirs();
        }
        Luban.with(getApplication())
                .load(uri)
                .ignoreBy(180)
                .setTargetDir(Constant.COMPRESS_PICTURE)
                .filter(path -> !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif")))
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(File file) {
                        LogUtil.i("压缩图片地址: " + file.getAbsolutePath() + "，图片大小: " + file.length());
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("压缩图片失败: " + e.getMessage());
                    }
                })
                .launch();
    }
}
