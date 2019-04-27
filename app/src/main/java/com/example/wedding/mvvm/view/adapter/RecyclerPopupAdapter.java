package com.example.wedding.mvvm.view.adapter;

import com.example.wedding.R;
import com.example.wedding.databinding.ItemRecyclerPopupBinding;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingAdapter;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingViewHolder;
import com.example.wedding.mvvm.view.bean.RecyclerPopupBean;

/**
 *
 */
public class RecyclerPopupAdapter extends BaseBindingAdapter<RecyclerPopupBean, BaseBindingViewHolder> {

    public RecyclerPopupAdapter() {
        super(R.layout.item_recycler_popup);
    }

    @Override
    protected void convert(BaseBindingViewHolder helper, RecyclerPopupBean item) {
        ItemRecyclerPopupBinding binding = helper.getBinding();
        binding.setItem(item);
    }

}
