package com.example.wedding.mvvm.view.adapter.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.wedding.R;

import java.util.List;

/**
 * 封装RecyclerView.Adapter基类的Adapter
 * 使用DataBinding
 *
 * @author ShenBen
 * @date 2018/11/8 13:19
 * @email 714081644@qq.com
 */
public abstract class BaseBindingAdapter<T> extends BaseQuickAdapter<T, BaseBindingViewHolder> {

    public BaseBindingAdapter(@Nullable List<T> data) {
        this(0, data);
    }

    public BaseBindingAdapter(int layoutResId) {
        this(layoutResId, null);
    }

    public BaseBindingAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }
}
