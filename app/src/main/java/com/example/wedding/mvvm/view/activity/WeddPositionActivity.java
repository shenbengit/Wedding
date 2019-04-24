package com.example.wedding.mvvm.view.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityWeddPositionBinding;
import com.example.wedding.mvvm.viewmodel.WeddPositionViewModel;

@Route(path = ARouterPath.WEDD_POSITION_ACTIVITY)
public class WeddPositionActivity extends BaseActivity<ActivityWeddPositionBinding, WeddPositionViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wedd_position;
    }

    @Override
    protected Class<WeddPositionViewModel> getModelClass() {
        return WeddPositionViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        super.initView();

        mBinding.rvWeddPosi.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvWeddPosi.setAdapter(mViewModel.weddLocationAdapter);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {


    }
}
