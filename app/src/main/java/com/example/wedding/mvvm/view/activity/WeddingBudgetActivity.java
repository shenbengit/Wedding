package com.example.wedding.mvvm.view.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityWeddingBudgetBinding;
import com.example.wedding.mvvm.viewmodel.BudgetViewModel;

@Route(path = ARouterPath.BUGDET_ACTIVITY)
public class WeddingBudgetActivity extends BaseActivity<ActivityWeddingBudgetBinding, BudgetViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wedding_budget;
    }

    @Override
    protected Class<BudgetViewModel> getModelClass() {
        return BudgetViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
}
