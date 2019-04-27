package com.example.wedding.mvvm.view.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.wedding.R;
import com.example.wedding.databinding.ItemBusinessEmceeBinding;
import com.example.wedding.databinding.ItemBusinessHotelBinding;
import com.example.wedding.databinding.ItemBusinessPhotographyBinding;
import com.example.wedding.mvvm.view.adapter.base.BaseBindingViewHolder;
import com.example.wedding.mvvm.view.bean.BusinessEmceeBean;
import com.example.wedding.mvvm.view.bean.BusinessHotelBean;
import com.example.wedding.mvvm.view.bean.BusinessPhotographyBean;
import com.example.wedding.mvvm.viewmodel.BusinessViewModel;

/**
 * 全部商家Adapter
 */
public class BusinessAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseBindingViewHolder> {

    public BusinessAdapter() {
        super(null);
        addItemType(BusinessViewModel.BUSINESS_PHOTOGRAPHY, R.layout.item_business_photography);
        addItemType(BusinessViewModel.BUSINESS_EMCEE, R.layout.item_business_emcee);
        addItemType(BusinessViewModel.BUSINESS_HOTEL, R.layout.item_business_hotel);

    }

    @Override
    protected void convert(BaseBindingViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case BusinessViewModel.BUSINESS_PHOTOGRAPHY: {
                ItemBusinessPhotographyBinding binding = helper.getBinding();
                BusinessPhotographyBean bean = (BusinessPhotographyBean) item;
                binding.setItem(bean);
            }
            break;
            case BusinessViewModel.BUSINESS_EMCEE: {
                ItemBusinessEmceeBinding binding = helper.getBinding();
                BusinessEmceeBean bean = (BusinessEmceeBean) item;
                binding.setItem(bean);
            }
            break;
            case BusinessViewModel.BUSINESS_HOTEL: {
                ItemBusinessHotelBinding binding = helper.getBinding();
                BusinessHotelBean bean = (BusinessHotelBean) item;
                binding.setItem(bean);
            }
            break;
        }
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
