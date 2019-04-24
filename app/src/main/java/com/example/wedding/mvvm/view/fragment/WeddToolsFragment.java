package com.example.wedding.mvvm.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.android.databinding.library.baseAdapters.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseFragment;
import com.example.wedding.databinding.FragmentToolsWeddBinding;
import com.example.wedding.mvvm.viewmodel.ToolsViewModel;

/**
 * 发现页Fragment
 *
 * @author
 */
public class WeddToolsFragment extends BaseFragment<FragmentToolsWeddBinding, ToolsViewModel> {


    public static WeddToolsFragment newInstance() {
        return new WeddToolsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tools_wedd;
    }

    @Override
    protected Class<ToolsViewModel> getModelClass() {
        return ToolsViewModel.class;
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
