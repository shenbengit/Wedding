package com.example.wedding.mvvm.view.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityNickNameBinding;
import com.example.wedding.mvvm.viewmodel.NickNameViewModel;

/**
 * @author

 */
@Route(path = ARouterPath.NICK_NAME_ACTIVITY)
public class NickNameActivity extends BaseActivity<ActivityNickNameBinding, NickNameViewModel> {
    public static final String NICK_NAME = "NICK_NAME";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nick_name;
    }

    @Override
    protected Class<NickNameViewModel> getModelClass() {
        return NickNameViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        mBinding.toolbar.setTitle("填写昵称");
        initToolbarNav(mBinding.toolbar);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mViewModel.getBaseLiveData().observe(this, s -> {
            if (!TextUtils.isEmpty(s)) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString(NICK_NAME, s);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                onBackPressedSupport();
            }
        });
    }
}
