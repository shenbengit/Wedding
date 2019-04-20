package com.example.wedding.mvvm.view.activity;

import android.support.annotation.Nullable;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.databinding.library.baseAdapters.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityFeedbackBinding;
import com.example.wedding.mvvm.viewmodel.FeedbackViewModel;

/**
 * 用户反馈首页
 */
@Route(path = ARouterPath.FEEDBACK_ACTIVITY)
public class FeedbackActivity extends BaseActivity<ActivityFeedbackBinding, FeedbackViewModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected Class<FeedbackViewModel> getModelClass() {
        return FeedbackViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        mBinding.toolbar.setTitle("用户反馈");
        initToolbarNav(mBinding.toolbar);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
}
