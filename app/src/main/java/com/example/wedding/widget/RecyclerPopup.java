package com.example.wedding.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import com.example.wedding.R;
import com.example.wedding.mvvm.view.adapter.RecyclerPopupAdapter;
import com.example.wedding.mvvm.view.bean.RecyclerPopupBean;

import java.util.List;

import razerdp.basepopup.BasePopupWindow;

/**
 * 下拉列表PopupWindow
 */
public class RecyclerPopup extends BasePopupWindow {

    private RecyclerPopupAdapter mAdapter;
    private OnItemClickListener mListener;
    /**
     * 显示列表的标识
     */
    private int mType = -1;
    private int mLastPosition = -1;

    public RecyclerPopup(Context context) {
        super(context, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundColor(Color.TRANSPARENT);
        RecyclerView mRvListContent = findViewById(R.id.rv_list_content);
        mAdapter = new RecyclerPopupAdapter();
        mAdapter.bindToRecyclerView(mRvListContent);
        mRvListContent.setLayoutManager(new LinearLayoutManager(context));
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (mLastPosition == position) {
                return;
            }
            if (mLastPosition != -1) {
                mAdapter.getItem(mLastPosition).setChecked(false);
                mAdapter.notifyItemChanged(mLastPosition);
            }
            mAdapter.getItem(position).setChecked(true);
            mAdapter.notifyItemChanged(position);
            mLastPosition = position;

            if (mListener != null) {
                mListener.onClick(position);
            }
            dismiss();
        });
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public void setNewData(int type, @NonNull List<RecyclerPopupBean> list) {
        if (mType != type) {
            mLastPosition = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).isChecked()) {
                    mLastPosition = i;
                    break;
                }
            }
            mAdapter.setNewData(list);
            mType = type;
        }
    }

    /**
     * 当前显示的类型
     *
     * @return
     */
    public int getShowType() {
        return mType;
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.layout_popup_recycler);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1f,
                Animation.RELATIVE_TO_SELF, 0f);
        animation.setDuration(300);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, -1f);
        animation.setDuration(300);
        animation.setInterpolator(new DecelerateInterpolator());
        return animation;
    }

    @Override
    public void showPopupWindow(View anchorView) {
        super.showPopupWindow(anchorView);
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
