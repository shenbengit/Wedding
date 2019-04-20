package com.example.wedding.mvvm.view.activity;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityRealNameBinding;
import com.example.wedding.mvvm.viewmodel.AccountSecurityViewModel;
import com.example.wedding.mvvm.viewmodel.RealNameViewModel;

/**
 * 输入真实姓名页
 */
@Route(path = ARouterPath.REAL_NAME_ACTIVITY)
public class RealNameActivity extends BaseActivity<ActivityRealNameBinding, RealNameViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_real_name;
    }

    @Override
    protected Class<RealNameViewModel> getModelClass() {
        return RealNameViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        mBinding.toolbar.setTitle("真实姓名");
        initToolbarNav(mBinding.toolbar);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mViewModel.getBaseLiveData().observe(this, (Observer<String>) s -> {
            if (!TextUtils.isEmpty(s)) {
                Intent intent = new Intent();
                intent.putExtra(AccountSecurityViewModel.REAL_NAME, s);
                setResult(RESULT_OK, intent);
                onBackPressed();
            }
        });
    }
}
