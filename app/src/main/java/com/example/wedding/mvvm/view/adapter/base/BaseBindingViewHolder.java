package com.example.wedding.mvvm.view.adapter.base;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wedding.R;

/**
 * 封装RecyclerView.ViewHolder基类ViewHolder
 * 使用DataBinding
 *
 * @author
 * @date 2018/11/8 13:17
 * @email 714081644@qq.com
 */
public class BaseBindingViewHolder extends BaseViewHolder {

    public BaseBindingViewHolder(View view) {
        super(view);
    }

    public <T extends ViewDataBinding> T getBinding() {
        return (T) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
    }
}
