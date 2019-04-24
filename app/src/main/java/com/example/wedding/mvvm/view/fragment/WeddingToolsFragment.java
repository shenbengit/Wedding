package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.android.databinding.library.baseAdapters.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.databinding.FragmentToolsWeddBinding;
import com.example.wedding.mvvm.viewmodel.WeddingToolsViewModel;

/**
 * 发现页Fragment
 *
 * @author
 */
public class WeddingToolsFragment extends BaseFragment<FragmentToolsWeddBinding, WeddingToolsViewModel> {


    public static WeddingToolsFragment newInstance() {
        return new WeddingToolsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tools_wedd;
    }

    @Override
    protected Class<WeddingToolsViewModel> getModelClass() {
        return WeddingToolsViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        super.initView();

        mBinding.rvWeddingTool.setLayoutManager(new LinearLayoutManager(_mActivity) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mBinding.rvWeddingTool.setAdapter(mViewModel.mWeddingToolAdapter);
    }


    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }
}
