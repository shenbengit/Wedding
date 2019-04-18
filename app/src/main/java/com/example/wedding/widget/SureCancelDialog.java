package com.example.wedding.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wedding.R;

/**
 * @author ShenBen
 * @date 2019/4/18 21:54
 * @email 714081644@qq.com
 */
public class SureCancelDialog extends Dialog {
    private ImageView mIvLogo;
    private TextView mTvContent;
    private TextView mTvSure;
    private TextView mTvCancel;
    private TextView mTvTitle;
    private OnOptionClickListener mListener;

    public SureCancelDialog(@NonNull Context context) {
        this(context, 0);
    }

    public SureCancelDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        initView();
    }

    public ImageView getLogoView() {
        return mIvLogo;
    }

    public void setTitle(String title) {
        mTvTitle.setText(title);
    }

    public TextView getTitleView() {
        return mTvTitle;
    }

    public void setContent(String content) {
        this.mTvContent.setText(content);
    }

    public TextView getContentView() {
        return mTvContent;
    }

    public void setSure(String strSure) {
        this.mTvSure.setText(strSure);
    }

    public TextView getSureView() {
        return mTvSure;
    }

    public void setCancel(String strCancel) {
        this.mTvCancel.setText(strCancel);
    }

    public TextView getCancelView() {
        return mTvCancel;
    }

    public void setOnOptionClickListener(OnOptionClickListener listener) {
        mListener = listener;
    }

    private void initView() {
        setContentView(R.layout.dialog_sure_cancel);
        getWindow().getDecorView().setBackgroundColor(Color.TRANSPARENT);
        mIvLogo = findViewById(R.id.iv_logo);
        mTvSure = findViewById(R.id.tv_sure);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvContent = findViewById(R.id.tv_content);
        mTvContent.setTextIsSelectable(true);
        mTvTitle = findViewById(R.id.tv_title);
        mTvSure.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.sure();
            }
            cancel();
        });
        mTvCancel.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.cancel();
            }
            cancel();
        });
    }

    public interface OnOptionClickListener {
        void sure();

        void cancel();
    }
}
