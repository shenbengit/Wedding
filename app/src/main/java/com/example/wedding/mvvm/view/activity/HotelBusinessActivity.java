package com.example.wedding.mvvm.view.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityHotelBusinessBinding;
import com.example.wedding.mvvm.viewmodel.HotelViewModel;

@Route(path = ARouterPath.HOTEL_BUSINESS_ACTIVITY)
public class HotelBusinessActivity extends BaseActivity<ActivityHotelBusinessBinding, HotelViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hotel_business;
    }

    @Override
    protected Class<HotelViewModel> getModelClass() {
        return HotelViewModel.class;
    }


    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        super.initView();
        mBinding.toolbar.setTitle("酒店商家");
        initToolbarWhite(mBinding.toolbar);

        mViewModel.mAdapter.bindToRecyclerView(mBinding.rvPhoto);
        mBinding.rvPhoto.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mViewModel.initPopup(this);
        mViewModel.getBaseLiveData().observe(this, s -> {
            mViewModel.mPopup.showPopupWindow(mBinding.ivTypeBg);
        });
    }
}
