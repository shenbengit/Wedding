package com.example.wedding.mvvm.view.activity;

import android.view.WindowManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityLoginBinding;
import com.example.wedding.loader.GlideImageLoader;
import com.example.wedding.mvvm.viewmodel.LoginViewModel;
import com.youth.banner.BannerConfig;

import cn.bmob.v3.BmobUser;

/**
 * 用户登录Activity
 *
 * @author ShenBen
 * @date 2018/11/8 13:19
 * @email 714081644@qq.com
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    private boolean isLogin;

    @Override
    protected void beforeSetContentView() {
        if (BmobUser.isLogin()) {//是否有用户登录
            isLogin = true;
            intentToMain();
            return;
        }
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected Class<LoginViewModel> getModelClass() {
        return LoginViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initData() {
        if (isLogin) {
            return;
        }
        mBinding.banner.setIndicatorGravity(BannerConfig.CENTER);
        mBinding.banner.setImageLoader(new GlideImageLoader());
        mViewModel.images.observe(this, integers -> {
            if (integers == null || integers.isEmpty()) {
                return;
            }
            mBinding.banner.setImages(integers);
            mBinding.banner.start();
        });

        mViewModel.sendCodeIcoVisible.observe(this, aBoolean -> mBinding.setVisibility(aBoolean));
        mViewModel.singOrLoginSuccess.observe(this, aBoolean -> {
            if (aBoolean != null && aBoolean) {
                intentToMain();
            }
        });
    }

    /**
     * 跳转到主页
     */
    private void intentToMain() {
        ARouter.getInstance().build(ARouterPath.MAIN_ACTIVITY).navigation();
        finish();
    }
}
