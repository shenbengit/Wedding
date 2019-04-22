package com.example.wedding.mvvm.view.adapter;


import com.example.wedding.R;
import com.example.wedding.databinding.ItemToolPositionBinding;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingAdapter;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingViewHolder;
import com.example.wedding.mvvm.view.bean.WeddPositionBen;


public class WeddPositionAdapter extends BaseBindingAdapter<WeddPositionBen, BaseBindingViewHolder> {

    public WeddPositionAdapter() {
        super(R.layout.item_tool_position, null);
    }

    @Override
    protected void convert(BaseBindingViewHolder helper, WeddPositionBen item) {
        ItemToolPositionBinding binding = helper.getBinding();
        binding.setWeddPosition(item);
    }
}
