package com.example.wedding.mvvm.view.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityBusinessBinding;
import com.example.wedding.mvvm.viewmodel.BusinessViewModel;

/**
 * 商家界面
 */
@Route(path = ARouterPath.BUSINESS_ACTIVITY)
public class BusinessActivity extends BaseActivity<ActivityBusinessBinding, BusinessViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_business;
    }

    @Override
    protected Class<BusinessViewModel> getModelClass() {
        return BusinessViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        mBinding.toolbar.setTitle("全部商家");
        initToolbarNav(mBinding.toolbar);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
}
