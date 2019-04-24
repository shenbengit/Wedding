package com.example.wedding.mvvm.view.adapter;


import com.example.wedding.R;
import com.example.wedding.databinding.ItemToolPositionBinding;
import com.example.wedding.http.bean.WeddingPositionBean;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingAdapter;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingViewHolder;


public class WeddPositionAdapter extends BaseBindingAdapter<WeddingPositionBean, BaseBindingViewHolder> {

    public WeddPositionAdapter() {
        super(R.layout.item_tool_position, null);
    }

    @Override
    protected void convert(BaseBindingViewHolder helper, WeddingPositionBean item) {
        ItemToolPositionBinding binding = helper.getBinding();
        binding.setWeddPosition(item);
    }
}
