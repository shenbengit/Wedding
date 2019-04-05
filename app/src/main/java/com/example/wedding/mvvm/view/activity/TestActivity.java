package com.example.wedding.mvvm.view.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityTestBinding;

@Route(path = ARouterPath.TEST_ACTIVITY)
public class TestActivity extends BaseActivity<ActivityTestBinding, BaseViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected Class<BaseViewModel> getModelClass() {
        return BaseViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return 0;
    }

    @Override
    protected void initData() {

    }
}
