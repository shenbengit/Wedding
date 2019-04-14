package com.example.wedding.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.wedding.R;


/**
 * @author vondear
 * @date 2017/3/20
 * 封装了从相册/相机 获取 图片 的Dialog.
 */
public class SelectPictureDialog extends Dialog {

    private TextView mTvCamera;
    private TextView mTvFile;
    private TextView mTvCancel;
    private OnSelectPictureModeListener mListener;

    public SelectPictureDialog(@NonNull Context context) {
        this(context, 0);
    }

    public SelectPictureDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    public void setOnSelectPictureModeListener(OnSelectPictureModeListener listener) {
        mListener = listener;
    }

    private void initView() {
        setContentView(R.layout.dialog_picker_pictrue_title);
        mTvCamera = findViewById(R.id.tv_camera);
        mTvFile = findViewById(R.id.tv_file);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvCancel.setOnClickListener(v -> cancel());
        mTvCamera.setOnClickListener(v -> {
            mListener.fromCamera();
            cancel();
        });
        mTvFile.setOnClickListener(v -> {
            mListener.formAlbum();
            cancel();
        });


    }

    public TextView getFromCameraView() {
        return mTvCamera;
    }

    public TextView getFromFileView() {
        return mTvFile;
    }

    public TextView getCancelView() {
        return mTvCancel;
    }

    @Override
    public void show() {
        super.show();
        //设置宽度全屏，要设置在show的后面
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(layoutParams);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
    }

    public interface OnSelectPictureModeListener {

        /**
         * 拍照选取
         */
        void fromCamera();

        /**
         * 相册选取
         */
        void formAlbum();
    }

}
