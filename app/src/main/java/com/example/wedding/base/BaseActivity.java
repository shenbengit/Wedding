package com.example.wedding.base;

import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.example.wedding.R;
import com.example.wedding.base.support.AbstractSupportActivity;


/**
 * @author

 */

public abstract class BaseActivity<VDB extends ViewDataBinding, VM extends BaseViewModel> extends AbstractSupportActivity {

    protected final String TAG = getClass().getSimpleName();

    protected VDB mBinding;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        beforeSetContentView();
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        init();
        initView();
        initData(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(mViewModel);
        mBinding.unbind();
    }

    /**
     * 在设置View之前调用
     */
    protected void beforeSetContentView() {

    }

    /**
     * 获取布局文件id
     *
     * @return 返回布局文件id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化ViewModel、DataBinding
     */
    private void init() {
        mViewModel = ViewModelProviders.of(this).get(getModelClass());
        mViewModel.injectLifecycleProvider(this);
        getLifecycle().addObserver(mViewModel);
        mBinding.setVariable(getVariableId(), mViewModel);
    }

    /**
     * 获取ViewModel
     *
     * @return 没有定义ViewModel，则传BaseViewModel
     */
    protected abstract Class<VM> getModelClass();

    /**
     * 获取ViewModel的id
     *
     * @return BR的id
     */
    protected abstract int getVariableId();

    /**
     * 初始化view，控件初始化设置相关监听等在此方法执行
     */
    protected void initView() {

    }

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    protected abstract void initData(@Nullable Bundle savedInstanceState);

    /**
     * 设置ToolBar
     *
     * @param toolbar 传入子类中的ToolBar
     */
    protected void initToolbarNav(Toolbar toolbar) {
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

}
