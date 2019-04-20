package com.example.wedding.mvvm.view.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityAccountSecurityBinding;
import com.example.wedding.mvvm.viewmodel.AccountSecurityViewModel;

/**
 * 账号安全
 *
 * @author

 */
@Route(path = ARouterPath.ACCOUNT_SECURITY_ACTIVITY)
public class AccountSecurityActivity extends BaseActivity<ActivityAccountSecurityBinding, AccountSecurityViewModel> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_account_security;
    }

    @Override
    protected Class<AccountSecurityViewModel> getModelClass() {
        return AccountSecurityViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        mBinding.toolbar.setTitle("账号安全");
        initToolbarNav(mBinding.toolbar);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
}
