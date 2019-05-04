package com.example.wedding.mvvm.view.adapter;

import android.support.annotation.Nullable;

import com.example.wedding.R;
import com.example.wedding.databinding.ItemGoodsWeddBinding;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingAdapter;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingViewHolder;
import com.example.wedding.mvvm.view.bean.WeddGoodsBean;

import java.util.List;

public class WeddGoodsAdapter extends BaseBindingAdapter<WeddGoodsBean, BaseBindingViewHolder> {

    public WeddGoodsAdapter() {
        super(R.layout.item_goods_wedd, null);
    }

    @Override
    protected void convert(BaseBindingViewHolder helper, WeddGoodsBean item) {
        ItemGoodsWeddBinding binding = helper.getBinding();
        binding.setBean(item);
    }
}
