package com.example.wedding.mvvm.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivitySettingBinding;
import com.example.wedding.mvvm.viewmodel.SettingViewModel;

/**
 * 设置页
 *
 * @author ShenBen
 * @date 2019/4/8 22:35
 * @email 714081644@qq.com
 */

@Route(path = ARouterPath.SETTING_ACTIVITY)
public class SettingActivity extends BaseActivity<ActivitySettingBinding, SettingViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected Class<SettingViewModel> getModelClass() {
        return SettingViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        mBinding.btnTest.setOnClickListener(v -> ARouter.getInstance().build(ARouterPath.PERSONAL_INFO_ACTIVITY).navigation());
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }

}