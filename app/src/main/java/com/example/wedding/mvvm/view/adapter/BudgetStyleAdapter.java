package com.example.wedding.mvvm.view.adapter;

import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.wedding.R;
import com.example.wedding.databinding.ItemBudgetSpendBinding;
import com.example.wedding.databinding.ItemRecyclerPopupBinding;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingAdapter;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingViewHolder;
import com.example.wedding.mvvm.view.bean.BudgetStyleBen;

import java.util.List;

public class BudgetStyleAdapter extends BaseBindingAdapter<BudgetStyleBen, BaseBindingViewHolder> {

    public BudgetStyleAdapter() {
        super(R.layout.item_budget_spend, null);
    }

    @Override
    protected void convert(BaseBindingViewHolder helper, BudgetStyleBen item) {
        ItemBudgetSpendBinding binding = helper.getBinding();
        binding.setStyle(item);
    }

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, int resource){
        imageView.setImageResource(resource);
    }
}
