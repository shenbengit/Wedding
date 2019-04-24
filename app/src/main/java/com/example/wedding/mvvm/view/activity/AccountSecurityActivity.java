package com.example.wedding.mvvm.view.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityAccountSecurityBinding;
import com.example.wedding.mvvm.viewmodel.AccountSecurityViewModel;

/**
 * 账号安全页
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
        mViewModel.getBaseLiveData().observe(this, s -> {
            if (!TextUtils.isEmpty(s)) {
                ARouter.getInstance()
                        .build(ARouterPath.REAL_NAME_ACTIVITY)
                        .navigation(AccountSecurityActivity.this, AccountSecurityViewModel.REAL_NAME_TAG);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode, resultCode, data);
    }
}
