package com.example.wedding.mvvm.view.adapter;


import com.example.wedding.R;
import com.example.wedding.databinding.ItemWeddingToolBinding;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingAdapter;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingViewHolder;
import com.example.wedding.mvvm.view.bean.HomeWeddingBean;


public class WeddingToolAdapter extends BaseBindingAdapter<HomeWeddingBean, BaseBindingViewHolder> {

    public WeddingToolAdapter() {
        super(R.layout.item_wedding_tool, null);
    }

    @Override
    protected void convert(BaseBindingViewHolder helper, HomeWeddingBean item) {
        ItemWeddingToolBinding binding = helper.getBinding();
        binding.setBean(item);
    }
}
