package com.example.wedding.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import com.example.wedding.R;

import razerdp.basepopup.BasePopupWindow;

/**
 * 下拉列表PopupWindow
 */
public class RecyclerPopup extends BasePopupWindow {

    private RecyclerView mRvListContent;

    public RecyclerPopup(Context context) {
        super(context, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundColor(Color.TRANSPARENT);
        mRvListContent = findViewById(R.id.rv_list_content);

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
}
