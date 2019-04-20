package com.example.wedding.mvvm.view.adapter;

import com.example.wedding.R;
import com.example.wedding.databinding.ItemWeddingTypeBinding;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingAdapter;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingViewHolder;
import com.example.wedding.mvvm.view.bean.HomeWeddingBean;

/**
 * @author
 * @date 2019/4/7 15:17
 * @email 714081644@qq.com
 */
public class WeddingTypeAdapter extends BaseBindingAdapter<HomeWeddingBean, BaseBindingViewHolder> {

    public WeddingTypeAdapter() {
        super(R.layout.item_wedding_type, null);
    }

    @Override
    protected void convert(BaseBindingViewHolder helper, HomeWeddingBean item) {
        ItemWeddingTypeBinding binding = helper.getBinding();
        binding.setBean(item);
    }
}
