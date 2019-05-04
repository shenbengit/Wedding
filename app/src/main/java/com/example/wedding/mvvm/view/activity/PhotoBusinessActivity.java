package com.example.wedding.mvvm.view.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityPhotoBusinessBinding;
import com.example.wedding.mvvm.viewmodel.BusinessViewModel;
import com.example.wedding.mvvm.viewmodel.PhotoBusinessViewModel;

@Route(path = ARouterPath.PHOTO_BUSINESS_ACTIVITY)
public class PhotoBusinessActivity extends BaseActivity<ActivityPhotoBusinessBinding, PhotoBusinessViewModel> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_photo_business;
    }

    @Override
    protected Class<PhotoBusinessViewModel> getModelClass() {
        return PhotoBusinessViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        super.initView();
        mBinding.toolbar.setTitle("摄影商家");
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
